import java.util.*;
import java.util.ArrayList;
import java.util.Random;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.GREEN;
  private static final int BORDER_BACKGROUND = Text.CYAN + Text.BACKGROUND;

  public static void main(String[] args) {
    run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(ArrayList<Adventurer> playerParty, ArrayList<Adventurer> enemyParty){
    for (int x = 1; x < HEIGHT; x++) {
      for (int y = 1; y < WIDTH; y++) {
        drawText(" ", x, y, BORDER_BACKGROUND);
      }
    }

    int line = 0;
        for (int x = 1; x < WIDTH; x++) {
          drawText("-", line, x, Text.RED);
        }
    int line1 = HEIGHT / 3;
        for (int x = 1; x < WIDTH; x++) {
          drawText("-", line1, x, Text.RED);
        }
        int line2 = (HEIGHT * 2) / 3;
        for (int x = 1; x < WIDTH; x++) {
          drawText("-", line2, x, BORDER_COLOR);
        }
        int line3 = (HEIGHT);
        for (int x = 1; x < WIDTH; x++) {
          drawText("-", line3, x, BORDER_COLOR);
        }
        for(int y = 1; y < HEIGHT; y++){
          if((line2<y && y<line3) || (line<y && y<line1)){
          drawText("|", y, WIDTH/3, Text.BLACK);
        }
      }
        for(int y = 1; y < HEIGHT; y++){
          if((line2<y && y<line3) || (line<y && y<line1)){
          drawText("|", y, 2 *WIDTH/3, Text.BLACK);
        }

        drawParty(playerParty, 1);
        drawParty(enemyParty, 20);
//System.out.println("done");
  //  drawText(" ", x, y, 10);
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
  }}

  //Display a line of text starting at
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol, int b){
Text.go(startRow, startCol);
System.out.println(Text.colorize(s, 37, b));
  /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
  //YOUR CODE HERE
  /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
}

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  /*
  public static void TextBox(int row, int col, int width, int height, String text){
    int ind = 0;
    for (int i = 0; i < height; i++) {
        String line = "";
        while (line.length() < width ) {
            line += text.charAt(ind);
            ind++;
            if(ind == text.length()){
              ind -= text.length();
            }
        }
        drawText(line, row + i, col, 0);
     //   ind = 0;
    }
  }

*/
public static void TextBox(int row, int col, int width, int height, String text){
    int ind = 0;
    for (int i = 0; i < height; i++) {
        String line = "";
        while (line.length() < width && ind < text.length()) {
            line += text.charAt(ind);
            ind++;
        }
        while (line.length() < width) {
            line += " ";
        }

        drawText(line, row + i, col, 0);
    }
}




