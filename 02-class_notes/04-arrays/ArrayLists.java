// package 02-class_notes.04-arrays;
import java.util.ArrayList;
public class ArrayLists {
    public static void main(String[] args){
    
        System.out.println("Dynamic Arrays Hello");

        ArrayList<String> names = new ArrayList<String>(); // this is how you format the array list
        System.out.println(names);
        names.add("Rora");
        names.add("Lexi"); //adds to the array
        System.out.println(names); // this will print the array
        System.out.println(names.get(0)); //names.get() will get you the name at that index number

        names.remove(0); //this removes a name at that value
        names.set(0,"Rachel");
        System.out.println(names);

        ArrayList<String> cars = new ArrayList<String>(java.util.Arrays.asList("Truck", "Jeep"));
        System.out.println(cars);
}
}