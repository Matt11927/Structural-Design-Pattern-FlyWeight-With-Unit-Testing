import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Document document = new Document();
        TextStyleFactory factory = new TextStyleFactory();

        TextStyle helloStyle  = factory.getStyle("Arial", "Red", 12);

        TextStyle worldStyle = factory.getStyle("Calibri", "Blue", 14);

        TextStyle csStyle  = factory.getStyle("Verdana", "Black", 16);

        TextStyle numberStyle  = factory.getStyle("Times New Roman", "Orange", 10);


        document.addCharacter(new Character('H', helloStyle));
        document.addCharacter(new Character('e', helloStyle));
        document.addCharacter(new Character('l', helloStyle));
        document.addCharacter(new Character('l', helloStyle));
        document.addCharacter(new Character('o', helloStyle));


        document.addCharacter(new Character('W', worldStyle));
        document.addCharacter(new Character('o', worldStyle));
        document.addCharacter(new Character('r', worldStyle));
        document.addCharacter(new Character('l', worldStyle));
        document.addCharacter(new Character('d', worldStyle));


        document.addCharacter(new Character('C', csStyle ));
        document.addCharacter(new Character('S', csStyle ));


        document.addCharacter(new Character('5', numberStyle ));
        document.addCharacter(new Character('8', numberStyle ));
        document.addCharacter(new Character('0', numberStyle ));
        document.addCharacter(new Character('0', numberStyle ));

        document.saveDocument("characterDocument.txt");

        Document loadedDocument = new Document();
        loadedDocument.loadDocument("characterDocument.txt");

        /*Test*/
        //System.out.println(loadedDocument.getCharacterCount());
    }

}
