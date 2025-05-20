package decoratorPattern;

public class Main {

    public static void main(String args[]) {
        // 1. 원본 객체 생성
        Component obj = new ConcreteComponent();

        // 2. 장식 1 하기
        Component deco1 = new ComponentDeco1(obj);
        deco1.operation(); // 장식된 객체의 장식된 기능 실행

        // 3. 장식 2 하기
        Component deco2 = new ComponentDeco2(obj);
        deco2.operation(); // 장식된 객체의 장식된 기능 실행

        // 4. 장식 1 + 2 하기
        Component deco3 = new ComponentDeco1(new ComponentDeco2(obj));

    }

}
