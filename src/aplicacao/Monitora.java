package aplicacao;

import java.util.Scanner;
import listas.ListaSensoresCrescente;
import entidades.Sensor;

public class Monitora {	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		/*
			"47º55'44''W,21º00'34''S"
			"47º55'42''W,21º00'35''S" 
			"47º55'39''W,21º00'37''S"
			"47º55'44''W,21º00'39''S"
		*/

		ListaSensoresCrescente lista = new ListaSensoresCrescente();
		//numero_serie, temperatura, ph, taxa de umidade e coordenadas
		
		Sensor sensor1 = new Sensor(10, 10, 6, 40, "47º55'44''W,21º00'34''S");
		Sensor sensor2 = new Sensor(14, 18, 6.5, 40, "47º55'42''W,21º00'35''S");
		Sensor sensor3 = new Sensor(30, 20, 7, 50, "47º55'39''W,21º00'37''S");
		Sensor sensor4 = new Sensor(78, 24, 7.5, 70, "47º55'44''W,21º00'39''S");
		
		lista.insere(sensor4); // 78
		lista.insere(sensor1); // 10
		lista.insere(sensor3); // 30
		lista.insere(sensor2); // 14
		
		
		String elem = "47º55'42''W,21º00'35''S";
		
		lista.encontrarSensor(elem);
		
		

		input.close();
	}

}