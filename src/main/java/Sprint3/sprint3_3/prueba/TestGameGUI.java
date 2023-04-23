package Sprint3.sprint3_3.prueba;

import Sprint3.sprint3_1.produccion.GUI;
import Sprint3.sprint3_1.produccion.GameSOS;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGameGUI {
    private GUI gui;
    @BeforeEach
    public void setUp() throws Exception{
        gui = new GUI();
    }

    // Criterio de Aceptacion 3.1
    @Test
    public void whenCorrectSizeCorrectModeThenCreateTable()
    {
        gui.initTableGUI("4", GameSOS.MODE.SIMPLE);
        showGUI();
    }
    // Criterio de Aceptacion 3.2
    @Test
    public void whenCorrectSizeNullModeThenCreateTable(){
        gui.initTableGUI("6", GameSOS.MODE.NONE);
        showGUI();
    }
    // Criterio de Aceptacion 3.3

    @Test
    public void whenIncorrectSizeCorrectModeThenCreateTable(){
        gui.initTableGUI("2", GameSOS.MODE.GENERAL);
        showGUI();
    }
    // Criterio de Aceptacion 3.4

    @Test
    public void whenIncorrectSizeNullModeThenCreateTable(){
        gui.initTableGUI("1", GameSOS.MODE.NONE);
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
