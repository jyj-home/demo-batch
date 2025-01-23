package demo.batch.processor;

import demo.batch.gen.entity.Person;
import org.springframework.batch.item.ItemProcessor;

public class MyItemProcessor implements ItemProcessor<Person, Person> {
  @Override
  public Person process(Person item) {
    // Perform processing logic here
    return item;
  }
}
