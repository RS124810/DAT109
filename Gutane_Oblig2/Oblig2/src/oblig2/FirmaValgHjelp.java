package oblig2;

import java.util.List;

import javax.swing.JOptionPane;
/**
 * 
 * @author runar
 *	Hjelpeklasse til brukergrensesnitt
 */

public class FirmaValgHjelp {
	
	/**
	 * Gir en bil til et valgt kontor
	 * @param firma
	 * @param bil
	 */
	
	public static void giBilTilKontor(Firma firma, Bil bil) {

		if (firma.getUtleigekontor().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingen Kontor er registrert");
		} else {
			// laster inn knapper fra list til array
			String[] kontorer = new String[firma.getUtleigekontor().size()];
			for (int i = 0; i < firma.getUtleigekontor().size(); i++) {
				kontorer[i] = firma.getUtleigekontor().get(i).getNavn();
			}

			int kontorNR = JOptionPane.showOptionDialog(null, "Velg kontor", "Firma navn",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kontorer, 0);
			firma.getUtleigekontor().get(kontorNR).addBil(bil);
			bil.setLedig(firma.getUtleigekontor().get(kontorNR));
			bil.setErLedig(true);
			System.out.println(bil.toString());
		}
	}
	
	/*
	 * oppretter nytt kontor
	 */
	public static List<UtleigeKontor> OpprettKontor(List<UtleigeKontor> utleigekontor, Firma firma) {
		
		int kontorNr = 0;
		List<UtleigeKontor> nylist = utleigekontor;
		if (utleigekontor != null) {
			kontorNr = nylist.size() + 1;
		}

		String navn = JOptionPane.showInputDialog("Skriv inn navn til kontoret:");
		String tlf = JOptionPane.showInputDialog("Skriv inn telefon nr:");
		String gateAdresse = JOptionPane.showInputDialog("Skriv inn gate adresse:");
		String postnr = JOptionPane.showInputDialog("post nummer? ");
		String poststed = JOptionPane.showInputDialog("Poststed? ");
		Adresse adresse = new Adresse(gateAdresse, postnr, poststed);
		UtleigeKontor nyttkontor = new UtleigeKontor(kontorNr, navn, tlf, adresse, firma);
		nylist.add(nyttkontor);
		return nylist;

	}
	
	/**
	 * Oppretter ny bil
	 * @return
	 */
	
	public static Bil regNyBil() {
		String registreringsNr = JOptionPane.showInputDialog("Skriv inn registrerings nummer");
		String merke = JOptionPane.showInputDialog("Merke?");
		String modell = JOptionPane.showInputDialog("Modell?");
		String farge = JOptionPane.showInputDialog("Farge?");
		Utleigegruppe gruppe = null;
		//valg av prisgruppe
		String knapper[] = { "A", "B", "C","D" };
		int klassevalg = JOptionPane.showOptionDialog(null, "Hvilken pris gruppe?\nA = liten bil"
				+ "\nB = mellomstor bil\nC = stor bil\nD = stasjonsvogn", "Firma navn",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, knapper, 0);
		
		if(klassevalg == 0) {
			 gruppe = A();
		}else if (klassevalg == 1) {
			 gruppe = B();
		}else if (klassevalg ==2) {
			 gruppe = C();
		}else if (klassevalg == 3) {
			 gruppe = D();	
		}
		// For enkelhetsskyld har en ny bil ikke brukt noe kilometerstand
		int kilometerstand = 0;

		return new Bil(registreringsNr, merke, modell, farge, gruppe, null, kilometerstand, null);
		
	}
	
	/**
	 * Oppretter utleigegrupper
	 * @return
	 */
	// Klassifisering av Utleigegrupper
	private static final Utleigegruppe A() {
		return new Utleigegruppe("A", "liten bil", 1000);
	}

	private static final Utleigegruppe B() {
		return new Utleigegruppe("B", "mellomstor bil", 1500);
	}

	private static final Utleigegruppe C() {
		return new Utleigegruppe("C", "stor bil", 2000);
	}

	private static final Utleigegruppe D() {
		return new Utleigegruppe("D", "stasjonsvogn", 2500);
	}


}
