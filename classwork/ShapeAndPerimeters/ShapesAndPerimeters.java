public class ShapesAndPerimeters {
    private static abstract class Shape{
        private double area;
        private double perimeter;
        private String colour;
        Shape(){
        }
        public String getColour() {
            return colour;
        }
        public void setColour(String colour) {
            this.colour = colour;
        }
        public void setArea(double area) {
            this.area = area;
        }
        public void setPerimeter(double perimeter) {
            this.perimeter = perimeter;
        }
        public double getArea() {
            return area;
        }
        public double getPerimeter() {
            return perimeter;
        }
    }

    public static class Circle extends Shape{
        private double radius;
        Circle(double radius){
            this.radius = radius;
            setArea();
            setPerimeter();
        }
        public void setArea(){
            super.area = Math.PI * radius * radius;
        }
        public void setPerimeter() {
            super.perimeter = Math.PI * radius * 2;
        }
        public double getRadius() {
            return radius;
        }
    }

    public static class Square extends Shape{
        private double length;
        Square(double length){
            this.length = length;
            setArea();
            setPerimeter();
        }
        public void setArea() {
            super.area = length * length;
        }
        public void setPerimeter() {
            super.perimeter = length * 4;
        }
        public double getLength() {
            return length;
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.setColour("red");
        System.out.println("\nThis is a " + circle.getColour() + " circle. \nRadius: " + circle.getRadius());
        System.out.println("Perimeter: " + circle.getPerimeter());
        System.out.println("Area: " + circle.getArea());

        Square square = new Square(5);
        square.setColour("blue");
        System.out.println("\nThis is a " + square.getColour() + " square. \nLength: " + square.getLength());
        System.out.println("Perimeter: " + square.getPerimeter());
        System.out.println("Area: " + square.getArea());
    }
}
