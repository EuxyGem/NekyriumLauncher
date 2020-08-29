package fr.euxygem.nekyrium.launcher.utility;

import fr.euxygem.nekyrium.launcher.NekyriumLauncher;
import fr.euxygem.nekyrium.launcher.interfaces.gui.implement.GuiLogin;
import fr.euxygem.nekyrium.launcher.interfaces.gui.implement.GuiSettingsAccount;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;

/**
 * @author EuxyGem
 **/

public class StringWriter
{
    private static final Properties properties = new Properties();

    public static void setProperty(File file, Object key, Object value)
    {
        if (file.exists())
            loadFile(file);

        String type = null;

        if (file.equals(GuiLogin.PROFILE_FILE))
            type = " Profile";
        else if (file.equals(GuiSettingsAccount.SETTINGS_FILE))
            type = " Settings";

        properties.setProperty(String.valueOf(key), String.valueOf(value));

        try
        {
            properties.store(new BufferedWriter(new FileWriter(file)), NekyriumLauncher.NAME[4] + type);
        } catch (Exception exception)
        {
            ConsoleWriter.warn("Une erreur est survenue : " + exception.getClass().getName() + " --> " + exception.getMessage());
        }
    }

    public static String getProperty(File file, Object key)
    {
        if (file.exists())
            loadFile(file);

        return properties.getProperty(String.valueOf(key));
    }

    private static void loadFile(File file)
    {
        try
        {
            properties.load(new FileInputStream(file));
        } catch (Exception exception)
        {
            ConsoleWriter.warn("Une erreur est survenue : " + exception.getClass().getName() + " --> " + exception.getMessage());
        }
    }
}
