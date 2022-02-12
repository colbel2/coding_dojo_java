// import java.util.Arrays;

public class Arrays{
    public static void main(String[] args){
        System.out.println("Hello Array Demo");

        int[] nums = {5,8,6,9}; // this is one way to initialize an array. int only uses primitive integers. use {} isntead of [] in Java for array

        int[] nums2 = new int[5]; // this is saying create an integer array called nums which will have 5 values it can fill...
            // [0,0,0,0,0] this what it lookes like under the hood. There is no way to add or take away from it. This array is static size.
        nums2[0] = 5;
        nums2[1] = 69;
        
        System.out.println(nums2[0]);
        System.out.println(nums); //prints crazy stuff
        System.out.println(java.util.Arrays.toString(nums2)); 

        String [] statesInAmerica = new String[50]; // you tould create a static array like this that will always have a set number that is not going to change
        statesInAmerica[0]="Alabama";
        statesInAmerica[1] = "Alaska";

    

    }



}