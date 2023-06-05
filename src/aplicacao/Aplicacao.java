package aplicacao;

import java.util.Scanner;
import listas.ListaSensoresCrescente;
import filas.FilaSensoresInadequados;
import entidades.Sensor;

public class Aplicacao {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ListaSensoresCrescente lista = new ListaSensoresCrescente();
		FilaSensoresInadequados fila = new FilaSensoresInadequados();
		
		//Criando sensores já presentes no sistema/platação
		Sensor sensor1 = new Sensor(10, 10, 6, 40, "47º55'44''W,21º00'34''S");
		Sensor sensor2 = new Sensor(14, 18, 6.5, 40, "47º55'42''W,21º00'35''S");
		Sensor sensor3 = new Sensor(30, 20, 7, 50, "47º55'39''W,21º00'37''S");
		Sensor sensor4 = new Sensor(78, 25, 7.5, 70, "47º55'44''W,21º00'39''S");
		//Inserindo na lista
		lista.insere(sensor4); // 78
		lista.insere(sensor1); // 10
		lista.insere(sensor3); // 30
		lista.insere(sensor2); // 14
		
		//Variáveis
		int opc = 0;
		int opc2 = 0;
		String coordenada_analise;
		
		do {
			System.out.print(
					  "\n0) Encerrar programa"
					+ "\n1) Verificar Coordenada"
					+ "\n2) Verificar Sensores"
					+ "\n4) Inserir Sensor"
					+ "\n5) Excluir Sensor"
					+ "\nSua opção: ");
			opc = input.nextInt();
			
			switch(opc){
			case 1:
				opc2 = 0;
				
				System.out.println("\n---Menu Verificador de Coordenadas---");
				do {
					input.nextLine();
					System.out.print("\nDigite a coordenada que deseja pesquisar: ");
					coordenada_analise = input.nextLine();
					
					lista.encontrarSensor(coordenada_analise);
					
					System.out.println("\nDeseja pesquisar mais sensores?"
							+ "\n1) SIM"
							+ "\n2) NÃO");
					opc2 = input.nextInt();
				} while(opc2 == 1);

				break;
			case 2:
				opc2 = 0;
				System.out.print("\n---Menu Verificador de Sensores---"
						+ "\nQual operação voce deseja fazer?"
						+ "\n1) Verificar quantidade de sensores"
						+ "\n2) Verificar a lista de sensores"
						+ "\n3) Verificar a fila de sensores inadequados"
						+ "\nSua opção: ");
				
				opc2 = input.nextInt();
				
				switch(opc2) {
				case 1:
					System.out.println("\n"+lista.contaNos()+" sensores");
					break;
				case 2:
					lista.apresenta();
					break;
				case 3:
					if(fila.isEmpty()) {
						System.out.println("\nFila vazia!");
					}
					else
						while(!fila.isEmpty()) {
							
						}

					
					break;
				default:
					
					break;
				}
					
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 0:
				System.out.println("---Encerrando programa...");
			default:
				System.out.println("\nOpção inválida");
			}
		}
		while(opc != 0);
		
		
		
		input.close();
	}

}
