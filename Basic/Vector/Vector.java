public class Vector implements Cloneable {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        this(0.0, 0.0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double value) {
        x = value;
    }

    public void setY(double value) {
        y = value;
    }

    public double len() {
        return Math.hypot(x, y);
    }

    public boolean equal(Vector other) {
        return x == other.x && y == other.y;
    }

    public void increase(Vector other) {
        x += other.x;
        y += other.y;
    }

    public void decrease(Vector other) {
        x -= other.x;
        y -= other.y;
    }

    public Vector sum(Vector other) {
        return new Vector(x + other.x, y + other.y);
    }

    public Vector difference(Vector other) {
        return new Vector(x - other.x, y - other.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Vector clone() throws CloneNotSupportedException {
        return (Vector) super.clone();
    }
}
