package demo.batch.reader;

import demo.batch.gen.entity.Person;
import demo.batch.gen.repository.PersonMapper;
import demo.batch.logic.DemoLogic;
import jakarta.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;
import lombok.Setter;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.DependsOn;

@DependsOn("demoLogic")
public class MyItemReader implements ItemReader<Person> {

  @Autowired
  private DemoLogic demoLogic;

  private Iterator<Person> iterator;

  @Autowired
  @Qualifier("personMapper")
  private PersonMapper personMapper;

  @Autowired
  JobLauncher jobLauncher;

  @Autowired
  private ApplicationContext context;

//  @Value("#{jobParameters['jobConfig']}")
  @Setter
  private String jobConfig;

  @PostConstruct
  public void init() {
    // 确保这里的逻辑不会影响依赖注入
    System.out.println("OK");
  }

  @Override
  public Person read() {
    System.out.println(jobConfig);
    Person person = new Person();
    person.setPersonId("001");
    person.setName("小李");
    List<Person> personList = demoLogic.getInfo(person);
    if (iterator == null) {
      iterator = personList.iterator();
    }
    return iterator.hasNext() ? iterator.next() : null;
  }
}
