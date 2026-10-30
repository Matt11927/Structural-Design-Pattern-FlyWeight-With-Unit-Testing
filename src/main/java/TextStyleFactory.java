import java.util.HashMap;

public class TextStyleFactory {

    private HashMap < String, TextStyle > textStyle = new HashMap<>();

    public TextStyle getStyle(  String textFont, String textColor, int textSize ){
        String text = textFont + textColor + textSize;

        if ( textStyle.containsKey(text) ){
           return textStyle.get(text);
        } else {
           TextStyle style = new TextStyle(textFont,textColor,textSize);
           textStyle.put(text,style);
           return style;
        }
    }
}
