import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // 배열은 참조 타입이어서 변수에 저장된 주소가 같아 같은 객체를 참조하므로 값이 동시에 바뀐다.
//        int a = 5;
//        int b = a;
//        b = 10;
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//
//        int[] arr1 = {1,2,3};
//        int[] arr2 = arr1;
//        arr2[0] = 10;
//
//        System.out.println("arr1[0] = " + arr1[0]);
//        System.out.println("arr2[0] = " + arr2[0]);

// ---------------------------------------------------------------------------

        //int에는 null 불가, integer은 null 가능

//        int num1 = 0;
//        Integer num2 = null;
//        num1 = num2;

        //이렇게 하면 에러가 발생한다. Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Integer.intValue()" because "num2" is null at Main.main(Main.java:24)
        //참조 타입(Integer) 값이 null인 상태에서 기본 타입(int)으로 언박싱하려고 해서 NullPointerException이 발생

//        System.out.println("num1 = " + num1);
    }
}
