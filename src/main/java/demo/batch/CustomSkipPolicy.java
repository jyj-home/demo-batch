package demo.batch;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;

public class CustomSkipPolicy implements SkipPolicy {

  private long skipLimit = -1;

  @Override
  public boolean shouldSkip(Throwable t, long skipCount) throws SkipLimitExceededException {
    if (t instanceof SkipException e && skipCount < Long.MAX_VALUE) {
      return true;
    }
    return false;
  }
}
