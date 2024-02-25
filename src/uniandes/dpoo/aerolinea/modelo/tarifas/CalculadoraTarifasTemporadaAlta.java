package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
	
	private int COSTO_POR_KM = 100;
	
	public int calcularCostoBase (Vuelo vuelo, Cliente cliente) {
		
		return 0;
	}
	
	public double calcularPorcentajeDescuento (Cliente cliente) {
		
		return 0.0;
	}
}
