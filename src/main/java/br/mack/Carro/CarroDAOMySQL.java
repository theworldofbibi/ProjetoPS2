package br.mack.Carro;

import br.mack.MySQLConnection;
import br.mack.Pais.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAOMySQL implements CarroDAO{
    private String createSQL = "INSERT INTO `Projeto_PS2`.`Carro` (`idCarro`, `modelo`, `marca`, `ano`, `categoria`) VALUES (?, ?, ?, ?, ?);";
    private String readSQL = "SELECT * FROM Carro";
    private String updateSQL = "UPDATE Carro SET modelo=?, marca=?, ano=?, categoria=? WHERE idCarro=?";
    private String deleteSQL = "DELETE FROM Carro WHERE idCarro=?";

    private final MySQLConnection mysql = new MySQLConnection();

    public boolean create(Carro carro) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            stm.setString(1, carro.getIdCarro());
            stm.setString(2, carro.getModelo());
            stm.setString(3, carro.getMarca());
            stm.setInt(4, carro.getAno());
            stm.setString(5, carro.getCategoria());

            int registros = stm.executeUpdate();
            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public List<Carro> read() {
        Connection conexao = mysql.getConnection();
        List<Carro> carros = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Carro carro = new Carro();
                carro.setIdCarro(rs.getString("idCarro"));
                carro.setModelo(rs.getString("modelo"));
                carro.setMarca(rs.getString("marca"));
                carro.setAno(rs.getInt("ano"));
                carro.setCategoria(rs.getString("categoria"));
                carros.add(carro);
            }

            return carros;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return carros;
    }

    public boolean update(Carro carro) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            stm.setString(5, carro.getIdCarro());
            stm.setString(1, carro.getModelo());
            stm.setString(2, carro.getMarca());
            stm.setInt(3, carro.getAno());
            stm.setString(4, carro.getCategoria());

            int registros = stm.executeUpdate();

            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    public boolean delete(Carro carro) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            //Inicializando os valores
            // cuidado com a ordem, eh diferente do insert
            stm.setString(1, carro.getIdCarro());

            int registros = stm.executeUpdate();

            // Se a quantidade de registros modificados
            // forem maiores que 1, significa que os dados
            // foram inserido corretamente
            return registros > 0 ? true : false;

        } catch (final SQLException ex) {
            System.out.println("Falha de conexão com a base de dados!");
            ex.printStackTrace();
        } catch (final Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }
}
