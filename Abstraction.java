public class Abstraction {
    // implementation of abstract classes

    abstract class Animal{
        // initialzing constructor in abstract classes , when the child class object is formed then parent class constructor is called first
        Animal(){
            System.out.println("Animal constructor called");
        }
        void eats(){
            System.out.println("eats");
        }

        abstract void walk(); // implementation in the child class
    }

    // child class

     class Horse extends Animal{
        Horse(){
            System.out.println("Horse Constructor is called");
        }

        void walk(){
            System.out.println("Dog walks on 4 legs ");
        }
    }

    class Mustang extends Horse{
        Mustang(){
            System.out.println("Mustang constructor is called");
        }
    }

    public void main(String[]args){
       Mustang myhorse = new Mustang();


    }
}
