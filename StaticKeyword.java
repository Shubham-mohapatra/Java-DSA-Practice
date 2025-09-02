public class StaticKeyword {

   static  class Student {
        String name ;
        int age;

        static  String schoolname;

        void setName(String name ){
            this.name = name;
        }

        String getname(){
            return this.name;
        }
    }



    public static void main(String[]args){
        // create an object for the Student class
        Student s1 = new Student();
        s1.schoolname = "APS";


    }
}
