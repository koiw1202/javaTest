package fieldReflectionTest;

import java.util.ArrayList;
import java.util.List;

public class DtoB {
    private String name ;
    private Integer num ;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return this.name ;
    }

    public void setName(String name) {
        this.name = name ;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    private List<String> list = new ArrayList<>() ;

}
