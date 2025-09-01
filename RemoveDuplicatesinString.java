public class RemoveDuplicatesinString {
    // using recursion to remove duplicates in a string
    public static void removeDuplicates(String s, int index, StringBuilder newstr, boolean[] map) {
        // base case
        if (index == s.length()) {
            System.out.println(newstr);
            return;
        }

        char curr = Character.toLowerCase(s.charAt(index)); // handle uppercase
        if (map[curr - 'a']) {
            removeDuplicates(s, index + 1, newstr, map);
        } else {
            map[curr - 'a'] = true;
            removeDuplicates(s, index + 1, newstr.append(s.charAt(index)), map);
        }
    }

    public static void main(String args[]) {
        String s = "Shubham";
        removeDuplicates(s, 0, new StringBuilder(), new boolean[26]);
    }
}
