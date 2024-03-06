package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	
	private int COSTO_POR_KM_NATURAL = 600;
	private int COSTO_POR_KM_CORPORATIVO = 900;
	private double DESCUENTO_PEQ = 0.02;
	private double DESCUENTO_MEDIANAS = 0.1;
	private double DESCUENTO_GRANDES = 0.2;
	
	public int calcularCostoBase (Vuelo vuelo, Cliente cliente) {
		
		int costoDistancia = 0;
		int total = 0;
		
		if (cliente.getTipoCliente() == "Corporativo") {
			
			costoDistancia = super.calcularDistanciaVuelo(vuelo.getRuta())*COSTO_POR_KM_CORPORATIVO;
		}
		
		else if (cliente.getTipoCliente() == "Natural") {
			
			costoDistancia = super.calcularDistanciaVuelo(vuelo.getRuta())*COSTO_POR_KM_NATURAL;
			total = super.calcularCostoBase(vuelo, cliente) + costoDistancia;
		}
		
		return total;
	}
	
	public double calcularPorcentajeDescuento (Cliente cliente) {
		
		return super.calcularPorcentajeDescuento (cliente);
	}
}
