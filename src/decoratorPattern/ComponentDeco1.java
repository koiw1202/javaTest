package decoratorPattern;

public class ComponentDeco1 extends Dacorator {


    public ComponentDeco1(Component component) {
        super(component);
    }

    public void operation() {
        super.operation(); // 원본 객체를 상위 클래스의 위임을 통해 실행하고
        extraOperation(); // 장식 클래스만의 메소드를 실행한다.
    }

    void extraOperation() {

    }
}
