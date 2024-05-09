package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Princimpal extends JFrame {
    public Princimpal (){
        setSize(1100,650);//Configuracoes da Frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Primcimpal");
        setLayout(null);

        //Criacao do painel que ira prencher a Frame
        JPanel painel= new JPanel(null);
        add(painel).setBounds(0,0,1100,650);
        painel.setBackground(Color.darkGray);

        //Criacao do primeiro painel
        JPanel painel1= new JPanel(null);
        //Adicao da imagem da logo
        ImageIcon imagem= new ImageIcon(getClass().getResource("logo.png"));
        JLabel lbimg= new JLabel(imagem);
        painel1.add(lbimg).setBounds(30,10,250,180);

        //labels
        JLabel lbmenu= new JLabel("MENU");
        JButton btnreservar=new JButton("Reservar Quarto");
        JButton btnverificar=new JButton("Verificar Disponibilidade");
        JButton btncadastrar=new JButton("Cadastrar ");
        JButton btnsair=new JButton("Sair");


        //posicionamento
        lbmenu.setBounds(120,150,100,30);
        btnreservar.setBounds(30,200,250,25);
        btnverificar.setBounds(30,250,250,25);
        btncadastrar.setBounds(30,300,250,25);
        btnsair.setBounds(30,350,250,25);

        //fontes
        lbmenu.setFont(new Font("Tahoma",Font.BOLD,20));

        //adicao de componentes
        painel1.add(lbmenu);
        painel1.add(btnreservar);
        painel1.add(btnverificar);
        painel1.add(btncadastrar);
        painel1.add(btnsair);

        //acao para p botao sair
        btnsair.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btnsair){
                    System.exit(0);
                }
            }
        });

        //acao para p botao cadastrar
        btncadastrar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroUser ircadastrar= new CadastroUser();
                ircadastrar.show();
                dispose();

            }
        });




        //possicionamento do primeiro painel
        painel1.setBorder(BorderFactory.createLineBorder(Color.black));
        painel.add(painel1).setBounds(0,0,350,950);
        painel1.setBackground(new Color(0, 175, 198));


        //remocao das bordas dos botoes
        btnreservar.setBorderPainted(false);
        btncadastrar.setBorderPainted(false);
        btnverificar.setBorderPainted(false);
        btnsair.setBorderPainted(false);
        //fontes
        //  btncadastrar.setBackground(new Color(0, 175, 198));



        //fundo
        ImageIcon imagem3 = new ImageIcon(getClass().getResource("fundo.jpg"));
        JLabel lbimg3 = new JLabel(imagem3);
        lbimg3.setBounds(0,0,1200,850);
        painel.add(lbimg3);

    }
    public static void main(String[] args) {
        new Princimpal().setVisible(true);

    }
}
