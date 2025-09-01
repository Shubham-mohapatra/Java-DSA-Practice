public class Polymorphism {

    // Method overloading -> compile time polymorphism
    static class Calculator{

        int sum(int a , int b){
            return a+b;
        }
        float sum(float a , float b){
            return a+b;
        }
        int sum(int a , int b , int c ){
            return a+b+c;
        }
    }

    // Method overriding -> run time polymorphism -> same function in both the parent and the child class but have different definations

    static class Animal{

        void eats(){
            System.out.println("Eats food");
        }

    }

    static class Deer extends Animal {
        void eats(){
            System.out.println("Eats only grass"); // here the eat function is called in both the parent and the child class but their functioning is different from each other
        }
    }


    public static void main(String[]args){
        Calculator c = new Calculator();

        System.out.println(c.sum(2,4));
        System.out.println(c.sum((float)2.5,(float)1.5));
        System.out.println(c.sum(2,3,4));

        Deer d = new Deer();
        d.eats();


    }
}
