package br.mack;

import br.mack.Carro.Carro;
import br.mack.Carro.CarroDAO;

import br.mack.Pais.Pais;
import br.mack.Pais.PaisDAO;

import br.mack.Computador.Computador;
import br.mack.Computador.ComputadorDAO;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    PaisDAO dao;
    CarroDAO carroDAO;
    ComputadorDAO computadorDAO;
    Scanner in;

    public InterfaceUsuario(PaisDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opc = 0;
        do {
            System.out.println("\n==============");
            System.out.println("==== Menu ====");
            System.out.println("==============");
            System.out.println("\t1. Criar");
            System.out.println("\t2. Listar");
            System.out.println("\t3. Alterar Dados");
            System.out.println("\t4. Deletar Dados");
            System.out.println("\t5. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();

            in.nextLine();

            switch (opc) {
                case 1:
                    this.createPais();
                    break;
                case 2:
                    this.readPais();
                    break;
                case 3:
                    this.updatePais();
                    break;
                case 4:
                    this.deletePais();
                    break;
                case 5:
                    System.out.println("Tchau!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

        } while (opc != 5);
    }

    // CRUD - País by TAYNÁ
    private void createPais() {
        Pais pais = new Pais();

        System.out.println("\n***************************");
        System.out.println("*** Adicionar Novo Pais ***");
        System.out.println("***************************");
        System.out.print("\nInforme a SIGLA do pais (Exemplo: BRA): ");
        pais.setIdPais(in.nextLine());

        System.out.print("Informe o NOME do pais: ");
        pais.setNome(in.nextLine());

        System.out.print("Informe o CONTINENTE do pais: ");
        pais.setContinente(in.nextLine());

        System.out.print("Informe a POPULAÇÃO do pais: ");
        pais.setPopulacao(in.nextLine());


        if (dao.create(pais)) {
            System.out.println(pais.getNome()+" adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o pais");
        }
    }
    private void readPais() {
        List<Pais> paises = dao.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Paises Cadastrados ***");
        System.out.println("***********************************");
        for(Pais pais : paises) {
            System.out.println(pais);
        }
    }
    private void updatePais() {
        Pais pais = new Pais();
        List<Pais> paises = dao.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de paises Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Pais pais1 : paises) {
                System.out.println(i + " - " + pais1);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("De qual pais deseja alterar os dados?: ");
            int opc = in.nextInt();
            in.nextLine();

            System.out.print("\nInforme o NOME do pais: ");
            pais.setNome(in.nextLine());

            System.out.print("Informe o CONTINENTE do pais: ");
            pais.setContinente(in.nextLine());

            System.out.print("Informe a POPULAÇÃO do pais: ");
            pais.setPopulacao(in.nextLine());

            System.out.print("Informe a SIGLA do pais: ");
            pais.setIdPais(in.nextLine());

            if (opc==i) {
                break;
            }

            if (opc >= paises.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao.update(pais)) {
                    System.out.println("Dados de "+pais.getNome()+" alterados!");
                } else {
                    System.out.println("OPS: falar ao tentar alterar dados");
                }
                break;
            }
        }
    }
    private void deletePais() {
        List<Pais> paises = dao.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Paises Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Pais pais : paises) {
                System.out.println(i + " - " + pais);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("\nQual pais deseja remover? ");
            int opc = in.nextInt();
            in.nextLine();

            if (opc==i) {
                break;
            }

            if (opc >= paises.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao.delete(paises.get(opc))) {
                    System.out.println(paises.get(opc).getNome() +
                            " removido com sucesso");
                } else {
                    System.out.println("OPS: falar ao tentar remover");
                }
                break;
            }
        }
    }

    // CRUD - Carro by DANILO
    private void createCarro() {
        Carro carro = new Carro();

        System.out.println("\n******************");
        System.out.println("*** Novo Carro ***");
        System.out.println("******************");
        System.out.print("\nInforme a PLACA do carro: ");
        carro.setIdCarro(in.nextLine());
        in.nextLine();

        System.out.print("Informe o MODELO do carro: ");
        carro.setModelo(in.nextLine());

        System.out.print("Informe o ANO do carro: ");
        carro.setAno(in.nextInt());

        System.out.print("Informe a CATEGORIA do carro: ");
        carro.setCategoria(in.nextLine());


        if (carroDAO.create(carro)) {
            System.out.println("Carro adicionado ao Banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o carro");
        }
    }
    private void readCarro() {
        List<Carro> carros = carroDAO.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Carros Cadastrados ***");
        System.out.println("***********************************");
        for(Carro carro : carros) {
            System.out.println(carro);
        }
    }
    private void updateCarro() {
        Carro carro = new Carro();

        List<Carro> carros = carroDAO.read();
        for(Carro carro1 : carros) {
            System.out.println(carro1);
        }

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Carros Cadastrados ***");
        System.out.println("***********************************");

        System.out.println("Informe a PLACA do carro que deseja alterar os dados: ");
        carro.setIdCarro(in.nextLine());

        System.out.print("\nInforme o MODELO do carro: ");
        carro.setModelo(in.nextLine());

        System.out.print("Informe o MARCA do carro: ");
        carro.setMarca(in.nextLine());

        System.out.print("Informe a ANO do carro: ");
        carro.setAno(in.nextInt());

        System.out.print("Informe o CATEGORIA do carro: ");
        carro.setCategoria(in.nextLine());

        if (carroDAO.update(carro)) {
            System.out.println("Dados do carro da placa " + carro.getIdCarro() + " alterados!");
        } else {
            System.out.println("OPS: falha ao tentar alterar dados");
        }
    }
    private void deleteCarro() {
        List<Carro> carros = carroDAO.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Carros Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Carro carro : carros) {
                System.out.println(i + " - " + carro);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual carro deseja remover? ");
            int opc = in.nextInt();
            in.nextLine();

            if (opc==i) {
                break;
            }

            if (opc >= carros.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (carroDAO.delete(carros.get(opc))) {
                    System.out.println("Carro da Placa: " + carros.get(opc).getIdCarro() +
                            " removido com sucesso");
                } else {
                    System.out.println("OPS: falha ao tentar remover");
                }
                break;
            }
        }
    }

    // CRUD - Computador by GABI
    private void createComputador() {
        Computador computador = new Computador();

        System.out.println("\n******************");
        System.out.println("*** Novo Computador ***");
        System.out.println("******************");
        System.out.print("\nInforme o SERIAL do computador: ");
        computador.setIdComputador(in.nextLine());
        in.nextLine();

        System.out.print("Informe a MARCA do computador: ");
        computador.setMarcaComputador(in.nextLine());

        System.out.print("Informe o PROCESSADOR do computador: ");
        computador.setProcessador(in.nextLine());

        System.out.print("Informe a QUANTIDADE DE MEMÓRIA RAM do computador: ");
        computador.setQtdRAM(in.nextLine());

        if (computadorDAO.create(computador)) {
            System.out.println("Computador adicionado ao Banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o computador");
        }
    }
    private void readComputador() {
        List<Computador> computadores = computadorDAO.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Computadores Cadastrados ***");
        System.out.println("***********************************");
        for(Computador computador : computadores) {
            System.out.println(computador);
        }
    }
    private void updateComputador() {
        Computador computador = new Computador();

        List<Computador> computadores = computadorDAO.read();
        for(Computador computador1 : computadores) {
            System.out.println(computador1);
        }

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Computadores Cadastrados ***");
        System.out.println("***********************************");

        System.out.println("Informe o SERIAL do computador que deseja alterar os dados: ");
        computador.setIdComputador(in.nextLine());

        System.out.print("\nInforme a MARCA do computador: ");
        computador.setMarcaComputador(in.nextLine());

        System.out.print("Informe o PROCESSADOR do computador: ");
        computador.setProcessador(in.nextLine());

        System.out.print("Informe a QUANTIDADE DE MEMÓRIA RAM do computador: ");
        computador.setQtdRAM(in.nextLine());

        System.out.print("Informe o TAMANHO DO DISCO do computador: ");
        computador.setTamanhoDisco(in.nextLine());

        if (computadorDAO.update(computador)) {
            System.out.println("Dados do computador de serial " + computador.getIdComputador() + " alterados!");
        } else {
            System.out.println("OPS: falha ao tentar alterar dados");
        }
    }
    private void deleteComputador() {
        List<Computador> computadores = computadorDAO.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Computadores Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Computador computador : computadores) {
                System.out.println(i + " - " + computador);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual computador deseja remover? ");
            int opc = in.nextInt();
            in.nextLine();

            if (opc==i) {
                break;
            }

            if (opc >= computadores.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (computadorDAO.delete(computadores.get(opc))) {
                    System.out.println("Computador de Serial: " + computadores.get(opc).getIdComputador() +
                            " removido com sucesso");
                } else {
                    System.out.println("OPS: falha ao tentar remover");
                }
                break;
            }
        }
    }
}