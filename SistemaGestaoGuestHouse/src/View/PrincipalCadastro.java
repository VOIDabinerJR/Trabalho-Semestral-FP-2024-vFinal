package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class PrincipalCadastro extends JFrame {
    public PrincipalCadastro(){
        componentes();





    }
    public void componentes(){
        setSize(1200,800);//Configuracoes da Frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Primcimpal");
        setLayout(null);

        //Criacao do painel que ira prencher a Frame
        JPanel painel= new JPanel(null);

        add(painel).setBounds(0,0,1200,800);
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
        JButton btncheckout = new JButton("Check Out");
        JButton btnaddquarto = new JButton("Gerir Quartos");
        JButton btnrelatorio = new JButton("Relatorios");


        //posicionamento
        lbmenu.setBounds(120,150,100,30);
        btnreservar.setBounds(30,200,250,25);
        btncheckout.setBounds(30,250,250,25);
        btnverificar.setBounds(30,300,250,25);
        btnaddquarto.setBounds(30,350,250,25);
        btncadastrar.setBounds(30,400,250,25);
        btnrelatorio.setBounds(30,500,250,25);
        btnsair.setBounds(30,550,250,25);




        //fontes
        lbmenu.setFont(new Font("Tahoma",Font.BOLD,20));

        //adicao de componentes
        painel1.add(lbmenu);
//        painel1.add(btnreservar);
//        painel1.add(btnverificar);
//        painel1.add(btnaddquarto);
//        painel1.add(btncheckout);
        painel1.add(btncadastrar);
//        painel1.add(btnsair);
//        painel1.add(btnrelatorio);



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





        //possicionamento do primeiro painel
        painel1.setBorder(BorderFactory.createLineBorder(Color.black));
        painel.add(painel1).setBounds(0,0,350,950);
        painel1.setBackground(new Color(0, 175, 198));


        //remocao das bordas dos botoes
//        btnreservar.setBorderPainted(false);
        btncadastrar.setBorderPainted(false);
//        btncheckout.setBorderPainted(false);
//        btnverificar.setBorderPainted(false);
//        btnaddquarto.setBorderPainted(false);
//        btnrelatorio.setBorderPainted(false);
//        btnsair.setBorderPainted(false);
        //fontes
        //  btncadastrar.setBackground(new Color(0, 175, 198));



        //fundo
        ImageIcon imagem3 = new ImageIcon(getClass().getResource("fundo.jpg"));
        JLabel lbimg3 = new JLabel(imagem3);
        lbimg3.setBounds(0,0,1200,950);
        painel.add(lbimg3);

        //acoes outros botoes
        btnreservar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reserva reserva= new Reserva();


                painel.removeAll();
                painel.add(painel1);
                setSize(1650,800);
                add(painel).setBounds(0,0,1650,800);

                painel.add(reserva).setBounds(350,0,1300,950);

            }
        });
        btncheckout.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Checkout checkout= new Checkout();


                painel.removeAll();
                painel.add(painel1);
                setSize(1200,800);//Configuracoes da Frame
                add(painel).setBounds(0,0,1200,800);

                painel.add(checkout).setBounds(350,0,1200,950);
            }
        });
        btnverificar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                QuartosDisponiveis qd= new QuartosDisponiveis();

                painel.removeAll();
                painel.add(painel1);
                setSize(1200,800);//Configuracoes da Frame
                add(painel).setBounds(0,0,1200,800);

//                painel.add(qd).setBounds(350,0,750,950);
                JDesktopPane desktopPane = new JDesktopPane();
                // Adicionar o JInternalFrame ao JDesktopPane
                QuartosDisponiveis quartosDisponiveis = null;
                try {
                    quartosDisponiveis = new QuartosDisponiveis();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                desktopPane.add(quartosDisponiveis);
                quartosDisponiveis.setVisible(true);
                painel.add(desktopPane).setBounds(350,0,1200,950);

            }
        });
        btnaddquarto.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Quarto quarto= new Quarto();

                painel.removeAll();
                painel.add(painel1);
                setSize(1200,800);//Configuracoes da Frame
                add(painel).setBounds(0,0,1200,800);

                painel.add(quarto).setBounds(350,0,1200,950);
            }
        });
        btncadastrar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroUser ircadastrar= new CadastroUser();
                painel.removeAll();
                painel.add(painel1);
                setSize(1200,800);//Configuracoes da Frame
                add(painel).setBounds(0,0,1200,800);

                painel.add(ircadastrar).setBounds(350,0,1200,950)  ;


            }
        });
        btnrelatorio.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String perfil ="admin";
                if (perfil != "admin"){
                    JOptionPane.showMessageDialog(null,"nao autorizado");
                }else {
                    Relatorio quarto= new Relatorio();

                    painel.removeAll();
                    painel.add(painel1);
                    setSize(1200,800);//Configuracoes da Frame
                    add(painel).setBounds(0,0,1200,800);

                    painel.add(quarto).setBounds(350,0,1200,950);


                }

            }
        });
        btnsair.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });




    }


    public static void main(String[] args) {
        new PrincipalCadastro().setVisible(true);

    }
}