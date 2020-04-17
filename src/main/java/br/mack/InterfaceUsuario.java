package br.mack;

import br.mack.Carro.Carro;
import br.mack.Carro.CarroDAO;

import br.mack.Pais.PaisDAO;
import br.mack.Pais.Pais;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    PaisDAO dao;
    CarroDAO carroDAO;
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
            System.out.println("\t1. Create");
            System.out.println("\t2. Read");
            System.out.println("\t3. Update");
            System.out.println("\t4. Delete");
            System.out.println("\t5. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();

            //necessário para ler a quebra de linha (enter)
            in.nextLine();

            switch (opc) {
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    this.update();
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    System.out.println("tchau :)");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        } while (opc != 5);
    }

    // CRUD - País by TAYNÁ
    private void create() {
        Pais pais = new Pais();

        System.out.println("\n******************");
        System.out.println("*** Novo Pais ***");
        System.out.println("******************");
        System.out.print("\nInforme a identificação do pais: ");
        pais.setIdPais(in.nextLong());
        //necessário para ler o \n da entrada (enter)
        in.nextLine();

        System.out.print("Informe o NOME do pais: ");
        pais.setNome(in.nextLine());

        System.out.print("Informe o CONTINENTE do pais: ");
        pais.setContinente(in.nextLine());

        System.out.print("Informe a POPULAÇÃO do pais: ");
        pais.setPopulacao(in.nextLine());


        if (dao.create(pais)) {
            System.out.println("Pais adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o pais");
        }
    }
    private void read() {
        List<Pais> paises = dao.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Paises Cadastrados ***");
        System.out.println("***********************************");
        for(Pais pais : paises) {
            System.out.println(pais);
        }
    }
    private void update() {
        Pais pais = new Pais();
        List<Pais> paises = dao.read();

        while (true) {
            //Mostra todos os alunos cadastrados
            System.out.println("\n***********************************");
            System.out.println("*** Lista de paises Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Pais pais1 : paises) {
                System.out.println(i + " - " + pais1);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            //escolhe qual aluno quer alterar os dados
            System.out.print("De qual pais deseja alterar os dados?: ");
            int opc = in.nextInt();
            //Necessário para ler a quebra de linha (enter)
            in.nextLine();

            System.out.print("\nInforme o NOME do pais: ");
            pais.setNome(in.nextLine());

            System.out.print("Informe o CONTINENTE do pais: ");
            pais.setContinente(in.nextLine());

            System.out.print("Informe a POPULAÇÃO do pais: ");
            pais.setPopulacao(in.nextLine());

            System.out.print("Informe o IDENTIFICADOR do pais: ");
            pais.setIdPais(in.nextLong());

            if (opc==i) {
                // Cancelar operação
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
                //Isso para o while infinito
                break;
            }
        }
    }
    private void delete() {
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

            System.out.print("Qual pais deseja remover? ");
            int opc = in.nextInt();
            //Necessário para ler a quebra de linha (enter)
            in.nextLine();

            if (opc==i) {
                // Cancelar operação
                break;
            }

            if (opc >= paises.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao.delete(paises.get(opc))) {
                    System.out.println("Pais " + paises.get(opc).getNome() +
                            " removido com sucesso");
                } else {
                    System.out.println("OPS: falar ao tentar remover");
                }
                //Isso para o while infinito
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
            System.out.println("Carro adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o pais");
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
            System.out.println("Dados do carro da placa "+carro.getIdCarro()+" alterados!");
        } else {
            System.out.println("OPS: falar ao tentar alterar dados");
        }
    }
    private void deleteCarro() {
        List<Carro> carros = carroDAO.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Paises Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Carro carro : carros) {
                System.out.println(i + " - " + carro);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual carro deseja remover? ");
            int opc = in.nextInt();
            //Necessário para ler a quebra de linha (enter)
            in.nextLine();

            if (opc==i) {
                // Cancelar operação
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
                //Isso para o while infinito
                break;
            }
        }
    }




}
