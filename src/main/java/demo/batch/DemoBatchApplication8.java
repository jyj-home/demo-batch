package demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

//@SpringBootApplication
public class DemoBatchApplication8 implements ApplicationRunner {

  @Autowired
  private ApplicationContext context;

  @Autowired
  private JobLauncher jobLauncher;

  @Autowired
  private JobRepository jobRepository;

  public static void main(String[] args) throws Exception {
    int ret = SpringApplication.exit(SpringApplication.run(DemoBatchApplication8.class, args));
    System.out.println("xxxxxxxxx_main:" + ret);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // 获取命令行参数 --jobConfig=classpath:jobs/job1.xml
    String jobConfig = context.getEnvironment().getProperty("jobConfig");
    jobConfig = "classpath:batch/job001/batch-job-ApplicationRunner.xml";
    if (jobConfig != null) {
      System.out.println("Loading job XML: " + jobConfig);

//      ((GenericApplicationContext) context).registerBean("jobRepository", JobRepository.class, () -> jobRepository);

      // 使用 XmlBeanDefinitionReader 动态加载 XML
      XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader((GenericApplicationContext) context);
      xmlReader.loadBeanDefinitions(jobConfig);

      // 触发 Job 执行（可选）
//      JobLauncher jobLauncher = context.getBean(JobLauncher.class);
      Job job = (Job) context.getBean("sampleJob"); // 确保 XML 里定义了 id="job"
//      // 手动注入 JobRepository
//      if (job instanceof SimpleJob simpleJob) {
//	simpleJob.setJobRepository(jobRepository);
//      }
      try {
	jobLauncher.run(job, new JobParameters());
      } catch (Exception e) {
	e.printStackTrace();
      }
    }
  }
}
