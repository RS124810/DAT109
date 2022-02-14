package oblig2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 * 
 * @author runar
 * retur objekt
 */
public class Retur {
	
	private Dato regReturDato;
	private int nyKilometerstand;
	private int regning;
	/**
	 * Retur objekt
	 * @param regReturDato
	 * @param nyKilometerstand
	 * @param regning
	 */
	public Retur(Dato regReturDato, int nyKilometerstand, int regning) {
		
		this.regReturDato = regReturDato;
		this.nyKilometerstand = nyKilometerstand;
		this.regning = regning;
	}

	public Dato getRegReturDato() {
		return regReturDato;
	}

	public void setRegReturDato(Dato regReturDato) {
		this.regReturDato = regReturDato;
	}

	public int getNyKilometerstand() {
		return nyKilometerstand;
	}

	public void setNyKilometerstand(int nyKilometerstand) {
		this.nyKilometerstand = nyKilometerstand;
	}

	public int getRegning() {
		return regning;
	}

	public void setRegning(int regning) {
		this.regning = regning;
	}
	public void beregnRegning(Bil bil,Utleige utleige, Retur retur) {
		int doegnpris = bil.getGruppe().getDoegnpris();
		LocalDate startDato = utleige.getStartDato().getDato();
		LocalDate ReturDato = retur.getRegReturDato().getDato();
		
		//differansen mellom to LocalDate objekt
		int diff =(int) ChronoUnit.DAYS.between(startDato, ReturDato);
		System.out.println("Bilen ble leid i: "+diff+" dager");
					
		//minimum leiepris er et doegn
		if (diff ==0 ) {
			diff += 1;
		}
		retur.setRegning(diff*doegnpris);
	}
}
