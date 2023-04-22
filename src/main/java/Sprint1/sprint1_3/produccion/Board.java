package Sprint1.sprint1_3.produccion;

public class Board {
    private int[][] grid = null;
    // Turno de la letra a colocar S u O
    private int size;

    private Player player;

    public void setSize(int size)
    {
        this.size = size;
    }
    public int getSize()
    {
        return size;
    }
    public Board(int SIZE){
        if(SIZE<=2) {
            setSize(-1);
        } else {
            grid = new int[SIZE][SIZE];
            player = new Player();
            setSize(SIZE);
        }
    }
    public int getCell(int row,int col)
    {
        if(row>=0 && row<size && col>=0 && col<size){
            return  grid[row][col];
        } else {
            return -1;
        }
    }

    public void simpleMove(int row, int column){
        if (row >= 0 && row < size && column >= 0 && column < size
                &&  grid[row][column] == 0)
        {
            grid[row][column] = ((player.getLetterTurn()=='S' || player.getLetterTurn()=='O')&& player.getColor()== Player.COLOR.BLUE) ? 1 : 2;
            if(player.getColor()== Player.COLOR.RED)
            {
                if(player.getLetterTurn()=='S')
                    player.setLetterTurn('O');
                else
                    player.setLetterTurn('S');
            }
            if(player.getColor()== Player.COLOR.BLUE)
                player.setColor(Player.COLOR.RED);
            else
                player.setColor(Player.COLOR.BLUE);
        }
    }

    public Player getPlayer(){
        return player;
    }


}
