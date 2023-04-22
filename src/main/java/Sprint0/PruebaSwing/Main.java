package Sprint0.PruebaSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Operaciones operaciones = new Operaciones();
        JPanel Primero = new JPanel();
        Primero.setLayout(new FlowLayout());
        JPanel Segundo = new JPanel();
        Segundo.setLayout(new FlowLayout());


        JLabel txt1 = new JLabel("Ingrese el primer numero");
        JLabel txt2 = new JLabel("Ingrese el segundo numero");

        JTextField Number1 = new JTextField("0",10);
        JTextField Number2 = new JTextField("0",10);

        Primero.add(txt1);
        Primero.add(Number1);
        Segundo.add(txt2);
        Segundo.add(Number2);

        JPanel header = new JPanel();
        GridLayout miGrid = new GridLayout(2,1);
        miGrid.setVgap(0);
        header.setLayout(miGrid);

        header.add(Primero,0,0);
        header.add(Segundo,0,1);


        JPanel main = new JPanel();
        main.setLayout(new FlowLayout());
        JRadioButton  Sumar = new JRadioButton("Sumar",false);
        JRadioButton  Restar = new JRadioButton("Restar",false);
        JRadioButton  Multiplicar = new JRadioButton("Multiplicar",false);
        JRadioButton  Dividir = new JRadioButton("Dividir",false);
        JButton OkButton = new JButton("OK");
        ButtonGroup Operaciones = new ButtonGroup();

        main.add(Sumar);
        main.add(Restar);
        main.add(Multiplicar);
        main.add(Dividir);
        main.add(OkButton);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.add(header,0,0);
        frame.add(main,0,1);

        frame.setVisible(true);

        Sumar.setSelected(true);
        Operaciones.add(Sumar);
        Operaciones.add(Restar);
        Operaciones.add(Multiplicar);
        Operaciones.add(Dividir);
        OkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String mensaje=null;
                float numero1=0,numero2=0;
                numero1 =Float.parseFloat(Number1.getText());
                numero2 = Float.parseFloat(Number2.getText());
                if(Sumar.isSelected()) {
                    int resultado = (int) operaciones.suma(numero1, numero2);
                    mensaje = "El resultado es " + String.valueOf(resultado);
                }
                else if(Restar.isSelected()){
                    int resultado = (int) operaciones.resta(numero1,numero2);
                    mensaje = "El resultado es " + String.valueOf(resultado);
                } else if(Multiplicar.isSelected()) {
                    int resultado = (int) operaciones.multiplicacion(numero1,numero2);
                    mensaje = "El resultado es " + String.valueOf(resultado);
                } else if (Dividir.isSelected()) {
                    float resultado = operaciones.division(numero1,numero2);
                    mensaje = "El resultado es " + String.valueOf(resultado);
                }
                JOptionPane.showMessageDialog(null,mensaje);
            }
        });
    }



}
