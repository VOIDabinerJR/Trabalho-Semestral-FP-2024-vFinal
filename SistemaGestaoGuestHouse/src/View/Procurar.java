package View;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Procurar extends JDesktopPane  {
    public Procurar(){
        setBackground(Color.lightGray);
        setSize(500,500);
        JPanel fundo = new JPanel(null);
        add(fundo).setBounds(0,0,500,500);

        JTextField t1 = new JTextField("t1");
        JTextField t2 = new JTextField("t2");
        JTextField t3 = new JTextField("t3");
        JButton badd= new JButton("Add");

        fundo.add(t1).setBounds(20,50,100, 30);
        fundo.add(t2).setBounds(180,50,100, 30);
       fundo.add(t3).setBounds(340,50,100, 30);
        fundo.add(badd).setBounds(400,50,100, 20);

        JTable tabela = new JTable(1,1);
        fundo.add(tabela).setBounds(20,100,200,200);
    }


    public static void main(String[] args) {
        Procurar A= new Procurar();
        A.setVisible(true);
    }



}
