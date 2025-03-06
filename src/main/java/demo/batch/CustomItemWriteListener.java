package demo.batch;

import demo.batch.gen.entity.Person;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.item.Chunk;

public class CustomItemWriteListener implements ItemWriteListener<Person> {
  @Override
  public void beforeWrite(Chunk<? extends Person> items) {
    // 在写入前执行
  }

  @Override
  public void afterWrite(Chunk<? extends Person> items) {
    // 写入成功后的处理逻辑
  }

  @Override
  public void onWriteError(Exception exception, Chunk<? extends Person> items) {
    // 发生错误时，记录日志或者采取补救措施
    // 默认情况下，Spring Batch会回滚当前的chunk
    // 可以选择抛出异常或吞掉异常
  }
}
