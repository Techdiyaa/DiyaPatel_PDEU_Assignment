package creational;

import java.util.Scanner;

interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    public void sound() {
        System.out.println("Meow!");
    }
}

class AnimalFactory {
    public Animal createAnimal(String type) {
        switch (type.toLowerCase()) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            default:
                throw new IllegalArgumentException("Unknown animal type");
        }
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter animal type (dog/cat): ");
        String type = scanner.nextLine();
        
        try {
            Animal animal = animalFactory.createAnimal(type);
            animal.sound();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } finally {
        }
    }
}
