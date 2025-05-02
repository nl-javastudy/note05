class Foo {
    public void foo() {
        System.out.println("foo");
    }
}

public class Main {
    public static void main(String[] args) {
        Foo f = null;

        try {
            f.foo();
        } catch (NullPointerException e) {
            f = new Foo();
        } finally {
            f.foo();
        }
    }
}