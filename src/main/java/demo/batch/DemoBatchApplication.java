package demo.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoBatchApplication implements ApplicationRunner {

  @Autowired
  private ApplicationContext context;

  public static void main(String[] args) {
    int ret = SpringApplication.exit(SpringApplication.run(DemoBatchApplication.class, args));
    System.out.println("xxxxxxxxx_main:" + ret);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
//    try (AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();) {
//      annotationContext.setParent(context);
//      annotationContext.register(CustomAppRunner2.class);
//      annotationContext.refresh();
//
//      CustomAppRunner2 customAppRunner2 = annotationContext.getBean(CustomAppRunner2.class);
//      customAppRunner2.run(args);
//    }
  }
}
