package demo.batch;

import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryPolicy;

public class CustomRetryPolicy implements RetryPolicy {

  @Override
  public boolean canRetry(RetryContext context) {
    // TODO 自動生成されたメソッド・スタブ
    return false;
  }

  @Override
  public RetryContext open(RetryContext parent) {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }

  @Override
  public void close(RetryContext context) {
    // TODO 自動生成されたメソッド・スタブ
    System.out.println("");
  }

  @Override
  public void registerThrowable(RetryContext context, Throwable throwable) {
    // TODO 自動生成されたメソッド・スタブ
    throwable = null;
    System.out.println("");
  }

}
