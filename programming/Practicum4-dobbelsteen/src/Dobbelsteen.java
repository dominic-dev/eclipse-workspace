
public class Dobbelsteen {
    public String[] ogen = {
        "     \n"+
        "  *  \n"+
        "     ",

        "*    \n"+
        "     \n"+
        "    *",

        "*    \n"+
        "  *  \n"+
        "    *",

        "*   *\n"+
        "     \n"+
        "*   *",

        "*   *\n"+
        "  *  \n"+
        "*   *",

        "*   *\n"+
        "*   *\n"+
        "*   *"
    };

    public int gooi(){
        return (int) Math.round((Math.random() *5));
    }
	

}
