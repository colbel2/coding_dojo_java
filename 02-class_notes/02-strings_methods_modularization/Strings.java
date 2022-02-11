public class Strings {
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

    }
}
