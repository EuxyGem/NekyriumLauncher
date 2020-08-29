package fr.euxygem.nekyrium.launcher.file;

import fr.euxygem.nekyrium.launcher.NekyriumLauncher;
import fr.euxygem.nekyrium.launcher.utility.OSDetector;

import java.io.File;

/**
 * @author EuxyGem
 **/

public class FileManager
{
    private static File getNekyriumDirectory()
    {
        String u = System.getProperty("user.home");
        String s = File.separator;

        switch (OSDetector.getCurrentOS())
        {
            case LINUX:
                return new File(u + s + "." + NekyriumLauncher.NAME[4]);

            case MACOS:
                return new File(u + s + "Library" + s + "Application Support" + s + NekyriumLauncher.NAME[4]);

            default:
                return new File(u + s + "AppData" + s + "Roaming" + s + NekyriumLauncher.NAME[4]);
        }
    }

    public static File getClientDirectory()
    {
        return new File(getNekyriumDirectory(), "Client");
    }

    public static File getLauncherDirectory()
    {
        return new File(getNekyriumDirectory(), "Launcher");
    }
}
