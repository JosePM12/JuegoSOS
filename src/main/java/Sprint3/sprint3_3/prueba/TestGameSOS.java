package Sprint3.sprint3_3.prueba;

import Sprint3.sprint3_3.produccion.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGameSOS {
    private Board board;
    // Criterio de Aceptacion 2.1
    @Test
    public void whenSelectFirstModeGameThenConfirmMode(){
        board = new Board(4, Board.MODE.SIMPLE);
        assertEquals(board.getModeGame(), Board.MODE.SIMPLE);
    }
    @Test
    public void whenSelectSecondModeGameThenConfirmMode(){
        board = new Board(4, Board.MODE.GENERAL);
        assertEquals(board.getModeGame(), Board.MODE.GENERAL);
    }
    // Criterio de Aceptacion 2.2
    @Test void whenNotSelectAnyModeGamethenNotMode(){
        board = new Board(4, Board.MODE.NONE);
        assertEquals(board.getModeGame(),Board.MODE.NONE);
    }
}
