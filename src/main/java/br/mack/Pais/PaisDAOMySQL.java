package br.mack.Pais;

import br.mack.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDAOMySQL implements PaisDAO {
    private String createSQL = "INSERT INTO Pais VALUES (?, ?, ?,?)";
    private String readSQL = "SELECT * FROM Pais";
    private String updateSQL = "UPDATE Pais SET nome=?, continente=?, populacao=? WHERE idPais=?";
    private String deleteSQL = "DELETE FROM Pais WHERE idPais=?";

    private final MySQLConnection mysql = new MySQLConnection();

    public boolean create(Pais pais) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            //Inicializando os valores
            stm.setString(1, pais.getIdPais());
            stm.setString(2, pais.getNome());
            stm.setString(3, pais.getContinente());
            stm.setString(4, pais.getPopulacao());


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
    public List<Pais> read() {
        Connection conexao = mysql.getConnection();
        List<Pais> paises = new ArrayList();

        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Pais pais = new Pais();
                pais.setIdPais(rs.getString("idPais"));
                pais.setNome(rs.getString("nome"));
                pais.setContinente(rs.getString("continente"));
                pais.setPopulacao(rs.getString("populacao"));
                paises.add(pais);
            }

            return paises;

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
        return paises;
    }
    public boolean update(Pais pais) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            //Inicializando os valores
            // cuidado com a ordem, eh diferente do insert
            stm.setString(1, pais.getNome());
            stm.setString(2, pais.getContinente());
            stm.setString(3, pais.getPopulacao());
            stm.setString(4,pais.getIdPais());

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

    public boolean delete(Pais pais) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            //Inicializando os valores
            // cuidado com a ordem, eh diferente do insert
            stm.setString(1, pais.getIdPais());

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
