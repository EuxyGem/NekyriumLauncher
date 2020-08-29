package fr.euxygem.nekyrium.launcher.interfaces.gui.implement;

import com.jfoenix.controls.JFXComboBox;
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

public class GuiSettingsCustomization extends Gui
{
    static final JFXComboBox<Label> comboBox = new JFXComboBox<>();

    @Override
    public void initializeGui(GuiManager guiManager)
    {
        GridPane settingsPanel = new GridPane();
        Label title = new Label("PERSONNALISATION"), mt1 = new Label("THÈME");

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

        NodeManager.setPosition(comboBox, 75, 86, HPos.LEFT, VPos.TOP);
        comboBox.setUnFocusColor(Color.rgb(191, 195, 195));
        comboBox.setFocusColor(Color.rgb(255, 182, 68));
        comboBox.getItems().clear();
        comboBox.getItems().addAll(new Label("Clair"), new Label("Sombre"));
        settingsPanel.getChildren().add(comboBox);

        if (GuiSettingsAccount.SETTINGS_FILE.exists())
        {
            if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("light"))
            {
                settingsPanel.setStyle("-fx-background-color: rgb(255, 255, 255);");
                comboBox.getSelectionModel().select(0);
            } else if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("dark"))
            {
                settingsPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
                comboBox.getSelectionModel().select(1);
            }
        } else
        {
            settingsPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
            comboBox.getSelectionModel().select(1);
        }
    }
}
