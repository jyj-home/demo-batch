package demo.batch.reader;

import demo.batch.gen.entity.Person;
import demo.batch.logic.DemoLogic;
import java.util.Iterator;
import java.util.List;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;

public class MyItemReader implements ItemReader<Person> {

  @Autowired
  private DemoLogic demoLogic;

  private Iterator<Person> iterator;

  @Override
  public Person read() {
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
