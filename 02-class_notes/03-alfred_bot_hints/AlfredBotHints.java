import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class AlfredBotHints{
    public static void main(String[] args){

        AlfredBotHints alfredBot = new AlfredBotHints();
        
        // Make some test greetings, providing any necessary data
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Rora");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        
        // String alexisTest = alfredBot.respondBeforeAlexis(
        //                     "Alexis! Play some low-fi beats."
        //                     );
        // String alfredTest = alfredBot.respondBeforeAlexis(
        //     "I can't find my yo-yo. Maybe Alfred will know where it is.");
        // String notRelevantTest = alfredBot.respondBeforeAlexis(
        //     "Maybe that's what Batman is about. Not winning. But failing.."
        // );
        
        // // Print the greetings to test.
        System.out.println(testGreeting);
        System.out.println(testGuestGreeting);
        System.out.println(testDateAnnouncement);



    }

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return String.format("Hello, %s. Lovely to see you.", name);
    }
    
    public String dateAnnouncement() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  

        LocalDateTime now = LocalDateTime.now();
        String currentDate = dateFormatter.format(now);
        
        return String.format("Current date is: %s", currentDate);
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if(conversation.indexOf("Alexis") > -1) {
            return "She can't help you at the moment";
        }

        if(conversation.indexOf("Alfred") > -1){
            return "Here to help";
        }

        return "Anything else?";
    }
    
}

