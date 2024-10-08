package enumTest;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-07-02        koiw1       최초 생성
 */
public class EnumTest3 {

    private enum TestEnum {
        book("Book"),
        cood("Cood")

        ;
        private TestEnum(String testVal) {
            this.testVal = testVal ;
        }

        String testVal ;

    }

    private static TestEnum getTestEnumByCode(String code) {

        return Arrays.stream(TestEnum.values())
                .filter(v -> v.testVal.equals(code))
                .findFirst()
                .orElse(null);

    }

    public static void main(String args[]) {
        System.out.println(getTestEnumByCode("Book"));
        System.out.println(getTestEnumByCode("a"));

    }

}

























