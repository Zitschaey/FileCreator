package main;

import java.io.File;

public class Creator {
	public static void main(String[] args) {

		String basisVerzeichnis = "C:\\Users\\CjVan\\OneDrive\\Alte Dateien\\Dokumente"; // Ändern Sie den Pfad entsprechend
		int ebenen = 3;
		int ordnerProEbene = 7;

		erstelleOrdner(basisVerzeichnis, ebenen, ordnerProEbene);
	}

	public static void erstelleOrdner(String basisVerzeichnis, int ebenen, int ordnerProEbene) {
		if (ebenen == 0) {
			return;
		}

		for (int i = 1; i <= ordnerProEbene; i++) {
			String ordnerName = String.format("%02dFolder", i);
			String ordnerPfad = basisVerzeichnis + "\\" + ordnerName;

			File ordner = new File(ordnerPfad);
			if (!ordner.exists()) {
				ordner.mkdir();
			}

			erstelleOrdner(ordnerPfad, ebenen - 1, ordnerProEbene);
		}
	}

}
