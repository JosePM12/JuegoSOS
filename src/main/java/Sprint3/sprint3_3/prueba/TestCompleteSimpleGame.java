package Sprint3.sprint3_3.prueba;
import Sprint3.sprint3_3.produccion.Board;
import Sprint3.sprint3_3.produccion.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCompleteSimpleGame {
    private Board board;
    private GUI gui;
    @BeforeEach
    public void setUp() throws Exception{
        board = new Board(4, Board.MODE.SIMPLE);
        gui = new GUI(board);
    }
    // Criterio de Aceptacion 5.1
    @Test
    public void TestBluePlayerWon(){
        board.simpleMove(2,1,Board.LETTER.S);
        board.simpleMove(3,0,Board.LETTER.O);
        board.simpleMove(1,2,Board.LETTER.O);
        board.simpleMove(2,0,Board.LETTER.S);
        board.simpleMove(0,3,Board.LETTER.S);
        assertEquals(board.getCurrentGameState(), Board.GameState.BLUE_WON);
        showGUI();
    }
    // Criterio de Aceptacion 5.2
    @Test
    public void TestRedPlayerWon(){
        board.simpleMove(3,1, Board.LETTER.S);
        board.simpleMove(3,0, Board.LETTER.S);
        board.simpleMove(0,0, Board.LETTER.S);
        board.simpleMove(2,0, Board.LETTER.O);
        board.simpleMove(0,2, Board.LETTER.S);
        board.simpleMove(1,0, Board.LETTER.S);
        assertEquals(board.getCurrentGameState(), Board.GameState.RED_WON);
        showGUI();
    }
    // Criterio de Aceptacion 5.3
    @Test
    public void TestDraw(){
        board.simpleMove(2,1, Board.LETTER.S);
        board.simpleMove(3,0, Board.LETTER.O);
        board.simpleMove(0,3, Board.LETTER.S);
        board.simpleMove(2,0, Board.LETTER.O);
        board.simpleMove(1,0, Board.LETTER.S);
        board.simpleMove(1,2, Board.LETTER.O);
        board.simpleMove(1,1, Board.LETTER.S);
        board.simpleMove(0,1, Board.LETTER.O);
        board.simpleMove(0,0, Board.LETTER.S);
        board.simpleMove(1,3, Board.LETTER.O);
        board.simpleMove(0,2, Board.LETTER.S);
        board.simpleMove(3,1, Board.LETTER.O);
        board.simpleMove(3,2, Board.LETTER.S);
        board.simpleMove(2,2, Board.LETTER.O);
        board.simpleMove(2,3, Board.LETTER.S);
        board.simpleMove(3,3, Board.LETTER.O);
        assertEquals(board.getCurrentGameState(), Board.GameState.DRAW);
        showGUI();
    }
    public void showGUI(){
        try{
            Thread.sleep(2000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
