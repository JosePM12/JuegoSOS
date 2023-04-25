package Sprint3.sprint3_3.prueba;

import Sprint3.sprint3_3.produccion.Board;
import Sprint3.sprint3_3.produccion.GUI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGameGUI {
    private Board board;
    private GUI gui;

    // Criterio de Aceptacion 3.1
    @Test
    public void whenCorrectSizeCorrectModeThenCreateTable()
    {
        board = new Board(4, Board.MODE.SIMPLE);
        gui = new GUI(board);
        showGUI();
    }
    // Criterio de Aceptacion 3.2
    @Test
    public void whenCorrectSizeNullModeThenCreateTable(){
        board = new Board(6, Board.MODE.NONE);
        gui = new GUI(board);
        showGUI();
    }
    // Criterio de Aceptacion 3.3

    @Test
    public void whenIncorrectSizeCorrectModeThenCreateTable(){
        board = new Board(2, Board.MODE.GENERAL);
        gui = new GUI(board);
        showGUI();
    }
    // Criterio de Aceptacion 3.4

    @Test
    public void whenIncorrectSizeNullModeThenCreateTable(){
        board = new Board(1, Board.MODE.NONE);
        gui = new GUI(board);
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
