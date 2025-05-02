# Java에서 Exception(예외)와 Error(에러)의 차이점 및 예시

## 1. 개념

- **Error(에러)**
  - JVM, 시스템, 하드웨어 등에서 발생하는 심각한 문제
  - 개발자가 복구하거나 처리할 수 없음

- **Exception(예외)**
  - 프로그램 실행 중 발생하는 예외적인 상황
  - 개발자가 예측하고 처리할 수 있음

---

## 2. 상속 구조


---

## 3. 차이점 비교

| 구분             | Error(에러)                              | Exception(예외)                      |
|------------------|------------------------------------------|--------------------------------------|
| 발생 원인        | JVM, 시스템, 하드웨어 등                  | 코드 로직, 외부 자원, 사용자 입력 등  |
| 복구 가능성      | 복구 불가                                 | 복구 가능                            |
| 예외 처리 여부   | try-catch로 처리 권장하지 않음            | try-catch, throws 등으로 처리 가능   |
| 예시             | OutOfMemoryError, StackOverflowError 등   | NullPointerException, IOException 등 |
| 용도             | 시스템적 치명적 오류                      | 프로그램 실행 중 예외적 상황          |
| 상속 구조        | Throwable → Error                         | Throwable → Exception                |

---

## 4. 에러와 예외의 대표적인 예시

### Error(에러) 예시

- **OutOfMemoryError**: JVM의 메모리가 부족할 때 발생  
- **StackOverflowError**: 메서드의 재귀 호출이 너무 깊어 스택 메모리가 초과될 때 발생  
- **VirtualMachineError**: JVM이 심각한 내부 문제를 만났을 때 발생  
- **NoClassDefFoundError**: 클래스 파일을 찾을 수 없을 때 발생  
- **LinkageError**: 클래스의 링크에 문제가 있을 때 발생  
- 예시 코드:
    ```
    public class ErrorExample {
        public static void main(String[] args) {
            recursive();
        }
        public static void recursive() {
            recursive(); // StackOverflowError 발생
        }
    }
    ```
[1][3]

---

### Exception(예외) 예시

- **NullPointerException**: null 객체를 참조할 때 발생  
- **ArrayIndexOutOfBoundsException**: 배열의 인덱스 범위를 벗어날 때 발생  
- **ArithmeticException**: 0으로 나누기 등 산술 연산 오류  
- **IOException**: 입출력 작업 실패  
- **FileNotFoundException**: 존재하지 않는 파일을 열 때  
- **NumberFormatException**: 문자열을 숫자로 변환할 때 형식이 맞지 않을 때  
- 예시 코드:
    ```
    // NullPointerException 예시
    public class ExceptionExample1 {
        public static void main(String[] args) {
            String str = null;
            System.out.println(str.length()); // NullPointerException 발생
        }
    }

    // ArrayIndexOutOfBoundsException 예시
    public class ExceptionExample2 {
        public static void main(String[] args) {
            int[] arr = new int[3];
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException 발생
        }
    }

    // ArithmeticException 예시 (try-catch)
    public class ExceptionExample3 {
        public static void main(String[] args) {
            try {
                int result = 5 / 0;
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException => " + e.getMessage());
            }
        }
    }

    // IOException 예시 (throws)
    import java.io.*;
    public class ExceptionExample4 {
        public static void findFile() throws IOException {
            File newFile = new File("test.txt");
            FileInputStream stream = new FileInputStream(newFile);
        }
        public static void main(String[] args) {
            try {
                findFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    ```
[2][3][4][5][7]

---

## 5. 결론

- **Error**: 시스템 레벨의 치명적 오류, 복구 불가, 예외 처리 불필요
- **Exception**: 프로그램 실행 중 예외 상황, 복구 가능, 예외 처리 필요
