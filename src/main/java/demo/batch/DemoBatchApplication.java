package demo.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoBatchApplication {

  public static void main(String[] args) {
    int ret = SpringApplication.exit(SpringApplication.run(DemoBatchApplication.class, args));
    System.exit(ret);
    System.out.println("xxxxxxxxx_main:" + ret);
  }
}
