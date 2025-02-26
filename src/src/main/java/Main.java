import geometricfigures.Circle;
import geometricfigures.GeometricFigure;
import geometricfigures.Rectangle;
import geometricfigures.Square;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<GeometricFigure> figures = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split(",");
                if (parts.length == 2) {
                    try {
                        String type = parts[0].toLowerCase();
                        double value1 = Double.parseDouble(parts[1].trim());

                        if (type.equals("circle")) {
                            figures.add(new Circle(value1));
                        } else if (type.equals("square")) {
                            figures.add(new Square(value1));
                        } else {
                            throw new IllegalArgumentException("Невозможно обработать фигуру: " + type);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Ошибка преобразования строки в число: " + e.getMessage());
                    }
                } else if (parts.length == 3) {
                    try {
                        String type = parts[0].toLowerCase();
                        double value1 = Double.parseDouble(parts[1].trim());
                        double value2 = Double.parseDouble(parts[2].trim());

                        if (type.equals("rectangle")) {
                            figures.add(new Rectangle(value1, value2));
                        } else {
                            throw new IllegalArgumentException("Неизвестная фигура: " + type);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Ошибка преобразования строки в число: " + e.getMessage());
                    }
                } else {
                    System.err.println("Неверный формат данных в строке: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (GeometricFigure figure : figures) {
            System.out.println("Площадь: " + figure.calculateArea());
            System.out.println("Периметр: " + figure.calculatePerimeter());
        }
    }
}