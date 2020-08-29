package fr.euxygem.nekyrium.launcher.interfaces.gui.implement;

import fr.euxygem.nekyrium.launcher.interfaces.GuiManager;
import fr.euxygem.nekyrium.launcher.interfaces.NodeManager;
import fr.euxygem.nekyrium.launcher.interfaces.gui.Gui;
import fr.euxygem.nekyrium.launcher.utility.StringWriter;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;

/**
 * @author EuxyGem
 **/

public class GuiHomeAbout extends Gui
{
    @Override
    public void initializeGui(GuiManager guiManager)
    {
        GridPane aboutPanel = new GridPane();

        super.initializeGui(guiManager);

        this.gui.setEffect(new DropShadow());

        this.gui.getChildren().add(GuiHome.navigationPanel);
        this.gui.getChildren().add(GuiHome.logoView);
        this.gui.getChildren().add(GuiHome.clockLabel);

        NodeManager.setPosition(aboutPanel, 0, 0, HPos.CENTER, VPos.TOP);
        aboutPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
        this.gui.add(aboutPanel, 0, 1);

        aboutPanel.getChildren().add(GuiHome.elevator);

        if (GuiSettingsAccount.SETTINGS_FILE.exists())
        {
            if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("light"))
                aboutPanel.setStyle("-fx-background-color: rgb(255, 255, 255);");
            else if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("dark"))
                aboutPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
        } else
            aboutPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
    }
}
