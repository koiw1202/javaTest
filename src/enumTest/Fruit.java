package enumTest;

import java.util.function.Function;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-06-15        koiw1       최초 생성
 */
public enum Fruit {
     APPLE("APPLE")
    ,GRAPE("GRAPE")

    ;

    Fruit(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    private String name ;

}