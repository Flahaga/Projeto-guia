package conta.controller;
import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;


	public class ContaController implements ContaRepository{

		private ArrayList<Conta> listaContas = new ArrayList<Conta>();
		
		 @Override
		    public void procurarPorNumero(int numero) {
		        var conta = buscarNaCollection(numero);
				
				if (conta != null)
					conta.visualizar();
				else
					System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
		    }

		    @Override
		    public void listarTodas() {
		        for (var conta : listaContas) {
					conta.visualizar();
				}        
		    }

		    @Override
		    public void cadastrar(Conta conta) {
				listaContas.add(conta);
				System.out.println("\nA Conta número: " + conta.getNúmero() + " foi criada com sucesso!");
		    }

		    @Override
		    public void atualizar(Conta conta) {
		        var buscaConta = buscarNaCollection(conta.getNúmero());
				
				if (buscaConta != null) {
					listaContas.set(listaContas.indexOf(buscaConta), conta);
					System.out.println("\nA Conta numero: " + conta.getNúmero() + " foi atualizada com sucesso!");
				}else
					System.out.println("\nA Conta numero: " + conta.getNúmero() + " não foi encontrada!");
		    }

		    
		    @Override
		    public void deletar(int numero) {
		        var conta = buscarNaCollection(numero);
				
				if (conta != null) {
					if(listaContas.remove(conta) == true)
						System.out.println("\nA Conta numero: " + numero + " foi deletada com sucesso!");
				}else
					System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
		    }

		    @Override
		    public void sacar(int numero, float valor) {
		        
		        
		    }

		    @Override
		    public void depositar(int numero, float valor) {
		        
		        
		    }

		    @Override
		    public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		        
		        
		    }

		 
			public int gerarNumero() {
				return listaContas.size() + 1;
			}

		   
			public Conta buscarNaCollection(int numero) {
				for (var conta : listaContas) {
					if (conta.getNúmero() == numero) {
						return conta;
					}
				}
				
				return null;
			}

			public int retornaTipo(int numero) {
				for (var conta : listaContas) {
					if (conta.getNúmero() == numero) {
						return conta.getTipo();
					}
				}
				
				return 0;
			}
		    
		}