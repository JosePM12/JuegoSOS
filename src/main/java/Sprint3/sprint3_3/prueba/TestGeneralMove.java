package Sprint3.sprint3_3.prueba;

import Sprint3.sprint3_3.produccion.Board;
import Sprint3.sprint3_3.produccion.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGeneralMove {
    private Board board;
    private GUI gui;
    @BeforeEach
    public void setUp() throws Exception{
        board = new Board(4, Board.MODE.GENERAL);
        gui = new GUI(board);
    }
    // Criterio de Aceptacion 6.1
    @Test
    public void whenBluePlayerFormSOSThenBlueTurn(){
        board.generalMove(1,0, Board.LETTER.S);
        board.generalMove(0,2, Board.LETTER.S);
        board.generalMove(1,1, Board.LETTER.O);
        board.generalMove(0,2, Board.LETTER.S);
        board.generalMove(1,2, Board.LETTER.S);
        board.generalMove(2,2, Board.LETTER.O);
        assertEquals(board.getCell(2,2), Board.CELL.BLUE_O);
        board.generalMove(3,3, Board.LETTER.O);
        assertEquals(board.getCell(3,3), Board.CELL.RED_O);
        showGUI();
    }
    // Criterio de Aceptacion 6.2
    @Test
    public void whenRedPlayerFormSOSThenRedTurn(){
        board.generalMove(1,0, Board.LETTER.O);
        board.generalMove(0,1, Board.LETTER.O);
        board.generalMove(1,1, Board.LETTER.S);
        board.generalMove(0,0, Board.LETTER.S);
        board.generalMove(1,2, Board.LETTER.O);
        board.generalMove(0,2, Board.LETTER.S);
        board.generalMove(3,3, Board.LETTER.O);
        assertEquals(board.getCell(3,3), Board.CELL.RED_O);
        board.generalMove(2,2, Board.LETTER.S);
        assertEquals(board.getCell(2,2), Board.CELL.BLUE_S);
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
