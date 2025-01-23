package demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class DemoBatchApplication4 implements CommandLineRunner {

  @Autowired
  private JobLauncher jobLauncher;

//  @Autowired
//  private JobRepository jobRepository;
//
//  @Autowired
//  private PlatformTransactionManager transactionManager;

  @Autowired
  ApplicationContext configurableApplicationContext;

  public static void main(String[] args) {
    SpringApplication.run(DemoBatchApplication4.class, args);
    System.out.println("xxxxxxxxx_main");
  }

  @Override
  public void run(String... args) throws Exception {
    if (args.length == 0) {
      System.err.println("Usage: java -jar app.jar <batch-config-xml>");
      System.exit(1);
    }

    String batchConfig = "batch-job.xml";
    try (ConfigurableApplicationContext xmlContext = new ClassPathXmlApplicationContext(new String[] { batchConfig },
	configurableApplicationContext)) {
//      GenericXmlApplicationContext context = (GenericXmlApplicationContext) xmlContext;
//      context.getBeanFactory().registerSingleton("jobRepository", jobRepository);
//      context.getBeanFactory().registerSingleton("transactionManager", transactionManager);
//      context.refresh();
      Job job = xmlContext.getBean(Job.class);

      // Execute the job
      JobExecution jobExecution = jobLauncher.run(job,
	  new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters());

      // Print job status
      System.out.println("Job Status: " + jobExecution.getStatus());

      // Exit with the appropriate status code
      if (jobExecution.getStatus().isUnsuccessful()) {
	System.exit(1); // Exit with error code if job fails
      } else {
	System.exit(0); // Exit with success code if job succeeds
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1); // Exit with error code on exception
    }
  }
}
