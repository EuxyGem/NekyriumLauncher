package fr.euxygem.nekyrium.launcher.interfaces.gui.implement;

import com.jfoenix.controls.JFXSlider;
import fr.euxygem.nekyrium.launcher.interfaces.GuiManager;
import fr.euxygem.nekyrium.launcher.interfaces.NodeManager;
import fr.euxygem.nekyrium.launcher.interfaces.gui.Gui;
import fr.euxygem.nekyrium.launcher.utility.StringWriter;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * @author EuxyGem
 **/

public class GuiSettingsRuntime extends Gui
{
    static final JFXSlider slider = new JFXSlider();

    @Override
    public void initializeGui(GuiManager guiManager)
    {
        GridPane settingsPanel = new GridPane();
        Label title = new Label("LANCEMENT DU CLIENT"), mt1 = new Label("EXECUTABLE JAVA"), mt2 = new Label("MÉMOIRE VIVE");

        super.initializeGui(guiManager);

        NodeManager.setPosition(settingsPanel, 0, 0, HPos.CENTER, VPos.CENTER);
        settingsPanel.getChildren().add(GuiSettingsAccount.leftBar);
        this.gui.getChildren().add(settingsPanel);

        NodeManager.setPosition(title, 75, 9, HPos.LEFT, VPos.TOP);
        title.setFont(NodeManager.getCustomFont("Poppins Bold", 30));
        title.setTextFill(Color.rgb(255, 182, 68));
        settingsPanel.getChildren().add(title);

        NodeManager.setPosition(mt1, 75, 70, HPos.LEFT, VPos.TOP);
        mt1.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        mt1.setTextFill(Color.rgb(255, 182, 68));
        settingsPanel.getChildren().add(mt1);

        NodeManager.setPosition(mt2, 75, 115, HPos.LEFT, VPos.TOP);
        mt2.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        mt2.setTextFill(Color.rgb(255, 182, 68));
        settingsPanel.getChildren().add(mt2);

        NodeManager.setPosition(slider, 75, 131, HPos.LEFT, VPos.TOP);
        slider.setMaxWidth(325);
        slider.setMin(1);
        slider.setMax(10);
        settingsPanel.getChildren().add(slider);

        if (GuiSettingsAccount.SETTINGS_FILE.exists())
        {
            if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("light"))
            {
                settingsPanel.setStyle("-fx-background-color: rgb(255, 255, 255);");
            } else if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("dark"))
            {
                settingsPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
            }

            slider.setValue(Integer.parseInt(StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "ram")));
        } else
        {
            settingsPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
            slider.setValue(1);
        }
    }
}
