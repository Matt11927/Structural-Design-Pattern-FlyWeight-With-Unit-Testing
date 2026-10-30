import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Document {

    ArrayList<Character> characters = new ArrayList<>();

    public void addCharacter( Character c ){ characters.add(c); }

    public Character getCharacter( int index ){ return characters.get( index ); }


    public int getCharacterCount() {
        int counter = 0;
        for ( int i = 0; i < characters.size() ; i++ ){
            counter++;
        }
        return counter;
    }

    public void saveDocument(String file) throws FileNotFoundException {
        PrintWriter writeFile = new PrintWriter(file);

        for ( int i = 0; i < characters.size(); i++){

            Character c = characters.get(i);
            TextStyle style = c.getStyle();

            writeFile.print(c.getCharacter() + ": " + style.getTextFont() + ", "
            + style.getTextColor() + ", " + style.getTextSize());

        }

        writeFile.close();
    }
}
