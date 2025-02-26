package geometricfigures;

public class Square implements GeometricFigure {
    private double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона квадрата должна быть положительной!");
        }
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}
