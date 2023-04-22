package Sprint1.sprint1_3.prueba;

import Sprint1.sprint1_3.produccion.Board;
import Sprint1.sprint1_3.produccion.GameSOS;
import Sprint1.sprint1_3.produccion.GameSOS.MODE;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGameSOS {
    private GameSOS gameSOS;
    @BeforeEach
    public void setUp() throws Exception{
        gameSOS = new GameSOS(new Board(4));
    }
    // Criterio de Aceptacion 2.1
    @Test
    public void whenSelectFirstModeGameThenConfirmMode(){
        gameSOS.setModeGame(MODE.SIMPLE);
        assertEquals(gameSOS.getModeGame(), MODE.SIMPLE);
    }
    @Test
    public void whenSelectSecondModeGameThenConfirmMode(){
        gameSOS.setModeGame(MODE.GENERAL);
        assertEquals(gameSOS.getModeGame(), MODE.GENERAL);
    }
    // Criterio de Aceptacion 2.2
    @Test void whenNotSelectAnyModeGamethenNotMode(){
        assertEquals(gameSOS.getModeGame(),MODE.NONE);
    }
}
