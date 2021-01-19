public class Complex implements Cloneable {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex() {
        this(0.0, 0.0);
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public boolean equals(Complex other) {
        return real == other.real && imaginary == other.imaginary;
    }

    public void increase(Complex other) {
        real += other.real;
        imaginary += other.imaginary;
    }

    public void decrease(Complex other) {
        real -= other.real;
        imaginary -= other.imaginary;
    }

    public Complex sum(Complex other) {
        return new Complex(real + other.real, imaginary + other.imaginary);
    }

    public Complex difference(Complex other) {
        return new Complex(real - other.real, imaginary - other.imaginary);
    }

    public Complex multiplication(Complex other) {
        return new Complex(real * other.imaginary + imaginary * other.real,
                real * other.real - imaginary * other. real);
    }

    public String toString() {
        if ( imaginary < 0 ) {
            return "(" + real + imaginary + "i)";
        } else {
            return "(" + real + "+" + imaginary + "i)";
        }
    }
    public Complex clone() throws CloneNotSupportedException {
        return (Complex) super.clone();
    }
}
