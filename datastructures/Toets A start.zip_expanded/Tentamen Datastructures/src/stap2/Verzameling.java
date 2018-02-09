package stap2;

/**
 * Generic Verzameling
 * 
 * @author dominic & MiW
 **/

import java.util.ArrayList;

public class Verzameling<E> {
	private ArrayList<E> contents;

	public Verzameling(){
		contents = new ArrayList<E>();
	}

	/**
	 * Return true als de verzameling het gegeven object bevat.
	 * @return true als, en alleen als, de verzameling het gegeven object bevat.
	 **/
	public boolean bevat(E e) {
		return contents.contains(e);
	}

	/**
	 * Voeg een element toe aan de verzameling.
	 * @param e het toe te voegen element.
	 **/
	public void voegToe(E e) {
		if (!bevat(e)) contents.add(e);
	}

	/**
	 * Verwijder een element van de verzameling.
	 * @param e het te verwijderen element.
	 **/
	public void verwijder(E e) {
		if (bevat(e)) contents.remove(e);
	}

	/**
	 * Voeg een array van elementen toe aan de verzameling.
	 * @param elts de elementen.
	 **/
	public void voegRijToe(E[] elts) {
		for(E e : elts) voegToe(e);
	}

	/**
	 * Return een array van alle elementen in de verzameling.
	 * @return alle elementen.
	 **/
	@SuppressWarnings("unchecked")
	public E[] alleElementen() {
		E[] result = (E[]) new Object[contents.size()];
		for(int i=0; i<contents.size(); i++){
			result[i] = (E) contents.get(i);
		}
		return result;
	}

	/**
	 * Return de gegeven verzameling met de huidige verzameling 
	 * verenigd in een nieuwe verzameling
	 * @param verzameling2 de gegeven verzameling.
	 * @return de verenigde verzameling.
	 **/
	public Verzameling<E> vereniging (Verzameling<E> verzameling2){
		Verzameling<E> result = new Verzameling<>();
		result.voegRijToe(alleElementen());
		result.voegRijToe(verzameling2.alleElementen());
		return result;
	}

	@Override
	public String toString(){
		String result = "[";
		int size = contents.size();
		if(size > 0){
			result +=  contents.get(0);
		}
		if(size > 0){
			for(int i=1; i<size; i++){
				result += ", " + contents.get(i);
			}
		}
		result += "]";
		return result;
	}
}
