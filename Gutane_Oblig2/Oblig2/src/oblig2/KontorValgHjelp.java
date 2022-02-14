package oblig2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * 
 * @author runar Hjelpeklasse til brukergrensenitt
 *
 */

public class KontorValgHjelp {

	/**
	 * 
	 * @param firma Registrer ny kunde via et kontor
	 */
	public static void regNyKunde(Firma firma) {

		String fornavn = JOptionPane.showInputDialog("Fornavn:");
		String etternavn = JOptionPane.showInputDialog("Etternavn:");
		String tlf = JOptionPane.showInputDialog("Telefon nummer:");
		Adresse adresse = new Adresse(JOptionPane.showInputDialog("Gateadresse:"),
				JOptionPane.showInputDialog("Post nummer:"), JOptionPane.showInputDialog("Poststed:"));

		Kunde kunde = new Kunde(fornavn, etternavn, adresse, tlf);
		firma.addKunde(kunde);
		System.out.println("Alle registrerte kunder:");
		for (int i = 0; i < firma.getKunder().size(); i++) {
			System.out.println(firma.getKunder().get(i));
		}
		System.out.println();
	}

	/**
	 * viser alle ledige biler ved et kontor
	 * 
	 * @param aktiv
	 */
	public static void visKontorBiler(UtleigeKontor aktiv) {
		if (aktiv.getBiler().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingen ledige biler er ved kontoret");
		} else {
			List<Bil> biler = aktiv.getBiler();
			String ledigeBiler = "Ledige biler ved kontor: " + aktiv.getNavn() + "\n";

			for (int i = 0; i < biler.size(); i++) {
				if (biler.get(i).getErLedig()) {
					ledigeBiler += "\n" + biler.get(i).toString();
				}
			}
			JOptionPane.showMessageDialog(null, ledigeBiler);
		}
	}

