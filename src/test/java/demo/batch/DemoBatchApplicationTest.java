package demo.batch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

import demo.batch.logic.DemoLogic;
import demo.batch.util.DemoUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootTest
public class DemoBatchApplicationTest {

  @Autowired
  private ApplicationContext context;

  @Autowired
  private Environment environment;

  @Autowired
  private DemoLogic demoLogic1;

  @Mock
  private DemoLogic demoLogic2;

//  @Autowired
//  ItemReader itemReader;

//  @Autowired
//  MyItemReader myItemReader;

  @Test
  public void testRegisterAndRunCustomAppRunner2() throws Exception {

    String[] activeProfiles = environment.getActiveProfiles();
    for (String profile : activeProfiles) {
      System.out.println("当前激活的配置文件: " + profile);
    }
    assertTrue(activeProfiles.length > 0, "没有激活任何配置文件");
    assertEquals("test", activeProfiles[0], "当前激活的配置文件不是 'test'");

    JuintTestJob.init(context);
    Object itemReader = JuintTestJob.jobContext.getBean("itemReader");
    Object demoLogic = JuintTestJob.jobContext.getBean(DemoLogic.class);

//    ReflectionTestUtils.setField(itemReader, "demoLogic", demoLogic2);

    doThrow(new RuntimeException("mock exception")).when(demoLogic2).getInfo(any());
//
    MockedStatic<DemoUtils> mockedStatic = Mockito.mockStatic(DemoUtils.class);
    mockedStatic.when(DemoUtils::test).thenThrow(new SkipException("mock exception"));

    // 准备测试参数
    String[] args = new String[] { "arg1", "arg2" };
    ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
    JuintTestJob.runjob(applicationArguments);

    mockedStatic.close();
  }

//定义一个拦截器类，用于替换静态方法的实现
  class StaticMethodInterceptor {
    public static String interceptStaticMethod() {
      return "Mocked result";
    }
  }
}