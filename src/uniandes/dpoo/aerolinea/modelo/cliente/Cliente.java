package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uniandes.dpoo.aerolinea.modelo.Vuelo;

public abstract class Cliente {
	
	private List<Tiquete> tiquetesSinUsar = new ArrayList<Tiquete>();
	private List<Tiquete> tiquetesUsados = new ArrayList<Tiquete>();
	private Tiquete tiquete;
	protected String identificador;
	
	public Cliente () {
		
		this.tiquetesSinUsar = new ArrayList<Tiquete>();
		this.tiquetesUsados = new ArrayList<Tiquete>();
		Random random = new Random ();
		long aleatorio = 1000000000L + random.nextLong() % 9000000000L;
		this.identificador = Long.toString(aleatorio);
	}
	
	public String getTipoCliente () {
		
		/**
		 * Pendiente-Revisar.
		 */
		
		return "TipoCliente";
	}
	
	public String getIdentificador () {
		
		return this.identificador;
	}
	
	public void agregarTiquete (Tiquete tiquete) {
		
		this.tiquetesSinUsar.add(tiquete);
		
	}
	
	public int calcularValorTotalTiquetes () {
		
		int valorTotal = 0;
		if(this.tiquetesSinUsar.size()>0)
		{
			for(Tiquete tiquete: this.tiquetesSinUsar)
			{
				valorTotal += tiquete.getTarifa();
			}
		}
		return valorTotal;
	}
	
	public void usarTiquetes (Vuelo vuelo) {
		
		for (int i = 0; i < this.tiquetesSinUsar.size(); i++) 
		{
			
			if (this.tiquetesSinUsar.contains(tiquete) && tiquete.getVuelo() == vuelo) 
			{
				tiquete.marcarComoUsado();
				this.tiquetesUsados.add(tiquete);
				this.tiquetesSinUsar.remove(tiquete);
			}
		}
	}
}
