package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class Reserva extends JFrame {
    public Reserva(){
        setSize(1300,650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        //criacao do painel que ira prencher a frame
        JPanel painel = new JPanel(null);

        //label
        JLabel lbtext4= new JLabel("RESERVAR");

        //possicionamento e adicao das labels no painel1
        painel.add(lbtext4).setBounds(560,20,300,25);

        //fonte da label
        lbtext4.setFont(new Font("Tahoma",Font.BOLD,25));

        add(painel).setBounds(0,0,1300,650);

        //criacao do primeiro painel
        JPanel painel1= new JPanel(null){
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

        //labels
        JLabel lbtext1= new JLabel("HOSPEDE");
        JLabel lbnome= new JLabel("NOME:");
        JLabel lbnr= new JLabel("NR DE BI:");
        JLabel lbcontacto= new JLabel("CONTACTO:");
        JLabel lbuser= new JLabel("USUARIO:");


        //CAIXAS DE TEXTO
        JTextField tfnome= new JTextField();
        JTextField tfnr=new JTextField();
        JTextField tfcontacto=new JTextField();

        //possicionamento e adicao das labels no painel1
        painel1.add(lbtext1).setBounds(120,20,100,25);
        painel1.add(lbnome).setBounds(30,80,100,25);
        painel1.add(lbnr).setBounds(30,120,100,25);
        painel1.add(lbcontacto).setBounds(20,160,100,25);
        painel1.add(lbuser).setBounds(20,250,100,25);

        //Possicionamento e adicao de caixas de texto
        painel1.add(tfnome).setBounds(100,80,230,25);
        painel1.add(tfnr).setBounds(100,120,230,25);
        painel1.add(tfcontacto).setBounds(100,160,230,25);


        //fontes
        lbtext1.setFont(new Font("Tahoma",Font.BOLD,20));
        lbnome.setFont(new Font("Tahoma",Font.BOLD,12));
        lbcontacto.setFont(new Font("Tahoma",Font.BOLD,12));
        lbnr.setFont(new Font("Tahoma",Font.BOLD,12));


        painel1.setBackground(new Color(0, 239, 236));
        painel.add(painel1).setBounds(30,70,350,300);


        //criacao do Segundo painel
        JPanel painel2= new JPanel(null){
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

        //labels
        JLabel lbtext2= new JLabel("RESERVA");
        JLabel lbid= new JLabel("Id do hospede:");
        JLabel lbchkin= new JLabel("Data  chekin:");
        JLabel lbchkout= new JLabel("Data  checkout:");
        JLabel lbnrQ= new JLabel("Numero quarto:");
        JLabel lbstatus= new JLabel("Stutus Reserva:");
        JLabel lbdata= new JLabel("Data");
        JLabel lbuser1= new JLabel("User");


        //CAIXAS DE TEXTO
        JTextField tfid= new JTextField();
        JTextField tfckin=new JTextField();
        JTextField tfchout=new JTextField();
        JTextField tfnrQ=new JTextField();

        //radiButons
        JRadioButton rbativ= new JRadioButton("Ativo");
        JRadioButton rbinativ= new JRadioButton("Inativo");

        //possicionamento e adicao dos radiuButons
        painel2.add(rbativ).setBounds(150,240,60,25);
        painel2.add(rbinativ).setBounds(240,240,120,25);


        //possicionamento e adicao das labels no painel1
        painel2.add(lbtext2).setBounds(160,20,100,25);
        painel2.add(lbid).setBounds(20,80,200,25);
        painel2.add(lbchkin).setBounds(30,120,200,25);
        painel2.add(lbchkout).setBounds(20,160,200,25);
        painel2.add(lbnrQ).setBounds(20,200,200,25);
        painel2.add(lbstatus).setBounds(20,240,200,25);
        painel2.add(lbdata).setBounds(20,280,60,25);
        painel2.add(lbuser1).setBounds(20,330,60,25);


        //Possicionamento e adicao de caixas de texto
        painel2.add(tfid).setBounds(140,80,230,25);
        painel2.add(tfckin).setBounds(140,120,230,25);
        painel2.add(tfchout).setBounds(140,160,230,25);
        painel2.add(tfnrQ).setBounds(140,200,230,25);



        //fontes das labels
        lbtext2.setFont(new Font("Tahoma",Font.BOLD,20));
        lbid.setFont(new Font("Tahoma",Font.BOLD,13));
        lbchkin.setFont(new Font("Tahoma",Font.BOLD,13));
        lbchkout.setFont(new Font("Tahoma",Font.BOLD,13));
        lbnrQ.setFont(new Font("Tahoma",Font.BOLD,13));
        lbstatus.setFont(new Font("Tahoma",Font.BOLD,13));
        lbdata.setFont(new Font("Tahoma",Font.BOLD,13));
        lbuser1.setFont(new Font("Tahoma",Font.BOLD,13));

        //fontes dos radiuButons
        rbativ.setBackground(new Color(0, 175, 198));
        rbinativ.setBackground(new Color(0, 175, 198));




        painel2.setBackground(new Color(0, 239, 236));
        painel.add(painel2).setBounds(410,70,410,400);

        //criacao do terceiro painel
        JPanel painel3= new JPanel(null){
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

        //labels
        JLabel lbtext3= new JLabel("CHEKIN");
        JLabel lbidreserv= new JLabel("Id da reserva:");
        JLabel lbprec= new JLabel("Preco:");
        JLabel lbvalorp= new JLabel("Valor pago:");
        JLabel lbtroc= new JLabel("Trocos:");
        JLabel lbdata2= new JLabel("Data");
        JLabel lbuser2= new JLabel("User");


        //CAIXAS DE TEXTO
        JTextField tfidreserv= new JTextField();
        JTextField tfprec=new JTextField();
        JTextField tfvalorp=new JTextField();
        JTextField tftroc=new JTextField();




        //possicionamento e adicao das labels no painel1
        painel3.add(lbtext3).setBounds(160,20,100,25);
        painel3.add(lbidreserv).setBounds(20,80,200,25);
        painel3.add(lbprec).setBounds(30,120,200,25);
        painel3.add(lbvalorp).setBounds(20,160,200,25);
        painel3.add(lbtroc).setBounds(20,200,200,25);
        painel3.add(lbdata2).setBounds(20,280,60,25);
        painel3.add(lbuser2).setBounds(20,330,60,25);


        //Possicionamento e adicao de caixas de texto
        painel3.add(tfidreserv).setBounds(120,80,200,25);
        painel3.add(tfprec).setBounds(120,120,200,25);
        painel3.add(tfvalorp).setBounds(120,160,200,25);
        painel3.add(tftroc).setBounds(120,200,200,25);



        //fontes das labels
        lbtext3.setFont(new Font("Tahoma",Font.BOLD,20));
        lbidreserv.setFont(new Font("Tahoma",Font.BOLD,13));
        lbprec.setFont(new Font("Tahoma",Font.BOLD,13));
        lbvalorp.setFont(new Font("Tahoma",Font.BOLD,13));
        lbtroc.setFont(new Font("Tahoma",Font.BOLD,13));
        lbdata2.setFont(new Font("Tahoma",Font.BOLD,13));
        lbuser2.setFont(new Font("Tahoma",Font.BOLD,13));



        painel3.setBackground(new Color(0, 239, 236));
        painel.add(painel3).setBounds(860,70,350,400);



        //fundo
        ImageIcon imagem3 = new ImageIcon(getClass().getResource("fundo.jpg"));
        JLabel lbimg3 = new JLabel(imagem3);
        lbimg3.setBounds(0,0,1300,650);
        painel.add(lbimg3);




    }

    public static void main(String[] args) {
        new Reserva().setVisible(true);

    }
}
