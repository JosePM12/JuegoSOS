package Sprint3.sprint3_2.prueba;

import Sprint3.sprint3_2.produccion.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSimpleMove {
    private Board board;

    @BeforeEach
    public void setUp() throws Exception{
        board = new Board(4);
    }
    // Criterio de Aceptacion 4.1
    @Test
    public void whenStarGameThenDoOneSimpleMove(){
        assertEquals(board.getColorPlayer(), Board.COLOR.BLUE);
        board.simpleMove(0,0, Board.LETTER.S);
        assertEquals(board.getCell(0,0), Board.CELL.BLUE_S);
        assertEquals(board.getColorPlayer(), Board.COLOR.RED);
        assertEquals(board.getLetterTurn(), Board.LETTER.S);
    }
    // Criterio de Aceptacion 4.2
    @Test
    public void whenDidOneMoveThenChangeColor(){
        board.simpleMove(0,0, Board.LETTER.S);
        assertEquals(board.getColorPlayer(), Board.COLOR.RED);
        assertEquals(board.getLetterTurn(), Board.LETTER.S);
        board.simpleMove(1,1, Board.LETTER.S);
        assertEquals(board.getCell(1,1), Board.CELL.RED_S);
    }
    // Criterio de Aceptacion 4.3
    @Test
    public void whenDidMovesThenChangeLetterAndColor(){
        // Empezamos con la letra S y BLUE
        board.simpleMove(0,0, Board.LETTER.S);
        // Seguimos con la letra O y RED
        board.simpleMove(1,1, Board.LETTER.O);
        assertEquals(board.getLetterTurn(), Board.LETTER.O);
        assertEquals(board.getColorPlayer(), Board.COLOR.BLUE);
    }

}
