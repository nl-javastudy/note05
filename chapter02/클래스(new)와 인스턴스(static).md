# Java `new`와 `static` 개념 정리

## 1. `new` 키워드와 인스턴스

### (1) `new`
- `new` 키워드는 클래스의 인스턴스를 생성.
- 인스턴스는 클래스의 구체적인 객체로, 메모리에 독립적으로 존재.
- 클래스의 생성자를 호출하여 인스턴스를 만들고, 힙(Heap) 메모리에 할당.

### (2) 사용법
```java
class Animal {
    ...
}

Animal cat = new Animal("Kitty"); // new를 사용하여 인스턴스 생성

```

### (3) 특징
- `new`를 사용할 때마다 새로운 객체가 생성.
- 각 객체는 독립적인 필드 값을 가진다.
- 객체는 힙(Heap) 메모리에 저장, 사용되지 않으면 가비지 컬렉터(GC)에 의해 제거.

---

## 2. `static` 키워드와 클래스 멤버

### (1) `static`
- `static` 키워드는 클래스 레벨에서 공유되는 변수 및 메서드를 정의할 때 사용됩니다.
- `static`이 붙은 변수나 메서드는 **클래스 자체에 속하며**, 특정 인스턴스에 속하지 않습니다.
- **`static` 멤버는 인스턴스를 생성하지 않고도 사용할 수 있다.**

### (2) 사용법
```java
class Counter {
    static int count = 0; // 클래스 변수 (모든 인스턴스가 공유)
    
    Counter() {
        count++; // 생성될 때마다 증가
    }
    
    static void printCount() {
        System.out.println("Total count: " + count);
    }
}

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        
        Counter.printCount(); // "Total count: 3" 출력
    }
}
```

### (3) 특징
- `static` 변수는 **클래스 로드 시 단 한 번만 메모리에 할당**됩니다.
- 모든 인스턴스가 같은 `static` 변수를 공유합니다.
- `static` 메서드는 **인스턴스 없이** 클래스 이름을 통해 직접 호출할 수 있습니다.

---

## 3. 언제?

- `new`를 사용하여 인스턴스를 생성해야 하는 경우:
  - 객체마다 고유한 데이터를 유지해야 할 때 (예: 은행 계좌, 게임 캐릭터)
  - 객체별로 상태가 변화하는 경우

- `static`을 사용하는 것이 적절한 경우:
  - 공통된 데이터(예: `Math.PI`, `System.out`)를 여러 인스턴스에서 공유해야 할 때
  - 도구(Utility) 클래스처럼 객체 생성 없이 메서드를 호출할 때 (예: `Math.sqrt()`)