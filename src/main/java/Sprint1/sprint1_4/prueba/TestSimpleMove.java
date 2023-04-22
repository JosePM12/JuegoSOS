package Sprint1.sprint1_4.prueba;

import Sprint1.sprint1_4.produccion.Board;
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
        assertEquals(board.getLetterTurn(),'S');
        board.simpleMove(0,0);
        assertEquals(board.getCell(0,0), Board.CELL.blueS);
        assertEquals(board.getColorPlayer(), Board.COLOR.RED);
        assertEquals(board.getLetterTurn(),'S');
    }
    // Criterio de Aceptacion 4.2
    @Test
    public void whenDidOneMoveThenChangeColor(){
        board.simpleMove(0,0);
        assertEquals(board.getColorPlayer(), Board.COLOR.RED);
        assertEquals(board.getLetterTurn(),'S');
        board.simpleMove(1,1);
        assertEquals(board.getCell(1,1), Board.CELL.redS);
    }
    // Criterio de Aceptacion 4.3
    @Test
    public void whenDidMovesThenChangeLetterAndColor(){
        // Empezamos con la letra S y BLUE
        board.simpleMove(0,0);
        // Seguimos con la letra S y RED
        board.simpleMove(1,1);
        // Ahora debe cambiar a la letra O y BLUE
        assertEquals(board.getLetterTurn(),'O');
        assertEquals(board.getColorPlayer(), Board.COLOR.BLUE);
    }

}
