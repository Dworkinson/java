public class Car implements Cloneable {
    private double fuelAmount;
    private double fuelCapacity;
    private double fuelConsumption;
    private Point location;
    private String model;

    public Car(double capacity, double consumption, Point location, String model) {
        this.fuelCapacity = capacity;
        this.fuelConsumption = consumption;
        this.location = location;
        this.model = model;
    }

    public Car() {
        this(60, 0.6, new Point(0.0, 0.0), "Mersedes");
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public Point getLocation() {
        return location;
    }

    public String getModel() {
        return model;
    }

    public void drive(Point destination) throws OutOfFuel {
        double distance = destination.distance(location);
        double fuelNeeded = distance * fuelConsumption;

        if ( fuelAmount < fuelNeeded ) {
            throw new OutOfFuel();
        } else {
            fuelAmount -= fuelNeeded;
            location = destination;
        }
    }

    public void drive(double x, double y) throws OutOfFuel {
        Point destination = new Point(x, y);
        this.drive(destination);
    }

    public void refill(double fuel) throws ToMuchFuel {
        double freeCapacity = fuelCapacity - fuelAmount;

        if ( fuel > freeCapacity ) {
            throw new ToMuchFuel();
        } else {
            fuelAmount += fuel;
        }
    }

    public void show() {
        System.out.println("Model: " + model);
        System.out.println("\tFuel capacity: " + getFuelCapacity());
        System.out.println("\tFuel amount: " + getFuelAmount());
        System.out.println("\tFuel consumption: " + getFuelConsumption());
        System.out.println("<" + model + ">" + " is located in: " + getLocation());
    }

    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }
}