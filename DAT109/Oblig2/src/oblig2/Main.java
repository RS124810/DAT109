package oblig2;
/**
 * 
 * @author Gruppe 4
 * 2.4 Runar Straume, �rjan Meling Sk�rnes, Sander Aasen Sk�nberg, Sanjith Shanmugarajah
 *
 */
public class Main {
	
	
	public static void main(String[] args) {
	
		BrukerGrensesnitt meny = new BrukerGrensesnitt();
		meny.start(OpprettFirma());
	}
	
	/**
	 * Oppretter kundens firma
	 */
	private static Firma OpprettFirma() {
		
		Adresse firmaAdresse = new Adresse ("Inndalsveien", 5063,"Bergen");
		Firma firma = new Firma ("HVL Gruppe 4", 55585800,firmaAdresse);
		
		return firma;
	}
}
