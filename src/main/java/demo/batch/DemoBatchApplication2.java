package demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
//@ImportResource("classpath:batch-jobs.xml") // 引入 XML 配置
public class DemoBatchApplication2 implements CommandLineRunner {

  @Autowired
  private JobLauncher jobLauncher;

  @Autowired
  private Job sampleJob;

  public static void main(String[] args) {
    SpringApplication.run(DemoBatchApplication2.class, args);
    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxmain");
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxrun");
    jobLauncher.run(sampleJob,
	new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters());
  }
}
