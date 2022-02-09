package oblig2;

import javax.swing.JOptionPane;

/**
 * 
 * @author Gruppe 4 2.4 Runar Straume, Ørjan Meling Skårnes, Sander Aasen
 *         Skønberg, Sanjith Shanmugarajah
 *
 */

public class BrukerGrensesnitt {

	/**
	 * Starter et enkelt brukergensesnitt som tar imot et selskap
	 */
	public void start(Firma firma) {

		String knapper[] = { "Firma", "Kontor", "Kunde", "Avslutt" };

		while (true) {
			int valg = JOptionPane.showOptionDialog(null, "Velg", "Firma navn", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, knapper, 0);

			/*
			 * avslutt/exit
			 */
			if (valg == -1 || valg == 3) {
				System.exit(0);
			}
			/*
			 * Firma
			 */
			else if (valg == 0) {
				boolean firmaaktiv = true;
				String firmaknapper[] = { "Opprett Utleige kontor", "Registrer ny bil", "Tilbake" };

				while (firmaaktiv) {
					int firmavalg = JOptionPane.showOptionDialog(null, "Firma Valg", "Firma navn",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, firmaknapper, 0);

					// Opprett utleige kontor
					if (firmavalg == 0) {
						// TODO
						firma.setUtleigekontor(firma.OpprettKontor(firma.getUtleigekontor())/* + nytt kontor */);
						firma.getUtleigekontor().forEach(e -> System.out
								.println("Kontor nr: " + e.getKontorNr() + ", Adresse  " + e.getKontoradresse().getPostnr()));

					}
					// Registrer ny bil
					else if (firmavalg == 1) {
						// TODO

					}
					// tilbake
					else if (firmavalg == 2 || firmavalg == -1) {
						firmaaktiv = false;
					}
				}

			}
			/*
			 * Kontor
			 */
			else if (valg == 1) {
				/*
				 * Laster inn alle registrerte kontor fra en array
				 */

				// eksempel kontorer forenklet
				String kontorer[] = { "Bergen", "Stavanger", "Oslo" };
				// TODO

				int kontorNR = JOptionPane.showOptionDialog(null, "Velg kontor", "Firma navn",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kontorer, 0);

				// TODO
				/*
				 * velger valgt kontor ut ifra kontorNR
				 */

				boolean kontoraktiv = true;
				String kontorknapper[] = { "Reg. en ny kunde", "Leig ut en bil", "Reg. en bil som er kommt i retur",
						"Tilbake" };

				while (kontoraktiv) {
					int kontorvalg = JOptionPane.showOptionDialog(null, "Kontor Valg", "Kontor navn",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kontorknapper, 0);
					if (kontorvalg == 0) {
						// TODO
						// Registrer en ny kunde
					} else if (kontorvalg == 1) {
						// TODO
						// Leiger/leverer ut en bil til en kunde fysisk ved valgt konotor
					} else if (kontorvalg == 2) {
						// TODO
						// Reg en bil levert tilbake fra en kunde og hent faktura
					}
					// tilbake
					else if (kontorvalg == 3 || kontorvalg == -1) {
						kontoraktiv = false;
					}
				}
			}
			/*
			 * Kunde
			 */
			else if (valg == 2) {
				// kunde Kunde = new kunde (finn eksisterende kunde);
				boolean kundeaktiv = true;
				String kundeknapper[] = { "Se ledige biler", "Leig en bil", "Lever tilbake en bil", "Tilbake" };

				while (kundeaktiv) {
					int kundevalg = JOptionPane.showOptionDialog(null, "Kunde Valg", "Kunde navn",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kundeknapper, 0);

					// Se ledige biler
					if (kundevalg == 0) {
						// TODO
						// vis ledige biler og hvilket kontor der kan hentes paa

					}
					// Leig en bil
					else if (kundevalg == 1) {
						// TODO
						// see for deg at du leiger en bil via internett

					}
					// Lever tilbake en bil og motta rekning
					else if (kundevalg == 2) {
						// TODO
						// Leverer bilen inn til et valgt kontor og mottar en regning
						JOptionPane.showMessageDialog(null,
								"Takk for at du valgte vårt utleige selskap\n Din rekning ble på kr 8000,-");
					}
					// tilbake
					else if (kundevalg == 3 || kundevalg == -1) {
						kundeaktiv = false;
					}
				}

			}
		}
	}
}
