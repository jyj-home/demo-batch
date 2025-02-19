package demo.batch;

import demo.batch.logic.DemoLogic;
import demo.batch.reader.MyItemReader;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.GenericXmlApplicationContext;

//@SpringBootApplication
public class DemoBatchApplication_ng1 implements ApplicationRunner {

  @Autowired
  private ApplicationContext context;

  public static void main(String[] args) throws Exception {
    int ret = SpringApplication.exit(SpringApplication.run(DemoBatchApplication_ng1.class, args));
    System.out.println("xxxxxxxxx_main:" + ret);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {

    if (!((ConfigurableApplicationContext) context).isActive()) {
      throw new IllegalStateException("父上下文尚未激活");
    }
    String[] beanNames = context.getBeanDefinitionNames();
    System.out.println("Spring 上下文中注册的 Bean 数量: " + beanNames.length);
    for (String beanName : beanNames) {
      Object bean = context.getBean(beanName);
      System.out.println("Bean 名称: " + beanName + ", 类型: " + bean.getClass().getName());
    }

    // 获取命令行参数 --jobConfig=classpath:jobs/job1.xml
    String jobConfig = context.getEnvironment().getProperty("jobConfig");
    jobConfig = "classpath:batch/job001/batch-job-ApplicationRunner.xml";
    GenericXmlApplicationContext xmlContext = new GenericXmlApplicationContext();
//    GenericXmlApplicationContext xmlContext = ((GenericXmlApplicationContext) context).load(jobConfig);
    xmlContext.setParent(context); // 将新加载的上下文与父上下文关联
    xmlContext.load(jobConfig); // 加载 batch-job-config.xml
    System.out.println("开始刷新子上下文");
    xmlContext.refresh(); // 刷新上下文
    System.out.println("子上下文刷新完成");
    if (!xmlContext.isActive()) {
      throw new IllegalStateException("子上下文尚未激活");
    }
    // 检查父子上下文的类加载器
    System.out.println("父上下文类加载器: " + context.getClassLoader());
    System.out.println("子上下文类加载器: " + xmlContext.getClassLoader());

    // 检查 AutowiredAnnotationBeanPostProcessor
    AutowiredAnnotationBeanPostProcessor autowiredProcessor = (AutowiredAnnotationBeanPostProcessor) xmlContext
	.getBean("org.springframework.context.annotation.internalAutowiredAnnotationProcessor");
    System.out.println("AutowiredAnnotationBeanPostProcessor 已获取: " + autowiredProcessor);

    // 检查 CommonAnnotationBeanPostProcessor
    CommonAnnotationBeanPostProcessor commonAnnotationProcessor = (CommonAnnotationBeanPostProcessor) xmlContext
	.getBean("org.springframework.context.annotation.internalCommonAnnotationProcessor");
    System.out.println("CommonAnnotationBeanPostProcessor 已获取: " + commonAnnotationProcessor);

    // 手动处理 reader 实例的依赖注入和初始化
//    try {
//      Object reader = xmlContext.getBean("itemReader");
//      reader = autowiredProcessor.postProcessBeforeInitialization(reader, "itemReader");
//      reader = commonAnnotationProcessor.postProcessBeforeInitialization(reader, "itemReader");
//      reader = autowiredProcessor.postProcessAfterInitialization(reader, "itemReader");
//      reader = commonAnnotationProcessor.postProcessAfterInitialization(reader, "itemReader");
//      System.out.println("手动处理 reader 实例完成");
//    } catch (Exception e) {
//      System.err.println("手动处理 reader 实例时出错: " + e.getMessage());
//    }

    // 检查子上下文是否能获取到父上下文中的 Mapper Bean
    try {
      Object pUserMapper = context.getBean("personMapper");
//      Object pAplicationContext = context.getBean(ApplicationContext.class);
      Object demoLogic = xmlContext.getBean(DemoLogic.class);
//      Object applicationContext = xmlContext.getBean(ApplicationContext.class);
      Object jobLauncher1 = xmlContext.getBean(JobLauncher.class);
      Object autowiredAnnotationBeanPostProcessor = xmlContext.getBean(AutowiredAnnotationBeanPostProcessor.class);
      Object myItemReader = xmlContext.getBean(MyItemReader.class);
      Object userMapper = xmlContext.getBean("personMapper");
      System.out.println("成功从子上下文获取父上下文的 Mapper Bean: " + userMapper);
    } catch (Exception e) {
      System.err.println("无法从子上下文获取父上下文的 Mapper Bean: " + e.getMessage());
    }

    // 尝试从 xmlContext 中获取 Spring Boot 自动配置的 DataSource Bean
    try {
      DataSource dataSource = xmlContext.getBean(DataSource.class);
      System.out.println("成功获取 DataSource: " + dataSource);
    } catch (Exception e) {
      System.out.println("无法从 xmlContext 中获取 DataSource: " + e.getMessage());
    }

    JobLauncher jobLauncher = xmlContext.getBean(JobLauncher.class);
    Job job = xmlContext.getBean("sampleJob", Job.class); // 确保 XML 里定义了 id="job"

    // 创建作业参数
    JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()) // 防止作业重复执行
	.toJobParameters();

    // 启动作业
    jobLauncher.run(job, jobParameters);
  }
}
