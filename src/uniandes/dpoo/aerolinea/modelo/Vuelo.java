package uniandes.dpoo.aerolinea.modelo;

import java.util.Collection;

import uniandes.dpoo.aerolinea.exceptions.VueloSobrevendidoException;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.tiquetes.GeneradorTiquetes;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;

public class Vuelo {
	
	private String fecha;
	private Ruta ruta;
	private Avion avion;
	private Collection<Tiquete> tiquetes;
	
	public Vuelo (Ruta ruta, String fecha, Avion avion) {
		
		this.fecha = fecha;
		this.ruta = ruta;
		this.avion = avion;
	}
	
	public Ruta getRuta() {
		
		return this.ruta;
	}
	
	public String getFecha() {
		
		return this.fecha;
	}
	
	public Avion getAvion() {
		
		return this.avion;
	}
	
	public Collection<Tiquete> getTiquetes() {
		
		return this.tiquetes;
	}
	
	public int venderTiquetes (Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException{
		
		int total = 0;
		
		if (this.getAvion().getCapacidad() < this.getTiquetes().size() + cantidad) {
			
			throw new VueloSobrevendidoException(this);
		}
		
		for (int i = 0; i <= cantidad; i++) {
			
			int tarifa = calculadora.calcularTarifa(this,  cliente);
			total += tarifa;
			Tiquete nuevotiquete = GeneradorTiquetes.generarTiquete (this, cliente, tarifa);
		this.tiquetes.add(nuevotiquete);	
		}
		
		return total;
	}
	
	@Override
	public boolean equals(Object obj)
    {
        boolean respuesta = false;
        if(getClass() == obj.getClass() ) 
        {
            if (this == obj ) 
            {
            respuesta = true;
            }
        }
        if (getClass() != obj.getClass() || obj == null )
        {
            respuesta = false;
        }
        return respuesta;
    }
}
