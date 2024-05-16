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

public class Relatorio extends JDesktopPane {
    public Relatorio() {
        componentes();
        inserirrelatorio();


    }
    public void componentes(){

        setSize(850,650);//Configuracoes da Frame

        setLayout(null);

        //Criacao do painel que ira prencher a Frame
        JPanel painel= new JPanel(null);
        add(painel).setBounds(0,0,850,650);
        painel.setBackground(Color.darkGray);


        //paineis
        JPanel reservasfeitas = new JPanel(null){
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

        JPanel receitatotal = new JPanel(null){
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
        JPanel ticketmedio = new JPanel(null){
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
        JPanel checkins = new JPanel(null){
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
        JPanel taxadecheckin = new JPanel(null){
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
        JPanel taxadesatisfacao = new JPanel(null){
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
        JPanel taxadecancelamento = new JPanel(null){
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
        JButton btnentrar2 = new JButton("Atualizar");

        JLabel lbreservasfeitas1 = new JLabel("Reservas Feitas");
        JLabel lbreservasfeitas2 = new JLabel("98");

        JLabel lbreceita1 = new JLabel("Receita Total");
        JLabel lbreceita2 = new JLabel("764 565,09");

        JLabel lbticketmedio1 = new JLabel("Ticket Medio");
        JLabel lbticketmedio2 = new JLabel("4357,98 ");

        JLabel lbcheckins1 = new JLabel("Check Ins");
        JLabel lbcheckins2 = new JLabel("65");

        JLabel lbtaxadecheckins1 = new JLabel("Taxa de Checkin");
        JLabel lbtaxadecheckins2 = new JLabel("87%");

        JLabel lbtaxadeCancelamento1 = new JLabel("Taxa de Canclamento");
        JLabel lbtaxadeCancelamento2 = new JLabel("13%");

        JLabel lbtaxadesatisfacao1 = new JLabel("Taxa de Satisfacao");
        JLabel lbtaxadesatisfacao2 = new JLabel("65%");



        //POSICIONAMENTO  E ADICAO DE LABLES AO PAINEL1



        //POSICIONAMENTO DAS CAIXAS DE TEXTO E ADICAO AO PAINEL1
        painel.add(btnentrar2).setBounds(390,550,100,25);

        reservasfeitas.add(lbreservasfeitas1).setBounds(40,20,180,40);
        lbreservasfeitas1.setFont(new Font("Tahoma",Font.BOLD,18));

        receitatotal.add(lbreceita1).setBounds(40,20,180,40);
        lbreceita1.setFont(new Font("Tahoma",Font.BOLD,18));

        ticketmedio.add(lbticketmedio1).setBounds(40,20,180,40);
        lbticketmedio1.setFont(new Font("Tahoma",Font.BOLD,18));

        taxadecheckin.add(lbtaxadecheckins1).setBounds(40,20,180,40);
        lbtaxadecheckins1.setFont(new Font("Tahoma",Font.BOLD,18));

        checkins.add(lbcheckins1).setBounds(40,20,180,40);
        lbcheckins1.setFont(new Font("Tahoma",Font.BOLD,18));

        taxadecancelamento.add(lbtaxadeCancelamento1).setBounds(40,20,180,40);
        lbtaxadeCancelamento1.setFont(new Font("Tahoma",Font.BOLD,18));

        taxadesatisfacao.add(lbtaxadesatisfacao1).setBounds(40,20,180,40);
        lbtaxadesatisfacao1.setFont(new Font("Tahoma",Font.BOLD,18));



        reservasfeitas.add(lbreservasfeitas2).setBounds(120,70,180,40);
        lbreservasfeitas2.setFont(new Font("Tahoma",Font.BOLD,24));

        receitatotal.add(lbreceita2).setBounds(120,70,180,40);
        lbreceita2.setFont(new Font("Tahoma",Font.BOLD,24));

        ticketmedio.add(lbticketmedio2).setBounds(120,70,180,40);
        lbticketmedio2.setFont(new Font("Tahoma",Font.BOLD,24));

        taxadecheckin.add(lbtaxadecheckins2).setBounds(120,70,180,40);
        lbtaxadecheckins2.setFont(new Font("Tahoma",Font.BOLD,24));

        checkins.add(lbcheckins2).setBounds(120,70,180,40);
        lbcheckins2.setFont(new Font("Tahoma",Font.BOLD,24));

        taxadecancelamento.add(lbtaxadeCancelamento2).setBounds(120,70,180,40);
        lbtaxadeCancelamento2.setFont(new Font("Tahoma",Font.BOLD,24));

        taxadesatisfacao.add(lbtaxadesatisfacao2).setBounds(120,70,180,40);
        lbtaxadesatisfacao2.setFont(new Font("Tahoma",Font.BOLD,24));








        //fontes

        btnentrar2.setBackground(Color.WHITE);

        //acoes para o botao entrar
        btnentrar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletar quarto= new deletar();

                try {

                    lbreservasfeitas2.setText(atualizar1());
                    lbreceita2.setText(atualizar2());

                    lbticketmedio2.setText(atualizar3());

                    lbtaxadecheckins2.setText(atualizar5()+" %");

                    lbcheckins2.setText(atualizar4());

                    lbtaxadeCancelamento2.setText(atualizar6()+" %");

                    lbtaxadesatisfacao2.setText(atualizar7()+" %");



                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

        reservasfeitas.setBackground(new Color(0, 239, 236));
        painel.add(reservasfeitas).setBounds(100,25,250,150);

        receitatotal.setBackground(new Color(0, 239, 236));
        painel.add(receitatotal).setBounds(400,25,250,150);

        ticketmedio.setBackground(new Color(0, 239, 236));
        painel.add(ticketmedio).setBounds(100,190,250,150);

        checkins.setBackground(new Color(0, 239, 236));
        painel.add(checkins).setBounds(400,190,250,150);

        taxadecheckin.setBackground(new Color(0, 239, 236));
        painel.add(taxadecheckin).setBounds(30,360,250,150);

        taxadecancelamento.setBackground(new Color(0, 239, 236));
        painel.add(taxadecancelamento).setBounds(290,360,250,150);

        taxadesatisfacao.setBackground(new Color(0, 239, 236));
        painel.add(taxadesatisfacao).setBounds(560,360,250,150);




        //fundo
        ImageIcon imagem3 = new ImageIcon(getClass().getResource("fundo.jpg"));
        JLabel lbimg3 = new JLabel(imagem3);
        lbimg3.setBounds(0,0,850,830);
        painel.add(lbimg3);


    }
    public String atualizar1() throws SQLException {

        String sql = "select * from relatorio order by idrelatorio desc limit 1;";
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        StringBuilder reserva = new StringBuilder();

        if (rs.next()){reserva.append(rs.getString("reservasfeitas"));
      } else {JOptionPane.showMessageDialog(null,"Erro ao aualizar");}
        return reserva.toString();

    }

    public String atualizar2() throws SQLException {

        String sql = "select * from relatorio order by idrelatorio desc limit 1;";
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        StringBuilder receita = new StringBuilder();
        if (rs.next()){ receita.append(rs.getString("receitatotal"));
            } else {JOptionPane.showMessageDialog(null,"Erro ao aualizar");}



        return receita.toString();
    }
    public String atualizar3() throws SQLException {

        String sql = "select * from relatorio order by idrelatorio desc limit 1;";
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
       StringBuilder tmedio = new StringBuilder();

        if (rs.next()){ tmedio.append(rs.getString("ticketmedio"));
        } else {JOptionPane.showMessageDialog(null,"Erro ao aualizar");}


        return tmedio.toString();

    }
    public String atualizar4() throws SQLException {

        String sql = "select * from relatorio order by idrelatorio desc limit 1;";
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        StringBuilder checkins = new StringBuilder();

        if (rs.next()){ checkins.append(rs.getString("checkins"));
        } else {JOptionPane.showMessageDialog(null,"Erro ao aualizar");}



        return checkins.toString();

    }
    public String atualizar5() throws SQLException {

        String sql = "select * from relatorio order by idrelatorio desc limit 1;";
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        StringBuilder tcheckin = new StringBuilder();

        if (rs.next()){tcheckin.append(rs.getString("taxadechekin"));
        } else {JOptionPane.showMessageDialog(null,"Erro ao aualizar");}



        return tcheckin.toString();

    }
    public String atualizar6() throws SQLException {

        String sql = "select * from relatorio order by idrelatorio desc limit 1;";
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
         StringBuilder tcancelamento = new StringBuilder();


        if (rs.next()){
            tcancelamento.append(rs.getString("taxadecancelamento"));

        } else {JOptionPane.showMessageDialog(null,"Erro ao aualizar");}


       return tcancelamento.toString();

    }
    public String atualizar7() throws SQLException {

        String sql = "select * from relatorio order by idrelatorio desc limit 1;";
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        StringBuilder tsatisfacao = new StringBuilder();


        if (rs.next()){
            tsatisfacao.append(rs.getString("taxadesatisfacao"));

        } else {JOptionPane.showMessageDialog(null,"Erro ao aualizar");}




return tsatisfacao.toString();

    }

    public void inserirrelatorio(){

        String sql1 = "SELECT count( * )  as total FROM reserva;";
        String sql2 = "SELECT sum( preco)  as total FROM checkin;";
        String sql4 = "SELECT count( * )  as total FROM checkin;";
        String sql7 = "SELECT sum( satisfacao)  as total FROM checkout;";

//        String sql2 = "select * from usuario where username='" +t2.getText()+ "'and senha='" +t1.getText()+ "';";
        StringBuilder s1= new StringBuilder();
        StringBuilder s2= new StringBuilder();

        StringBuilder s4= new StringBuilder();


        StringBuilder s7= new StringBuilder();


        try {
            PreparedStatement pst1 = ConexaoMySQL.obterConexao().prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery();
            if(rs1.next()){
                s1.append(rs1.getString("total")); }
            System.out.println(s1);

        }catch (Exception e){
            System.out.println(e);
        }
        try {
            PreparedStatement pst2 = ConexaoMySQL.obterConexao().prepareStatement(sql2);
            ResultSet rs2 = pst2.executeQuery();
            if(rs2.next()){
                s2.append(rs2.getString("total")); }
            System.out.println(s2);

        }catch (Exception e){
            System.out.println(e);
        }
        double ss1= Double.parseDouble(s1.toString());
        double ss2= Double.parseDouble(s2.toString());
        double s3 = (double) (ss2/ss1);
        System.out.println(s3);

        try {
            PreparedStatement pst4 = ConexaoMySQL.obterConexao().prepareStatement(sql4);
            ResultSet rs4 = pst4.executeQuery();
            if(rs4.next()){
                s4.append(rs4.getString("total")); }
            System.out.println(s4);

        }catch (Exception e){
            System.out.println(e);
        }
        double ss4= Double.parseDouble(s4.toString());
        float s5 = (float) (ss1/ss4);
        System.out.println(s5);

        float s6 = (float) ((1-s5));
        System.out.println(s5);

        try {
        PreparedStatement pst7 = ConexaoMySQL.obterConexao().prepareStatement(sql7);
        ResultSet rs7 = pst7.executeQuery();
        if(rs7.next()){
            s7.append(rs7.getString("total")); }
        System.out.println(s7);

    }catch (Exception e){
        System.out.println(e);
    }
        double sss7= Double.parseDouble(s7.toString());
        double ss7 =  ((sss7/ss4));
        System.out.println(ss7);








        String sql ="insert into relatorio (reservasfeitas, receitatotal, ticketmedio, checkins, taxadechekin, taxadecancelamento, taxadesatisfacao) values ('"+ s1.toString()+"','"+ s2.toString()+"','"+ s3+"','"+ s4.toString()+"','"+ s5+"','"+ s6+"','"+ ss7+"');";
        try {
            PreparedStatement pst8 = ConexaoMySQL.obterConexao().prepareStatement(sql);
            pst8.execute();
            System.out.println(sql);

        }catch (Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        Relatorio relatorio = new Relatorio();
        relatorio.setVisible(true);
    }
}
