package br.mack.Pais;

public class Pais {
    private long idPais;
    private String nome;
    private String continente;
    private String populacao;

    public Pais() {}

    public Pais(long idPais, String nome, String continente,String populacao) {
        this.setIdPais(idPais);
        this.setNome(nome);
        this.setContinente(continente);
        this.setPopulacao(populacao);
    }

    public long getIdPais() {
        return idPais;
    }

    public void setIdPais(long idPais) {
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    @Override
    public String toString() {
        return getNome() +
                " [Identificador:" + idPais +
                ", Continente: " + continente + ", População: " + populacao + "]" ;
    }
}
