package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;

import java.util.Collection;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class CalculadoraTarifas {
	
	private double IMPUESTO = 0.28;
	
	public int calcularTarifa (Vuelo vuelo, Cliente cliente) {
		
		int tarifa = 0;
		int costoBase = calcularCostoBase(vuelo, cliente);
		double DESC = calcularPorcentajeDescuento(cliente);
		
		if (DESC == 1) {
			
			tarifa = 0;
		}
		else {
			
			tarifa = costoBase + calcularValorImpuestos(costoBase);
		}
		
		int respuesta = (int) tarifa;
		
		return respuesta;
	}
	
	public int calcularCostoBase (Vuelo vuelo, Cliente cliente) {
		
		int total = 0;
		Collection <Tiquete> tiquetes = vuelo.getTiquetes();
		
		for (Tiquete tiquete: tiquetes) {
			
			if (tiquete.getCliente().getIdentificador() == cliente.getIdentificador()) {
				
				total = tiquete.getTarifa();
			}
		}
		
		return total;
	}
	
	public double calcularPorcentajeDescuento (Cliente cliente) {
		
		int descuentoCliente = 0;
		
		if (cliente.getTipoCliente() == "Corporativo") {
			
			descuentoCliente = 1;
		}
		
		return descuentoCliente;
	}
	
	public int calcularDistanciaVuelo (Ruta ruta) {
			
		Aeropuerto origen = ruta.getOrigen();
		Aeropuerto destino = ruta.getDestino();
		
		return Aeropuerto.calcularDistancia(origen, destino);
	}
	
	public int calcularValorImpuestos (int costoBase) {
		
		double impuesto = costoBase*IMPUESTO;
		int respuesta = (int) impuesto;
		
		return respuesta;
	}
}
