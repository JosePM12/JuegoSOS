package Sprint3.sprint3_2.produccion;

public class GameSOS {
    public enum MODE{
        NONE,
        SIMPLE,
        GENERAL
    }


    private Board board;
    private MODE modeGame;
    public GameSOS(Board board){
        // Size de forma estatica
        this.board = board;
        modeGame = MODE.NONE;
    }
    public void setModeGame(MODE mode)
    {
        this.modeGame = mode;
    }
    public MODE getModeGame()
    {
        return this.modeGame;
    }

}
