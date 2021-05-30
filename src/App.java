import java.util.Scanner;
import java.lang.Math;

public class App {

    public static boolean flip(String guess){
        //tails equals 1 and heads equals 2
        int result = (int)(Math.random() * 2 + 1);
        if((result == 2 && guess.equals("heads")) || (result == 1 && guess.equals("tails")))
            return true;
        return false;

    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter(System.lineSeparator());

        String cont = "yes";
        boolean ans;
        int compC = 0;
        int playC = 0;

        System.out.println("What's your given name?");
        String firstName = scan.nextLine();
        String nick = firstName.substring(0,1);

        System.out.println("And your surname?");
        String lastName = scan.nextLine();

        System.out.println("Thanks " + firstName + " " + lastName + "!");

        System.out.println("\nWait! How old are you??");
        int age = scan.nextInt();

        System.out.print("Hmm...I think " + age + " is old enough to play my little game. Say, " + nick + ", can I call you " + nick + "? ");
        System.out.println("My favorite game is a good old-fashioned coin flip! I'll keep score—you can trust me *wink wink*.");

        String guess = "";

        while(cont.equals("yes")){
            System.out.println("Heads or tails? (all lowercase please!)");
            guess = scan.next();
            ans = flip(guess);
            
            if(ans){
                playC++;
                System.out.println("Darn! It WAS " + guess + "! Play again? yes/no");
                System.out.println("\nScore: [Computer - " + compC + " ]  [Player - " + playC + " ]");
                cont = scan.next();
            }
            else if(!ans){
                compC++;
                System.out.println("Bazinga! I KNEW it wouldn't be " + guess + "! Play again? yes/no");
                System.out.println("\nScore: [Computer - " + compC + " ]  [Player - " + playC + " ]");
                cont = scan.next();
            }
        }
        if(playC > compC){
            System.out.println("Man, I really thought I had it, " + nick + "! GG!");
        }
        else if(playC < compC){
            System.out.println("Well...not everyone is as great as me, " + nick + ". Better luck next time!");
        }
        else if(playC == compC){
            System.out.println("Did you end then on purpose " + nick + "?? I guess we tie...Let's play again soon!");
        }

        scan.close();
    }
}