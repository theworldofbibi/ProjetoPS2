package br.mack.Carro;

public class Carro {
    private String idCarro;
    private String modelo;
    private String marca;
    private int ano;
    private String categoria;

    public Carro() {}

    public Carro(String idCarro, String modelo, String marca,int ano ,String categoria) {
        this.setIdCarro(idCarro);
        this.setModelo(modelo);
        this.setMarca(marca);
        this.setAno(ano);
        this.setCategoria(categoria);
    }

    public String getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(String idCarro) {
        this.idCarro = idCarro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Placa do Carro: " + getIdCarro() + "[Modelo: " + modelo + ", Marca: " +
                marca + ", Ano: " + ano + ", Categoria: " + categoria + "]";
    }
}

