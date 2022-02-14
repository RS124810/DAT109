package oblig2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Dato {
	

	private LocalDate dato;
	private LocalTime klokkeslett;

	/**
	 * Dato objekt bruker LocalDate (int yyyy, int mm, int dd) LocalTime (int hh,
	 * int dd, int ss) Angir man ugyldig verdi som 61 sekunder går det gale gyldig
	 * format er (0-23,0-59,0-59)
	 * 
	 * @param dato
	 * @param klokkeslett
	 */
	public Dato(LocalDate dato, LocalTime klokkeslett) {

		this.dato = dato;
		this.klokkeslett = klokkeslett;
	}

	public LocalDate getDato() {
		return dato;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public LocalTime getKlokkeslett() {
		return klokkeslett;
	}

	public void setKlokkeslett(LocalTime klokkeslett) {
		this.klokkeslett = klokkeslett;
	}
	@Override
	public String toString() {
		return  dato + ", klokkeslett: " + klokkeslett;
	}
	}

