package stap4;

import java.io.Serializable;

public class Dier implements Serializable {
	
	private String soort;
	private double gewicht;
	private int aaibaarheidsfactor;
	
	public Dier(String soort, double gewicht, int aaibaarheidsfactor) {
		super();
		this.soort = soort;
		this.gewicht = gewicht;
		this.aaibaarheidsfactor = aaibaarheidsfactor;
	}
	
	public String toString() {
		return "[ " + soort + ", " + gewicht + ", " + aaibaarheidsfactor + "]";
	}
	
}
