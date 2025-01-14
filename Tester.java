public class Tester{
  public static void main(String[] args){
    Text.clear();
//    TextBox(1,1,20,2, "Hello World");
    Game.drawBackground();
  }


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
*All remaining locations in the text box should be written // Move to the next part of the text with spaces to
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
            drawText(line, row + i, col, 0);
         //   ind = 0;
        }



/*  for (int i = 0; i < height; i++) {
    for(int w = 0; w < width/text.length(); w++){
    drawText(text, row + i, col+w);
  }
}

*/
}
}
