package nl.hva.bos;

public class BinaireBoom {
  
  private BinaireBoom links;
  private int waarde;
  private BinaireBoom rechts;
  
  public BinaireBoom(BinaireBoom l, int w, BinaireBoom r) {
    super();
    links = l;
    waarde = w;
    rechts = r;
  }
  
  public BinaireBoom(int w) {
    this(null, w, null);
  }
    
  public boolean isBlad() {
    return ( links == null && rechts == null );
  }

  public int som() {
    return ( links != null ? links.som() : 0 ) + waarde + ( rechts != null ? rechts.som() : 0 );
  }
  
  public int telKnopen() {
    return ( links != null ? links.telKnopen() : 0 ) + 1 + ( rechts != null ? rechts.telKnopen() : 0 );
  }
  
  public boolean voegKnoopToe(int w) {
    if ( w == waarde ) {
      return false; // De waarde w komt al voor in de boom en hoeft dus niet nogmaals te worden toegevoegd
    }
    if ( w < waarde ) {
      if ( links != null ) {
        return links.voegKnoopToe(w);
      }
      links = new BinaireBoom(w);
      return true;
    } else {
      if ( rechts != null ) {
        return rechts.voegKnoopToe(w);
      }
      rechts = new BinaireBoom(w);
      return true;
    }
  }
  
  public static BinaireBoom maakBoom(int[] waarden) {
    if ( waarden.length == 0 ) {
      return null;
    }
    BinaireBoom boom = new BinaireBoom(waarden[0]);
    for ( int i=1; i< waarden.length; i++ ) {
      boom.voegKnoopToe(waarden[i]);
    }
    return boom;
  }

  public boolean zoek(int n) {
    return ( links != null ? links.zoek(n) : false ) || waarde == n || ( rechts != null ? rechts.zoek(n) : false );
  }
  
  // Voor de het tentamen datastructuren moet deze methode worden gemaakt!
  public int diepte(int w) {
	  int d = 0;
	  if ( waarde == w ) {
		  d = 0;
	  } else if ( w < waarde ) {
		  d = (links != null ? links.diepte(w) : -1);
		  if ( d >= 0 ) {
			  d++;
		  }
	  } else {
		  d = (rechts != null ? rechts.diepte(w) : -1);
		  if ( d >= 0 ) {
			  d++;
		  }
	  }
	  return d;
  }

  public boolean equals(Object obj) {
    if ( obj instanceof BinaireBoom ) {
      BinaireBoom other = (BinaireBoom) obj;
      return this.waarde == other.waarde 
          && (this.links == null ? other.links == null : ( other.links != null && this.links.equals(other.links)))
          && (this.rechts == null ? other.rechts == null : ( other.rechts != null && this.rechts.equals(other.rechts)));
    } else return false;
  }

  public String toString() {
    StringBuffer buf = new StringBuffer("<");
    if ( links != null ) {
      buf.append(links.toString());
    } else {
      buf.append(" - ");
    }
    
    buf.append(" " + waarde + " ");
    
    if (rechts != null ) {
      buf.append(rechts.toString());
    } else {
      buf.append(" - ");
    }
    
    buf.append(">");
    return buf.toString();
  }

}
