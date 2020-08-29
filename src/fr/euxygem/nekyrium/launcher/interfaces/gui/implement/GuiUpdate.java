package fr.euxygem.nekyrium.launcher.interfaces.gui.implement;

import com.jfoenix.controls.JFXProgressBar;
import fr.euxygem.nekyrium.launcher.interfaces.GuiManager;
import fr.euxygem.nekyrium.launcher.interfaces.NodeManager;
import fr.euxygem.nekyrium.launcher.interfaces.gui.Gui;
import fr.euxygem.nekyrium.launcher.utility.StringWriter;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * @author EuxyGem
 **/

public class GuiUpdate extends Gui
{
    @Override
    public void initializeGui(GuiManager guiManager)
    {
        GridPane background = new GridPane();
        JFXProgressBar progressBar = new JFXProgressBar();
        Label title = new Label("CHARGEMENT EN COURS");
        Label content = new Label("Mise a jour du client...");

        super.initializeGui(guiManager);

        NodeManager.setPosition(background, 0, 0, HPos.CENTER, VPos.CENTER);
        background.setStyle("-fx-background-color: rgb(51, 51, 51);");
        this.gui.getChildren().add(background);

        NodeManager.setPosition(progressBar, 0, 175, HPos.CENTER, VPos.TOP);
        progressBar.setEffect(new DropShadow());
        progressBar.setMaxSize(1300, 25);
        background.getChildren().add(progressBar);

        NodeManager.setPosition(title, 0, 75, HPos.CENTER, VPos.TOP);
        title.setEffect(new DropShadow());
        title.setTextFill(Color.rgb(255, 182, 68));
        title.setFont(NodeManager.getCustomFont("Poppins Bold", 50));
        background.getChildren().add(title);

        NodeManager.setPosition(content, 0, 250, HPos.CENTER, VPos.TOP);
        content.setEffect(new DropShadow());
        content.setTextFill(NodeManager.getTextColor());
        content.setFont(NodeManager.getCustomFont("Poppins Regular", 25));
        background.getChildren().add(content);

        if (GuiSettingsAccount.SETTINGS_FILE.exists())
        {
            if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("light"))
            {
                background.setStyle("-fx-background-color: rgb(255, 255, 255);");
            } else if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("dark"))
            {
                background.setStyle("-fx-background-color: rgb(51, 51, 51);");
            }
        } else
        {
            background.setStyle("-fx-background-color: rgb(51, 51, 51);");
        }
    }
}
