import java.util.*;
import java.util.Random;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.GREEN;
  private static final int BORDER_BACKGROUND = Text.CYAN + Text.BACKGROUND;

  public static void main(String[] args) {
  //  run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
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

        drawParty(party, 1);

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
        names += adventurer.getName() + "    ";
        hp += "HP: " + adventurer.getHP() + "    ";
        special += adventurer.getSpecial() + ": " + adventurer.getSpecialValue() + "    ";
      }

      names = names.substring(0, names.length()-4);
      hp = hp.substring(0, hp.length()-4);
      special = special.substring(0, special.length()-4);

      TextBox(startRow, 1, 20, 4, names);
      TextBox(startRow + 1, 1, 20, 4, hp);
      TextBox(startRow + 2, 1, 20, 4, special);
      TextBox(startRow + 3, 1, 20, 4, "");
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
  public static void drawScreen(){

    drawBackground();

    //draw player party

    //draw enemy party

  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
        Text.go(30, 30);
        Text.showCursor();
      //show cursor

      String input = in.nextLine();

      //clear the text that was written
      for (int x = 1; x < HEIGHT/3 && x > HEIGHT*2/3; x++) {
        for (int y = 1; y < WIDTH; y++) {
          drawText(" ", x, y, BORDER_BACKGROUND);
        }
      }
      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    //Make the classes random. Replace strings with the actual constructor
    Warrior EnemyWarrior = new Warrior("Enemy Warrior");
    Mage EnemyMage = new Mage("Enemy Mage");
    Healer EnemyHealer = new Healer("Enemy Mage");
    Boss Boss = new Boss("Iron Fist");
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    double rand = Math.random();
    if(rand < 0.3333){
      enemies.add(Boss);
    }
    else if(rand < 0.6666){
      enemies.add(EnemyWarrior);
      enemies.add(EnemyMage);
    }
    else{
      enemies.add(EnemyWarrior);
      enemies.add(EnemyMage);
      enemies.add(EnemyMage);
    }
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //YOUR CODE HERE
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen();//initial state.

    //Main loop

    //display this prompt at the start of the game.
    String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit + 1/2/3";

    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
      //Read user input
      input = userInput(in);

      //example debug statment
      TextBox(24,2,1,78,"input: "+input+" partyTurn:"+partyTurn+ " whichPlayer="+whichPlayer+ " whichOpp="+whichOpponent );

      //display event based on last turn's input
      if(partyTurn){

        //Process user input for the last Adventurer:
        if(input.startsWith("attack ") || input.startsWith("a ")){
          if(input.contains(1)){
            party.get(whichPlayer).attack(enemies.get(0));
          }
          if(input.contains(2)){
            party.get(whichPlayer).attack(enemies.get(1));
          }
          if(input.contains(3)){
            party.get(whichPlayer).attack(enemies.get(2));
          }
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(input.startsWith("special ") || input.startsWith("sp ")){
          if(input.contains(1)){
            party.get(whichPlayer).specialAttack(enemies.get(0));
          }
          if(input.contains(2)){
            party.get(whichPlayer).specialAttack(enemies.get(1));
          }
          if(input.contains(3)){
            party.get(whichPlayer).specialAttack(enemies.get(2));
          }
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
          //YOUR CODE HERE
          /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }

        //CAN SUPPORT EITHER THEMSELVES OR THEIR TEAMATE DEPENDING ON INPUT
        else if(input.startsWith("su ") || input.startsWith("support ")){
          if(input.contains(1)){
            party.get(whichPlayer).support(enemies.get(0));
          }
          else if(input.contains(2)){
            party.get(whichPlayer).support(enemies.get(1));
          }
          else if(input.contains(3)){
            party.get(whichPlayer).support(enemies.get(2));
          }
          party.get(whichPlayer).support();
        }

        //You should decide when you want to re-ask for user input
        //If no errors:
        whichPlayer++;


        if(whichPlayer < party.size()){
          //This is a player turn.
          //Decide where to draw the following prompt:
          String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";


        }else{
          //This is after the player's turn, and allows the user to see the enemy turn
          //Decide where to draw the following prompt:
          String prompt = "press enter to see monster's turn";

          partyTurn = false;
          whichOpponent = 0;
        }
        //done with one party member
      }else{
        //not the party turn!


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //YOUR CODE HERE
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        //Decide where to draw the following prompt:
        String prompt = "press enter to see next turn";

        whichOpponent++;

      }//end of one enemy.

      //modify this if statement.
      if(!partyTurn && whichOpponent >= enemies.size()){
        //THIS BLOCK IS TO END THE ENEMY TURN
        //It only triggers after the last enemy goes.
        whichPlayer = 0;
        turn++;
        partyTurn=true;
        //display this prompt before player's turn
        String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
      }

      //display the updated screen after input has been processed.
      drawScreen();


    }//end of main game loop


    //After quit reset things:
    quit();
  }





}
