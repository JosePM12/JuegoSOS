package sprint1_1.prueba;

import org.junit.jupiter.api.Test;

import sprint1_1.produccion.Board;
import sprint1_1.produccion.GUI;

public class TestSizeGUI {
    // Criterio de aceptacion 1.1
    @Test
    public void whenGiveCorrectSizeThenShowBoard(){
        new GUI(new Board(3));
        showGUI();
    }
    // Criterio de aceptacion 1.2
    @Test
    public void whenGiveIncorrectSizeThenNoShowBoard(){
        new GUI(new Board(2));
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
