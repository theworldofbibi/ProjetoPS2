package br.mack.Computador;

public class Computador {
        private String idComputador;
        private String marcaComputador;
        private String processador;
        private String qtdRAM;
        private String tamanhoDisco;

        public Computador() {}

        public Computador(String idComputador, String marcaComputador, String processador, String qtdRAM, String tamanhoDisco) {
            this.setIdComputador (idComputador);
            this.setMarcaComputador (marcaComputador);
            this.setProcessador (processador);
            this.setQtdRAM (qtdRAM);
            this.setTamanhoDisco (tamanhoDisco);
        }

        public String getIdComputador() {
            return idComputador;
        }
        public void setIdComputador(String idComputador) { this.idComputador = idComputador; }

        public String getMarcaComputador() {
            return marcaComputador;
        }
        public void setMarcaComputador(String marcaComputador) {
            this.marcaComputador = marcaComputador;
        }

        public String getProcessador() {
            return processador;
        }
        public void setProcessador(String marca) {
            this.processador = processador;
        }

        public String getQtdRAM() {
            return qtdRAM;
        }
        public void setQtdRAM(String qtdRAM) {
            this.qtdRAM = qtdRAM;
        }

        public String getTamanhoDisco() {
            return tamanhoDisco;
        }
        public void setTamanhoDisco(String tamanhoDisco) {
            this.tamanhoDisco = tamanhoDisco;
        }

        @Override
        public String toString() {
            return "Número serial do computador: " + getIdComputador() + "[Processador: " + processador + ", Marca do computador: " +
                    marcaComputador + ", Quantidade de memória RAM: " + qtdRAM + ", Tamanho do disco: " + tamanhoDisco + "]";
        }
    }