
import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {

        Scanner Conta = new Scanner(System.in);

        System.out.println("--SIMULAÇÃO CONTA BANCÁRIA--\n");

        System.out.println("Digite seu nome completo: ");
        String nome = Conta.nextLine();

//exige nome com pelo menos 10 caracteres
        while (nome.length() < 10) {
            System.out.println("Nome completo!");
            nome = Conta.nextLine();
        }

        System.out.println("\nDigite seu CPF: ");
        String cpf = Conta.nextLine();
//exige cpf com 11 digitos
        while (cpf.length() < 11) {
            System.out.println("Um CPF possui 11 digitos...");
            cpf = Conta.nextLine();
        }

//variavel sem valor que retorna o que o usuario digitar
        double saldoInicial = 0;
//loop ate sair um resultado valido
        while (saldoInicial <= 0) {
            System.out.println("Qual seu saldo inicial: ");
            saldoInicial = Conta.nextDouble();


            if (saldoInicial <= 0) {
                System.out.println("Valor inválido, digite novamente");
            }
            if (saldoInicial >= 10000000) {
                System.out.println("O limite é 10 Milhões...");
                saldoInicial = Conta.nextDouble();
            }
        }
        double valorTaxa = 0;

        double totalInvestido = 0;

        String tipoConta1 = "";

        int tipoConta = 0;

        while (tipoConta < 1 || tipoConta > 3) {
            System.out.println("Qual seu tipo de conta:");
            System.out.println("1- Conta Corrente");
            System.out.println("2- Conta Poupança");
            System.out.println("3- Conta Investimentos");

            tipoConta = Conta.nextInt();

            if (tipoConta < 1 || tipoConta > 3) {
                System.out.println("Opção inválida, tente novamente.");
            }
            if (tipoConta == 1) {
                System.out.println("Conta Corrente");
                tipoConta1 = "Conta Corrente";
            } else if (tipoConta == 2) {
                System.out.println("Conta Poupança");
                tipoConta1 = "Conta Poupança";

            } else if (tipoConta == 3) {
                boolean sairInvestimentos = false;
                while (!sairInvestimentos) {

                    tipoConta1 = "Conta investimento";

                    System.out.println("Que tipo de investimento você deseja fazer:\n ");

                    System.out.println("1- Renda Fixa ");
                    System.out.println("2- Renda Variável ");
                    System.out.println("3- Fundos de Investimentos ");
                    System.out.println("4- Quero aprender a investir");
                    System.out.println("5- Sair ");

                    int tpinvestimento1 = Conta.nextInt();


                    if (tpinvestimento1 == 1) {

                        System.out.println("Renda Fixa");

                        System.out.println("Que tipo de Renda Fixa deseja investir: \n");

                        System.out.println("1- Tesouro Direto ");
                        System.out.println("2- LCI e LCA ");
                        System.out.println("3- CDB ");
                        System.out.println("4- Fundos de Renda Fixa ");

                        int opcaoRendaFixa = Conta.nextInt();

                        double taxa = 0;

                        String opcaoRendaFixa2 = "";

                        if (opcaoRendaFixa == 1) {

                            System.out.println("Tesouro Direto");
                            opcaoRendaFixa2 = "Tesouro Direto";
                            taxa = 0.006;

                            System.out.println("Como deseja transferir?\n");
                            System.out.println("1- Pix \n2- Boleto \n3- Cartão");
                            int tesouroDireto = Conta.nextInt();

                            String tesouroDireto2 = "";

                            if (tesouroDireto == 1) {
                                System.out.println("Pix");
                                tesouroDireto2 = "Pix";
                                System.out.println("Qual Valor deseja investir no tesouro direto\n");
                                int transferenciaPix = Conta.nextInt();
                                double calculo = transferenciaPix;

                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.010; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaPix;

                                if (saldoInicial < transferenciaPix) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaPix;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (tesouroDireto == 2) {
                                System.out.println("Boleto");
                                tesouroDireto2 = "Boleto";
                                System.out.println("Qual Valor deseja investir no tesouro direto\n");
                                int transferenciaBoleto = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.010; // VIP
                                }

                                double calculo = transferenciaBoleto;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();


                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaBoleto;

                                if (saldoInicial < transferenciaBoleto) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaBoleto;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (tesouroDireto == 3) {
                                System.out.println("Cartão");
                                tesouroDireto2 = "Cartão";
                                System.out.println("Qual Valor deseja investir no tesouro direto\n");

                                int transferenciaCartao = Conta.nextInt();
                                double calculo = transferenciaCartao;
                                System.out.println("Por quantos meses deseja investir");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.010; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaCartao;

                                if (saldoInicial < transferenciaCartao) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaCartao;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);

                                }
                            }
                        }

                        if (opcaoRendaFixa == 2) {

                            System.out.println("LCI e LCA");
                            opcaoRendaFixa2 = "LCI e LCA";
                            taxa = 0.0065;

                            System.out.println("Como deseja transferir?\n");
                            System.out.println("1- Pix \n2- Boleto \n3- Cartão");
                            int lCILCA = Conta.nextInt();

                            String lCILCA2 = "";

                            if (lCILCA == 1) {
                                System.out.println("Pix");
                                lCILCA2 = "Pix";
                                System.out.println("Qual Valor deseja investir no LCI e LCA\n");
                                int transferenciaPix = Conta.nextInt();

                                double calculo = transferenciaPix;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.010; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaPix;

                                if (saldoInicial < transferenciaPix) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaPix;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (lCILCA == 2) {
                                System.out.println("Boleto");
                                lCILCA2 = "Boleto";
                                System.out.println("Qual Valor deseja investir no LCI e LCA\n");
                                int transferenciaBoleto = Conta.nextInt();

                                double calculo = transferenciaBoleto;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.010; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaBoleto;

                                if (saldoInicial < transferenciaBoleto) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaBoleto;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (lCILCA == 3) {
                                System.out.println("Cartão");
                                lCILCA2 = "Cartão";
                                System.out.println("Qual Valor deseja investir no LCI e LCA\n");
                                int transferenciaCartao = Conta.nextInt();

                                double calculo = transferenciaCartao;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.010; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaCartao;

                                if (saldoInicial < transferenciaCartao) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaCartao;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            }
                        }

                        if (opcaoRendaFixa == 3) {
                            System.out.println("CDB");
                            opcaoRendaFixa2 = "CDB";
                            taxa = 0.007;


                            System.out.println("Como deseja transferir?\n");
                            System.out.println("1- Pix \n2- Boleto \n3- Cartão");
                            int CDB = Conta.nextInt();

                            String CDB2 = "";

                            if (CDB == 1) {
                                System.out.println("Pix");
                                CDB2 = "Pix";
                                System.out.println("Qual Valor deseja investir no CDB\n");
                                int transferenciaPix = Conta.nextInt();

                                double calculo = transferenciaPix;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.010; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaPix;

                                if (saldoInicial < transferenciaPix) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaPix;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (CDB == 2) {
                                System.out.println("Boleto");
                                CDB2 = "Boleto";
                                System.out.println("Qual Valor deseja investir no CDB\n");
                                int transferenciaBoleto = Conta.nextInt();

                                double calculo = transferenciaBoleto;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.010; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaBoleto;

                                if (saldoInicial < transferenciaBoleto) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaBoleto;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (CDB == 3) {
                                System.out.println("Cartão");
                                CDB2 = "Cartão";
                                System.out.println("Qual Valor deseja investir no CDB\n");
                                int transferenciaCartao = Conta.nextInt();

                                double calculo = transferenciaCartao;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.010; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaCartao;

                                if (saldoInicial < transferenciaCartao) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaCartao;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            }
                        }
                        if (opcaoRendaFixa == 4) {
                            System.out.println("Fundos de Renda Fixa");
                            opcaoRendaFixa2 = "Fundos de Renda Fixa";
                            taxa = 0.005;


                            System.out.println("Como deseja transferir?\n");
                            System.out.println("1- Pix \n2- Boleto \n3- Cartão");
                            int fundosRendaFix = Conta.nextInt();

                            String fundosRendaFix2 = "";

                            if (fundosRendaFix == 1) {
                                System.out.println("Pix");
                                fundosRendaFix2 = "Pix";
                                System.out.println("Qual Valor deseja investir no Fundos de Renda Fixa\n");
                                int transferenciaPix = Conta.nextInt();

                                double calculo = transferenciaPix;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.010; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaPix;

                                if (saldoInicial < transferenciaPix) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaPix;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (fundosRendaFix == 2) {
                                System.out.println("Boleto");
                                fundosRendaFix2 = "Boleto";
                                System.out.println("Qual Valor deseja investir no Fundos de Renda Fixa\n");

                                int transferenciaBoleto = Conta.nextInt();
                                double calculo = transferenciaBoleto;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.010; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaBoleto;

                                if (saldoInicial < transferenciaBoleto) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaBoleto;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (fundosRendaFix == 3) {
                                System.out.println("Cartão");
                                fundosRendaFix2 = "Cartão";
                                System.out.println("Qual Valor deseja investir no Fundos de Renda Fixa\n");
                                int transferenciaCartao = Conta.nextInt();
                                double calculo = transferenciaCartao;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.010; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaCartao;

                                if (saldoInicial < transferenciaCartao) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaCartao;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            }
                        }
                    }

                    if (tpinvestimento1 == 2) {
                        System.out.println("Renda Variavel");

                        System.out.println("Que tipo de Renda variavel deseja fazer: \n");

                        System.out.println("1- Ações ");
                        System.out.println("2- Fundos Imobiliários ");
                        System.out.println("3- ETFs ");
                        System.out.println("4- Commodities e Câmbio ");

                        int opcaoRendaVariavel = Conta.nextInt();

                        double taxa = 0;

                        String opcaoRendaVariavel1 = "";

                        if (opcaoRendaVariavel == 1) {
                            System.out.println("Ações");
                            opcaoRendaVariavel1 = "Ações";
                            taxa = 0.01;

                            System.out.println("Como deeja trasferir?\n");
                            System.out.println("1- Pix \n2- Boleto \n3- Cartão");
                            int acao = Conta.nextInt();

                            String rendaVariavel1 = "";

                            if (acao == 1) {
                                System.out.println("Pix");
                                rendaVariavel1 = "Pix";
                                System.out.println("Qual valor deseja transferir em Ações\n");
                                int transferenciaPix = Conta.nextInt();
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.02; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.04; // medio
                                } else {
                                    taxa = 0.06; // VIP
                                }

                                double calculo = transferenciaPix;
                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaPix;

                                if (saldoInicial < transferenciaPix) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaPix;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);

                                }
                            } else if (acao == 2) {
                                System.out.println("Boleto");
                                rendaVariavel1 = "Boleto";

                                System.out.println("Qual valor deseja transferir em Ações\n");
                                int transferenciaBoleto = Conta.nextInt();

                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.02; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.04; // medio
                                } else {
                                    taxa = 0.06; // VIP
                                }

                                double calculo = transferenciaBoleto;
                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaBoleto;

                                if (saldoInicial < transferenciaBoleto) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaBoleto;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (acao == 3) {
                                System.out.println("Cartão");
                                rendaVariavel1 = "Cartão";
                                System.out.println("Qual valor deseja transferir em Ações\n");
                                int transferenciaCartao = Conta.nextInt();

                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.02; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.04; // medio
                                } else {
                                    taxa = 0.06; // VIP
                                }

                                double calculo = transferenciaCartao;
                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaCartao;

                                if (saldoInicial < transferenciaCartao) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaCartao;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);

                                }
                            }
                        }
                        if (opcaoRendaVariavel == 2) {
                            System.out.println("Fundos Imobiliários");
                            opcaoRendaVariavel1 = "Fundos Imobiliários";

                            System.out.println("Como deseja tranferir \n");
                            System.out.println("1- Pix \n2- Boleto \n3- Cartão");
                            int fundoImobiliario = Conta.nextInt();
                            taxa = 0.008;

                            String rendaVariavel1 = "";

                            if (fundoImobiliario == 1) {
                                System.out.println("Pix");
                                rendaVariavel1 = "Pix";

                                System.out.println("Qual valor deseja tranferir em Fundos Imobiliários\n");
                                int transferenciaPix = Conta.nextInt();

                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.009; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.01; // medio
                                } else {
                                    taxa = 0.02; // VIP
                                }

                                double calculo = transferenciaPix;
                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaPix;

                                if (saldoInicial < transferenciaPix) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaPix;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (fundoImobiliario == 2) {
                                System.out.println("Boleto");
                                rendaVariavel1 = "Boleto";

                                System.out.println("Qual valor deseja tranferir em Fundos Imobiliários\n");
                                int transferenciaBoleto = Conta.nextInt();

                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.009; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.01; // medio
                                } else {
                                    taxa = 0.02; // VIP
                                }

                                double calculo = transferenciaBoleto;
                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaBoleto;

                                if (saldoInicial < transferenciaBoleto) {
                                    System.out.println("Você não tem saldo suuficiente...");
                                } else {
                                    saldoInicial -= transferenciaBoleto;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (fundoImobiliario == 3) {
                                System.out.println("Cartão");
                                rendaVariavel1 = "Cartão";

                                System.out.println("Qual valor deseja trasferir em Fundos Imobiliários\n");
                                int transferenciaCartao = Conta.nextInt();
                                double calculo = transferenciaCartao;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.009; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.01; // medio
                                } else {
                                    taxa = 0.02; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaCartao;

                                if (saldoInicial < transferenciaCartao) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaCartao;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            }

                        }
                        if (opcaoRendaVariavel == 3) {
                            System.out.println("ETFs");
                            opcaoRendaVariavel1 = "ETFs";

                            System.out.println("Como deseja tranferir \n");
                            System.out.println("1- Pix \n2- Boleto \n3- Cartão");
                            int etfS = Conta.nextInt();
                            taxa = 0.007;

                            String etfS1 = "";

                            if (etfS == 1) {
                                System.out.println("Pix");
                                etfS1 = "Pix";
                                System.out.println("Qual valor deseja transferir em ETFs\n");
                                int transferenciaPix = Conta.nextInt();

                                double calculo = transferenciaPix;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.01; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será:  R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaPix;

                                if (saldoInicial < transferenciaPix) {
                                    System.out.println("Você não tem saldo sufuciente...");
                                } else {
                                    saldoInicial -= transferenciaPix;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (etfS == 2) {
                                System.out.println("Boleto");
                                etfS1 = "Boleto";
                                System.out.println("Qual valor deseja tranferir em ETFs\n");
                                int transferenciaBoleto = Conta.nextInt();

                                double calculo = transferenciaBoleto;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.01; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaBoleto;

                                if (saldoInicial < transferenciaBoleto) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaBoleto;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (etfS == 3) {
                                System.out.println("Cartão");
                                etfS1 = "Cartão";
                                System.out.println("Qual valor deseja transferir em ETFs\n");
                                int transferenciaCartao = Conta.nextInt();

                                double calculo = transferenciaCartao;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.008; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.009; // medio
                                } else {
                                    taxa = 0.01; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaCartao;

                                if (saldoInicial < transferenciaCartao) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaCartao;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            }


                        }
                        if (opcaoRendaVariavel == 4) {
                            System.out.println("Commodities e Câmbio");
                            opcaoRendaVariavel1 = "Commodities e Câmbio";
                            taxa = 0.01;

                            System.out.println("Como deseja tranferir \n");
                            System.out.println("1- Pix \n2- Boleto \n3- Cartão \n");
                            int commodiCambio = Conta.nextInt();

                            if (commodiCambio == 1) {
                                System.out.println("Pix");
                                opcaoRendaVariavel1 = "Pix";
                                System.out.println("Qual valor deseja transferir em Commodities e Câmbio\n");
                                int transferenciaPix = Conta.nextInt();
                                double calculo = transferenciaPix;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.02; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.025; // medio
                                } else {
                                    taxa = 0.03; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaPix;

                                if (saldoInicial < transferenciaPix) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaPix;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (commodiCambio == 2) {
                                System.out.println("Boleto");
                                opcaoRendaVariavel1 = "Boleto";
                                System.out.println("Qual valor deseja transferir em Commodities e Câmbio\n");

                                int transferenciaBoleto = Conta.nextInt();
                                double calculo = transferenciaBoleto;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.02; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.025; // medio
                                } else {
                                    taxa = 0.03; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaBoleto;

                                if (saldoInicial < transferenciaBoleto) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaBoleto;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (commodiCambio == 3) {
                                System.out.println("Cartão");
                                opcaoRendaVariavel1 = "Cartão";
                                System.out.println("Qual valor deseja tranferir em Commodities e Câmbio\n");

                                int transferenciaCartao = Conta.nextInt();
                                double calculo = transferenciaCartao;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.02; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.025; // medio
                                } else {
                                    taxa = 0.03; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaCartao;

                                if (saldoInicial < transferenciaCartao) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaCartao;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            }
                        }
                    }

                    if (tpinvestimento1 == 3) {
                        System.out.println("Fundos de Investimento");

                        System.out.println("Que tipo de Renda variavel deseja fazer: \n");

                        System.out.println("1- Fundo Multimercado ");
                        System.out.println("1- Fundos Multimercado ");
                        System.out.println("2- Fundo Imobiliário ");
                        System.out.println("3- Fundo de Previdência ");
                        System.out.println("4- Sair");

                        int opcaoFundoInv = Conta.nextInt();
                        double taxa = 0;

                        String opcaoFundoInv1 = "";

                        if (opcaoFundoInv == 1) {

                            System.out.println("Fundo Multimercado");
                            opcaoFundoInv1 = "Fundo Multimercado";
                            taxa = 0.009;

                            System.out.println("Como deseja transferir\n");
                            System.out.println("1- Pix \n2- Boleto \n3- Cartão");
                            int fundoMultimercado = Conta.nextInt();

                            String fundoMultimercado1 = "";

                            if (fundoMultimercado == 1) {
                                System.out.println("Pix");
                                fundoMultimercado1 = "Pix";
                                System.out.println("Qual valor deseja transferir em Fundo Multimercado\n");
                                int transferenciaPix = Conta.nextInt();
                                double calculo = transferenciaPix;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.01; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.015; // medio
                                } else {
                                    taxa = 0.02; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaPix;

                                if (saldoInicial < transferenciaPix) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaPix;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (fundoMultimercado == 2) {
                                System.out.println("Boleto");
                                fundoMultimercado1 = "Boleto";
                                System.out.println("qual valor deseja trasnferir em Fundo Multimercado\n");
                                int transferenciaBoleto = Conta.nextInt();
                                double calculo = transferenciaBoleto;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.01; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.015; // medio
                                } else {
                                    taxa = 0.02; // VIP
                                }

                                totalInvestido += calculo;

                                for ( int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaBoleto;

                                if (saldoInicial < transferenciaBoleto) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaBoleto;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (fundoMultimercado == 3) {
                                System.out.println("Cartão");
                                fundoMultimercado1 = "Cartão";
                                System.out.println("qual valor deseja trasnferir em Fundo Multimercado\n");
                                int transferenciaCartao = Conta.nextInt();
                                double calculo = transferenciaCartao;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.01; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.015; // medio
                                } else {
                                    taxa = 0.02; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaCartao;

                                if (saldoInicial < transferenciaCartao) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaCartao;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            }
                        }
                        if (opcaoFundoInv == 2) {
                            System.out.println("Fundo Imobiliário");
                            opcaoFundoInv1 = "Fundo Imobiliário";
                            taxa = 0.002;

                            System.out.println("Como deseja tranferir\n");
                            System.out.println("1- Pix \n2- Boleto \n3- Cartão");
                            int fundoImobiliario = Conta.nextInt();

                            String fundoImobiliario1 = "";

                            if (fundoImobiliario == 1) {
                                System.out.println("Pix");
                                fundoImobiliario1 = "Pix";
                                System.out.println("Qual valor deseja trasnferir em Fundo Imobiliário\n");
                                int transferenciaPix = Conta.nextInt();
                                double calculo = transferenciaPix;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.003; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.004; // medio
                                } else {
                                    taxa = 0.006; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaPix;

                                if (saldoInicial < transferenciaPix) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaPix;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (fundoImobiliario == 2) {
                                System.out.println("Boleto");
                                fundoImobiliario1 = "Boleto";
                                System.out.println("Qual valor deseja transferir em Fundo Imobiliário\n");
                                int transferenciaBoleto = Conta.nextInt();
                                double calculo = transferenciaBoleto;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.003; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.004; // medio
                                } else {
                                    taxa = 0.006; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaBoleto;

                                if (saldoInicial < transferenciaBoleto) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaBoleto;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }

                            } else if (fundoImobiliario == 3) {
                                System.out.println("Cartão");
                                fundoImobiliario1 = "Cartão";
                                System.out.println("Qual valor deseja transferir em Fundo Imobiliário\n");
                                int transferenciaCartao = Conta.nextInt();
                                double calculo = transferenciaCartao;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.003; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.004; // medio
                                } else {
                                    taxa = 0.006; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaCartao;

                                if (saldoInicial < transferenciaCartao) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaCartao;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            }
                        }
                        if (opcaoFundoInv == 3) {
                            System.out.println("Fundo de Previdência");
                            opcaoFundoInv1 = "Fundo de Previdência";
                            taxa = 0.0059;

                            System.out.println("Como deseja tranferir\n");
                            System.out.println("1- Pix \n2- Boleto \n3- Cartão");
                            int fundoPrevidencia = Conta.nextInt();

                            String fundoPrevidencia1 = "";

                            if (fundoPrevidencia == 1) {
                                System.out.println("Pix");
                                fundoPrevidencia1 = "Pix";
                                System.out.println("Qual valor deseja investir em Fundo de Previdência\n");
                                int transferenciaPix = Conta.nextInt();
                                double calculo = transferenciaPix;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.0062; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.0065; // medio
                                } else {
                                    taxa = 0.0067; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaPix;

                                if (saldoInicial < transferenciaPix) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaPix;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (fundoPrevidencia == 2) {
                                System.out.println("Boleto");
                                opcaoFundoInv1 = "Boleto";
                                System.out.println("Qual valor deseja transferir em Fundo de Previdência\n");
                                int transferenciaBoleto = Conta.nextInt();
                                double calculo = transferenciaBoleto;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.0062; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.0065; // medio
                                } else {
                                    taxa = 0.0067; // VIP
                                }
                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaBoleto;

                                if (saldoInicial < transferenciaBoleto) {
                                    System.out.println("Você não tem saldo suficiente...");
                                } else {
                                    saldoInicial -= transferenciaBoleto;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }
                            } else if (fundoPrevidencia == 3) {
                                System.out.println("Cartão");
                                opcaoFundoInv1 = "Cartão";
                                System.out.println("Qual valor deseja transferir em Fundo de Previdência");
                                int transferenciaCartao = Conta.nextInt();
                                double calculo = transferenciaCartao;
                                System.out.println("Por quantos meses deseja investir? ");
                                int meses = Conta.nextInt();

                                if (saldoInicial <= 1000) {
                                    taxa = 0.0062; //basico
                                }
                                if (saldoInicial <= 10000) {
                                    taxa = 0.0065; // medio
                                } else {
                                    taxa = 0.0067; // VIP
                                }

                                totalInvestido += calculo;

                                for (int c = 0; c < meses; c++) {
                                    calculo += calculo * taxa;
                                }
                                System.out.printf("Após " + meses + " meses, o investimento será: R$ %.2f%n", calculo);
                                valorTaxa += calculo - transferenciaCartao;

                                if (saldoInicial < transferenciaCartao) {
                                    System.out.println("Você não tem saldo suficiente");
                                } else {
                                    saldoInicial -= transferenciaCartao;
                                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                                }

                            }
                        }
                    }

                    if(tpinvestimento1 == 4) {
                        System.out.println("\n=== GUIA RÁPIDO PARA INICIANTES ===");
                        System.out.println("\n TIPOS DE CONTA:");
                        System.out.println("• CORRENTE: pagamentos, cheques, TED (sem rendimento)");
                        System.out.println("• POUPANÇA: rende 0.5%/mês automático, seguro");
                        System.out.println("• INVESTIMENTO: acesso a Tesouro/CDB/Ações");

                        System.out.println("\n INVESTIMENTOS:");
                        System.out.println("• TESOURO DIRETO: 100% SEGURO (Governo)");
                        System.out.println("• CDB: banco paga juros altos (FGC protege R$250k)");
                        System.out.println("• LCI/LCA: IGUAL CDB mas SEM IMPOSTO!");
                        System.out.println("• AÇÕES: alto risco/alto lucro (vira sócio empresa)");
                        System.out.println("• ETFs: 'cesta' de ações (menos risco)");

                        System.out.println("\nPressione ENTER pra voltar...");
                        Conta.nextLine(); Conta.nextLine();
                    }
                    else if (tpinvestimento1 == 5) {
                        sairInvestimentos = true;
                    }
                }
            }
        }
        //dados iniciais

        System.out.println("Nome completo: " + nome);
        System.out.println("Tipo Conta: " + tipoConta1);
        System.out.printf("Saldo atual: R$ %.2f%n", saldoInicial);
        if (tipoConta == 3) {
            System.out.printf("Investimento feito: R$ %.2f%n", totalInvestido);
            System.out.printf("Retorno do investimento: R$ %.2f%n", valorTaxa);
        }

        System.out.println("============================================================== \nOperações");

        Scanner operacao = new Scanner(System.in);

        while (true) {

            System.out.println("1- Consultadar saldos ");
            System.out.println("2- Receber valor ");
            System.out.println("3- Transferir valor ");
            System.out.println("4- Avaliar SIMULAÇÃO ");
            System.out.println("5- Sair ");

            int opcao = operacao.nextInt();

            if (opcao == 1) {
                System.out.println("Seu saldo é de " + saldoInicial);

            } else if (opcao == 2) {
                System.out.println("Qual valor deseja adicionar ");
                int valorAdicionar = operacao.nextInt();
                System.out.println(saldoInicial += valorAdicionar);
            } else if (opcao == 3) {
                System.out.println("Qual valor deseja tranferir");
                int valorTransferir = operacao.nextInt();
                if (saldoInicial < valorTransferir) {
                    System.out.println("Você não tem saldo suficiente...");
                } else {
                    saldoInicial -= valorTransferir;
                    System.out.printf(nome + " ,Seu saldo foi atualizado! R$ %.2f%n", saldoInicial);
                }
            } else if (opcao == 5) {
                System.out.println("--FIM SIMULÇÂO--");
                break;
            } else if (opcao == 4) {
                System.out.println("Digite sua avaliação entre 0 a 5 sobre a SIMULAÇÃO");
                int avaliacao = Conta.nextInt();

                while (true)
                {
                    if (avaliacao > 5) {
                        System.out.println("Somente de 0 a 5");
                        avaliacao = Conta.nextInt();
                    } else {
                        break;
                    }
                }

                if (avaliacao >= 3 && avaliacao <= 5) {
                    System.out.println("Obrigado (:");
                } else {
                    System.out.println("Obrigado ):");
                }

            }
        }
    }
}