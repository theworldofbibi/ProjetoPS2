package br.mack;

import br.mack.Pais.PaisDAOMySQL;

public class App {
    public static void main(final String[] args) {
        PaisDAOMySQL mysqlDAO = new PaisDAOMySQL();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(mysqlDAO);
        interfaceUsuario.iniciar();
    }
}