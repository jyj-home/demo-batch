package demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

//@SpringBootApplication
//@ImportResource("${batch.jobs.path}")
public class DemoBatchApplication9_ok implements ApplicationRunner {

  @Autowired
  private JobLauncher jobLauncher;

  @Autowired
  private ApplicationContext context;

  @Value("${batch.jobs.path}")
  private String jobpath;

  public static void main(String[] args) throws Exception {
    int ret = SpringApplication.exit(SpringApplication.run(DemoBatchApplication9_ok.class, args));
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
