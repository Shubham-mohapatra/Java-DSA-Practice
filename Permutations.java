public class Permutations {

    // func to find the number of ways to form new strings
    // str.len = n , number of ways -> n!

    public static void findPermutations(String str , String ans){
        // base  case  -> when str.len == 0
        //print the ans and return
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        // recursion step

        for(int i =0;i<str.length();i++){
            // find the curr char
            char ch = str.charAt(i);
            // remove the  curr character at the i the level so that it doesn't get included in the next level
            // abcde => "ab" + "de" -> "abde"
            String newstr = str.substring(0,i) + str.substring(i+1);
            // skip the curr char and add the rest of the char till the str.length-1

            // backtrack
            findPermutations(newstr , ans+ch);
        }

    }

    public static void main(String[]args){
        String str = "abc";
        findPermutations(str,"");

    }
}
