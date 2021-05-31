import java.util.Scanner;
import java.lang.Math;

public class App {

    public static boolean flip(String guess){
        //tails equals 1 and heads equals 2
        int result = (int)((Math.random() * 2) + 1);
        if((result == 1 && guess.equals("heads")) || (result == 2 && guess.equals("tails")))
            return true;
        return false;

    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter(System.lineSeparator());

        boolean ans;
        int compC = 0;
        int playC = 0;

        System.out.println("What's your given name?");
        String firstName = scan.nextLine();
        String nick = (firstName.substring(0,1).toUpperCase());

        System.out.println("And your surname?");
        String lastName = scan.nextLine();

        System.out.println("Thanks " + firstName + " " + lastName + "!");

        System.out.println("\nWait! How old are you??");
        int age = scan.nextInt();

        System.out.print("Hmm...I think " + age + " is old enough to play my little game. Say, " + nick + ", can I call you " + nick + "? ");
        System.out.println("My favorite game is a good old-fashioned coin flip! I'll keep score——you can trust me *wink wink*.");

        System.out.println("So! Heads or tails? (H for heads / T for tails / Q to quit)");
        String guess = scan.next();
        guess = guess.toUpperCase();

        if(guess.equals("H") || guess.equals("T")){
            while(guess.equals("H") || guess.equals("T")){
            
                if(guess.equals("H")){
                    guess = "heads";
                }
                else if(guess.equals("T")){
                    guess = "tails";
                }
                ans = flip(guess);
                
                if(ans){
                    playC++;
                    System.out.println("Darn! It WAS " + guess + "! Heads or tails? (H/T/Q)");
                    System.out.println("\nScore: [Computer - " + compC + " ]  [Player - " + playC + " ]");
                    guess = scan.next();
                    guess = guess.toUpperCase();
                }
                else if(!ans){
                    compC++;
                    System.out.println("Bazinga! I KNEW it wouldn't be " + guess + "! Heads or tails? (H/T/Q)");
                    System.out.println("\nScore: [Computer - " + compC + " ]  [Player - " + playC + " ]");
                    guess = scan.next();
                    guess = guess.toUpperCase();
                }
            }
            if(guess.equals("Q")){
                if(playC > compC){
                    System.out.println("Man, I really thought I had it, " + nick + "! GG!");
                }
                else if(playC < compC){
                    System.out.println("Well...not everyone is as great as me, " + nick + ". Better luck next time!");
                }
                else if(playC == compC){
                    System.out.println("Did you end then on purpose " + nick + "?? I guess we tie...Let's play again soon!");
                }
            }
            else{
                System.out.println("That wasn't——you know what, take your jokes somewhere else, " + nick + ".");
            }
        }
        else{
            System.out.println("Really? If you want to play later, come find me.");
        }
        
        System.out.println("*\n*\n*\nEND");
        scan.close();
    }
}
