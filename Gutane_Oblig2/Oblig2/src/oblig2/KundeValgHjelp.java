package oblig2;

import java.util.List;

import javax.swing.JOptionPane;

/**
 * 
 * @author runar
 *
 */

public class KundeValgHjelp {

	/**
	 * viser alle ledige biler til firma
	 * 
	 * @param firma
	 */

	public static void visAlleBiler(Firma firma) {

		String alleBiler = "Alle ledige biler:";
		List<UtleigeKontor> kontorer = firma.getUtleigekontor();

		for (int i = 0; i < kontorer.size(); i++) {
			List<Bil> biler = firma.getUtleigekontor().get(i).getBiler();
			alleBiler += "\n\nLedige biler som kan hentes ved kontor: " + firma.getUtleigekontor().get(i).getNavn()
					+ "\n";
			for (int j = 0; j < biler.size(); j++) {
				if (biler.get(j).getErLedig()) {
					alleBiler += "\n" + biler.get(j).toString();
				}
			}
		}
		JOptionPane.showMessageDialog(null, alleBiler);

	}

}
