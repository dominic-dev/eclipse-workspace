package stap4;

/**
 * Lees dieren in vanuit een bestand en print ze naar std out
 * 
 * @author dominic
 **/

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Dierentuin {
	private final String PATH = "artis.dat";

	public Dierentuin() {
	}

	// Vraag 4.3
	public static void main(String[] args) {
		Dierentuin artis = new Dierentuin();
		artis.run();
	}

	/**
	 * Lees het bestand in PATH, en druk alle Dier objecten
	 * in de file af naar std out.
	 **/
	public void run(){
		try {
			// Lees het bestand.
			ArrayList<Dier> dieren = readFile(PATH);
			// Vraag 4.1
			System.out.println(String.format("De file bevat %d dieren.", dieren.size()));
			for(Dier dier : dieren){
				// Vraag 4.2
				System.out.println(dier);
			}
		} catch (FileNotFoundException e) {
			System.out.println(String.format("Het bestand \"%s\" is niet gevonden.", PATH));
		} catch (IOException e) {
			System.out.println(String.format("Er ging iets mis met het lezen van het bestand \"%s\".", PATH));
		}
	}

	/**
	 * Lees objecten van het type Dier in van het gespecificeerd bestand.
	 * @param path het bestandspad
	 * @return de lijst met dieren
	 * @throws FileNotFoundException 
	 * @throws IOException
	 **/
	public ArrayList<Dier> readFile(String path) throws FileNotFoundException, IOException {
		ArrayList<Dier> result = new ArrayList<>();
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream dis = new ObjectInputStream(fis);
		boolean eof = false;
		// Totdat het einde van het bestand bereikt is.
		while(!eof){
			try {
				// Lees het object en cast naar Dier.
				Dier d = (Dier) dis.readObject();
				// Voeg toe aan resultaat: result
				result.add(d);
			} catch(EOFException e){
				eof = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		dis.close();
		fis.close();
		return result;

	}

}
