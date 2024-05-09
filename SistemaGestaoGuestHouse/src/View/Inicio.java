package View;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Inicio extends JFrame {
    public Inicio(){
        setSize(1100,750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        //painel que ira prencher a frame
        JPanel painel = new JPanel(null);
        add(painel).setBounds(0,0,1100,750);
        painel.setBackground();
    }

    public static void main(String[] args) {

    }

}
