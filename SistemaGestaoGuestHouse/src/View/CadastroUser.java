package View;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class CadastroUser extends JFrame {
    public CadastroUser(){
        setSize(1250,750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        //painel que ira prencher a frame
        JPanel painel = new JPanel(null);
        add(painel).setBounds(0,0,1250,750);
        painel.setBackground(ColorUIResource.lightGray);

        // primeiro painel
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

        //labels
        JLabel lbcadastro= new JLabel("CADASTRO");
        JLabel lbnome= new JLabel("NOME: ");
        JLabel lbnumerodoc= new JLabel("BI: ");
        JLabel lbperfil= new JLabel("PERFIL: ");
        JLabel lbusername= new JLabel("USER NAME: ");
        JLabel lbsenha= new JLabel("SENHA: ");
        JLabel lbsexo= new JLabel("SEXO: ");
        JLabel lbendereco= new JLabel("ENDERECO: ");
        JLabel lbcelular= new JLabel("CELULAR: ");
        JLabel lbdata= new JLabel("DATA: ");
        JLabel lbestado= new JLabel("ESTADO: ");

        //caixas de textos
        JTextField tfnome= new JTextField(30);
        JTextField tfnumerodoc= new JTextField(30);
        JTextField tfusername= new JTextField(30);
        JTextField tfsenha= new JTextField(30);
        JTextField tfendereco= new JTextField(30);
        JTextField tfcelular= new JTextField("(+258):");
        JTextField tfdata= new JTextField("DD/MM/AA");



        //RadioButons
        JRadioButton rbtadmin= new JRadioButton("ADIM");
        JRadioButton rbtuser= new JRadioButton("USER");
        JRadioButton rbtmasc= new JRadioButton("MASCULINO");
        JRadioButton rbtfem= new JRadioButton("FEMENINO");
        JRadioButton rbtativo= new JRadioButton("ATIVO");
        JRadioButton rbtinativo= new JRadioButton("INATIVO");

        //botoes
        JButton btnvoltar= new JButton("VOLTAR");
        JButton btncadastrar= new JButton("CADASTRAR");


        //posicionamento de  labels e adicao de componentes
        painel1.add(lbcadastro).setBounds(350,20,300,30);
        painel1.add(lbnome).setBounds(100,80,400,30);
        painel1.add(lbnumerodoc).setBounds(100,130,400,30);
        painel1.add(lbperfil).setBounds(100,180,400,30);
        painel1.add(lbusername).setBounds(100,230,450,30);
        painel1.add(lbsenha).setBounds(100,280,450,30);
        painel1.add(lbsexo).setBounds(100,320,450,30);
        painel1.add(lbendereco).setBounds(100,370,450,30);
        painel1.add(lbcelular).setBounds(100,420,450,30);
        painel1.add(lbdata).setBounds(100,480,450,30);
        painel1.add(lbestado).setBounds(100,530,450,30);


        //posicionamento de  caixas de texto  e adicao de componentes
        painel1.add(tfnome).setBounds(200,80,450,30);
        painel1.add(tfnumerodoc).setBounds(200,130,450,30);
        painel1.add(tfusername).setBounds(200,230,450,30);
        painel1.add(tfsenha).setBounds(200,280,450,30);
        painel1.add(tfendereco).setBounds(200,370,450,30);
        painel1.add(tfcelular).setBounds(200,420,450,30);
        painel1.add(tfdata).setBounds(200,480,450,30);


        //possicionamento dos radiobuton
        painel1.add(rbtadmin).setBounds(200,180,150,25);
        painel1.add(rbtuser).setBounds(350,180,150,25);
        painel1.add(rbtmasc).setBounds(200,320,150,25);
        painel1.add(rbtfem).setBounds(350,320,150,25);
        painel1.add(rbtativo).setBounds(200,530,100,30);
        painel1.add(rbtinativo).setBounds(350,530,100,30);

        //possicionamento e adicao de botoes
        painel1.add(btnvoltar).setBounds(250,580,150,25);
        painel1.add(btncadastrar).setBounds(450,580,150,25);



        //fontes
        lbcadastro.setFont(new Font("Tahoma",Font.BOLD,25));
        lbnome.setFont(new Font("Tahoma",Font.BOLD,15));
        lbnumerodoc.setFont(new Font("Tahoma",Font.BOLD,15));
        lbperfil.setFont(new Font("Tahoma",Font.BOLD,15));
        lbsenha.setFont(new Font("Tahoma",Font.BOLD,15));
        lbusername.setFont(new Font("Tahoma",Font.BOLD,15));
        lbsexo.setFont(new Font("Tahoma",Font.BOLD,15));
        lbendereco.setFont(new Font("Tahoma",Font.BOLD,15));
        lbcelular.setFont(new Font("Tahoma",Font.BOLD,15));
        lbdata.setFont(new Font("Tahoma",Font.BOLD,15));
        tfdata.setFont(new Font("Tahoma",Font.BOLD,15));
        tfcelular.setFont(new Font("Tahoma",Font.BOLD,15));
        lbestado.setFont(new Font("Tahoma",Font.BOLD,15));

        //fonte dos radiobutons
        rbtadmin.setFont(new Font("Tahoma",Font.BOLD,15));
        rbtuser.setFont(new Font("Tahoma",Font.BOLD,15));
        rbtmasc.setFont(new Font("Tahoma",Font.BOLD,15));
        rbtfem.setFont(new Font("Tahoma",Font.BOLD,15));
        rbtativo.setFont(new Font("Tahoma",Font.BOLD,15));
        rbtinativo.setFont(new Font("Tahoma",Font.BOLD,15));
        rbtadmin.setBackground(new Color(0, 175, 198));
        rbtuser.setBackground(new Color(0, 175, 198));
        rbtmasc.setBackground(new Color(0, 175, 198));
        rbtfem.setBackground(new Color(0, 175, 198));
        rbtativo.setBackground(new Color(0, 175, 198));
        rbtinativo.setBackground(new Color(0, 175, 198));

        //acoes do botao vontar
        btnvoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Princimpal voltarprimcimpal= new Princimpal();
                voltarprimcimpal.show();
                dispose();
            }
        });

        //acoes do botao cadastrar
        btncadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso");
            }
        });











        painel1.setBackground(new Color(0, 239, 236));
        painel.add(painel1).setBounds(250,25,850,650);



        //fundo
        ImageIcon imagem3 = new ImageIcon(getClass().getResource("fundo.jpg"));
        JLabel lbimg3 = new JLabel(imagem3);
        lbimg3.setBounds(0,0,1260,1000);
        painel.add(lbimg3);
    }
    public static void main(String[] args) {
        new CadastroUser().setVisible(true);

    }
}
