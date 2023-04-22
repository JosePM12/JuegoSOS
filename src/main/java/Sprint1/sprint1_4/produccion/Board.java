package Sprint1.sprint1_4.produccion;

public class Board {
    // el valor de cada valor del array va a determinar el color del player que realizo el movimiento
    public enum CELL{
        redS,
        redO,
        blueS,
        blueO,
        EMPTY
    }

    public enum COLOR{
        RED,
        BLUE
    }

    private CELL[][] grid;
    // Turno de la letra a colocar S u O
    private char letterTurn;
    private COLOR colorPlayer;
    private int size;
    public void setSize(int size)
    {
        this.size = size;
    }
    public int getSize()
    {
        return size;
    }
    public char getLetterTurn(){
        return letterTurn;
    }
    public COLOR getColorPlayer(){
        return colorPlayer;
    }
    public Board(int SIZE){
        if(SIZE<=2) {
            setSize(-1);
        } else {
            grid = new CELL[SIZE][SIZE];
            setSize(SIZE);
            initBoard();
        }
    }

    public void initBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j] = CELL.EMPTY;
            }
        }
        letterTurn = 'S';
        colorPlayer = COLOR.BLUE;
    }
    public CELL getCell(int row,int col)
    {
        if(row>=0 && row<size && col>=0 && col<size){
            return  grid[row][col];
        } else {
            return null;
        }
    }
    // Metodos para un juego simple
    public void simpleMove(int row, int column){
        if (row >= 0 && row < size && column >= 0 && column < size
                &&  grid[row][column] == CELL.EMPTY)
        {
            if(colorPlayer==COLOR.BLUE) {
                if (letterTurn == 'S')
                    grid[row][column] = CELL.blueS;
                else
                    grid[row][column] = CELL.blueO;
                colorPlayer = COLOR.RED;
            } else if (colorPlayer==COLOR.RED) {
                if(letterTurn == 'S') {
                    grid[row][column] = CELL.redS;
                    letterTurn = 'O';
                } else {
                    grid[row][column] = CELL.redO;
                    letterTurn = 'S';
                }
                colorPlayer = COLOR.BLUE;
            }
        }
    }


}
