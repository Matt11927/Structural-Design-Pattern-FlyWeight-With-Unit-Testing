import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

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

            writeFile.println(c.getCharacter() + ": " + style.getTextFont() + ", "
            + style.getTextColor() + ", " + style.getTextSize());

        }

        writeFile.close();
    }

    public void loadDocument(String fileName) throws FileNotFoundException {

        Scanner readFile = new Scanner(new File(fileName));

        TextStyleFactory styleFactory = new TextStyleFactory();

        while ( readFile.hasNextLine() ) {

            String line = readFile.nextLine();

            String[] parts = line.split(",");

            String[] firstPart = parts[0].split(":");

            char letter = firstPart[0].trim().charAt(0);

            String font = firstPart[1].trim();

            String color = parts[1].trim();

            int size = Integer.parseInt(parts[2].trim());

            TextStyle style = styleFactory.getStyle(font, color, size);

            Character character = new Character(letter, style);

            addCharacter(character);
        }

        readFile.close();
    }
}
