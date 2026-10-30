public class Character {

    private char character;
    private TextStyle style;
    public Character(char character, TextStyle style) {
        this.character = character;
        this.style = style;
    }

    public char getCharacter(){ return character; }

    public TextStyle getStyle(){ return style; }
}
