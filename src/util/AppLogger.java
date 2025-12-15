package util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AppLogger {

    private static final Logger LOGGER = Logger.getLogger("ProjetoKura");

    private AppLogger() {
        // evita instância
    }

    public static void info(String mensagem) {
        LOGGER.log(Level.INFO, mensagem);
    }

    public static void warn(String mensagem) {
        LOGGER.log(Level.WARNING, mensagem);
    }

    public static void error(String mensagem, Exception e) {
        LOGGER.log(Level.SEVERE, mensagem, e);
    }
}
