package fieldReflectionTest;

import java.util.ArrayList;
import java.util.List;

public class DtoA {

    public Integer getNum() {
        return num;
    }

    private String name ;

    public void setNum(Integer num) {
        this.num = num;
    }

    private Integer num ;

    public String getName() {
        return this.name ;
    }

    public void setName(String name) {
        this.name = name ;
    }

    private String test ;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    private List<String> list = List.of("1", "2", "3") ;
}
