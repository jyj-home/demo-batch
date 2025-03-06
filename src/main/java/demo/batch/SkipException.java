package demo.batch;

public class SkipException extends RuntimeException {

  public SkipException(String message) {
    super(message);
  }
}
