package org.example;

import java.util.List;

public interface PaisDAO {
    boolean create (Pais pais);
    List<Pais> read ();
    boolean update(Pais pais);
    boolean delete(Pais pais);
}
