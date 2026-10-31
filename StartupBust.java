import java.util.ArrayList;

public class StartupBust {
    private Gamehelper helper = new Gamehelper();
    private ArrayList<Startup> startups = new ArrayList<Startup>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        Startup one = new Startup();
        one.setName("solaris");
        Startup two = new Startup();
        two.setName("jeef");
        Startup three = new Startup();
        three.setName("lil clanker");
        startups.add(one);
        startups.add(two);
        startups.add(three);

        System.out.println("Sink three startups");
        System.out.println("solaris, jeef, and lil clanker");
        System.out.println("Sink them with the fewest # of guesses");

        for (Startup startup : startups){
            ArrayList<String> newLocation = helper.placeStartups(3);
            startup.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!startups.isEmpty()){
            String userGuess = helper.getUserInput("enter a guess");
            checkUserGuess = helper.getUserInput(userGuess);

        }
        finishGame();
    }


private void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "miss";

    for  (Startup startupToTest : startups){
        result = startupToTest.checkYourself(userGuess);

        if (result.equals("hit")){
            break;
        }
        if (result.equals("kill")){
            startups.remove(startupToTest);
            break;
        }
    }
    System.out.println(result);
}

private void finishGame(){
    System.out.println("All ur Startups died. Your worthless");
    if(numOfGuesses <= 18) {
        System.out.println("It only took you " + numOfGuesses + " guesses.");
        System.out.println("You got out before you options sank.");
    } else {
        System.out.println("Damn you slow, it took you " + numOfGuesses + " guesses.");
        System.out.println("Ur cooked");
    }   
}
public static void main(String[] args) {
    game.setUpGame();
    game.startPlaying();
}
}