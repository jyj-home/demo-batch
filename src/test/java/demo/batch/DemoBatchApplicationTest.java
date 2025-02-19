package demo.batch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootTest
public class DemoBatchApplicationTest {

  @Autowired
  private ApplicationContext context;

  @Autowired
  private Environment environment;

  @Test
  public void testRegisterAndRunCustomAppRunner2() throws Exception {

    String[] activeProfiles = environment.getActiveProfiles();
    for (String profile : activeProfiles) {
      System.out.println("当前激活的配置文件: " + profile);
    }
    assertTrue(activeProfiles.length > 0, "没有激活任何配置文件");
    assertEquals("test", activeProfiles[0], "当前激活的配置文件不是 'test'");

    // 准备测试参数
    String[] args = new String[] { "arg1", "arg2" };
    ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);

    try (AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();) {
      annotationContext.setParent(context);
      annotationContext.register(CustomAppRunner2.class);
      annotationContext.refresh();

      CustomAppRunner2 customAppRunner2 = annotationContext.getBean(CustomAppRunner2.class);
      customAppRunner2.run(applicationArguments);
    }
  }
}