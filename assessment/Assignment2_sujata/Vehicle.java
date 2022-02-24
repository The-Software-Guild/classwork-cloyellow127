// Exercise 1: Create a class called Vehicle. Create subclasses like Truck, Bus, Car etc. Add common methods in the base class 
// and specific methods in the corresponding class. Create a class called Road 
// and create objects for the Truck, Car, Bus etc and display the appropriate message.

// Exercise 2: Create a class called Shape3D with the following method signatures alone, volume () and 
// surfaceArea (). Then create subclasses like Cylinder, Sphere, and Cube etc and implement 
// these methods.

// Exercise 3:Create the classes required to store data regarding different types of courses that employees In a company can enroll for. All courses have name and course fee. Courses are also either 
// classroom delivered or delivered online. Courses could also be full time or part time. The 
// program must be menu based input which enables the course coordinator to register 
// employees for courses, list out employees registered for specific courses, deregister employees 
// from a course.
public class Vehicle {
    private String type;

    Vehicle(){
        type = "Vehicle";
    }

    protected void getType() {
        System.out.println("This is a " + type);
    }

    protected void setType(String type){
        this.type = type;
    }
}

