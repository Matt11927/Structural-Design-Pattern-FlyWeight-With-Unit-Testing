import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


}
