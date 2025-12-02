package inheritanceAndClass.abstractExample;

abstract class Animal {
    String name;
    int age;

    void sound() {
        System.out.println("DogDog");
    }
    abstract void eat();
}

// 추상 클래스의 추상 메서드(abstract)는 자식 클래스에서 각자 구현(커스텀)하도록 열어주는 메서드이다.

class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("FOOD");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.sound();
        d.age = 1;
        d.name = "Dog";
    }
}
