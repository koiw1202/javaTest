package decoratorPattern;

public class ConcreteComponent implements Component {

    @Override
    public void operation() {
        System.out.println("ConcreteComponent 실행");
    }
}
