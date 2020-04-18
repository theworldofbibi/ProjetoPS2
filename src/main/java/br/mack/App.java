package br.mack;

import br.mack.Pais.PaisDAOMySQL;
import br.mack.Carro.CarroDAOMySQL;
import br.mack.Computador.ComputadorDAOMySQL;

public class App {
    public static void main(final String[] args) {
        PaisDAOMySQL paisDAOMySQL = new PaisDAOMySQL();
        CarroDAOMySQL carroDAOMySQL = new CarroDAOMySQL();
        ComputadorDAOMySQL computadorDAOMySQL = new ComputadorDAOMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(paisDAOMySQL,carroDAOMySQL,computadorDAOMySQL);
        interfaceUsuario.iniciar();
    }
}