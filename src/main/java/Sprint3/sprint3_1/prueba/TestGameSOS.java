package Sprint3.sprint3_1.prueba;

import Sprint3.sprint3_1.produccion.Board;
import Sprint3.sprint3_1.produccion.GameSOS;
import org.junit.jupiter.api.Assertions;
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
        gameSOS.setModeGame(GameSOS.MODE.SIMPLE);
        Assertions.assertEquals(gameSOS.getModeGame(), GameSOS.MODE.SIMPLE);
    }
    @Test
    public void whenSelectSecondModeGameThenConfirmMode(){
        gameSOS.setModeGame(GameSOS.MODE.GENERAL);
        Assertions.assertEquals(gameSOS.getModeGame(), GameSOS.MODE.GENERAL);
    }
    // Criterio de Aceptacion 2.2
    @Test void whenNotSelectAnyModeGamethenNotMode(){
        Assertions.assertEquals(gameSOS.getModeGame(), GameSOS.MODE.NONE);
    }
}
