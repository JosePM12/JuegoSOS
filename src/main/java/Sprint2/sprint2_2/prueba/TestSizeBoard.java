package Sprint2.sprint2_2.prueba;

import Sprint2.sprint2_0.produccion.Board;
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
