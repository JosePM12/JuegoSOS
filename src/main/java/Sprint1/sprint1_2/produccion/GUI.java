package Sprint1.sprint1_2.produccion;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {
    JFrame frame = new JFrame();
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
    JPanel boardGUI = new JPanel();
    private Board board;

    private GameSOS gameSOS;
    JPanel footer = new JPanel();

    JLabel infoGame = new JLabel("Current turn: blue (or red)");

    public GUI() {
        initStaticGUI();
        frame.setVisible(true);
    }



    public void initTableGUI(String size, GameSOS.MODE mode)
    {
        setSizeGUI(size);
        this.board = new Board(Integer.parseInt(this.size.getText()));

        gameSOS = new GameSOS(board);
        selectModeGame(mode);
        // Seleccionamos el JRadiosButton para generar el objeto de la clase GameSOS

        if(modeGame1.isSelected() && board.getSize()>2){
            gameSOS.setModeGame(GameSOS.MODE.SIMPLE);
            createBoard();
        } else if(modeGame2.isSelected() && board.getSize()>2) {
            gameSOS.setModeGame(GameSOS.MODE.GENERAL);
            createBoard();
        } else {
            JOptionPane.showMessageDialog(frame,"No se puede crear el tablero");
        }
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

        footer.setLayout(new FlowLayout(FlowLayout.CENTER));
        footer.add(infoGame);

        frame.add(header, BorderLayout.NORTH);
        frame.add(bluePlayer,BorderLayout.WEST);
        frame.add(redPlayer,BorderLayout.EAST);
        frame.add(footer,BorderLayout.SOUTH);
    }

    public void setSizeGUI(String s)
    {
        size.setText(s);
    }

    public void selectModeGame(GameSOS.MODE mode)
    {
        if(mode== GameSOS.MODE.SIMPLE) {
            modeGame1.setSelected(true);
        } else if(mode== GameSOS.MODE.GENERAL){
            modeGame2.setSelected(true);
        }
    }
    public void createBoard(){
        if(board.getSize()>2)
        {
            GridLayout boardGrid = new GridLayout(board.getSize(),board.getSize());
            boardGUI.setLayout(boardGrid);
            for (int i=0;i<board.getSize()*board.getSize();i++)
            {
                JPanel BoardPiece = new JPanel();
                BoardPiece.setBackground(Color.WHITE);
                Border borde;
                borde = BorderFactory.createLineBorder(Color.black);  ///se le pone un borde.
                BoardPiece.setBorder(borde);
                boardGUI.add(BoardPiece);
            }
            frame.add(boardGUI,BorderLayout.CENTER);
        }
    }

    public Board getBoard(){
        return board;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}
