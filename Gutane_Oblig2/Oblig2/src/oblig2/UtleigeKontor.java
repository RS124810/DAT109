package oblig2;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gruppe 4 2.4 Runar Straume, Ørjan Meling Skårnes, Sander Aasen
 *         Skønberg, Sanjith Shanmugarajah
 *
 */

public class UtleigeKontor {
	private int kontorNr;
	private String navn;
	private String tlf; // for enkelhet skyld ved bruker input, endret datatype til string
	private Adresse kontoradresse;
	private List<Bil> biler;
	//added kontor er en del av firma
	private Firma firma;


	/**
	 * 
	 * @param kontorNr
	 * @param tlf
	 * @param kontoradresse Oppretter et kontor objekt
	 */
	public UtleigeKontor(int kontorNr, String navn, String tlf, Adresse kontoradresse, Firma firma) {

		this.kontorNr = kontorNr;
		this.navn = navn;
		this.tlf = tlf;
		this.kontoradresse = kontoradresse;
		this.biler = new ArrayList<Bil>();
		this.firma = firma;
	}
	public Firma getFirma() {
		return firma;
	}
	public void setFirma(Firma firma) {
		this.firma = firma;
	}
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}

	/**
	 * tom kontruktor til JPA
	 */
	public UtleigeKontor() {

	}

	public int getKontorNr() {
		return kontorNr;
	}

	public void setKontorNr(int kontorNr) {
		this.kontorNr = kontorNr;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	@Override
	public String toString() {
		return "UtleigeKontor ble lagt til:\nKontor Nr: " + kontorNr + ", navn: " + navn + ", tlf: " + tlf
				+ kontoradresse.toString()+"\n";
	}

	public Adresse getKontoradresse() {
		return kontoradresse;
	}

	public void setKontoradresse(Adresse kontoradresse) {
		this.kontoradresse = kontoradresse;
	}

	public List<Bil> getBiler() {
		return biler;
	}

	public void setBiler(List<Bil> biler) {
		this.biler = biler;
	}
	public void addBil(Bil b) {
		biler.add(b);
	}
}
