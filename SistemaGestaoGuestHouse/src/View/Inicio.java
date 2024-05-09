package View;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Inicio extends JFrame {
    public Inicio(){
        setSize(1150,650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        //painel que ira prencher a frame
        JPanel painel = new JPanel(null);
        add(painel).setBounds(0,0,1150,650);
        painel.setBackground(ColorUIResource.lightGray);

        //primeiro painel
        JPanel painel1=new JPanel(null){
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int width = getWidth();
            int height = getHeight();
            int arc = 50;
            g2d.setColor(new Color(0, 175, 198));
            g2d.fill(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arc, arc));

            g2d.setColor(Color.BLACK);
            g2d.draw(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arc, arc));
            g2d.dispose();
        }//metodo para achatar as bordas do primeiro painel
    };
        painel1.setBackground(new Color(0, 239, 236));
        painel.add(painel1).setBounds(250,20,300,500);

        //segundo painel
        JPanel painel2 = new JPanel(null){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                int width = getWidth();
                int height = getHeight();
                int arc = 50;
                g2d.setColor(new Color(0, 175, 198));
                g2d.fill(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arc, arc));

                g2d.setColor(Color.BLACK);
                g2d.draw(new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arc, arc));
                g2d.dispose();
            }//metodo para achatar as bordas do primeiro painel
        };
        painel2.setBackground(new Color(0, 239, 236));
        painel.add(painel2).setBounds(580,20,500,500);


        //fundo
        ImageIcon imagem3 = new ImageIcon(getClass().getResource("fundo.jpg"));
        JLabel lbimg3 = new JLabel(imagem3);
        lbimg3.setBounds(0,0,1160,980);
        painel.add(lbimg3);
    }

    public static void main(String[] args) {
        new Inicio().setVisible(true);

    }

}
