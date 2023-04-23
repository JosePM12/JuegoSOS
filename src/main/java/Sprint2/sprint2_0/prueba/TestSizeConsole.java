package Sprint2.sprint2_0.prueba;

import Sprint2.sprint2_0.produccion.Console;
import org.junit.jupiter.api.Test;
import Sprint2.sprint2_0.produccion.Board;

public class TestSizeConsole {
    private Board board;
    // Criterio de aceptacion 1.1
    @Test
    public void whenGiveCorrectSizeThenCreateBoard(){
        board = new Board(3);
        new Console(board).displayBoard();
    }
    // Criterio de aceptacion 1.2
    @Test
    public void whenGiveIncorrectSizeThenNotCreateBoard(){
        board = new Board(1);
        new Console(board).displayBoard();
    }
}
