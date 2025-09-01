public class Interfaces {
    // implementation of interface -> multiple inheritance , total abstraction

    // Bear class will implement the methods in the harbivore and the carnivore interfaces

    interface Herbivore{
        void eats(); // just like abstraction in interface the implementation of the methods are in the child class

    }

    interface Carnivore{
        void eats();

    }

    static class Bear implements Herbivore,Carnivore {
        public void eats(){
            System.out.println("Bear is Omnivores ");
        }

    }

    public static void main(String[]args){
        Bear b = new Bear();
        b.eats();

    }
}
