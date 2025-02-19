package demo.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class CustomAppRunner implements ApplicationRunner {

  @Autowired
  private ApplicationContext context;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    try (AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();) {
      annotationContext.setParent(context);
      annotationContext.register(CustomAppRunner2.class);
      annotationContext.refresh();

      CustomAppRunner2 customAppRunner2 = annotationContext.getBean(CustomAppRunner2.class);
      customAppRunner2.run(args);
    }
  }
}
