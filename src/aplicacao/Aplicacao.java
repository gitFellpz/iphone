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
		Sensor sensor1 = new Sensor(10, 10, 6, 40, 115.675,"47º55'44''W,21º00'34''S");
		Sensor sensor2 = new Sensor(14, 18, 6.5, 40, 209.95, "47º55'42''W,21º00'35''S");
		Sensor sensor3 = new Sensor(30, 20, 7.7, 50, 111.758, "47º55'39''W,21º00'37''S");
		Sensor sensor4 = new Sensor(78, 25, 7.5, 70, 204.5, "47º55'44''W,21º00'39''S");
		//Inserindo na lista
		lista.insere(sensor4); // 78
		lista.insere(sensor1); // 10
		lista.insere(sensor3); // 30
		lista.insere(sensor2); // 14
		
		//Variáveis
		int opc = 0;
		int opc2 = 0;
		String coordenada_analise;
		Sensor sensor_recebido;
		
		do {
			System.out.print(
					  "\n0) Encerrar programa"
					+ "\n1) Verificar Coordenada"
					+ "\n2) Verificar Sensores"
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
						+ "\n2) Verificar a lista dos sensores"
						+ "\n3) Verificar Status sensores"
						+ "\n4) Verificar sensores inadequados (uso fila)"
						+ "\n5) Adicionar sensor (lista)"
						+ "\n6) Excluir sensor (lista)"
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
					
					int opc4 = 1;
					
					while(opc4 == 1){
						
						sensor_recebido = lista.verificarSolo(fila);
						if(sensor_recebido != null)
							lista.remove(sensor_recebido);
						
						System.out.println(
									"\nDeseja continuar verificando status?"
									+ "\n1) Sim"
									+ "\n2) Não"
						);
						opc4 = input.nextInt();
					}
					
					break;
				case 4:
					if(!fila.isEmpty())  {
						
						int opc3 = 1;
						
						while(opc3 == 1){
							if(!fila.isEmpty()) {
								System.out.println(fila.first());
								System.out.println(
										  "\nDeseja arrumar os níveis fora do aceitável?"
										  + "\n1) Sim"
										  + "\n2) Não"
								);
								opc3 = input.nextInt();
								
								switch(opc3) {
								case 1:
									Sensor v = fila.dequeue();
									lista.arrumarSolo(v);
									lista.insere(v);
									break;
								case 2:
									break;
								default:
									System.out.println("\nOpção inválida!");
								}
							}
							else
								break;
								
						}
						
					}
					else
						System.out.println("\nFila de sensores inadequados VAZIA!");
					break;
				case 5:
					opc2 = 1;
					while(opc2 == 1) {
						int numero_serie; //Critério de ordenação
						int temperatura;
						double ph;
						int taxa_umidade;
						double concentracao_ferro;
						String coordenadas;
						System.out.println("\nInstruções\nPegue seu Sensor e coloque-o no local desejado e plug o painel na entrada USB\nOs dados apresentados serão usados para inseri-lo no sistema!");
						
						System.out.print("\n----Menu Inserção Sensor----"
								+ "\nDigite o número de série: ");
						numero_serie = input.nextInt();
						System.out.print("Digite a temperatura que aparece no painel do sensor: ");
						temperatura = input.nextInt();
						System.out.print("Digite o pH que aparece no painel do sensor: ");
						ph = input.nextDouble();
						System.out.print("Digite a taxa de umidade que aparece no painel do sensor: ");
						taxa_umidade = input.nextInt();
						System.out.print("Digite a quantidade de ferro que aparece no painel do sensor: ");
						concentracao_ferro = input.nextDouble();
						System.out.print("Digite a coordenada do local do sensor: ");
						coordenadas = input.next();
						
						Sensor sensorX = new Sensor(numero_serie, temperatura, ph, taxa_umidade, concentracao_ferro, coordenadas);
						
						lista.insere(sensorX);
						System.out.println("\nSensor Adicinado com sucesso!");
						
						System.out.println("\nDeseja continuar adicionando Sensores?"
								+ "\n1) Sim"
								+ "\n2) Não");
						opc2 = input.nextInt();
					}
					break;
				case 6:
					
					break;
					
				default:
					System.out.println("\nOpção inválida");
					break;
				}
					
				break;
				
			case 0:
				System.out.println("---Encerrando programa...");
				break;
				
			default:
				System.out.println("\nOpção inválida");
			}
			
		} while(opc != 0);
		
		input.close();
	}
}
