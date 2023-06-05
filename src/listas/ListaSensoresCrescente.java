package listas;

import entidades.Sensor;
import filas.FilaSensoresInadequados;
import java.util.Random;


public class ListaSensoresCrescente {
	private int TEMPERATURA_MIN = 18;
	private int TEMPERATURA_MAX = 24;
	private double PH_MIN = 6;
	private double PH_MAX = 7;
	private int UMIDADE_MIN = 50;
	private int UMIDADE_MAX = 70;
	private double FERRO_MIN = 111.758;
	private double FERRO_MAX = 204.5;
	
	private class NO {
		Sensor dado;
		NO prox;
	}

	//Sem método init. Já instancia a lista
	private NO lista = null;

	public void insere(Sensor elem) {
		NO novo = new NO();
		novo.dado = elem;
		if (lista == null) {
			novo.prox = null;
			lista = novo;
		} else {
			if (novo.dado.getNumero_serie() < lista.dado.getNumero_serie()) {
				novo.prox = lista;
				lista = novo;
			} else {
				NO aux = lista;
				boolean achou = false;
				while (aux.prox != null && !achou) {
					if (aux.prox.dado.getNumero_serie() < novo.dado.getNumero_serie())
						aux = aux.prox;
					else
						achou = true;
				}
				novo.prox = aux.prox;
				aux.prox = novo;
			}
		}
	}

	
	public boolean remove(Sensor valor) {
		boolean achou = false;
		if (lista != null) {
			if (valor == lista.dado) {
				achou = true;
				lista = lista.prox;
			} else {
				NO aux = lista;
				while (aux.prox != null && !achou) {
					if (aux.prox.dado != valor)
						aux = aux.prox;
					else {
						achou = true;
						aux.prox = aux.prox.prox;
					}
				}
			}
		}
		return achou;
	}
	
	
	public int contaNos() {
		int cont=0;
		NO aux = lista;
		while (aux!=null) {
			cont++;
			aux=aux.prox;
		}
		return cont;
	}
	
	
	public void apresenta() {
		NO aux = lista;
		System.out.println("\n *** LISTA ***");
		while (aux != null) {
			System.out.println("\t " + aux.dado);
			aux = aux.prox;
		}
	}

	
	//Método obrigatório
	//Diz se a coordenada existe no sistema (exibir coordenada) ou não (alerta)
	public void encontrarSensor(String coordenada_analise) {
		boolean achou = false;
		NO aux = lista;
		
		while(aux != null && !achou) {
			if(aux.dado.getCoordenadas().equals(coordenada_analise)) {
				
				System.out.println("\nSensor nas coordenadas "+ coordenada_analise +" ENCONTRADO!");
				System.out.println(aux.dado.toString());
				achou = true;
			}
			else 
				aux = aux.prox;
		}
		
		if(!achou)
			System.out.println("\nSensor nas coordenadas "+ coordenada_analise +" NÃO encontrado!");
	}
	
	
	// Método obrigatório
	// Verifica a situação dos sensores
	public Sensor verificarSolo(FilaSensoresInadequados fila) {
		NO aux = lista;

		while(aux != null) {
			int achou = 0;
			System.out.println("\n--------------------------------------------");
			System.out.println("Sensor nº série: "+aux.dado.getNumero_serie());
			if((aux.dado.getTemperatura() < TEMPERATURA_MIN) || (aux.dado.getTemperatura() > TEMPERATURA_MAX)) {
				achou = achou +1;
				System.out.println("A temperatura está fora dos intervalos aceitos (entre "+TEMPERATURA_MIN+" e "+TEMPERATURA_MAX+"º)");
			}
			if((aux.dado.getPh() < PH_MIN) || (aux.dado.getPh() > PH_MAX)) {
				achou = achou +1;
				System.out.println("O ph está fora dos intervalos aceitos");
			}
			if((aux.dado.getTaxa_umidade() < UMIDADE_MIN) || (aux.dado.getTaxa_umidade() > UMIDADE_MAX)) {
				achou = achou +1;
				System.out.println("A umidade está fora dos intervalos aceitos");
			}
			if((aux.dado.getConcentracao_ferro() < FERRO_MIN) || (aux.dado.getConcentracao_ferro() > FERRO_MAX)) {
				achou = achou +1;
				System.out.println("O ferro está fora dos intervalos aceitos");
			}
			
			if(achou >= 2) {
				System.out.println("\nALERTA\nO sensor foi enviado a fila de sensores inadequados!\nHá mais de 1 parâmetro fora do seu intervalo de aceitação");
				Sensor aux2 = aux.dado;
				fila.enqueue(aux2);
				System.out.println("--------------------------------------------\n");
				return aux2;
			}
			
			System.out.println("--------------------------------------------\n");
			
			aux = aux.prox;
		}
		
		return null;
	}
	
	// Método adicional (gerar alertar e mudar os valores para dentro do intervalo)
	public void arrumarSolo(Sensor sensor_inadequado) {
		Random random = new Random();
		System.out.println("------------------ALERTA---------------------");
		
		if((sensor_inadequado.getTemperatura() < TEMPERATURA_MIN) || (sensor_inadequado.getTemperatura() > TEMPERATURA_MAX)) {
			System.out.println("A temperatura precisa ser alterada!");
			int temp_aleatoria = random.nextInt(7) + 18;
			sensor_inadequado.setTemperatura(temp_aleatoria);
		}

		if((sensor_inadequado.getPh() < PH_MIN) || (sensor_inadequado.getPh() > PH_MAX)) {
			System.out.println("O pH precisa ser alterado!");
			double ph_aleatorio = random.nextDouble() + 6.0;
			sensor_inadequado.setPh(ph_aleatorio);
		}

		if((sensor_inadequado.getTaxa_umidade() < UMIDADE_MIN) || (sensor_inadequado.getTaxa_umidade() > UMIDADE_MAX)) {
			System.out.println("A umidade precisa ser alterada!");
			int umidade_aleatorio = random.nextInt(21) + 50;
			sensor_inadequado.setTaxa_umidade(umidade_aleatorio);
		}

		if((sensor_inadequado.getConcentracao_ferro() < FERRO_MIN) || (sensor_inadequado.getConcentracao_ferro() > FERRO_MAX)) {
			System.out.println("A concentração de ferro precisa ser alterada!");
			double ferro_aleatorio = (random.nextDouble() * (204.5 - 111.758)) + 111.758;
			sensor_inadequado.setConcentracao_ferro(ferro_aleatorio);
		}
			
		System.out.println("\nDrones estão indo arrumar o solo! Não se preocupe");
		System.out.println("--------------------------------------------");
	}
	
}

