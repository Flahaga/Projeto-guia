package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupança;
import conta.util.Cores;

public class Menu {

        public static void main(String[] args) {
        	
        	Scanner leia = new Scanner(System.in);
        	
        	ContaController contas = new ContaController();
			
    int opcao, numero,agencia,tipo,aniversário;
    String titular;
    float saldo,limite;
        
    System.out.println("\nCriar Contas\n");
	
	ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
	contas.cadastrar(cc1);
		
	ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
	contas.cadastrar(cc2);
	
	ContaPoupança cp1 = new ContaPoupança(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
	contas.cadastrar(cp1);
	
	ContaPoupança cp2 = new ContaPoupança(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
	contas.cadastrar(cp2);
	
	contas.listarTodas();

			while (true) {

				System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
						+ "*****************************************************");
				System.out.println("                                                     ");
				System.out.println("                BANCO DO BRAZIL COM Z                ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("                                                     ");
				System.out.println("            1 - Criar Conta                          ");
				System.out.println("            2 - Listar todas as Contas               ");
				System.out.println("            3 - Buscar Conta por Numero              ");
				System.out.println("            4 - Atualizar Dados da Conta             ");
				System.out.println("            5 - Apagar Conta                         ");
				System.out.println("            6 - Sacar                                ");
				System.out.println("            7 - Depositar                            ");
				System.out.println("            8 - Transferir valores entre Contas      ");
				System.out.println("            9 - Sair                                 ");
				System.out.println("                                                     ");
				System.out.println("*****************************************************");
				System.out.println("Entre com a opção desejada:                          ");
				System.out.println("                                                     " + Cores.TEXT_RESET);
				
				try {
					opcao = leia.nextInt();
				}catch(InputMismatchException e){
					System.out.println("\nDigite valores inteiros!");
					leia.nextLine();
					opcao=0;
				}

				if (opcao == 9) {
					System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
					leia.close();
					System.exit(0);
				}

				switch (opcao) {
				case 1:
					System.out.println("\n Criar Conta");
               System.out.println("\n Digite o número da Agencia:");
               agencia = leia.nextInt();
               System.out.println("\n Digite o nome do Titular:");
               leia.skip("\\ R?");
               titular = leia.nextLine();
				
               do { 
            	System.out.println("\n Digite o tipo da Conta (1-CC ou 2-CP):");
                 tipo = leia.nextInt();
               } while (tipo < 1 && tipo > 2);
               System.out.println("\n Digite o Saldo da conta (R$):");
               saldo = leia.nextFloat();
               switch(tipo) {
               case 1 -> {
            System.out.println("\n Digite o limite de Crédito (R$):");
            limite = leia.nextFloat();
    contas.cadastrar(new ContaCorrente(contas.gerarNumero(),agencia,tipo,titular,saldo,limite));
               }
               case 2 -> {    
             System.out.println("\n Digite o dia do Aniversário da conta:");
             aniversário = leia.nextInt();
       contas.cadastrar(new ContaPoupança(contas.gerarNumero(),agencia,tipo,titular,saldo,aniversário));
               }
               } 
               keyPress();
					break;
				case 2:
					System.out.println("\n Listar todas as Contas");
                    contas.listarTodas();
					keyPress();
					break;
				case 3:
					System.out.println("\n Buscar Conta por número");
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					contas.procurarPorNumero(numero);
					keyPress();
					break;
				case 4:
					System.out.println("\n Atualizar dados da Conta");
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					if (contas.buscarNaCollection(numero) != null) {
						
						System.out.println("Digite o Numero da Agência: ");
						agencia = leia.nextInt();
						System.out.println("Digite o Nome do Titular: ");
						leia.skip("\\R?");
						titular = leia.nextLine();
							
						System.out.println("Digite o Saldo da Conta (R$): ");
						saldo = leia.nextFloat();
						
						tipo = contas.retornaTipo(numero);
						
						switch(tipo) {
							case 1 -> {
								System.out.println("Digite o Limite de Crédito (R$): ");
								limite = leia.nextFloat();
								contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
							}
							case 2 -> {
								System.out.println("Digite o dia do Aniversário da Conta: ");
								aniversário = leia.nextInt();
								contas.atualizar(new ContaPoupança(numero, agencia, tipo, titular, saldo, aniversário));
							}
							default ->{
								System.out.println("Tipo de conta inválido!");
							}
						}
						
					}else
						System.out.println("\nConta não encontrada!");

					keyPress();
					break;
				case 5:
					System.out.println("\n Apagar Conta");
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
						
					contas.deletar(numero);
					keyPress();
					break;
				case 6:
					System.out.println("\n Sacar");

					keyPress();
					break;
				case 7:
					System.out.println("\n Depositar");

					keyPress();
					break;
				case 8:
					System.out.println("\n Transferir");

					keyPress();
					break;
				default:
					System.out.println("\nOpção Inválida" + Cores.TEXT_RESET);
					
					keyPress();
					break;
				}
			}
		}

		public static void keyPress() {

			try {

				System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
				System.in.read();

			} catch (IOException e) {

				System.out.println("Você pressionou uma tecla diferente de enter!");

			}
		}
	}