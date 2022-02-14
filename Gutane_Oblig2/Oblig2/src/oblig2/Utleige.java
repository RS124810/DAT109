package oblig2;

public class Utleige {
	
	private Kunde kunde;
	private int kilometerdandStart;
	private Dato startDato;
	private String kredittkort;
	private Dato forventetRetur;
	private Retur retur;
	
	/**
	 * 
	 * @param kunde
	 * @param kilometerdandStart
	 * @param startDato
	 * @param kredittkort
	 * @param forventetRetur
	 */
	public Utleige(Kunde kunde, int kilometerdandStart, Dato startDato, String kredittkort, Dato forventetRetur) {
		super();
		this.kunde = kunde;
		this.kilometerdandStart = kilometerdandStart;
		this.startDato = startDato;
		this.kredittkort = kredittkort;
		this.forventetRetur = forventetRetur;
		this.retur = null;
	}

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public int getKilometerdandStart() {
		return kilometerdandStart;
	}

	public void setKilometerdandStart(int kilometerdandStart) {
		this.kilometerdandStart = kilometerdandStart;
	}

	public Dato getStartDato() {
		return startDato;
	}

	public void setStartDato(Dato startDato) {
		this.startDato = startDato;
	}

	public String getKredittkort() {
		return kredittkort;
	}

	public void setKredittkort(String kredittkort) {
		this.kredittkort = kredittkort;
	}

	public Dato getForventetRetur() {
		return forventetRetur;
	}

	public void setForventetRetur(Dato forventetRetur) {
		this.forventetRetur = forventetRetur;
	}

	public Retur getRetur() {
		return retur;
	}

	public void setRetur(Retur retur) {
		this.retur = retur;
	}

	@Override
	public String toString() {
		return "Utleige [kunde=" + kunde.getTlf() + ", kilometerdandStart=" + kilometerdandStart + ", startDato=" + startDato.getDato()
				+ ", kredittkort=" + kredittkort + ", forventetRetur=" + forventetRetur.getDato() + ", retur=" + retur + "]";
	}
}
