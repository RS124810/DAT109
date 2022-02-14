package oblig2;

/**
 * 
 * @author runar 
 * Test objekter for enklre testing/eksempelkoering
 */
public class TestObjekter {

	// Gir hvert kontor noen test biler
	public static void giTestBilerTilkontor(Firma firma) {
		Utleigegruppe A = new Utleigegruppe("A", "liten bil", 1000);
		Utleigegruppe B = new Utleigegruppe("B", "mellom stor bil", 1500);
		Utleigegruppe C = new Utleigegruppe("C", "stor bil", 2000);
		Bil bil1 = new Bil("SV 44355", "VW", "Golf", "Gul", A, null, 0, null);
		Bil bil2 = new Bil("TV 98765", "Tesla", "Model S", "Svart", C, null, 0, null);
		Bil bil3 = new Bil("SV 33333", "Volvo", "360", "Kvit", B, null, 0, null);
		firma.getUtleigekontor().get(0).addBil(bil1);
		bil1.setLedig(firma.getUtleigekontor().get(0));
		firma.getUtleigekontor().get(1).addBil(bil2);
		bil2.setLedig(firma.getUtleigekontor().get(1));
		firma.getUtleigekontor().get(0).addBil(bil3);
		bil3.setLedig(firma.getUtleigekontor().get(0));
		System.out.println(bil1.toString());
		System.out.println(bil2.toString());
		System.out.println(bil3.toString());

	}
	
	// Oppretter 2 test kunder
	public static void testKunder(Firma firma) {
		String fornavn = "Per";
		String etternavn = "Persen";
		String tlf = "11 11 11 11";
		Adresse adresse = new Adresse("Bryggen 3", "4060", "Stavanger");

		Kunde kunde = new Kunde(fornavn, etternavn, adresse, tlf);
		firma.addKunde(kunde);

		fornavn = "Mia";
		etternavn = "Andersen";
		tlf = "222 22 222";
		adresse = new Adresse("Flatevad 19", "5118", "Ulseth");

		kunde = new Kunde(fornavn, etternavn, adresse, tlf);
		firma.addKunde(kunde);

		System.out.println("\nAlle registrerte kunder:");
		for (int i = 0; i < firma.getKunder().size(); i++) {
			System.out.println(firma.getKunder().get(i));
		}
		System.out.println();

	}
	/**
	 * Test metode som legger til noen dummy kontor
	 * 
	 * @param firma
	 */
	public static void testKontor(Firma firma) {

		Adresse adresse1 = new Adresse("Bryggen 3", "4012", "Stavanger");
		Adresse adresse2 = new Adresse("Danmarkplass 3", "5043", "Bergen");
		UtleigeKontor nyttkontor1 = new UtleigeKontor(1, "Stavanger", "58 96 80 80", adresse1, firma);
		UtleigeKontor nyttkontor2 = new UtleigeKontor(2, "Bergen", "56 56 60 60", adresse2,firma);
		firma.addUtleigekontor(nyttkontor1);
		firma.addUtleigekontor(nyttkontor2);
		
		firma.getUtleigekontor().forEach(e -> System.out.println(e.toString()));
	}
}
