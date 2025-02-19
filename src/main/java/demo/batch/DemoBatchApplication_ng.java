package demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//@SpringBootApplication
public class DemoBatchApplication_ng implements ApplicationRunner {

  @Autowired
  private ApplicationContext context;

  public static void main(String[] args) throws Exception {
    int ret = SpringApplication.exit(SpringApplication.run(DemoBatchApplication_ng.class, args));
    System.out.println("xxxxxxxxx_main:" + ret);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // 获取命令行参数 --jobConfig=classpath:jobs/job1.xml
    String jobConfig = context.getEnvironment().getProperty("jobConfig");
    jobConfig = "classpath:batch/job001/batch-job-ApplicationRunner.xml";
    GenericXmlApplicationContext xmlContext = new GenericXmlApplicationContext();
    xmlContext.setParent(context); // 将新加载的上下文与父上下文关联
    xmlContext.load(jobConfig); // 加载 batch-job-config.xml
    xmlContext.refresh(); // 刷新上下文

    JobLauncher jobLauncher = xmlContext.getBean(JobLauncher.class);
    Job job = context.getBean("sampleJob", Job.class); // 确保 XML 里定义了 id="job"

    // 创建作业参数
    JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()) // 防止作业重复执行
	.toJobParameters();

    // 启动作业
    jobLauncher.run(job, jobParameters);
  }
}
