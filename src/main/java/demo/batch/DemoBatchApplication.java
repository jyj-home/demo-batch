package demo.batch;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoBatchApplication extends CommandLineJobRunner {

//  @Autowired
//  private JobLauncher jobLauncher;

//  @Autowired
//  private JobRepository jobRepository;
//
//  @Autowired
//  private PlatformTransactionManager transactionManager;

//  @Autowired
//  ApplicationContext configurableApplicationContext;

//  <bash$ java CommandLineJobRunner endOfDayJob.xml endOfDay schedule.date=2007-05-05,java.time.LocalDate

  public static void main(String[] args) throws Exception {
    CommandLineJobRunner.main(args);
    System.out.println("xxxxxxxxx_main");
  }
}
