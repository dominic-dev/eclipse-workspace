/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author huub
 */
public class NatuurlijkPersoon extends BetrokkenPartij{

    public final int KREDIET_THRESHOLD = 6; 
	private int bsn;
	private int kredietwaardigheid;

    public NatuurlijkPersoon(int bsn, int kredietwaardigheid, String naam, Contract contract) {
        super(naam, contract);
		this.bsn = bsn;
		this.kredietwaardigheid = kredietwaardigheid;
    }

	public int getBsn() {
    	return bsn;
	}

	public void setKredietwaardigheid(int kredietwaardigheid) {
    	this.kredietwaardigheid = kredietwaardigheid;
	}

	public int getKredietwaardigheid() {
    	return kredietwaardigheid;
	}

    @Override
    public boolean isBetrouwbaar(){
        return  super.isBetrouwbaar() && kredietwaardigheid > KREDIET_THRESHOLD;
    }

    @Override
    public String toString(){
        String betrouwbaar = this.isBetrouwbaar() ? "WEL" : "NIET";
        return String.format("%s, bsn: %d, %s (%s betrouwbaar)", naam, bsn, this.contract.getType(), betrouwbaar);
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof NatuurlijkPersoon){
            return this.getBsn() == ((NatuurlijkPersoon) other).getBsn();
        }
        return false;
    }

}
