package View;

import Conection.ConexaoMySQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuartosDisponiveis extends JInternalFrame {


    public List<Quarto> obterDadosQ() throws SQLException {

        String sql = "SELECT * FROM quarto;";
        List<Quarto> quartos= new ArrayList<>();

        try {
            PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();





            while (rs.next()) {
                Quarto quart = new Quarto();
                quart.setA1(rs.getInt("idQuarto"));
                quart.setA2(rs.getInt("nrQuarto"));
                quart.setA3(rs.getString("tipo"));
                quart.setA4(rs.getInt("nrcamas"));
                quart.setA5(rs.getString("descricao"));
                quart.setA6(rs.getString("statusquarto"));
                quart.setA7(rs.getDouble("tarifa"));
                quart.setA8(rs.getString("dataadicao"));
                quart.setA9(rs.getString("usuarioid"));
                quartos.add(quart);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quartos;


    }
    public void readJtable(DefaultTableModel model) throws SQLException {
        // Limpar a tabela antes de adicionar novos dados
        model.setRowCount(0);

        // Obter os dados e preencher na tabela
        for (Quarto q : obterDadosQ()) {
            model.addRow(new Object[]{
                    q.getA1(), q.getA2(), q.getA3(), q.getA4(), q.getA5(), q.getA6(), q.getA7(), q.getA8(), q.getA9()
            });
        }
    }

    public QuartosDisponiveis() throws SQLException {
        setTitle("Tabela de Quartos");
        setClosable(false);
        setMaximizable(true);
        setResizable(false);
        setSize(600, 600);

        // Criar um JPanel para adicionar a tabela
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        // Criar a tabela e o modelo
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel(
                new Object[][] {{null, null, null, null, null, null, null, null, null}},
                new String[]{"ID", "Número", "Tipo", "Camas", "Descrição", "Status", "Tarifa", "Data", "Usuário"}
        );

        // Configurar o modelo na tabela
        table.setModel(model);

        // Preencher a tabela com os dados
        readJtable(model);

        // Adicionar a tabela ao JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

    }



    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            System.out.println();
            // Criar o frame principal
            JFrame frame = new JFrame("Meu Aplicativo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            // Adicionar o JDesktopPane ao JFrame
            JDesktopPane desktopPane = new JDesktopPane();
            frame.add(desktopPane, BorderLayout.CENTER);

            // Adicionar o JInternalFrame ao JDesktopPane
            QuartosDisponiveis quartosDisponiveis = null;
            try {
                quartosDisponiveis = new QuartosDisponiveis();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            desktopPane.add(quartosDisponiveis);
            quartosDisponiveis.setVisible(true);

            frame.setVisible(true);
        });
    }
}
