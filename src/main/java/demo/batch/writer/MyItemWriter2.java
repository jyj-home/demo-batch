package demo.batch.writer;

import demo.batch.gen.entity.Person;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.lang.NonNull;

public class MyItemWriter2 implements ItemWriter<Person> {

  @Override
  public void write(@NonNull Chunk<? extends Person> chunk) throws Exception {
    chunk.forEach(System.out::println);
  }
}
