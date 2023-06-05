package entidades;

public class Sensor {
	
	//Atributos 
	private int numero_serie; //Critério de ordenação
	private int temperatura;
	private double ph;
	private int taxa_umidade;
	private String coordenadas;
	
	//Construtor
	public Sensor(int numero_serie, int temperatura, double ph, int taxa_umidade, String coordenadas) {
		this.numero_serie = numero_serie;
		this.temperatura = temperatura;
		this.ph = ph;
		this.taxa_umidade = taxa_umidade;
		this.coordenadas = coordenadas;
	}

	//Getters e Setters
	public int getNumero_serie() {
		return numero_serie;
	}
	public void setNumero_serie(int numero_serie) {
		this.numero_serie = numero_serie;
	}
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	public double getPh() {
		return ph;
	}
	public void setPh(int ph) {
		this.ph = ph;
	}
	public int getTaxa_umidade() {
		return taxa_umidade;
	}
	public void setTaxa_umidade(int taxa_umidade) {
		this.taxa_umidade = taxa_umidade;
	}
	public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	@Override //To string
	public String toString() {
		return "\n--------------------"
				+ "\nSensor número de série: " + numero_serie 
				+"\nTemperatura: " + temperatura 
				+"\nPH: " + ph
				+"\nTaxa de umidade: " + taxa_umidade
				+ "\nCoordenadas: " + coordenadas
				+ "\n--------------------";
	}	
}
