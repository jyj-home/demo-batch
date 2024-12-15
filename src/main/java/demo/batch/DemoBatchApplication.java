package demo.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoBatchApplication {

  private static ConfigurableApplicationContext context;

  public static void main(String[] args) {
    context = SpringApplication.run(DemoBatchApplication.class, args);
    System.out.println("xxx");
    shutDown();
  }

  public static void shutDown() {
    int exitCode = SpringApplication.exit(context);
    context.close();
    System.exit(9);
  }
}
