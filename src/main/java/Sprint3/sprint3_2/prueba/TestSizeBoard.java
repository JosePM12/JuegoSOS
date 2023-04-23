package Sprint3.sprint3_2.prueba;

import Sprint3.sprint3_1.produccion.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSizeBoard {
    private Board board;

    @Test
    public void whenGiveCorrectSizeThenCreateBoard(){
        Board board = new Board(3);
        assertEquals(board.getSize(),3);
    }
    // Criterio de aceptacion 1.2
    @Test
    public void whenGiveIncorrectSizeThenNotCreateBoard(){
        Board board = new Board(2);
        assertEquals(board.getSize(),-1);
    }
}
