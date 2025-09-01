
public class OOPS {

    static class Student {

        String name;
        int age;
        int marks[];

        // Parameterized constructor
        Student(String name, int age, int[] marks) {
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

        // Non-parameterized constructor
        Student() {
            marks = new int[3];
            System.out.println("Constructor is called");
        }

        // Copy constructor
        Student(Student s1) {
            marks = new int[3];
            this.name = s1.name;
            this.age = s1.age;
            for (int i = 0; i < s1.marks.length; i++) {
                this.marks[i] = s1.marks[i];
            }
        }




    }
     static class Animal {

        String color;

        void eat(){
            System.out.println("Eats");
        }
        void breathe(){
            System.out.println("Breathes");
        }
    }


    static class Mammal extends Animal {
        void walk(){
            System.out.println("Can walk ");
        }
    }

    static class Fish extends Animal{
        int fins;

        void swim(){
            System.out.println("Swims");
        }
    }

    static class Bird extends Animal{
        String fly;

        void fly(){
            System.out.println("Fly");
        }
    }



    public  static void main(String[] args) {
        int[] arr = {100, 200, 80};
        Student s1 = new Student("Shubham", 21, arr);
        System.out.println(s1.name);
        System.out.println(s1.age);
        for (int i = 0; i < 3; i++) {
            System.out.println(s1.marks[i]);
        }

        Student s2 = new Student();
        for (int i = 0; i < 3; i++) {
            System.out.println(s2.marks[i]); // prints 0,0,0
        }

        Student s3 = new Student(s1);
          System.out.println("Copied Student:");
        System.out.println(s3.name);
        System.out.println(s3.age);
        for (int i = 0; i < 3; i++) {
            System.out.println(s3.marks[i]);
        }


        Fish f1 = new Fish();
        f1.breathe();
        f1.eat();
        Bird b = new Bird();
        System.out.print("Bird : ");
        b.breathe();


    }
}
