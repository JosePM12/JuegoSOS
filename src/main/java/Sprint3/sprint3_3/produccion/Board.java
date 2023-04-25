package Sprint3.sprint3_3.produccion;

public class Board {
    // el valor de cada valor del array va a determinar el color del player que realizo el movimiento
    public enum GameState{
        PLAYING,
        RED_WON,
        BLUE_WON,
        DRAW,
    }

    public enum MODE{
        NONE,
        SIMPLE,
        GENERAL
    }

    public enum LETTER{
        S,
        O
    }

    public enum CELL{
        RED_S,
        RED_O,
        BLUE_S,
        BLUE_O,
        EMPTY,
    }

    public enum COLOR{
        RED,
        BLUE
    }

    private CELL[][] grid;
    // Turno de la letra a colocar S u O
    private MODE modeGame = MODE.NONE;
    private LETTER letterTurn;
    private COLOR colorPlayer;
    private GameState currentGameState;
    private int size;
    public void setSize(int size)
    {
        this.size = size;
    }
    public int getSize()
    {
        return size;
    }
    public LETTER getLetterTurn(){
        return letterTurn;
    }
    public COLOR getColorPlayer(){
        return colorPlayer;
    }
    public void setModeGame(MODE mode)
    {
        this.modeGame = mode;
    }
    public MODE getModeGame()
    {
        return this.modeGame;
    }
    public Board(int SIZE,MODE mode){
        if(SIZE<=2) {
            setSize(-1);
        } else {
            grid = new CELL[SIZE][SIZE];
            setModeGame(mode);
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
        currentGameState = GameState.PLAYING;
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


    // Metodos para el modo de juego simple
    public void simpleMove(int row, int column, LETTER letter){
        if (row >= 0 && row < size && column >= 0 && column < size
                &&  grid[row][column] == Board.CELL.EMPTY)
        {
            this.letterTurn = letter;
            if(colorPlayer== COLOR.BLUE) {
                if (letterTurn == LETTER.S)
                    grid[row][column] = CELL.BLUE_S;
                else
                    grid[row][column] = CELL.BLUE_O;
                updateGameState(letterTurn,colorPlayer,row,column);
                colorPlayer = COLOR.RED;
            } else if (colorPlayer== COLOR.RED) {
                if(letterTurn == LETTER.S) {
                    grid[row][column] = CELL.RED_S;
                    updateGameState(letterTurn,colorPlayer,row,column);;
                } else {
                    grid[row][column] = CELL.RED_O;
                    updateGameState(letterTurn,colorPlayer,row,column);
                }
                colorPlayer = COLOR.BLUE;
            }
        }
    }

    private void updateGameState(LETTER letterTurn, COLOR color, int row, int column){
        if(isDraw()) {
            currentGameState = GameState.DRAW;
        } else if (hasWon(letterTurn, color, row, column)) {
            currentGameState = (color== COLOR.BLUE)? GameState.BLUE_WON: GameState.RED_WON;
        } else{
            currentGameState = GameState.PLAYING;
        }
    }

    private boolean isDraw() {
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                if (grid[row][col] == CELL.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasWon(LETTER letterTurn, COLOR color, int row, int column){
        if (letterTurn == LETTER.S) {
            return formSOSwithS(color,row,column);
        } else {
            return formSOSwith0(color,row,column);
        }
    }

    private boolean formSOSwith0(COLOR color, int row, int column) {
        int contrarioX, contrarioY;
        if(color == COLOR.RED){
            for(int i=-1;i<=1;i++){
                if(row+i>=0 && row+i<size) {
                    for (int j = -1; j <= 1; j++) {
                        if (column + j >= 0 && column + j < size) {
                            contrarioX = -1 * i;
                            contrarioY = -1 * j;
                            if(row+contrarioX >=0 && row+contrarioX<size && column+contrarioY >=0 && column+contrarioY<size) {
                                if (grid[row + i][column + j] == CELL.RED_S && grid[row + contrarioX][column + contrarioY] == CELL.RED_S) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        } else{
            for(int i=-1;i<=1;i++){
                if(row+i>=0 && row+i<size) {
                    for (int j = -1; j <= 1; j++) {
                        if (column + j >= 0 && column + j < size) {
                            contrarioX = -1 * i;
                            contrarioY = -1 * j;
                            if(row+contrarioX >=0 && row+contrarioX<size && column+contrarioY >=0 && column+contrarioY<size) {
                                if (grid[row + i][column + j] == CELL.BLUE_S && grid[row + contrarioX][column + contrarioY] == CELL.BLUE_S) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean formSOSwithS(COLOR color, int row, int column) {
        if (color == COLOR.RED) {
            for (int i = -1; i <= 1; i++) {
                if (row + i >= 0 && row + i < size) {
                    for (int j = -1; j <= 1; j++) {
                        if (column + j >= 0 && column + j < size) {
                            if (grid[row + i][column + j] == CELL.RED_O) {
                                if (i == 0 || j == 0) {
                                    if (j != 0) {
                                        if (column + 2 * j >= 0 && column + 2 * j < size) {
                                            if (grid[row + i][column + 2 * j] == CELL.RED_S) {
                                                return true;
                                            }
                                        }
                                    } else if (i != 0) {
                                        if (row + 2 * i >= 0 && row + 2 * i < size) {
                                            if (grid[row + 2 * i][column + j] == CELL.RED_S) {
                                                return true;
                                            }
                                        }
                                    }
                                } else {
                                    if (column + 2 * j >= 0 && column + 2 * j < size && row + 2 * i >= 0 && row + 2 * i < size) {
                                        if (grid[row * 2 * i][column + 2 * j] == CELL.RED_S) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            for (int i = -1; i <= 1; i++) {
                if (row + i >= 0 && row + i < size) {
                    for (int j = -1; j <= 1; j++) {
                        if (column + j >= 0 && column + j < size) {
                            if (grid[row + i][column + j] == CELL.BLUE_O) {
                                if (i == 0 || j == 0) {
                                    if (j != 0) {
                                        if (column + 2 * j >= 0 && column + 2 * j < size) {
                                            if (grid[row + i][column + 2 * j] == CELL.BLUE_S) {
                                                return true;
                                            }
                                        }
                                    } else if (i != 0) {
                                        if (row + 2 * i >= 0 && row + 2 * i < size) {
                                            if (grid[row + 2 * i][column + j] == CELL.BLUE_S) {
                                                return true;
                                            }
                                        }
                                    }
                                } else {
                                    if (column + 2 * j >= 0 && column + 2 * j < size && row + 2 * i >= 0 && row + 2 * i < size) {
                                        if (grid[row + 2 * i][column + 2 * j] == CELL.BLUE_S) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void normalMove(int row, int column, LETTER letter){
        if (row >= 0 && row < size && column >= 0 && column < size
                &&  grid[row][column] == Board.CELL.EMPTY)
        {
            this.letterTurn = letter;
            if(colorPlayer== COLOR.BLUE) {
                if (letterTurn == LETTER.S)
                    grid[row][column] = CELL.BLUE_S;
                else
                    grid[row][column] = CELL.BLUE_O;
            } else if (colorPlayer== COLOR.RED) {
                if(letterTurn == LETTER.S) {
                    grid[row][column] = CELL.RED_S;
                } else {
                    grid[row][column] = CELL.RED_O;
                }
            }
        }
    }

    // Metodods para el modo de juego general
    public void generalMove(int row,int column,LETTER letter){
        if(letter == LETTER.O)
        {
            if(formSOSwith0(colorPlayer,row,column)){
                normalMove(row,column,letter);
            } else {
                simpleMove(row,column,letter);
            }
        } else {
            if(formSOSwithS(colorPlayer,row,column)){
                normalMove(row,column,letter);
            } else {
                simpleMove(row,column,letter);
            }
        }
    }
    public GameState getCurrentGameState() {
        return currentGameState;
    }
}
