package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		
		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Número              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair do sistema                               ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");
             opcao = leia.nextInt();

         	if (opcao == 9) {
       System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
        			leia.close();
        			System.exit(0);
        			}   
             
			switch (opcao) {
				case 1:
					System.out.println("\nCriar Conta");
					break;
				case 2:
					System.out.println("\nListar todas as Contas");
					break;
				case 3:
					System.out.println("\nConsultar dados da Conta - por número");
					break;
				case 4:
					System.out.println("\nAtualize seus dados da Conta");
					break;
				case 5:
					System.out.println("\nApagar sua Conta");
					break;
				case 6:
					System.out.println("\n Faça seu saque");
					break;
				case 7:
					System.out.println("\n Faça seu depósito");
					break;
				case 8:
					System.out.println("\nTransferência entre Contas");
					break;
				default:
			System.out.println("\nOpção Inválida!");
				break;
			}
		}
	}



	


}
