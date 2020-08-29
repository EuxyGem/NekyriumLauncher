package fr.euxygem.nekyrium.launcher;

import fr.euxygem.nekyrium.launcher.file.FileManager;
import fr.euxygem.nekyrium.launcher.interfaces.GuiManager;
import fr.euxygem.nekyrium.launcher.interfaces.gui.implement.GuiLogin;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author EuxyGem
 **/

public class NekyriumLauncher extends Application
{
    public static final String[] NAME = {"euxygem", "EuxyGem", "EUXYGEM", "nekyrium", "Nekyrium", "NEKYRIUM"};
    public static final String[] VERSION = {"v1", "V1"};

    public static void main(String[] args)
    {
        try
        {
            Class.forName("fr.euxygem.nekyrium.launcher.NekyriumLauncher");
            launch(args);
        } catch (ClassNotFoundException classNotFoundException)
        {
            System.exit(0);
        }
    }

    @Override
    public void start(Stage stage)
    {
        System.setProperty("prism.lcdtext", "false");

        if (!FileManager.getClientDirectory().exists())
            FileManager.getClientDirectory().mkdirs();

        if (!FileManager.getLauncherDirectory().exists())
            FileManager.getLauncherDirectory().mkdirs();

        GuiManager guiManager = new GuiManager(stage);
        guiManager.initializeGui();
        guiManager.displayGui(new GuiLogin(), true);
    }
}
