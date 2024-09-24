import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float stockPrice);
}

// Concrete observer class
class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(float stockPrice) {
        System.out.println(name + " notified: New stock price is " + stockPrice);
    }
}

// Subject (Observable) interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject class
class Stock implements Subject {
    private float price;
    private List<Observer> observers = new ArrayList<>();

    public void setPrice(float price) {
        this.price = price;
        notifyObservers(); // Notify all observers when stock price changes
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}

// Main class to demonstrate Observer Pattern
public class ObserverPattern {
    public static void main(String[] args) {
        Stock stock = new Stock();

        // Create observers
        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        // Register observers
        stock.registerObserver(investor1);
        stock.registerObserver(investor2);

        // Simulate price changes
        stock.setPrice(100);
        stock.setPrice(200);
    }
}
