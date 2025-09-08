package etc;

import accessLevel.A;

public class EqualsHashCodeTest {

    static Person person = new Person();

    public static void main(String args[]) {

        Person person2 = new Person();
        Person person3 = person2;

        if(person2.equals(person)) {
            System.out.println("동일");
        } else {
            System.out.println("다름");
        }

        if(person2.equals(person3)) {
            System.out.println("동일");
        } else {
            System.out.println("다름");
        }

        if("123".equals("123")) {
            System.out.println("동일");
        } else {
            System.out.println("다름");
        }

    }
}
