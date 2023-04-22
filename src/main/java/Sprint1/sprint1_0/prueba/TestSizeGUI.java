package Sprint1.sprint1_0.prueba;

import org.junit.jupiter.api.Test;
import Sprint1.sprint1_0.produccion.Board;
import Sprint1.sprint1_0.produccion.GUI;

public class TestSizeGUI {
    private Board board;
    // Criterio de aceptacion 1.1
    @Test
    public void whenGiveCorrectSizeThenShowBoard(){
        board = new Board(4);
        new GUI(board);
        showGUI();
    }
    // Criterio de aceptacion 1.2
    @Test
    public void whenGiveIncorrectSizeThenNoShowBoard(){
        board = new Board(2);
        new GUI(board);
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
