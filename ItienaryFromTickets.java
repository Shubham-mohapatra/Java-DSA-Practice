import java.util.*;
public class ItienaryFromTickets {

    public static String getStart(HashMap<String,String> tickets){
        // create a reverse hashmap for "to" -> "from"
        HashMap<String,String> revmap = new HashMap<>();
        for(String key : tickets.keySet()){
            revmap.put(tickets.get(key) , key); // reversed
        }

        // check if the "from" city is there is "to"
        for(String key : tickets.keySet()){
            if(!revmap.containsKey(key)){  // if the revmap doesnt contain the "from" city
                return key; // return the starting point
            }
        }



        return null;
    }



    public static void main(String[]args){
        HashMap<String,String> tickets = new HashMap<>();
        // add from and to cities
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");

        String start = getStart(tickets);
        // print the starting point
        System.out.print(start);
        for(String key : tickets.keySet()){
            System.out.print( "-> "+tickets.get(start)); // get the next value after start
            start = tickets.get(start);
        }
        System.out.println();
    }

}
