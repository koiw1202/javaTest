package decoratorPattern;


public abstract class Dacorator implements Component{

    private final Component component;


    public Dacorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation(); // 위임
    }

}
