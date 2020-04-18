package br.mack.Computador;
import br.mack.Computador.Computador;
import br.mack.Computador.ComputadorDAO;
import br.mack.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputadorDAOMySQL implements ComputadorDAO {
        private String createSQL = "INSERT INTO Computador VALUES (?, ?, ?, ?, ?)";
        private String readSQL = "SELECT * FROM Computador";
        private String updateSQL = "UPDATE Computador SET marca = ?, processador = ?, qtdRam = ?, tamanhoDisco = ? WHERE idComputador = ?";
        private String deleteSQL = "DELETE FROM Computador WHERE idComputador = ?";

        private final MySQLConnection mysql = new MySQLConnection();

        public boolean create(Computador computador) {
            Connection conexao = mysql.getConnection();
            try {
                PreparedStatement stm = conexao.prepareStatement(createSQL);

                stm.setString(1, computador.getIdComputador());
                stm.setString(2, computador.getMarcaComputador());
                stm.setString(3, computador.getProcessador());
                stm.setString(4, computador.getQtdRAM());
                stm.setString(5, computador.getTamanhoDisco());

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

        public List<Computador> read() {
            Connection conexao = mysql.getConnection();
            List<Computador> computadores = new ArrayList();

            try {
                PreparedStatement stm = conexao.prepareStatement(readSQL);
                ResultSet rs = stm.executeQuery();

                while (rs.next()) {
                    Computador computador = new Computador();
                    computador.setIdComputador(rs.getString("idComputador"));
                    computador.setMarcaComputador(rs.getString("marca"));
                    computador.setProcessador(rs.getString("processador"));
                    computador.setQtdRAM(rs.getString("qtdRam"));
                    computador.setTamanhoDisco(rs.getString("tamanhoDisco"));
                    computadores.add(computador);
                }

                return computadores;

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
            return computadores;
        }

        public boolean update(Computador computador) {
            Connection conexao = mysql.getConnection();
            try {
                PreparedStatement stm = conexao.prepareStatement(updateSQL);

                stm.setString(5, computador.getIdComputador());
                stm.setString(1, computador.getMarcaComputador());
                stm.setString(2, computador.getProcessador());
                stm.setString(3, computador.getQtdRAM());
                stm.setString(4, computador.getTamanhoDisco());

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

        public boolean delete(Computador computador) {
            Connection conexao = mysql.getConnection();
            try {
                PreparedStatement stm = conexao.prepareStatement(deleteSQL);

                stm.setString(1, computador.getIdComputador());

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
    }