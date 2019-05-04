package week14.polymorphismexample;

public class AnimalTest {

    public static void main(String[] args) {
        Cat cat1 = new Cat(); // not polymorphism
        Animal cat2 = new Cat(); // polymorphism

        cat1.sound();
        cat2.sound();

        cat2 = new Dog(); // polymorphism power
        cat2.sound();

        // cat1 = new Dog(); // you can't do it, because there is no ploymorphism
    }

}
