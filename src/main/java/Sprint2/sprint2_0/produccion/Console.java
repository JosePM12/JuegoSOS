package Sprint2.sprint2_0.produccion;

public class Console {
    private Board  board;
    public Console(Board board)
    {
        this.board = board;
    }
    public void displayBoard()
    {
        int size = board.getSize();
        for(int row=0;row<size;row++) {
            System.out.println("-------");
            for (int col=0;col<size;col++){
                System.out.print("|"+ board.getCell(row, col));
            }
            System.out.println("");
        }
        System.out.println("-------");
    }
    public static void main(String[] args) {
        new Console(new Board(2)).displayBoard();;
    }
}
