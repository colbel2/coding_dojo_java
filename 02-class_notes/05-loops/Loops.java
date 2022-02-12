// package 02-class_notes.05-loops;
import java.util.ArrayList;
public class Loops {
    
    public static void main(String[] args){
    
        System.out.println("Dynamic Arrays Hello");

        ArrayList<String> names = new ArrayList<String>(); // this is how you format the array list
        System.out.println(names);
        names.add("Rora");
        names.add("Lexi"); //adds to the array
        names.add("Colin");
        names.add("Rachel");

        System.out.println(names); // this will print the array
        System.out.println(names.get(0)); //names.get() will get you the name at that index number

        names.remove(0); //this removes a name at that value
        names.set(0,"Colin");
        // names.set(1,"Rachel");
        // names.set(2,"Lexi");
        // names.set(3,"Rora");


        System.out.println(names);

        ArrayList<String> cars = new ArrayList<String>(java.util.Arrays.asList("Truck", "Jeep"));
        System.out.println(cars);

        for (int i = 0; i<names.size(); i++){
            
            System.out.println("Looping: i is ===>" + 1);
            System.out.println(names.get(i)); //like saying names[i]in JS 
        }

        // enhanced loop is when we dont need index numbers, just values at teh index numbers
        for(String name: names){
            System.out.println(name);
        }
}
}

