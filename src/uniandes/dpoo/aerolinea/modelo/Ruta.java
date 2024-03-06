package uniandes.dpoo.aerolinea.modelo;

/**
 * Esta clase tiene la información de una ruta entre dos aeropuertos que cubre una aerolínea.
 */
public class Ruta
{
    // TODO completar
	
	private String horaSalida;
	private String horaLlegada;
	private String codigoRuta;
	private Aeropuerto origen;
	private Aeropuerto destino;
	
	public Ruta (Aeropuerto origen, Aeropuerto destino, String horaSalida, String horaLlegada, String codigoRuta) {
		
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.codigoRuta = codigoRuta;
		this.origen = origen;
		this.destino = destino;
	}
	
	public String getCodigoRuta () {
		
		return this.codigoRuta;
	}
	
	public Aeropuerto getOrigen () {
		
		/**
		 * Pendiente - Revisar
		 */
		
		return this.origen;
	}
	
	public Aeropuerto getDestino () {
		
		/**
		 * Pendiente - Revisar
		 */
		
		return this.destino;
	}
	
	public String getHoraSalida () {
		
		return this.horaSalida;
	}
	
	public String getHoraLlegada () {
		
		return this.horaLlegada;
	}
	
	public int getDuracion () {
		
		/**
		 * HoraLlegada: Cadena de 4 digitos
		 * HoraSalida: Cadena de 4 digitos
		 */
		
		int horasSalida = getHoras(horaSalida);
		int horasLlegada = getHoras(horaLlegada);
		int minutosSalida = getMinutos(horaSalida);
		int minutosLlegada = getMinutos(horaLlegada);
		
		int SalidaEnMinutos = (horasSalida*60) + minutosSalida;
		int LlegadaEnMinutos = (horasLlegada*60) + minutosLlegada;
		
		int duracionMinutos = 0;
		
		if (horasSalida <= horasLlegada) {
			
			duracionMinutos = LlegadaEnMinutos - SalidaEnMinutos; 
		}
		else if (horasSalida > horasLlegada) {
			
			int Llegada = (24*60) + LlegadaEnMinutos;
			int Salida = SalidaEnMinutos;
			
			duracionMinutos = Llegada - Salida;
		}
		else if (this.horaSalida == this.horaLlegada) {
			
			duracionMinutos = 24*60;
		}
		
		return duracionMinutos;
	}

    /**
     * Dada una cadena con una hora y minutos, retorna los minutos.
     * 
     * Por ejemplo, para la cadena '715' retorna 15.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de minutos entre 0 y 59
     */
    public static int getMinutos( String horaCompleta )
    {
        int minutos = Integer.parseInt( horaCompleta ) % 100;
        return minutos;
    }

    /**
     * Dada una cadena con una hora y minutos, retorna las horas.
     * 
     * Por ejemplo, para la cadena '715' retorna 7.
     * @param horaCompleta Una cadena con una hora, donde los minutos siempre ocupan los dos últimos caracteres
     * @return Una cantidad de horas entre 0 y 23
     */
    public static int getHoras( String horaCompleta )
    {
        int horas = Integer.parseInt( horaCompleta ) / 100;
        return horas;
    }

    
}