	/**
	 * Leiger ut en bil via et kontor
	 * 
	 * @param aktiv
	 */
	public static void leiUt(UtleigeKontor aktiv) {

		// henter biler og lager en knapp for hvert registerings nr
		if (aktiv.getBiler().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingen ledige biler er ved kontoret");
		} else {
			// laster inn knapper fra list til array
			List<Bil> erLedig = new ArrayList<Bil>();
			String[] ledigeBiler = new String[aktiv.getBiler().size()];
			for (int i = 0; i < aktiv.getBiler().size(); i++) {
				if (aktiv.getBiler().get(i).getErLedig()) {
					ledigeBiler[i] = aktiv.getBiler().get(i).getRegistrersnr() + " "
							+ aktiv.getBiler().get(i).getMerke();
					erLedig.add(aktiv.getBiler().get(i));
				} else {
					ledigeBiler[i] = "Ikke ledig";
				}
			}
			if (erLedig.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ingen ledige biler er ved kontoret");
			} else {
				int bilIndex = JOptionPane.showOptionDialog(null, "Velg bil", aktiv.getNavn(),
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ledigeBiler, 0);
				Bil bil = aktiv.getBiler().get(bilIndex);

				System.out.println("valgt bil: " + bil.toString());

				Kunde kunde = new Kunde();
				List<Kunde> alleKunder = aktiv.getFirma().getKunder();
				// sok kunde etter tlf
				boolean kundefunnet = false;

				while (!kundefunnet) {
					String tlf = JOptionPane.showInputDialog("Kundens tlf:");
					for (int i = 0; i < alleKunder.size(); i++) {
						if (alleKunder.get(i).getTlf().equals(tlf)) {
							kunde = alleKunder.get(i);
							kundefunnet = true;
						}
					}
					if (!kundefunnet)
						JOptionPane.showMessageDialog(null, ("Ingen Kunde funnet, prov igjen"));

				}

				System.out.println(kunde.toString());

				String kredittKort = JOptionPane.showInputDialog("Kundens kredittkortnr");
				String options[] = { "yes", "no" };
				int r = JOptionPane.showOptionDialog(null, "Registrer forventet retur?", "forventet retur",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
				Dato retur = new Dato(LocalDate.now(), LocalTime.now().withNano(0));
				if (r == 0) {
					int year = Integer.parseInt(JOptionPane.showInputDialog("Retur arr? (yyyy)"));
					int month = Integer.parseInt(JOptionPane.showInputDialog("Retur maaned? (mm)"));
					int dayOfMonth = Integer.parseInt(JOptionPane.showInputDialog("Retur dag? (dd)"));
					LocalTime returKlokke = LocalTime.now().withNano(0);
					LocalDate returDato = LocalDate.of(year, month, dayOfMonth);
					retur = new Dato(returDato, returKlokke);
				}

				// Dagspris for og forenkle retur tid klokke
				Dato startDato = new Dato(LocalDate.now(), LocalTime.now().withNano(0));

				Utleige kontrakt = new Utleige(kunde, bil.getKilometerstand(), startDato, kredittKort, retur);

				bil.setKontrakt(kontrakt);
				bil.setErLedig(false);
				JOptionPane.showMessageDialog(null, "Ordre registret: " + bil.getRegistrersnr() + ", kunde: "
						+ kontrakt.getKunde().toString() + ", fra dato: " + kontrakt.getStartDato().toString()
						+ "\nBilen hentes ved kontor: "+aktiv.getNavn());
				System.out.println(kontrakt.toString());
				System.out.println(bil.toString());
			}
		}
	}

	public static void retur(UtleigeKontor aktiv, Firma firma) {

		if (firma.getUtleigekontor().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Ingen Kontor er registrert");
		} else {
			// laster inn knapper fra list til array
			String[] kontorer = new String[firma.getUtleigekontor().size()];
			for (int i = 0; i < firma.getUtleigekontor().size(); i++) {
				kontorer[i] = firma.getUtleigekontor().get(i).getNavn();
			}

			int kontorNR = JOptionPane.showOptionDialog(null, "Hvilke kontor ble bilen leid fra?", firma.getNavn(),
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, kontorer, 0);

			/*
			 * velger valgt kontor ut ifra kontorNR
			 */
			UtleigeKontor bilkomfra = firma.getUtleigekontor().get(kontorNR);
			boolean utleigefinnes = false;

			String[] ubiler = new String[bilkomfra.getBiler().size()];
			// logikk til og ta vare paa utleide bilers index
			int[] uIndex = new int[ubiler.length];
			int j = 0;
			if (bilkomfra.getBiler().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Ingen utleiger fra dette kontoret");
			} else {
				for (int i = 0; i < bilkomfra.getBiler().size(); i++) {
					if (!bilkomfra.getBiler().get(i).getErLedig()) {
						ubiler[i] = bilkomfra.getBiler().get(i).getRegistrersnr() + " "
								+ bilkomfra.getBiler().get(i).getMerke();
						uIndex[j] = i;
						j++;
						utleigefinnes = true;
					} else {
						ubiler[i] = "X";
					}
				}
				// Trimmer string arrayen for null verider (X)
				int count = 0;
				for (String i : ubiler) {
					if (!i.equals("X"))
						count++;
				}
				int index = 0;
				String[] Ubiler = new String[count];
				for (String i : ubiler) {
					if (!i.equals("X"))
						Ubiler[index++] = i;
				}

				
				// finner utleigd bil fra listen av biler der bilen ble leid.
				if (!utleigefinnes) {
					JOptionPane.showMessageDialog(null, "Ingen utleiger fra dette kontoret");
				} else {
					int bilIndex = JOptionPane.showOptionDialog(null, "Velg bilens Reg nr", "Utleide biler fra " + bilkomfra.getNavn(),
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Ubiler, 0);
					bilIndex = uIndex[bilIndex];

					System.out.println(bilIndex);

					Bil bil = bilkomfra.getBiler().get(bilIndex);
					Utleige kontrakt = bil.getKontrakt();

					System.out.println("valgt bil: " + bil.toString());

					int year = Integer.parseInt(JOptionPane.showInputDialog("Retur arr? (yyyy)"));
					int month = Integer.parseInt(JOptionPane.showInputDialog("Retur maaned? (mm)"));
					int dayOfMonth = Integer.parseInt(JOptionPane.showInputDialog("Retur dag? (dd)"));
					// Dagspris for og forenkle retur tid klokke
					LocalTime returKlokke = LocalTime.now().withNano(0);
					LocalDate returDato = LocalDate.of(year, month, dayOfMonth);
					Dato regRetur = new Dato(returDato, returKlokke);
					int nyKilometerstand = Integer.parseInt(JOptionPane.showInputDialog("Ny kilometerstand (int)"));

					Retur retur = new Retur(regRetur, nyKilometerstand, 0);
					retur.beregnRegning(bil, kontrakt, retur);

					JOptionPane.showMessageDialog(null,
							kontrakt.getKunde().toString() + "\nDin rekning ble på kr " + retur.getRegning()
									+ "\nLeid i " + (retur.getRegning() / bil.getGruppe().getDoegnpris())
									+ " dager, a pris pr. dag kr " + bil.getGruppe().getDoegnpris());

					bil.setErLedig(true);
					bil.setLedig(aktiv);
					aktiv.getBiler().add(bil);
					bilkomfra.getBiler().remove(bilIndex);
					bil.setKontrakt(null);
					bil.setKilometerstand(nyKilometerstand);
				}
			}
		}
	}

}
