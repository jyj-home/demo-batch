package demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication
//@ImportResource("classpath:batch-jobs.xml")
public class DemoBatchApplication3 {

  private static ConfigurableApplicationContext context;

  public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException,
      JobInstanceAlreadyCompleteException, JobParametersInvalidException {
    context = SpringApplication.run(DemoBatchApplication3.class, args);
    System.out.println("xxx");

    JobLauncher jobLauncher = context.getBean(JobLauncher.class);
    Job userJob = context.getBean("userJob", Job.class);
    JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
	.toJobParameters();
    jobLauncher.run(userJob, jobParameters);
    shutDown();
  }

  public static void shutDown() {
    int exitCode = SpringApplication.exit(context);
    context.close();
    System.exit(9);
  }
}
