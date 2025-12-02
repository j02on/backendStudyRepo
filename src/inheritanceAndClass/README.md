## 상속, 추상 클래스, 접근 제어자, override, overload, 어노테이션

### 상속
> 상속이란, 클래스가 가지고 있는 멤버를 다른 클래스에 계승 시키는 것이다. 부모 클래스에 정의된 멤버 변수와 멤버 함수를 자식 클래스에서 재사용하여 중복을 줄일 수 있다.
> 상속을 통해 다형성을 활용할 수 있다.

**다형성이란?**
    - 다형성은 같은 코드가 다양한 형태로 동작할 수 있는 성질을 뜻한다.
    - 하나의 타입으로 여러 객체를 다룰 수 있는 능력
```java
abstract class Animal {
    abstract void makeSound();
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("야옹");
    }
}

Animal a = new Dog();
a.makeSound(); // 멍멍

a = new Cat();
a.makeSound(); // 야옹
```

### 추상 클래스
> 직접 객체를 만들 수 없고, 공통 기능은 제공하면서 일부 기능은 자식이 반드시 구현하도록 강제하는 클래스
> abstract 키워드로 선언한다.
> 추상 메서드를 포함할 수 있으며, 이 메서드는 구현없이 자식이 반드시 구현해야합니다.

```java
abstract class Animal {
    String name;

    void eat() {    
        System.out.println(name + " is eating");
    }

    abstract void makeSound(); //추상 메서드
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("멍멍!");
    }
}
```

### 접근 제어자
1. 클래스의 접근 제어자
- public : public을 사용하면, 모든 클래스에서 이 클래스에 접근이 가능하다.
- default : 클래스 앞에 접근 제어자가 없으면 같은 패키지 안의 클래스에서만 접근이 가능하다.

2. 클래스 멤버의 접근 제어자
- public : 공개를 나타내며, 모든 클래스에서 접근이 가능하다.
- private: 비공개를 나타내며, 같은 클래스 안에 있는 멤버들만 접근이 가능하다.
- protected: 같은 패키지 안의 모든 클래스와 다른 패키지의 자식 클래스에서 접근이 가능하다.
- default : 접근 지정자가 없으면, 같은 패키지 안의 클래스에서만 접근이 가능하다.
**공개범위는 public -> protected -> default -> private로 좁아진다.**

### 어노테이션
> 자바 소스에 추가하여 사용할 수 있는 메타데이터의 일종이다. 
> 보통 @ 기호를 앞에 붙여서 사용한다.
> 클래스 파일에 임베디드되어 컴파일러에 의해 생성된 후 자바 가상머신에 포함되어 작동한다.

- 예전에는 자바 파일과 설정 파일을 따로 저장하고, ver.@.@로 구분하여 관리했다.
  - 이 때, 사람들이 자바 코드는 변경하는데 설정 파일을 업데이트 하지 않는 어려움, 설정과 코드가 분리되어 있어 개발에 대한 어려움이 발생했다.
  - 이를 해결하기 위해 어노테이션을 만들게 되었다.

1. 표준 어노테이션 
- 자바가 기본적으로 제공해주는 어노테이션
**예시**
- @Override
  - 오버라이딩을 올바르게 했는지를 컴파일러가 체크
```java
class Parent{
void parentMethod(){}
}

class Child extends Parent{
@Override
void parentMethod(){}
```

- @Deprecated
  - 앞으로 사용하지 않을 것을 권장하는 필드나 메서드에 붙인다.
```java
@Deprecated
public int getDate(){
return normalize().getDayOfMonth();
}
```

- @SuppressWarnings
  - 컴파일러의 경고메세지가 나타나지 않게한다.
```java
 @SuppressWarnings("unchecked") //제네릭의 경고메시지 안나타나게
```

- @FunctionalInterface
  - 함수형 인터페이스에 붙이면, 컴파일러가 올바르게 작성했는지 체크한다.
```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}
```

2. 메타 어노테이션
- 어노테이션을 위한 어노테이션

**예시**
- @Target
  - 어노테이션을 정의할 때, 적용 대상을 지정하는데 사용한다.
```java
@Target({TYPE, FIELD, TYPE_USE})
```

- @Retention
  - 어노테이션이 유지되는 기간을 지정하는데 사용
```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
```
3. 사용자정의 어노테이션
- 사용자가 직접 정의하는 어노테이션

**어노테이션의 특징**
- 적용 시 값을 지정하지 않으면, 사용될 수 있는 기본값을 지정할 수 있다.
- 요소가 하나이고, 이름이 value일 때는 요소이름을 생략할 수 있다.

**조상 어노테이션**
- Annotation은 모든 어노테이션의 조상이지만 상속은 불가능하다.

**마커 어노테이션**
- 요소가 하나도 정의되지 않은 어노테이
