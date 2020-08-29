package fr.euxygem.nekyrium.launcher.utility;

import fr.euxygem.nekyrium.launcher.NekyriumLauncher;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author EuxyGem
 **/

public class ConsoleWriter
{
    private static final String PREFIX = "[" + NekyriumLauncher.NAME[4] + "] [" + new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())) + "] ";

    public static void info(Object info)
    {
        System.out.println(PREFIX + "[INFO] " + info);
    }

    public static void warn(Object warn)
    {
        System.err.println(PREFIX + "[WARN] " + warn);
    }
}
