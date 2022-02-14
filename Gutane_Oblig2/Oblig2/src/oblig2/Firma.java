package oblig2;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author Gruppe 4 2.4 Runar Straume, Ørjan Meling Skårnes, Sander Aasen
 *         Skønberg, Sanjith Shanmugarajah
 *
 */
public class Firma {

	private String navn;
	private int tlf;
	private Adresse adresse;
	private List<UtleigeKontor> utleigekontorer;
	private List<Kunde> kunder;

	public List<Kunde> getKunder() {
		return kunder;
	}

	public void setKunder(List<Kunde> kunder) {
		this.kunder = kunder;
	}

	/**
	 * Oppretter et firma objekt
	 * 
	 * @param navn
	 * @param tlf
	 * @param adresse
	 */
	public Firma(String navn, int tlf, Adresse adresse) {

		this.navn = navn;
		this.tlf = tlf;
		this.adresse = adresse;
		this.utleigekontorer = new ArrayList<UtleigeKontor>();
		this.kunder = new ArrayList<Kunde>();
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getTlf() {
		return tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<UtleigeKontor> getUtleigekontor() {
		return utleigekontorer;
	}

	public void setUtleigekontor(List<UtleigeKontor> utleigekontorer) {
		this.utleigekontorer = utleigekontorer;
	}

	public void addUtleigekontor(UtleigeKontor a) {
		utleigekontorer.add(a);
	}

	public void addKunde(Kunde kunde) {
		kunder.add(kunde);
	}

	public Kunde getLast() {
		return kunder.get(kunder.size() - 1);
	}

	/**
	 * tom kontruktor til JPA
	 */
	public Firma() {

	}

	/**
	 * Oppretter et nytt kontor og legger det inn en liste av eksisterende kontor
	 */
	public List<UtleigeKontor> OpprettKontor(List<UtleigeKontor> utleigekontor, Firma firma) {
		return FirmaValgHjelp.OpprettKontor(utleigekontor, firma);
	}

	/**
	 * Oppretter en ny bil
	 */
	public Bil regNyBil() {
		return FirmaValgHjelp.regNyBil();
	}
}
