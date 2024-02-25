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
		
		return 0;
	}
	
	public double calcularPorcentajeDescuento (Cliente cliente) {
		
		return 0;
	}
}
