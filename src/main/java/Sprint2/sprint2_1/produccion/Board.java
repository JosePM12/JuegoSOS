package Sprint2.sprint2_1.produccion;

public class Board {
    private int[][] grid = null;
    // Turno del jugador Blue(B) o Red(R)
    private char Playerturn = 'B';
    // Turno de la letra a colocar S u O
    private char LetterTurn = 'S';
    private int size;

    public void setSize(int size)
    {
        this.size = size;
    }
    public int getSize()
    {
        return size;
    }
    public Board(int SIZE){
        if(SIZE<=2) {
            setSize(-1);
        } else {
            grid = new int[SIZE][SIZE];
            setSize(SIZE);
        }
    }
    public int getCell(int row,int col)
    {
        if(row>=0 && row<size && col>=0 && col<size){
            return  grid[row][col];
        } else {
            return -1;
        }
    }

    public char getPlayerturn(){
        return Playerturn;
    }

    public char getLetterTurn() {
        return LetterTurn;
    }
}
