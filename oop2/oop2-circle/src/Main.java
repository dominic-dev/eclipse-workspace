import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );

    public static void main(String[] args) {
        //LogManager.getLogManager().reset();
        LOGGER.log(Level.INFO, "test");
    }

}
