package inheritanceAndClass;

public class Main {
    public static void main(String[] args) {
        A als = new A();

        als.b();
        als.a = 0;
//        als.ba();
        als.c();

    }
}

class A {
    Integer a = 0;
    public Number b() {
        a = 9;
        return this.a;
    }

    private Number ba() {
        a = 9;
        return this.a;
    }

    protected Number c() {
        a = 11;
        return this.a;
    }
}

// A가 main 함수 안에 있으면, A가 메서드 내부의 지역 클래스이기 때문에, 같은 메서드 안에서는 private 접근 제어가 적용되지 않고 그대로 접근할 수 있어서 에러가 나지 않는다.
// A가 밖에 있을 땐, A클래스 바깥(main)에서 사용하는 것이므로 private는 에러가 난다.

interface a {
    Integer a();
    Number b();
}

class B implements a {
    @Override
    public Integer a() {
        return 9;
    }

    @Override
    public Number b() {
        return 9;
    }
}

//상속, 추상 클래스, 접근 제어자, override, overload
