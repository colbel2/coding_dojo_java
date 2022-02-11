public class Methods {
    public static void main(String[] args) {
        System.out.println("Hello Strings");

        String coolQuote = "It is not the mountains ahead that will wear you out, it is the pebble in your shoe";
        // many methods are possible
        coolQuote.length(); // gives length of string

        String author = "Muhammad Ali";

        String result = coolQuote.concat(author); // concat with accept a string type and return string
        // you cant create a variable without a data type.
        System.out.println(result);

        System.out.println(coolQuote.indexOf("pebble"));

        Integer indexWherePebble = coolQuote.indexOf("pebble");
        System.out.println(indexWherePebble);

        // Equality Comparison for Strings
        // Normal string assignment
        String a = "same string";
        String b = "same string";
        System.out.println(a == b); // true
        // Creating new strings as separate objects (another way to create a String)
        a = new String("same letters");
        b = new String("same letters");
        System.out.println(a == b); // false. Not the same object in memory.
        System.out.println(a.equals(b)); // true. same exact characters.

        generateFullName("Colin", "Belmar");
        generateFirstName("Rora");

        generateFullName("Rachel", "Kaye", "Meyer");
    }


    //createing my own method here
    // public void is used when you are not returning anything

    public static void generateName(String strInput){
        System.out.println(strInput);
    }

    public static void generateFirstName(String strFirstName){
        System.out.println(strFirstName);
    }

    public static void generateLasName(String strLastName){
        System.out.println(strLastName);
    }

    public static void generateFullName(String firstName, String lastName){
        System.out.println(firstName + lastName);
        System.out.println(String.format("Hello, %s %s", firstName, lastName));

    }

    //Method overloading is when you have multiple methods that are the same in their return type and name but they are different in their parameters
    public static void generateFullName(String firstName,String middleName, String lastName){ // these methods are the same name but different signatures. 
        System.out.println(firstName + lastName);
        System.out.println(String.format("Hello, %s %s", firstName, lastName));

    }
}