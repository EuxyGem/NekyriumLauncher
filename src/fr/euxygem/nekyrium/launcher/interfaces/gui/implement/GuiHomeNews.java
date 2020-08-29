package fr.euxygem.nekyrium.launcher.interfaces.gui.implement;

import fr.euxygem.nekyrium.launcher.interfaces.GuiManager;
import fr.euxygem.nekyrium.launcher.interfaces.NodeManager;
import fr.euxygem.nekyrium.launcher.interfaces.gui.Gui;
import fr.euxygem.nekyrium.launcher.utility.StringWriter;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;

/**
 * @author EuxyGem
 **/

public class GuiHomeNews extends Gui
{
    @Override
    public void initializeGui(GuiManager guiManager)
    {
        GridPane newsPanel = new GridPane();
        Label noNews = new Label("Pas de nouveautées.");

        super.initializeGui(guiManager);

        this.gui.setEffect(new DropShadow());

        this.gui.getChildren().add(GuiHome.navigationPanel);

        NodeManager.setPosition(newsPanel, 0, 0, HPos.CENTER, VPos.TOP);
        newsPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
        newsPanel.setEffect(new DropShadow());
        this.gui.add(newsPanel, 0, 1);

        this.gui.getChildren().add(GuiHome.logoView);
        this.gui.getChildren().add(GuiHome.clockLabel);

        NodeManager.setPosition(noNews, 0, 0, HPos.CENTER, VPos.CENTER);
        noNews.setFont(NodeManager.getCustomFont("Poppins Regular", 14));
        noNews.setTextFill(NodeManager.getTextColor());
        newsPanel.getChildren().add(noNews);

        newsPanel.getChildren().add(GuiHome.elevator);

        if (GuiSettingsAccount.SETTINGS_FILE.exists())
        {
            if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("light"))
            {
                newsPanel.setStyle("-fx-background-color: rgb(255, 255, 255);");
            } else if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("dark"))
            {
                newsPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
            }
        } else
            newsPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
    }
}
