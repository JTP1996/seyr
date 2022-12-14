package Modelo;

public class CalcularImporte {
	private String CiudadOrigen;
	private boolean OrigenNacional;
	private String CiudadDestino;
	private boolean DestinoNacional;
	private String TipoEnvio;
	private float Peso;
	
	
	
	public String getCiudadOrigen() {
		return CiudadOrigen;
	}
	public void setCiudadOrigen(String ciudadOrigen) {
		CiudadOrigen = ciudadOrigen;
	}
	public boolean isOrigenNacional() {
		return OrigenNacional;
	}
	public void setOrigenNacional(boolean origenNacional) {
		OrigenNacional = origenNacional;
	}
	public String getCiudadDestino() {
		return CiudadDestino;
	}
	public void setCiudadDestino(String ciudadDestino) {
		CiudadDestino = ciudadDestino;
	}
	public boolean isDestinoNacional() {
		return DestinoNacional;
	}
	public void setDestinoNacional(boolean destinoNacional) {
		DestinoNacional = destinoNacional;
	}
	public String getTipoEnvio() {
		return TipoEnvio;
	}
	public void setTipoEnvio(String tipoEnvio) {
		TipoEnvio = tipoEnvio;
	}
	public float getPeso() {
		return Peso;
	}
	public void setPeso(float peso) {
		Peso = peso;
	}
	
	public CalcularImporte(String ciudadOrigen, boolean origenNacional, String ciudadDestino, boolean destinoNacional,
			String tipoEnvio, float peso) {
		super();
		CiudadOrigen = ciudadOrigen;
		OrigenNacional = origenNacional;
		CiudadDestino = ciudadDestino;
		DestinoNacional = destinoNacional;
		TipoEnvio = tipoEnvio;
		Peso = peso;
	}
	
	public CalcularImporte() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "CalcularImporte [CiudadOrigen=" + CiudadOrigen + ", OrigenNacional=" + OrigenNacional
				+ ", CiudadDestino=" + CiudadDestino + ", DestinoNacional=" + DestinoNacional + ", TipoEnvio="
				+ TipoEnvio + ", Peso=" + Peso + "]";
	}
	
	public  double  CalcImporte(boolean origenNacional, boolean destinoNacional, String Tipo, float Peso) {
		
		double ImporteBase = 7;
		
		
		if (origenNacional == true && destinoNacional == true) {
			ImporteBase =4 ; 
		}
		
		if (Tipo.equals("Paq 10 - Envio antes de las 10h")) {
			
			ImporteBase = ImporteBase +5;
		}
		
		ImporteBase = ImporteBase + (Peso * 0.1);
		
		return ImporteBase;
		
	}
	
	
	
	
	
	
}
