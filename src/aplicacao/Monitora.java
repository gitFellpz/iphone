package aplicacao;
import java.util.Random;
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
		
		Sensor sensor1 = new Sensor(10, 10, 6, 40, 115.675,"47º55'44''W,21º00'34''S");
		Sensor sensor2 = new Sensor(14, 18, 6.5, 40, 209.95, "47º55'42''W,21º00'35''S");
		Sensor sensor3 = new Sensor(30, 20, 7, 50, 97.65, "47º55'39''W,21º00'37''S");
		Sensor sensor4 = new Sensor(78, 25, 7.5, 70, 204.5, "47º55'44''W,21º00'39''S");
		
		lista.insere(sensor4); // 78
		lista.insere(sensor1); // 10
		lista.insere(sensor3); // 30
		lista.insere(sensor2); // 14
		
		
		Random random = new Random();
		
        int valorAleatorio = random.nextInt(7) + 18;
        System.out.println(valorAleatorio);
        sensor1.setTemperatura(valorAleatorio);
        System.out.println(sensor1);
		
		
		

		input.close();
	}

}