package ExceptionTest;

public class MyCustomRuntimeException extends RuntimeException {

    // 메시지와 원인(cause) Throwable을 받는 생성자
    public MyCustomRuntimeException(String message, Throwable cause) {
        super(message, cause); // 부모 클래스(RuntimeException)의 생성자에 전달
    }

    // 메시지만 받는 생성자 (필요하다면)
    public MyCustomRuntimeException(String message) {
        super(message);
    }

    // 원인(cause) Throwable만 받는 생성자 (필요하다면)
    public MyCustomRuntimeException(Throwable cause) {
        super(cause);
    }
}
