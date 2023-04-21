package sprint1_1.prueba;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sprint1_1.produccion.Board;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmptyBoard {
    private Board board;
    @BeforeEach
    public void setUp() throws Exception{
        board = new Board(4);
    }
    @Test
    public void whenCreateBoardThenNotAllowInvalidRow(){
        assertEquals(board.getCell(4,0),-1);
    }
    @Test
    public void whenCreateBoardThenAllowRow(){
        assertEquals(board.getCell(2,1),0);
    }
}
