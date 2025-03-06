package demo.batch;

import java.util.Iterator;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:batch/job001/batch-job-ApplicationRunner.xml")
public class CustomAppRunner2 implements ApplicationRunner {
  @Autowired
  private JobLauncher jobLauncher;

  @Autowired
  private ApplicationContext context;

  @Autowired
  Job job;

  @Override
  public void run(ApplicationArguments args) throws Exception {

    Job userJob = context.getBean("sampleJob", Job.class);
    JobExecution jobExecution = jobLauncher.run(userJob,
	new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters());

    Iterator<StepExecution> Iterator = jobExecution.getStepExecutions().iterator();

    while (Iterator.hasNext()) {
      StepExecution stepExecution = Iterator.next();
//      stepExecution.
    }
  }

}
