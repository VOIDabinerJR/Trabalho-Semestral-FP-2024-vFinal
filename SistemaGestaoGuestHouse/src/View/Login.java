package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class Login extends JFrame  {
    public Login(){
        setSize(850,650);//Configuracoes da Frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Login");
        setLayout(null);

        //Criacao do painel que ira prencher a Frame
        JPanel painel= new JPanel(null);
        add(painel).setBounds(0,0,850,650);
        painel.setBackground(Color.darkGray);


        //Criacao do primeiro painel
        JPanel painel1 = new JPanel(null){
            @Override
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

        //LABELS
        ImageIcon imagemuser= new ImageIcon(getClass().getResource("user.png"));
        JLabel lbuser= new JLabel(imagemuser);
        painel1.add(lbuser).setBounds(40,5,300,400);

        //labels
        JLabel lbtext1=new JLabel("LOGIN");
        JLabel lbnome=new JLabel("NOME: ");
        JLabel lbemail=new JLabel("SENHA: ");
        JButton btnvoltar= new JButton("INICIO");
        JButton btnentrar= new JButton("ENTRAR");


        //CAIXAS DE TEXTO
        JTextField tfnome = new JTextField(30);
        JPasswordField tfemail = new JPasswordField(30);


        //POSICIONAMENTO  E ADICAO DE LABLES AO PAINEL1
        painel1.add(lbtext1).setBounds(150,140,300,30);
        painel1.add(lbnome).setBounds(20,190,300,30);
        painel1.add( lbemail).setBounds(20,240,300,30);

        //POSICIONAMENTO DAS CAIXAS DE TEXTO E ADICAO AO PAINEL1
       painel1.add( tfnome).setBounds(70,190,300,30);
        painel1.add(tfemail).setBounds(70,240,300,30);
        painel1.add(btnvoltar).setBounds(100,320,100,25);
        painel1.add(btnentrar).setBounds(250,320,100,25);


        //fontes
        lbtext1.setFont(new Font("Tahoma",Font.BOLD,30));
        btnentrar.setBackground(Color.white);
        btnvoltar.setBackground(Color.white);

        //acoes do botao ENTRAR
        btnvoltar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio voltar_inicio = new Inicio();
                voltar_inicio.show();
                dispose();
            }
        });
        //acoes para o botao entrar
//        btnentrar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                princimpal irprincimpal= new princimpal();
//                irprincimpal.show();
//                dispose();
//            }
//        });


        painel1.setBackground(new Color(0, 239, 236));
        painel.add(painel1).setBounds(210,25,400,450);
        //fundo
        ImageIcon imagem3 = new ImageIcon(getClass().getResource("fundo.jpg"));
        JLabel lbimg3 = new JLabel(imagem3);
        lbimg3.setBounds(0,0,850,830);
        painel.add(lbimg3);
    }

    public static void main(String[] args) {
        new Login().setVisible(true);

    }
}

