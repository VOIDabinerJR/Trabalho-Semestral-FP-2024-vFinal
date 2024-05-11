package View;

import Conection.ConexaoMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Checkout extends JDesktopPane {
    public Checkout(){
        this.setSize(750,900);
        JPanel painel = new JPanel(null);
        add(painel).setBounds(0,50,750,900);
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

        //labels
        JLabel lbtext5= new JLabel("Check Out");
        JLabel lbnumero= new JLabel("ID CHECK IN");
        JLabel lbtipo= new JLabel("OBS FUNCIONARIO");
        JLabel lbcams= new JLabel("OBS CLIENTE");
        JLabel lbdescricao= new JLabel("SATISFACAO 1-100");
        JLabel lbusuario = new JLabel("Processado por ");
        JLabel lbsucesso = new JLabel("Sucesso");





        //caixas de texto
        JTextField tfnumeroQ= new JTextField(30);
        JTextField tfnumerocamasQ= new JTextField(30);
        JTextField tfdescricaoQ= new JPasswordField(30);
        JTextField tftipoQ= new JTextField();




        //posicionamento e adicao de labels
        painel2.add(lbtext5).setBounds(170,30,300,30);
        painel2.add(lbnumero).setBounds(30,130,100,30);
        painel2.add(lbcams).setBounds(30,190,100,30);
        painel2.add(lbdescricao).setBounds(30,250,100,30);
        painel2.add(lbtipo).setBounds(30,310,50,30);

        painel2.add(lbsucesso).setBounds(140,60,100,30);
        painel2.add(lbusuario).setBounds(30,450,140,30);


        //posicionamento e adicao de caixas de texto
        painel2.add(tfnumeroQ).setBounds(150,130,250,30);
        painel2.add(tfnumerocamasQ).setBounds(150,190,250,30);
        painel2.add(tfdescricaoQ).setBounds(150,250,250,30);
        painel2.add(tftipoQ).setBounds(150,310,250,30);


        //butpes
        JButton btnentrar = new JButton("Checkout");
        btnentrar.setBorderPainted(false);
        painel2.add(btnentrar).setBounds(280,430,130,30);




        //fontes
        lbtext5.setFont(new Font("Tahoma",Font.BOLD,25));
        //lbtext6.setFont(new Font("Tahoma",Font.BOLD,19));

        //acoes do botao entrar
        btnentrar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lbusuario.setText(checkoutt(tfnumeroQ,tfnumerocamasQ,tftipoQ,tfdescricaoQ ));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        painel2.setBackground(new Color(0, 239, 236));
        painel.add(painel2).setBounds(80,20,500,500);

    }
    public String checkoutt(JTextField t1,JTextField t2,JTextField t3, JTextField t4) throws SQLException {
        String sql = "insert into checkout (descricao, obscliente, satisfacao, usuarioid) values ('"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','1');";
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement(sql);
        System.out.println(sql);
        pst.execute();

        String sql1 = "select * from checkin where idcheckin='"+t1.getText()+"';";
        PreparedStatement pst1 = ConexaoMySQL.obterConexao().prepareStatement(sql1);
        ResultSet rs = pst1.executeQuery();
        System.out.println(sql1);
        StringBuilder idquarto = new StringBuilder();

        if (rs.next()){idquarto.append(rs.getString("idquarto"));
        }

        String sql2 = "update quarto set statusquarto='1' where idquarto='"+idquarto.toString()+"';";
        PreparedStatement pst2 = ConexaoMySQL.obterConexao().prepareStatement(sql2);
        pst2.execute();
        System.out.println(sql2);

        return "Sucesso";

    }


    public static void main(String[] args) {
        Checkout checkout =new Checkout();
        checkout.setVisible(true);
    }
}

