package oblig2;
/**
 * 
 * @author runar
 *
 */
public class Bil {
	
	private String registrersnr;
	private String merke;
	private String modell;
	private String farge;
	private Utleigegruppe gruppe;
	private UtleigeKontor ledig;
	private boolean erLedig;
	private int kilometerstand;
	private Utleige kontrakt;
	
	/**
	 * Bil objekt
	 * @param registrersnr
	 * @param merke
	 * @param modell
	 * @param farge
	 * @param gruppe
	 * @param ledig
	 * @param kilometerstand
	 * @param kontrakt
	 */
	public Bil(String registrersnr, String merke, String modell, String farge, Utleigegruppe gruppe,
			UtleigeKontor ledig, int kilometerstand, Utleige kontrakt) {
		
		this.registrersnr = registrersnr;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.gruppe = gruppe;
		this.ledig = ledig;
		this.erLedig = true;
		this.kilometerstand = kilometerstand;
		this.kontrakt = kontrakt;
	}

	public String getRegistrersnr() {
		return registrersnr;
	}

	public void setRegistrersnr(String registrersnr) {
		this.registrersnr = registrersnr;
	}

	public String getMerke() {
		return merke;
	}

	public void setMerke(String merke) {
		this.merke = merke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public Utleigegruppe getGruppe() {
		return gruppe;
	}

	public void setGruppe(Utleigegruppe gruppe) {
		this.gruppe = gruppe;
	}

	public UtleigeKontor getLedig() {
		return ledig;
	}

	public void setLedig(UtleigeKontor ledig) {
		this.ledig = ledig;
	}

	public boolean getErLedig() {
		return erLedig;
	}

	public void setErLedig(boolean erLedig) {
		this.erLedig = erLedig;
	}

	public int getKilometerstand() {
		return kilometerstand;
	}

	public void setKilometerstand(int kilometerstand) {
		this.kilometerstand = kilometerstand;
	}

	public Utleige getKontrakt() {
		return kontrakt;
	}

	public void setKontrakt(Utleige kontrakt) {
		this.kontrakt = kontrakt;
	}

	@Override
	public String toString() {
		return "Bil [registrersnr: " + registrersnr + ", merke: " + merke + ", modell: " + modell + ", farge: " + farge
				+ ", prisgruppe=" + gruppe.getNavn() + ", er ved kontor: " + ledig.getNavn() + ", kilometerstand="
				+ kilometerstand  + "]";
	}
	
}
