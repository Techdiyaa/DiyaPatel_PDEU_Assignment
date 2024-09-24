package structural;

import java.util.ArrayList;
import java.util.List;

interface Graphic {
    void draw();
}

class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class CompositeGraphic implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    public void remove(Graphic graphic) {
        graphics.remove(graphic);
    }

    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();

        CompositeGraphic compositeGraphic = new CompositeGraphic();
        compositeGraphic.add(circle);
        compositeGraphic.add(square);

        compositeGraphic.draw();
    }
}
