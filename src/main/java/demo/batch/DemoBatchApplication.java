package demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:batch-job-ApplicationRunner.xml" }) // 引入多个XML配置文件
public class DemoBatchApplication implements ApplicationRunner {

  @Autowired
  private JobLauncher jobLauncher;

  @Autowired
  private JobRepository jobRepository;

  @Autowired
  private ApplicationContext context;

  public static void main(String[] args) throws Exception {
    int ret = SpringApplication.exit(SpringApplication.run(DemoBatchApplication.class, args));
    System.out.println("xxxxxxxxx_main:" + ret);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // 读取命令行参数，指定要运行的作业
    String jobName = args.getOptionValues("jobName") != null ? args.getOptionValues("jobName").get(0) : "sampleJob";

    // 根据参数动态获取作业
    Job job = (Job) context.getBean(jobName);

    // 创建作业参数
    JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()) // 防止作业重复执行
	.toJobParameters();

    // 启动作业
    jobLauncher.run(job, jobParameters);
  }
}
