package Sprint1.sprint1_3.produccion;

public class Player {
    public enum COLOR{
        RED,
        BLUE
    }
    private COLOR color;
    private char letterTurn;
    public Player(){
        this.color= COLOR.BLUE;
        this.letterTurn = 'S';
    }
    public void setLetterTurn(char letter)
    {
        letterTurn = letter;
    }
    public char getLetterTurn(){
        return letterTurn;
    }
    public void setColor(COLOR color)
    {
        this.color = color;
    }
    public COLOR getColor(){
        return  color;
    }
}
