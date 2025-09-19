import java.util.Scanner;
    // function to change the first character of each word to Uppercase 
    class UpperCaseString {
    public static String toUpperCase(String s ){
        StringBuilder sb = new StringBuilder(" ");
        char ch = Character.toUpperCase(s.charAt(0));
        sb.append(ch);

        // loop for checking spaces and changing the first word after the space toUpperCase

        for(int i=1;i<s.length();i++){
            if(s.charAt(i) ==  ' ' && i<s.length()-1){
                sb.append(s.charAt(i));
                i++;
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
            else{
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine(); 

        System.out.println("The UpperCase of each word in the sentence : "+toUpperCase(input));

    }
}
