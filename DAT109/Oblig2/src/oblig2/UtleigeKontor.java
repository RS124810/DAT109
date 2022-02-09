package oblig2;

import java.util.List;

/**
 * 
 * @author Gruppe 4
 * 2.4 Runar Straume, Ørjan Meling Skårnes, Sander Aasen Skønberg, Sanjith Shanmugarajah
 *
 */

public class UtleigeKontor {
	private int kontorNr;
	private int tlf;
	private Adresse kontoradresse;
	private List<Bil> biler;
		
	/**
	 * 
	 * @param kontorNr
	 * @param tlf
	 * @param kontoradresse
	 * Oppretter et kontor objekt
	 */
	public UtleigeKontor(int kontorNr, int tlf, Adresse kontoradresse) {
		
		this.kontorNr = kontorNr;
		this.tlf = tlf;
		this.kontoradresse = kontoradresse;
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
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
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
}
