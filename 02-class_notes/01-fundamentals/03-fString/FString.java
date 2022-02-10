public class FString {
    public static void main(String [] args){

        String name = "Rora"; //String is the data type. All variables need a data type when creating them. name is our variable. "Rora" is our value.

        //int is a "primitive type. it contains the minimum requirements to store an integer. The plus side is that it takes up less space while the downside is that it comes with no built in functions like Integer does has"
        int numberOfFur = 500000000;
        // Integer is an object type. it takes up more space but has built in functions. 
        Integer tails = 1;

        System.out.println("Hello World");
        System.out.println(name + " is a real good girl!");
        System.out.println(name + " has " + numberOfFur + "furs!");
        System.out.println(name + " has " + tails + " tail.");
        System.out.println(String.format("How is it going %s, you have %s tail!", name, tails));
        System.out.printf("Hello %s! You have so much fur, %s \n",name, numberOfFur); // important to know, printf will not move the log down a line, anything added after printf will appear on same line. to move down a line add \n inside the "" at the end of your line before the variables.
        System.out.printf("testing \n");
        System.out.println("Testing");
    }
}
