package demo.batch;

import java.io.IOException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

//@Configuration
public class DynamicBatchConfig {

//  @Bean
  BeanFactoryPostProcessor beanFactoryPostProcessor() {
    return beanFactory -> {
      ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
      try {
	// 递归加载 batch 目录及其子目录下的所有 XML
	Resource[] resources = resolver.getResources("classpath*:batch/**/*.xml");
//	Resource[] resources = resolver.getResources("classpath*:batch/batch-job-ApplicationRunner.xml");
	XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
	for (Resource resource : resources) {
	  reader.loadBeanDefinitions(resource);
	}
      } catch (IOException e) {
	throw new RuntimeException("Failed to load batch job XML files", e);
      }
    };
  }
}
