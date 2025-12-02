package inheritanceAndClass.packageB;

import inheritanceAndClass.packageA.Parent;

public class DifferentPackage extends Parent {
    Parent p = new Parent();

    public void test() { //show가 protected임에도 불구하고 실행되는 이유는 Parent를 상속받았기 떄문이다.
        show();
    }

    @Override //@Override를 통해 재정의를 할 수 있다.
    protected void show() {
        System.out.println("show in DifferentPackage");
    }
}
