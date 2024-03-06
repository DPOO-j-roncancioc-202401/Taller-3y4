package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
	
	private int COSTO_POR_KM = 100;
	
	public int calcularCostoBase (Vuelo vuelo, Cliente cliente) {
		
		int costoDistancia = super.calcularDistanciaVuelo(vuelo.getRuta())*COSTO_POR_KM;
		int total = super.calcularCostoBase(vuelo,  cliente) + costoDistancia;
		
		return total;
	}
	
	public double calcularPorcentajeDescuento (Cliente cliente) {
		
		return super.calcularPorcentajeDescuento(cliente);
	}
}
