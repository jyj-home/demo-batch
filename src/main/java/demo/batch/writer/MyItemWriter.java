package demo.batch.writer;

import demo.batch.gen.entity.Person;
import demo.batch.util.DemoUtils;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.lang.NonNull;

public class MyItemWriter implements ItemWriter<Person> {

  private int count;

  @Override
  public void write(@NonNull Chunk<? extends Person> chunk) throws Exception {
    count++;
    chunk.forEach(System.out::println);
    System.out.println(DemoUtils.test());
  }
}
