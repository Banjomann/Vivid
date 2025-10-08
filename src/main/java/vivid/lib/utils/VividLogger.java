package vivid.lib.utils;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

public class VividLogger {
    private static final Logger LOGGER = LogUtils.getLogger();

    public enum LogType {
        Info,
        Warn,
        Error,
        Debug
    }

    public static void log(String message) {
        log(message, LogType.Info);
    }
    public static void log(String message, LogType type) {
        switch (type) {
            case Info:
            LOGGER.info(message);
            break;
            case Warn:
            LOGGER.warn(message);
            break;
            case Error:
            LOGGER.error(message);
            break;
            case Debug:
            LOGGER.debug(message);
            break;
            default:
            LOGGER.info(message);
            break;
        }
    }
}
