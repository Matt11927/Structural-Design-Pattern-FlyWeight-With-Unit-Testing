import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTextStyle {



    @Test
    public void TestTextStyle(){
        TextStyle style = new TextStyle( "Arial","Red",12 );

        String actualFont = style.getTextFont();
        String actualColor = style.getTextColor();
        int actualSize = style.getTextSize();

        String expectedFont = "Arial";
        String expectedColor = "Red";
        int expectedSize = 12;

        assertEquals(expectedFont,actualFont);
        assertEquals(expectedColor,actualColor);
        assertEquals(expectedSize,actualSize);
    }

    @Test
    public void TestTextStyleFactoryReuse(){
        TextStyleFactory styleFactory = new TextStyleFactory();

        TextStyle actual = styleFactory.getStyle("Arial","Red",12);
        TextStyle expected = styleFactory.getStyle("Arial","Red",12);

        assertSame(expected,actual);

    }

    @Test
    public void TestTextStyleFactoryDifferent(){
        TextStyleFactory styleFactory = new TextStyleFactory();

        TextStyle actual = styleFactory.getStyle("Arial","Red",12);
        TextStyle expected = styleFactory.getStyle("Verdana ","Black ",16);

        assertNotSame(expected,actual);
    }

    @Test
    public void TestCharacter(){
        TextStyle style = new TextStyle( "Arial","Red",12 );

        Character c = new Character('H',style);

        char actualChar = c.getCharacter;
        TextStyle actualCharStyle = c.getStyle();

        char expectedChar = 'H';
        TextStyle expectedCharStyle = style;

        assertEquals(expectedChar,actualChar);
        assertSame(expectedCharStyle,actualCharStyle);
    }


}
