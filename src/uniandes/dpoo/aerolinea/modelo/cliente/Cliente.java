package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.Vuelo;

public abstract class Cliente {
	
	public Cliente () {
		
	}
	
	public String getTipoCliente () {
		
		return "TipoCliente";
	}
	
	public String getIdentificador () {
		
		return "Identificador";
	}
	
	public void agregarTiquete (Tiquete tiquete) {
		
	}
	
	public int calcularValorTotalTiquetes () {
		 
		return 0;
	}
	
	public void usarTiquetes (Vuelo vuelo) {
		
	}
}
