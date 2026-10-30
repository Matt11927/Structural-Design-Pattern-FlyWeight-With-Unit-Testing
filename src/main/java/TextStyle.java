public class TextStyle {

    private String textFont;
    private String textColor;
    private int textSize;

    TextStyle( String textFont, String textColor, int textSize ){
        this.textFont = textFont;
        this.textColor = textColor;
        this.textSize = textSize;
    }

    public String getTextFont(){ return textFont; }
    public String getTextColor(){ return textColor; }
    public int getTextSize(){ return textSize; }


}
