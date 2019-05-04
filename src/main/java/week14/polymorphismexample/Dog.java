package week14.polymorphismexample;

public class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Bark bark!!");
    }
}
