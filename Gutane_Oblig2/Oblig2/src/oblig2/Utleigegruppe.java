package oblig2;

public class Utleigegruppe {

	private String navn;
	private String beskrivelse;
	private int doegnpris;
	
	public Utleigegruppe(String navn, String beskrivelse, int doegnpris) {
		
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.doegnpris = doegnpris;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public int getDoegnpris() {
		return doegnpris;
	}

	public void setDoegnpris(int doegnpris) {
		this.doegnpris = doegnpris;
	}
	
}
