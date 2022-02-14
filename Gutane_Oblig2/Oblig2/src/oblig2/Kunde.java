package oblig2;

/**
 * 
 * @author runar
 *
 */
public class Kunde {
	
	private String fornavn;
	private String etternavn;
	private Adresse adresse;
	private String tlf;
	
	/**
	 * Oppretter et kunde objekt
	 * @param fornavn
	 * @param etternavn
	 * @param adresse
	 * @param tlf
	 */
	public Kunde(String fornavn, String etternavn, Adresse adresse, String tlf) {
		super();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.tlf = tlf;
	}
	public Kunde () {
		
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	@Override
	public String toString() {
		return fornavn + " " + etternavn +" Tef: "+tlf;
	}
}
