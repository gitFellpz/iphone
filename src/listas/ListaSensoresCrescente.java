package listas;

import entidades.Sensor;
import filas.FilaSensoresInadequados;

public class ListaSensoresCrescente {
	private int TEMPERATURA_MIN = 18;
	private int TEMPERATURA_MAX = 24;
	private float PH_MIN = 6;
	private float PH_MAX = 7;
	private int UMIDADE_MIN = 50;
	private int UMIDADE_MAX = 70;
	
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
				System.out.println("\n"+aux.dado.toString());
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
	public void verificarSolo(FilaSensoresInadequados fila) {
		NO aux = lista;

		while(aux != null) {
			int achou = 0;
			
			if((aux.dado.getTemperatura() < TEMPERATURA_MIN) || (aux.dado.getTemperatura() > TEMPERATURA_MAX))
				achou = achou +1;
			if((aux.dado.getPh() < PH_MIN) || (aux.dado.getPh() > PH_MAX))
				achou = achou +1;
			if((aux.dado.getTaxa_umidade() < UMIDADE_MIN) || (aux.dado.getTaxa_umidade() > UMIDADE_MAX))
				achou = achou +1;
			
			if(achou >= 2) {
				System.out.println("\nO sensor de número de série "+aux.dado.getNumero_serie()+" foi enviado a fila de sensores inadequados!\nHá mais de 1 parâmetro fora do seu intervalo de aceitação");
				Sensor aux2 = aux.dado;
				fila.enqueue(aux2);
			}
			
			aux = aux.prox;
		}
	}
	
}

