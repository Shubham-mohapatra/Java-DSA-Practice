import java.util.Scanner;

// Class to represent and operate on complex numbers
class ComplexNumbers {
    int real;
    int imag;

    // Constructor to initialize real and imaginary parts
    public ComplexNumbers(int r, int i) {
        real = r;
        imag = i;
    }

    // Method to add two complex numbers
    public ComplexNumbers add(ComplexNumbers other) {
        return new ComplexNumbers(this.real + other.real, this.imag + other.imag);
    }

    // Method to subtract two complex numbers
    public ComplexNumbers subtract(ComplexNumbers other) {
        return new ComplexNumbers(this.real - other.real, this.imag - other.imag);
    }

    // Method to multiply two complex numbers
    public ComplexNumbers multiply(ComplexNumbers other) {
        int realPart = this.real * other.real - this.imag * other.imag;
        int imagPart = this.real * other.imag + this.imag * other.real;
        return new ComplexNumbers(realPart, imagPart);
    }

    // Method to display a complex number
    public void display() {
        System.out.println(real + (imag >= 0 ? " + " : " - ") + Math.abs(imag) + "i");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for first complex number
        System.out.print("Enter real and imaginary part of first complex number: ");
        int r1 = sc.nextInt();
        int i1 = sc.nextInt();
        ComplexNumbers c1 = new ComplexNumbers(r1, i1);

        // Input for second complex number
        System.out.print("Enter real and imaginary part of second complex number: ");
        int r2 = sc.nextInt();
        int i2 = sc.nextInt();
        ComplexNumbers c2 = new ComplexNumbers(r2, i2);

        // Operations
        ComplexNumbers sum = c1.add(c2);
        ComplexNumbers diff = c1.subtract(c2);
        ComplexNumbers prod = c1.multiply(c2);

        // Output
        System.out.print("Sum: ");
        sum.display();
        System.out.print("Difference: ");
        diff.display();
        System.out.print("Product: ");
        prod.display();
    }
}
