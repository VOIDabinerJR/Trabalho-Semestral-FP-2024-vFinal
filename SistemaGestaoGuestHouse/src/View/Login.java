package View;

import Conection.ConexaoMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Login extends JFrame  {
    public Login(){


        if (ConexaoMySQL.verificarConexao()){
            bdimg ="true.png";

        } else {
            bdimg ="false.png";
        }

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
        ImageIcon imgbd = new ImageIcon(getClass().getResource(bdimg));
        JLabel lbbdimg = new JLabel(imgbd);
        painel1.add(lbbdimg).setBounds(30,360,80,80);

        //labels
        JLabel lbtext1=new JLabel("LOGIN");
        JLabel lbnome=new JLabel("NOME: ");
        JLabel lbemail=new JLabel("SENHA: ");
        JButton btnvoltar= new JButton("INICIO");
        JButton btnentrar2 = new JButton("ENTRAR");
        JLabel lblerrologin = new JLabel("");



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
        painel1.add(btnentrar2).setBounds(250,320,100,25);
        painel1.add(lblerrologin).setBounds(80,370,300,30);


        //fontes
        lbtext1.setFont(new Font("Tahoma",Font.BOLD,30));
        btnentrar2.setBackground(Color.red);
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
        btnentrar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblerrologin.setText(logar(tfnome,tfemail));
            }
        });

        painel1.setBackground(new Color(0, 239, 236));
        painel.add(painel1).setBounds(210,25,400,450);
        //fundo
        ImageIcon imagem3 = new ImageIcon(getClass().getResource("fundo.jpg"));
        JLabel lbimg3 = new JLabel(imagem3);
        lbimg3.setBounds(0,0,850,830);
        painel.add(lbimg3);


    }

    /// metodo fazer login
    public String logar(JTextField t2, JPasswordField t1) {



        String sql = "select * from usuario where username='" +t2.getText()+ "'and senha='" +t1.getText()+ "';";
        try {

            PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement(sql);


            ResultSet rs = pst.executeQuery();

            if(rs.next()){

                Princimpal irprincimpal= new Princimpal();
                irprincimpal.show();
                dispose();

            } else {

               return "UserName ou senha invalios" ;
            }


        }catch (Exception e){
            System.out.println(e);

        }
        return "";
    }

    public static void main(String[] args) {
        new Login().setVisible(true);

    }

    public String bdimg;
}

