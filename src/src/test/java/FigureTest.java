import geometricfigures.Circle;
import geometricfigures.Rectangle;
import geometricfigures.Square;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FigureTest {
    private static final double PI = 3.14159;
    @DataProvider(name = "circles")
    public Object[][] circles() {
        return new Object[][]{
                {1.0, PI},
                {2.0, 4 * PI},
                {3.0, 9 * PI}
        };
    }

    @Test(dataProvider = "circles")
    public void testCircleArea(double radius, double expectedArea) {
        Circle circle = new Circle(radius);
        assertEquals(circle.calculateArea(), expectedArea, 0.00001);
    }

    @DataProvider(name = "rectangles")
    public Object[][] rectangles() {
        return new Object[][]{
                {2.0, 3.0, 6.0},
                {4.0, 5.0, 20.0},
                {10.0, 15.0, 150.0}
        };
    }

    @Test(dataProvider = "rectangles")
    public void testRectangleArea(double length, double width, double expectedArea) {
        Rectangle rectangle = new Rectangle(length, width);
        assertEquals(rectangle.calculateArea(), expectedArea, 0.00001);
    }

    @DataProvider(name = "squares")
    public Object[][] squares() {
        return new Object[][]{
                {2.0, 4.0},
                {3.0, 9.0},
                {5.0, 25.0}
        };
    }

    @Test(dataProvider = "squares")
    public void testSquareArea(double side, double expectedArea) {
        Square square = new Square(side);
        assertEquals(square.calculateArea(), expectedArea, 0.00001);
    }

    @DataProvider(name = "circlePerimeters")
    public Object[][] circlePerimeters() {
        return new Object[][]{
                {1.0, 2 * PI},
                {2.0, 4 * PI},
                {3.0, 6 * PI}
        };
    }

    @Test(dataProvider = "circlePerimeters")
    public void testCirclePerimeter(double radius, double expectedPerimeter) {
        Circle circle = new Circle(radius);
        assertEquals(circle.calculatePerimeter(), expectedPerimeter, 0.00001);
    }

    // Данные для тестирования периметра прямоугольников
    @DataProvider(name = "rectanglePerimeters")
    public Object[][] rectanglePerimeters() {
        return new Object[][]{
                {2.0, 3.0, 10.0},
                {4.0, 5.0, 18.0},
                {10.0, 15.0, 50.0}
        };
    }

    @Test(dataProvider = "rectanglePerimeters")
    public void testRectanglePerimeter(double length, double width, double expectedPerimeter) {
        Rectangle rectangle = new Rectangle(length, width);
        assertEquals(rectangle.calculatePerimeter(), expectedPerimeter, 0.00001);
    }

    // Данные для тестирования периметра квадратов
    @DataProvider(name = "squarePerimeters")
    public Object[][] squarePerimeters() {
        return new Object[][]{
                {2.0, 8.0},
                {3.0, 12.0},
                {5.0, 20.0}
        };
    }

    @Test(dataProvider = "squarePerimeters")
    public void testSquarePerimeter(double side, double expectedPerimeter) {
        Square square = new Square(side);
        assertEquals(square.calculatePerimeter(), expectedPerimeter, 0.00001);
    }
}