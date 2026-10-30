import org.junit.jupiter.api.Test;

import javax.print.Doc;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class TestTextStyle {


    @Test
    public void TestTextStyle() {
        TextStyle style = new TextStyle("Arial", "Red", 12);

        String actualFont = style.getTextFont();
        String actualColor = style.getTextColor();
        int actualSize = style.getTextSize();

        String expectedFont = "Arial";
        String expectedColor = "Red";
        int expectedSize = 12;

        assertEquals(expectedFont, actualFont);
        assertEquals(expectedColor, actualColor);
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestTextStyleFactoryReuse() {
        TextStyleFactory styleFactory = new TextStyleFactory();

        TextStyle actual = styleFactory.getStyle("Arial", "Red", 12);
        TextStyle expected = styleFactory.getStyle("Arial", "Red", 12);

        assertSame(expected, actual);

    }

    @Test
    public void TestTextStyleFactoryDifferent() {
        TextStyleFactory styleFactory = new TextStyleFactory();

        TextStyle actual = styleFactory.getStyle("Arial", "Red", 12);
        TextStyle expected = styleFactory.getStyle("Verdana ", "Black ", 16);

        assertNotSame(expected, actual);
    }

    @Test
    public void TestCharacter() {
        TextStyle style = new TextStyle("Arial", "Red", 12);

        Character c = new Character('H', style);

        char actualChar = c.getCharacter();
        TextStyle actualCharStyle = c.getStyle();

        char expectedChar = 'H';
        TextStyle expectedCharStyle = style;

        assertEquals(expectedChar, actualChar);
        assertSame(expectedCharStyle, actualCharStyle);
    }

    @Test
    public void testDocumentAddCharacters() {
        Document document = new Document();
        TextStyle style = new TextStyle("Arial", "Red", 12);
        Character c = new Character('H', style);

        document.addCharacter(c);

        Character actual = document.getCharacter(0);
        Character expected = c;

        assertSame(expected, actual);

    }

    @Test
    public void testDocumentStoringMultipleCharacters() {

        Document document = new Document();

        TextStyle style = new TextStyle("Arial", "Red", 12);

        document.addCharacter(new Character('H', style));
        document.addCharacter(new Character('e', style));
        document.addCharacter(new Character('l', style));
        document.addCharacter(new Character('l', style));
        document.addCharacter(new Character('o', style));

        int actual = document.getCharacterCount();
        int expected = 5;

        assertEquals(expected, actual);

    }

    @Test
    public void testDocumentRetrievesCharactersInOrder() {

        Document document = new Document();

        TextStyle style = new TextStyle("Arial", "Red", 12);

        document.addCharacter(new Character('H', style));
        document.addCharacter(new Character('e', style));
        document.addCharacter(new Character('l', style));

        char actualFirstIndex = document.getCharacter(0).getCharacter();
        char actualSecondIndex = document.getCharacter(1).getCharacter();
        char actualThirdIndex = document.getCharacter(2).getCharacter();

        char expectedFirstIndex = 'H';
        char expectedSecondIndex = 'e';
        char expectedThirdIndex = 'l';

        assertEquals(expectedFirstIndex, actualFirstIndex);
        assertEquals(expectedSecondIndex,actualSecondIndex);
        assertEquals(expectedThirdIndex,actualThirdIndex);
    }

    @Test
    public void testSaveDocument() throws FileNotFoundException {

        Document document = new Document();

        TextStyle style = new TextStyle("Arial","Red",12);

        document.addCharacter(new Character('H', style));

        document.saveDocument("characterDocument.txt");

        File file = new File("characterDocument.txt");

        assertTrue(file.exists());

    }





}
