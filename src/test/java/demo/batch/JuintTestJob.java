package demo.batch;

import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JuintTestJob {

  public static AnnotationConfigApplicationContext jobContext;

  public static CustomAppRunner2 customAppRunner2;

  public static CustomAppRunner2 init(ApplicationContext context) {
    jobContext = new AnnotationConfigApplicationContext();
    jobContext.setParent(context);
    jobContext.register(CustomAppRunner2.class);
    jobContext.refresh();
    customAppRunner2 = jobContext.getBean(CustomAppRunner2.class);
    return customAppRunner2;
  }

  public static void runjob(ApplicationArguments args) {

    try {
      customAppRunner2.run(args);
    } catch (Exception e) {
      // TODO 自動生成された catch ブロック
      e.printStackTrace();
    }
  }
}
