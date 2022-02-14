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
	 * Starter et brukergensesnitt som tar imot et selskap
	 */
	public void start(Firma firma) {

		/**
		 * 
		 * Mulighet til og legge inn test objekter
		 */
		String options[] = { "yes", "no" };
		int test = JOptionPane.showOptionDialog(null,
				"legg til noen eksempel objekter?\n2 kontor (Stavanger,Bergen)\n3 biler (VW,Volvo i Stavanger, Tesla i Bergen"
						+ "\n2 Testkunder",
				"Eksempler?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
		if (test == 0) {
			TestObjekter.testKontor(firma);
			TestObjekter.giTestBilerTilkontor(firma);
			TestObjekter.testKunder(firma);			
		}

		String knapper[] = { "Firma", "Kontor", "Kunde", "Avslutt" };

		while (true) {
			int valg = JOptionPane.showOptionDialog(null, "Velg", firma.getNavn(), JOptionPane.YES_NO_CANCEL_OPTION,
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
					int firmavalg = JOptionPane.showOptionDialog(null, "Firma Valg", firma.getNavn(),
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, firmaknapper, 0);

					// Opprett utleige kontor
					if (firmavalg == 0) {

						firma.setUtleigekontor(firma.OpprettKontor(firma.getUtleigekontor(), firma));
						// utskrift av alle kontor til firma
						System.out.println("Alle registrerte kontor:");
						firma.getUtleigekontor().forEach(e -> System.out.println(e.toString()));
					}
					// Registrer ny bil
					else if (firmavalg == 1) {
						Bil bil = firma.regNyBil();
						FirmaValgHjelp.giBilTilKontor(firma, bil);
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
				if (firma.getUtleigekontor().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ingen Kontor er registrert");
				} else {
					// laster inn knapper fra list til array
					String[] kontorer = new String[firma.getUtleigekontor().size()];
					for (int i = 0; i < firma.getUtleigekontor().size(); i++) {
						kontorer[i] = firma.getUtleigekontor().get(i).getNavn();
					}

					int kontorNR = JOptionPane.showOptionDialog(null, "Velg kontor", firma.getNavn(),
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kontorer, 0);

					/*
					 * velger valgt kontor ut ifra kontorNR
					 */
					UtleigeKontor aktiv = firma.getUtleigekontor().get(kontorNR);
					boolean kontoraktiv = true;
					String kontorknapper[] = { "Reg. en ny kunde", "Leig ut en bil", "Reg. en bil som er kommt i retur",
							"Vis biler ved kontor: " + aktiv.getNavn(), "Tilbake" };

					while (kontoraktiv) {
						int kontorvalg = JOptionPane.showOptionDialog(null, "Kontor Valg",
								firma.getUtleigekontor().get(kontorNR).getNavn(), JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null, kontorknapper, 0);
						// Registrer en kunde
						if (kontorvalg == 0) {

							KontorValgHjelp.regNyKunde(aktiv.getFirma());

							// Bekreftelse av registrering
							System.out.println(
									"Ny kunde registrert av kontor: " + firma.getUtleigekontor().get(kontorNR).getNavn()
											+ "\nKundens navn: " + aktiv.getFirma().getLast().toString() + "\n");

							// Leiger/leverer ut en bil til en kunde fysisk ved valgt konotor
						} else if (kontorvalg == 1) {
							KontorValgHjelp.leiUt(aktiv);

							// Reg en bil levert tilbake fra en kunde og hent faktura
						} else if (kontorvalg == 2) {
							KontorValgHjelp.retur(aktiv, firma);

							// Vis biler hos kontoret
						} else if (kontorvalg == 3) {
							KontorValgHjelp.visKontorBiler(aktiv);

							// tilbake
						} else if (kontorvalg == 4 || kontorvalg == -1) {
							kontoraktiv = false;
						}
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

					// Se alle ledige biler
					if (kundevalg == 0) {
						KundeValgHjelp.visAlleBiler(firma);
					}
					// Leig en bil
					else if (kundevalg == 1) {

						// see for deg at du leiger en bil via internett
						String[] kontorer = new String[firma.getUtleigekontor().size()];
						for (int i = 0; i < firma.getUtleigekontor().size(); i++) {
							kontorer[i] = firma.getUtleigekontor().get(i).getNavn();
						}

						int kontorNR = JOptionPane.showOptionDialog(null, "Velg kontor", firma.getNavn(),
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kontorer, 0);

						/*
						 * velger valgt kontor ut ifra kontorNR og leiger ut bil
						 */
						UtleigeKontor aktiv = firma.getUtleigekontor().get(kontorNR);
						KontorValgHjelp.leiUt(aktiv);
					}
					// Lever tilbake en bil og motta rekning
					else if (kundevalg == 2) {

						// Leverer bilen inn til et valgt kontor og mottar en regning
						String[] kontorer = new String[firma.getUtleigekontor().size()];
						for (int i = 0; i < firma.getUtleigekontor().size(); i++) {
							kontorer[i] = firma.getUtleigekontor().get(i).getNavn();
						}

						int kontorNR = JOptionPane.showOptionDialog(null, "Velg kontor", firma.getNavn(),
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kontorer, 0);

						/*
						 * velger valgt kontor ut ifra kontorNR
						 */
						UtleigeKontor aktiv = firma.getUtleigekontor().get(kontorNR);
						KontorValgHjelp.retur(aktiv, firma);
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
