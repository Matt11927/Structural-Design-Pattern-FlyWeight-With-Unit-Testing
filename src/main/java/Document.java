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
}
