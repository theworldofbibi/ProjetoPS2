package br.mack.Carro;

import java.util.List;

public interface CarroDAO {
    boolean create(Carro carro);
    List<Carro> read();
    boolean update(Carro carro);
    boolean delete(Carro carro);
}