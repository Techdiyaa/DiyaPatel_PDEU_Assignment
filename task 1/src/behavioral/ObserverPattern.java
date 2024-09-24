package behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update(String message);
}

class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }
}

class NewsChannel implements Observer {
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received news: " + message);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter news channel name: ");
        String channelName = scanner.nextLine();
        NewsChannel channel = new NewsChannel(channelName);

        agency.attach(channel);

        while (true) {
            System.out.print("Enter news (or 'exit' to quit): ");
            String news = scanner.nextLine();
            if (news.equalsIgnoreCase("exit")) break;
            agency.setNews(news);
        }
        scanner.close();
    }
}
