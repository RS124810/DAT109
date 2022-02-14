package oblig2;

public class Adresse {

	private String gateadresse;
	private String postnr;
	private String poststed;
	
	/**
	 * Oppretter en adresse
	 * @param gateadresse
	 * @param postnr
	 * @param poststed
	 */
	
	public Adresse(String gateadresse, String postnr, String poststed) {
		
		this.gateadresse = gateadresse;
		this.postnr = postnr;
		this.poststed = poststed;
	}
	
	@Override
	public String toString() {
		return "\nGateadresse: " + gateadresse + ", postnr: " + postnr + ", poststed: " + poststed + " ";
	}

	/**
	 * tom konstruktor til JPA
	 */
	public Adresse() {
		
	}

	public String getGateadresse() {
		return gateadresse;
	}

	public void setGateadresse(String gateadresse) {
		this.gateadresse = gateadresse;
	}

	public String getPostnr() {
		return postnr;
	}

	public void setPostnr(String postnr) {
		this.postnr = postnr;
	}

	public String getPoststed() {
		return poststed;
	}

	public void setPoststed(String poststed) {
		this.poststed = poststed;
	}
}
