package Sprint1.sprint1_0.produccion;

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
    public int getCell(int row,int col) {
        return grid[row][col];
    }

    public char getPlayerturn(){
        return Playerturn;
    }

    public char getLetterTurn() {
        return LetterTurn;
    }
}
