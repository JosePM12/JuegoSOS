package Sprint3.sprint3_3.produccion;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    JFrame frame = new JFrame();

    // Medidas para el board
    public static int CELL_SIZE = 330;
    public static int GRID_WIDTH = 3;
    public static int GRID_WIDHT_HALF = GRID_WIDTH / 2;

    public static int CELL_PADDING = CELL_SIZE / 6;
    public static int SYMBOL_STROKE_WIDTH = 8;

    private int CANVAS_WIDTH;
    private int CANVAS_HEIGHT;

    private GameBoardCanvas gameBoardCanvas;
    private JLabel gameStatusBar;
    // Header del frame
    JPanel header =new JPanel();
    // Componenetes de header
    JLabel nameGame = new JLabel("SOS");
    JRadioButton modeGame1 = new JRadioButton("Simple Game");
    JRadioButton modeGame2 = new JRadioButton("General Game");
    JLabel boardSize = new JLabel("Board Size");
    JTextField size = new JTextField(2);
    FlowLayout miFLowLayout = new FlowLayout(FlowLayout.LEFT);
    // Seccion del jugador azul y rojo
    JPanel bluePlayer = new JPanel();
    JPanel redPlayer = new JPanel();
    // Componenetes de cada jugador
    JLabel namebluePlayer =  new JLabel("Blue Player");
    JLabel nameredPlayer = new JLabel("Red Player");
    JRadioButton firstLetterBluePlayer = new JRadioButton("S");
    JRadioButton secondLetterBluePlayer = new JRadioButton("O");
    JRadioButton firstLetterRedPlayer = new JRadioButton("S");
    JRadioButton secondLetterRedPlayer = new JRadioButton("O");
    // Grid de la seccion de Player
    BoxLayout blueGrid = new BoxLayout(bluePlayer,BoxLayout.Y_AXIS);
    BoxLayout redGrid = new BoxLayout(redPlayer,BoxLayout.Y_AXIS);
    // Crear el tablero
    private Board board;
    // Parte inferior
    JPanel footer = new JPanel();
    JButton newGame = new JButton("New Game");

    Board.MODE modeGame = Board.MODE.NONE;
    String sizeGame = "0";

    public GUI(Board prBord) {
        initStaticGUI();
        // Usar el boton

        initTableGUI(prBord);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sizeGame = size.getText();
                Board exBoard;
                if(modeGame1.isSelected()){
                    modeGame = Board.MODE.SIMPLE;
                    exBoard = new Board(Integer.parseInt(sizeGame),modeGame);
                    initTableGUI(exBoard);
                    setSizeGUI(sizeGame);
                    newGame.setEnabled(false);
                    frame.setVisible(true);;

                } else if (modeGame2.isSelected()) {
                    modeGame = Board.MODE.GENERAL;
                    exBoard = new Board(Integer.parseInt(sizeGame),modeGame);
                    initTableGUI(exBoard);
                    setSizeGUI(sizeGame);
                    newGame.setEnabled(false);
                    frame.setVisible(true);;
                } else {
                    JOptionPane.showMessageDialog(frame,"No se puede crear el tablero");
                }
            }
        });
        frame.setVisible(true);
    }


    public void initTableGUI(Board exBoard)
    {
        this.board = exBoard;
        // Seleccionamos el JRadiosButton para generar el objeto de la clase GameSOS
        createBoard();

    }
    public void initStaticGUI(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        header.setLayout(miFLowLayout);
        header.add(nameGame);
        header.add(modeGame1);
        header.add(modeGame2);
        header.add(Box.createRigidArea(new Dimension(70,0)));
        header.add(boardSize);
        header.add(size);

        ButtonGroup modeGame = new ButtonGroup();
        modeGame.add(modeGame1);
        modeGame.add(modeGame2);

        bluePlayer.setLayout(blueGrid);
        bluePlayer.add(Box.createRigidArea(new Dimension(10,20)));
        bluePlayer.add(namebluePlayer);
        bluePlayer.add(Box.createRigidArea(new Dimension(10,20)));
        bluePlayer.add(firstLetterBluePlayer);
        bluePlayer.add(secondLetterBluePlayer);

        ButtonGroup lettersBlue = new ButtonGroup();
        lettersBlue.add(firstLetterBluePlayer);
        lettersBlue.add(secondLetterBluePlayer);

        redPlayer.setLayout(redGrid);
        redPlayer.add(Box.createRigidArea(new Dimension(10,20)));
        redPlayer.add(nameredPlayer);
        redPlayer.add(Box.createRigidArea(new Dimension(10,20)));
        redPlayer.add(firstLetterRedPlayer);
        redPlayer.add(secondLetterRedPlayer);

        ButtonGroup lettersRed = new ButtonGroup();
        lettersRed.add(firstLetterRedPlayer);
        lettersRed.add(secondLetterRedPlayer);

        footer.setLayout(new FlowLayout(FlowLayout.RIGHT));
        gameStatusBar = new JLabel("  ");
        gameStatusBar.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 15));
        gameStatusBar.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
        footer.add(gameStatusBar);
        footer.add(newGame);

        frame.add(header, BorderLayout.NORTH);
        frame.add(bluePlayer,BorderLayout.WEST);
        frame.add(redPlayer,BorderLayout.EAST);
        frame.add(footer,BorderLayout.SOUTH);
    }

    public void setSizeGUI(String s)
    {
        size.setText(s);
    }

    public void createBoard(){
        if(board.getSize()>2)
        {
            CELL_SIZE /= board.getSize();
            gameBoardCanvas = new GameBoardCanvas();
            CANVAS_WIDTH = CELL_SIZE * board.getSize();
            CANVAS_HEIGHT = (CELL_SIZE)* board.getSize() ;
            gameBoardCanvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
            Container boardPanel = getContentPane();
            boardPanel.setLayout(new BorderLayout());
            boardPanel.add(gameBoardCanvas, BorderLayout.CENTER);
            frame.add(boardPanel,BorderLayout.CENTER);
        }
    }
    public Board getBoard(){
        return board;
    }

    class GameBoardCanvas extends  JPanel{
        GameBoardCanvas() {
            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (board.getCurrentGameState() == Board.GameState.PLAYING) {
                        int rowSelected = e.getY() / CELL_SIZE;
                        int colSelected = e.getX() / CELL_SIZE;
                        if(board.getModeGame()== Board.MODE.SIMPLE)
                            board.simpleMove(rowSelected, colSelected,board.getLetterTurn());
                        else if (board.getModeGame() == Board.MODE.GENERAL) {
                            board.generalMove(rowSelected,colSelected,board.getLetterTurn());
                        }
                    } else {
                        board.initBoard();
                    }
                    repaint();
                }
            });
        }
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.WHITE);
            drawGridLines(g);
            drawBoard(g);

            printStatusBar();
        }
        private void drawGridLines(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillRoundRect(0,0,CANVAS_WIDTH-1,GRID_WIDTH,GRID_WIDTH,GRID_WIDTH);
            g.fillRoundRect(0, 0,
                    GRID_WIDTH, CANVAS_HEIGHT - 1, GRID_WIDTH, GRID_WIDTH);
            for (int row = 1; row < board.getSize(); ++row) {
                g.fillRoundRect(0, CELL_SIZE * row - GRID_WIDHT_HALF,
                        CANVAS_WIDTH - 1, GRID_WIDTH, GRID_WIDTH, GRID_WIDTH);
            }
            for (int col = 1; col < board.getSize(); ++col) {
                g.fillRoundRect(CELL_SIZE * col - GRID_WIDHT_HALF, 0,
                        GRID_WIDTH, CANVAS_HEIGHT - 1, GRID_WIDTH, GRID_WIDTH);
            }
            g.fillRoundRect(0,CELL_SIZE*board.getSize(),CANVAS_WIDTH-1,GRID_WIDTH,GRID_WIDTH,GRID_WIDTH);
            g.fillRoundRect(CELL_SIZE*board.getSize(), 0,
                    GRID_WIDTH, CANVAS_HEIGHT - 1, GRID_WIDTH, GRID_WIDTH);

        }

        private void drawBoard(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setFont(new Font("Arial",Font.BOLD,24));
            g2d.setStroke(new BasicStroke(SYMBOL_STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            for (int row = 0; row < board.getSize(); ++row) {
                for (int col = 0; col < board.getSize(); ++col) {
                    int x1 = col * CELL_SIZE + (CELL_SIZE/2);
                    int y1 = row * CELL_SIZE + (CELL_SIZE/2);
                    if (board.getCell(row, col) == Board.CELL.RED_S) {
                        g2d.setColor(Color.RED);
                        g2d.drawString("S",x1,y1);
                    } else if (board.getCell(row, col) == Board.CELL.BLUE_S) {
                        g2d.setColor(Color.BLUE);
                        g2d.drawString("S",x1,y1);
                    } else if (board.getCell(row,col) == Board.CELL.RED_O) {
                        g2d.setColor(Color.RED);
                        g2d.drawString("O",x1,y1);
                    } else if (board.getCell(row,col)==Board.CELL.BLUE_O){
                        g2d.setColor(Color.BLUE);
                        g2d.drawString("O",x1,y1);
                    }
                }
            }
        }

        private void printStatusBar() {
            if (board.getCurrentGameState() == Board.GameState.PLAYING) {
                gameStatusBar.setForeground(Color.BLACK);
                if (board.getColorPlayer() == Board.COLOR.BLUE) {
                    gameStatusBar.setText("Turno del Jugador Azul'");
                } else {
                    gameStatusBar.setText("Turno del Jugador Rojo");
                }
            } else if (board.getCurrentGameState() == Board.GameState.DRAW) {
                gameStatusBar.setForeground(Color.RED);
                gameStatusBar.setText("Empate!");
            } else if (board.getCurrentGameState() == Board.GameState.BLUE_WON) {
                gameStatusBar.setForeground(Color.BLUE);
                gameStatusBar.setText("Jugador Azul Gana!");
            } else if (board.getCurrentGameState() == Board.GameState.RED_WON) {
                gameStatusBar.setForeground(Color.RED);
                gameStatusBar.setText("Jugador Rojo Gana gana!");
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI(new Board(4, Board.MODE.SIMPLE));
            }
        });
    }
}
