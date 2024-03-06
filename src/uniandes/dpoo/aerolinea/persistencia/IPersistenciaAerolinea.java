package uniandes.dpoo.aerolinea.persistencia;

import java.io.IOException;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Avion;

public interface IPersistenciaAerolinea {
	
	public void cargarAerolinea (String archivo, Aerolinea aerolinea) throws IOException, InformacionInconsistenteException;
	
	public void salvarAerolinea (String archivo, Aerolinea aerolinea) throws IOException;
}