/*


    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      return new CodeWarrior("Bob"+(int)(Math.random()*100));
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
*/

    public static void drawParty(ArrayList<Adventurer> party,int startRow){
      String names = "";
      String hp = "";
      String special = "";
      for (Adventurer adventurer : party) {
        names += adventurer.getName() + "                             ";
          names = names.substring(0, names.length() - adventurer.getName().length());

        hp += "HP: " + adventurer.getHP() + "                      ";
        special += adventurer.getSpecialName() + ": " + adventurer.getSpecial() + "                    ";
      }

      names = names.substring(0, names.length()-4);
      hp = hp.substring(0, hp.length()-4);
      special = special.substring(0, special.length()-4);

      TextBox(startRow + 2, 1, 80, 4, names);
      TextBox(startRow + 3, 1, 80, 4, hp);
      TextBox(startRow + 4, 1, 80, 4, special);
      TextBox(startRow + 5, 1, 80, 1, "");
      Text.go(17, 40);
    }


      /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
      //YOUR CODE HERE
      /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/



  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    if(((double)hp / (double) maxHP) < 0.25){
      return Text.colorize(output, Text.RED);
    }
    else if (((double)hp / (double) maxHP) < 0.75){
      return Text.colorize(output, Text.YELLOW);
    }
    else{
          return Text.colorize(output, Text.WHITE);
    }
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> playerParty, ArrayList<Adventurer> enemyParty){

    drawBackground(playerParty, enemyParty);
//System.out.println("done");
    //draw player party

    //draw enemy party

  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
        Text.go(15, 45);
        Text.showCursor();
      //show cursor

      String input = in.nextLine();

      //clear the text that was written

  /*  for (int x = 1; x < HEIGHT/3 && x > HEIGHT*2/3; x++) {
        for (int y = 1; y < WIDTH; y++) {
          drawText(" ", x, y, BORDER_BACKGROUND);
        }
      }
      return input;
  }
  */
  for (int x = HEIGHT / 3; x < (HEIGHT * 2) / 3; x++) {
     for (int y = 1; y < WIDTH; y++) {
         drawText(" ", x, y, BORDER_BACKGROUND);
     }
 }
 return input;}

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32, 1);
    System.exit(0);
}


  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();

    Scanner userInput = new Scanner(System.in);
    ArrayList<Adventurer> playerParty = new ArrayList<>();
    ArrayList<Adventurer> enemyParty = new ArrayList<>();

    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    //Make the classes random. Replace strings with the actual constructor
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Warrior EnemyWarrior = new Warrior("Enemy Warrior");
    Mage EnemyMage = new Mage("Enemy Mage");
    Healer EnemyHealer = new Healer("Enemy Healer");
    Boss Boss = new Boss("Iron Fist");

    double rand = Math.random();
    if(rand < 0.3333){
      enemyParty.add(Boss);
    }
    else if(rand < 0.6666){
      enemyParty.add(EnemyWarrior);
      enemyParty.add(EnemyMage);
    }
    else if (rand > 0.6666){
      enemyParty.add(EnemyWarrior);
      enemyParty.add(EnemyMage);
      enemyParty.add(EnemyHealer);
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    System.out.println("Welcome to H and A's Adventurer Game!");
    System.out.println("Create your party with 3 adventurers!");
    for(int i = 1; i <= 3; i++){
      System.out.println("Select class for player " + i + ": (1) Warrior, (2) Mage, (3) Healer");
            int classChoice = userInput.nextInt();
            userInput.nextLine();

            System.out.println("Enter name for player " + i + ": ");
            String name = userInput.nextLine();

            if (classChoice == 1) {
                playerParty.add(new Warrior(name));
            } else if (classChoice == 2) {
                playerParty.add(new Mage(name));
            } else if (classChoice == 3) {
                playerParty.add(new Healer(name));
            } else {
                System.out.println("Invalid! You'll just be Warrior lol");
                playerParty.add(new Warrior(name));
            }
        }

    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(playerParty, enemyParty);//initial state.
    //Main loop
    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+playerParty.get(whichPlayer)+": attack/special/quit:";
    TextBox(15, 1, 80, 3, preprompt);
    Text.go(17, 40);
    input = userInput(in);
    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //System.out.println("hit enter to continue");
      //Read user input
      //input = userInput(in);
      //example debug statment
  //    TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.startsWith("attack ") || input.startsWith("a ")){
          if(input.contains("1")){
          TextBox(15, 1, 80, 3, (playerParty.get(whichPlayer).attack(enemyParty.get(0))));
          }
          if(input.contains("2")){
            TextBox(15, 1, 80, 3, (playerParty.get(whichPlayer).attack(enemyParty.get(1))));
          }
          if(input.contains("3")){
            TextBox(15, 1, 80, 3, (playerParty.get(whichPlayer).attack(enemyParty.get(2))));
          }
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("special ") || input.startsWith("sp ")){
          if(input.contains("1")){
            TextBox(15, 1, 80, 3, (playerParty.get(whichPlayer).specialAttack(enemyParty.get(0))));
          }
          if(input.contains("2")){
            TextBox(15, 1, 80, 3, (playerParty.get(whichPlayer).specialAttack(enemyParty.get(1))));
          }
          if(input.contains("3")){
            TextBox(15, 1, 80, 3, (playerParty.get(whichPlayer).specialAttack(enemyParty.get(2))));
          }
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("su ") || input.startsWith("support ")){
          if(input.contains("1")){
            TextBox(15, 1, 80, 3, (playerParty.get(whichPlayer).support(playerParty.get(0))));
          }
          else if(input.contains("2")){
            TextBox(15, 1, 80, 3, (playerParty.get(whichPlayer).support(playerParty.get(1))));
          }
          else if(input.contains("3")){
            TextBox(15, 1, 80, 3, (playerParty.get(whichPlayer).support(playerParty.get(2))));
          }
          else{
          TextBox(15, 1, 80, 3, (playerParty.get(whichPlayer).support()));
        }
        }

          userInput(in);
          for(int i = 0; i < enemyParty.size(); i++){
            if (enemyParty.get(i).getHP() <= 0){
            TextBox(15, 1, 80, 3, enemyParty.get(i).getName() + " died");
              enemyParty.remove(i);
              userInput(in);
            }
          }
          if(enemyParty.size() == 0){
            TextBox(15, 1, 80, 3, "you won the game!");
            userInput(in);
            break;
          }


        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;



        if(whichPlayer < playerParty.size()){
          drawScreen(playerParty, enemyParty);
           preprompt = "Enter command for "+playerParty.get(whichPlayer)+": attack/special/quit:";
          TextBox(15, 1, 80, 3, preprompt);
          Text.go(1, 1);
          input = userInput(in);
          //This is a player turn.


        }else{
      //    drawScreen(playerParty, enemyParty);//initial state.
        //   preprompt = "Enter command for "+playerParty.get(whichPlayer)+": attack/special/quit:";
        //  TextBox(15, 1, 80, 3, preprompt);
        //  Text.go(1, 1);
        //  input = userInput(in);
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        if (whichOpponent < enemyParty.size()) {
               Adventurer enemy = enemyParty.get(whichOpponent);
               double enemyAction = Math.random();

               if (enemyAction < 0.33) {
                   // Enemy attacks a random player
                   int playerIndex = (int)(Math.random() * playerParty.size());
                   TextBox(15, 1, 80, 3, enemy.attack(playerParty.get(playerIndex)));
               }
               else if (enemyAction < 0.66) {
                   // Enemy uses special attack on a random player
                   int playerIndex = (int)(Math.random() * playerParty.size());
                   TextBox(15, 1, 80, 3, enemy.specialAttack(playerParty.get(playerIndex)));
               } else {
                   // Enemy supports a random ally
                   int enemyIndex = (int)(Math.random() * enemyParty.size());
                   TextBox(15, 1, 80, 3, enemy.support(enemyParty.get(enemyIndex)));
               }

                 userInput(in);
                 for(int i = 0; i < playerParty.size(); i++){
                   if (playerParty.get(i).getHP() <= 0){
                     TextBox(15, 1, 80, 3, playerParty.get(i).getName() + " died");
                     playerParty.remove(i);
                     userInput(in);
                   }
                 }
                 if(playerParty.size() == 0){
                   TextBox(15, 1, 80, 3, "you lose the game");
                   userInput(in);
                   break;
                 }
  whichOpponent++;}
  else{
    whichPlayer = 0;
    turn++;
    partyTurn = true;
    String prompt = "Enter command for "+playerParty.get(whichPlayer).getName()+": attack/special/quit";
    TextBox(15, 1, 80, 3, prompt);
    input = userInput(in);


  }
}
drawScreen(playerParty, enemyParty);
}
quit();
}
}


        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

/*
        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemyParty.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+playerParty.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      drawScreen(playerParty, enemyParty);


    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
*/
