package View;

import Conection.ConexaoMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Quarto extends  JDesktopPane{
   public Quarto(){
       this.setSize(750,900);
       JPanel painel = new JPanel(null);
      // painel.setBackground(new Color(0, 239, 236));
       add(painel).setBounds(0,0,750,900);
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
       JLabel lbtext5= new JLabel("Adicionar Quarto");
       JLabel lbnumero= new JLabel("NUMERO");
       JLabel lbtipo= new JLabel("TIPO");
       JLabel lbcams= new JLabel("NR CAMAS");
       JLabel lbdescricao= new JLabel("DESCRICAO");
       JLabel lbstatus = new JLabel("STATUS");
       JLabel lbtaridfa= new JLabel("TARIFA");
       JLabel lbusuario = new JLabel("Processado por ");
       JLabel lbsucesso = new JLabel("Sucesso");





       //caixas de texto
       JTextField tfnumeroQ= new JTextField(30);
       JTextField tfnumerocamasQ= new JTextField(30);
       JTextField tfdescricaoQ= new JPasswordField(30);
       JTextField tftarifaQ= new JTextField();
       JTextField tftipoQ= new JTextField();
       ButtonGroup btnstatusQ = new ButtonGroup();
       JRadioButton btnstatus1 = new JRadioButton("Ativo");
       JRadioButton btnstatus2 = new JRadioButton("Inativo");
       btnstatusQ.add(btnstatus1);
       btnstatusQ.add(btnstatus2);
       btnstatus1.setBackground(new Color(0, 175, 198));
       btnstatus2.setBackground(new Color(0, 175, 198));





       //posicionamento e adicao de labels
       painel2.add(lbtext5).setBounds(170,30,300,30);
       painel2.add(lbnumero).setBounds(30,130,100,30);
       painel2.add(lbcams).setBounds(30,190,100,30);
       painel2.add(lbdescricao).setBounds(30,250,100,30);
       painel2.add(lbtipo).setBounds(30,310,50,30);
       painel2.add(lbtaridfa).setBounds(30,370,50,30);
       painel2.add(lbstatus).setBounds(30,400,50,30);
       painel2.add(lbsucesso).setBounds(140,60,100,30);
       painel2.add(lbusuario).setBounds(30,450,140,30);


       //posicionamento e adicao de caixas de texto
       painel2.add(tfnumeroQ).setBounds(150,130,250,30);
       painel2.add(tfnumerocamasQ).setBounds(150,190,250,30);
       painel2.add(tfdescricaoQ).setBounds(150,250,250,30);
       painel2.add(tftipoQ).setBounds(150,310,250,30);
       painel2.add(tftarifaQ).setBounds(150,370,250,30);
       painel2.add(btnstatus1).setBounds(150,400,100,25);
       painel2.add(btnstatus2).setBounds(260,400,80,25);


       //butpes
       JButton btnentrar = new JButton("Cadastrar");
       btnentrar.setBorderPainted(false);
       painel2.add(btnentrar).setBounds(280,430,130,30);




       //fontes
       lbtext5.setFont(new Font("Tahoma",Font.BOLD,25));
       //lbtext6.setFont(new Font("Tahoma",Font.BOLD,19));

       //acoes do botao entrar
       btnentrar.addActionListener(new AbstractAction() {
           @Override
           public void actionPerformed(ActionEvent e) {
               lbusuario.setText(cadastrarquarto(tfnumeroQ,tfnumerocamasQ,tfdescricaoQ,tftipoQ,tftarifaQ,"1","1"));
           }
       });


       painel2.setBackground(new Color(0, 239, 236));
       painel.add(painel2).setBounds(180,50,500,500);
       //fundo
       ImageIcon imagem3 = new ImageIcon(getClass().getResource("fundo.jpg"));
       JLabel lbimg3 = new JLabel(imagem3);
       lbimg3.setBounds(0,0,1100,950);
       painel.add(lbimg3);
   }
   public String cadastrarquarto(JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5,String t6,String t7){
       String retorno="";
       String sql = "insert into  quarto (nrquarto,nrcamas, descricao,tipo,tarifa,statusquarto,usuarioid) values('" +t1.getText()+ "','" +t2.getText()+ "', '" +t3.getText()+ "','" +t4.getText()+ "','" +t5.getText()+ "','" +t6+ "','" +t7+ "');";
       String idsql= "select * from quarto where nrquarto='"+t1.getText()+"';";
       try {
           PreparedStatement psth = ConexaoMySQL.obterConexao().prepareStatement(sql);
           PreparedStatement psth2 = ConexaoMySQL.obterConexao().prepareStatement(idsql);

           psth.execute();
           psth2.executeQuery();

           if(true){
               System.out.println(sql);
               JOptionPane.showMessageDialog(null,"sucesso");
               ResultSet rs = psth2.executeQuery();
               StringBuilder retornoSB = new StringBuilder();
               retornoSB.append("ID QUARTO: ").append(rs.getString("idquarto")).append("\n");
               retorno = retornoSB.toString();

           } else {
               System.out.println(t1.getText());
           }


       }catch (Exception e){

       }



      return retorno;
   }

    public static void main(String[] args) {
        Quarto AA = new Quarto();
        AA.setVisible(true);
    }
}
