package ExceptionTest;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExampleService {

    public void someMethod() {
        java.util.logging.Logger logger = Logger.getGlobal();


        try {
            // 어떤 작업 중 다른 예외(예: IOException)가 발생했다고 가정
            // 예시를 위해 직접 IOException 생성
            throw new IOException("파일 읽기 오류 발생");

        } catch (IOException e) {
            // IOException을 잡아서 우리의 커스텀 RuntimeException으로 감싸서 다시 던짐
            MyCustomRuntimeException customException = new MyCustomRuntimeException("데이터 처리 중 오류 발생", e);

            // 로깅 프레임워크의 메소드에 예외 객체 자체를 전달
            Logger logging = Logger.getLogger(this.getClass().getName());
            logging.log(Level.WARNING, "커스텀 예외 발생!", customException);
//            logger.info("커스텀 예외 발생!", customException);

            // 만약 예외를 다시 던져야 한다면:
            // throw customException;
        }
    }

    public static void main(String[] args) {
        ExampleService service = new ExampleService();
        service.someMethod();
    }
}