package fr.euxygem.nekyrium.launcher.interfaces.gui.implement;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.euxygem.nekyrium.launcher.file.FileManager;
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

import java.io.File;

/**
 * @author EuxyGem
 **/

public class GuiSettingsAccount extends Gui
{
    public static final File SETTINGS_FILE = new File(FileManager.getLauncherDirectory(), "settings.nekyrium");
    static final GridPane leftBar = new GridPane();

    @Override
    public void initializeGui(GuiManager guiManager)
    {
        GridPane settingsPanelAccount = new GridPane();
        JFXButton disconnectLabel = new JFXButton("Se déconnecter");
        Label title = new Label("COMPTE"), mt1 = new Label("NOM D'UTILISATEUR"), mt11 = new Label(StringWriter.getProperty(GuiLogin.PROFILE_FILE, "username")), mt2 = new Label("ADRESSE E-MAIL"), mt22 = new Label(StringWriter.getProperty(GuiLogin.PROFILE_FILE, "e-mail")), mt3 = new Label("IDENTIFIANT UNIQUE"), mt33 = new Label(StringWriter.getProperty(GuiLogin.PROFILE_FILE, "uuid"));
        MaterialDesignIconView backButton = new MaterialDesignIconView(MaterialDesignIcon.ARROW_LEFT_BOLD_HEXAGON_OUTLINE), accountSettings = new MaterialDesignIconView(MaterialDesignIcon.ACCOUNT), customizationSettings = new MaterialDesignIconView(MaterialDesignIcon.PALETTE_ADVANCED), runtimeIcon = new MaterialDesignIconView(MaterialDesignIcon.ROCKET), disconnectButton = new MaterialDesignIconView(MaterialDesignIcon.EXIT_TO_APP);

        super.initializeGui(guiManager);

        leftBar.getChildren().clear();

        NodeManager.setPosition(settingsPanelAccount, 0, 0, HPos.CENTER, VPos.CENTER);
        this.gui.getChildren().add(settingsPanelAccount);

        NodeManager.setPosition(leftBar, 0, 0, HPos.LEFT, VPos.CENTER);
        leftBar.setEffect(new DropShadow());
        leftBar.setMaxWidth(60);
        settingsPanelAccount.getChildren().add(leftBar);

        NodeManager.setPosition(backButton, 0, 15, HPos.CENTER, VPos.TOP);
        backButton.setEffect(new DropShadow());
        backButton.setFill(NodeManager.getTextColor());
        backButton.setSize("30px");
        backButton.setOpacity(0.8);
        backButton.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(backButton, 0.25, 0.8, 1));
        backButton.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(backButton, 0.25, 1, 0.8));
        backButton.setOnMouseClicked(event ->
        {
            guiManager.displayGui(new GuiHome(), true);
            this.saveOptions();
        });
        leftBar.getChildren().add(backButton);

        NodeManager.setPosition(accountSettings, 0, 60, HPos.CENTER, VPos.TOP);
        accountSettings.setEffect(new DropShadow());
        accountSettings.setFill(NodeManager.getTextColor());
        accountSettings.setSize("30px");
        accountSettings.setOpacity(0.8);
        accountSettings.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(accountSettings, 0.25, 0.8, 1));
        accountSettings.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(accountSettings, 0.25, 1, 0.8));
        accountSettings.setOnMouseClicked(event ->
        {
            guiManager.displayGui(new GuiSettingsAccount(), false);
            this.saveOptions();
        });
        leftBar.getChildren().add(accountSettings);

        NodeManager.setPosition(customizationSettings, 0, 120, HPos.CENTER, VPos.TOP);
        customizationSettings.setEffect(new DropShadow());
        customizationSettings.setFill(NodeManager.getTextColor());
        customizationSettings.setSize("30px");
        customizationSettings.setOpacity(0.8);
        customizationSettings.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(customizationSettings, 0.25, 0.8, 1));
        customizationSettings.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(customizationSettings, 0.25, 1, 0.8));
        customizationSettings.setOnMouseClicked(event ->
        {
            guiManager.displayGui(new GuiSettingsCustomization(), false);
            this.saveOptions();
        });
        leftBar.getChildren().add(customizationSettings);

        NodeManager.setPosition(runtimeIcon, 0, 180, HPos.CENTER, VPos.TOP);
        runtimeIcon.setEffect(new DropShadow());
        runtimeIcon.setFill(NodeManager.getTextColor());
        runtimeIcon.setSize("30px");
        runtimeIcon.setOpacity(0.8);
        runtimeIcon.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(runtimeIcon, 0.25, 0.8, 1));
        runtimeIcon.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(runtimeIcon, 0.25, 1, 0.8));
        runtimeIcon.setOnMouseClicked(event ->
        {
            guiManager.displayGui(new GuiSettingsRuntime(), false);
            this.saveOptions();
        });
        leftBar.getChildren().add(runtimeIcon);

        NodeManager.setPosition(disconnectLabel, 75, 205, HPos.LEFT, VPos.TOP);
        disconnectLabel.setEffect(new DropShadow());
        disconnectLabel.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        disconnectLabel.setGraphic(disconnectButton);
        disconnectLabel.setTextFill(NodeManager.getTextColor());
        disconnectLabel.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(disconnectLabel, 0.25, 0.8, 1));
        disconnectLabel.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(disconnectLabel, 0.25, 1, 0.8));
        disconnectLabel.setOnMouseClicked(event ->
        {
            GuiLogin.disconnect(guiManager);
            this.saveOptions();
        });
        settingsPanelAccount.getChildren().add(disconnectLabel);

        NodeManager.setPosition(title, 75, 9, HPos.LEFT, VPos.TOP);
        title.setEffect(new DropShadow());
        title.setFont(NodeManager.getCustomFont("Poppins Bold", 30));
        title.setTextFill(Color.rgb(255, 182, 68));
        settingsPanelAccount.getChildren().add(title);

        NodeManager.setPosition(mt1, 75, 70, HPos.LEFT, VPos.TOP);
        mt1.setEffect(new DropShadow());
        mt1.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        mt1.setTextFill(Color.rgb(255, 182, 68));
        settingsPanelAccount.getChildren().add(mt1);

        NodeManager.setPosition(mt11, 75, 86, HPos.LEFT, VPos.TOP);
        mt11.setEffect(new DropShadow());
        mt11.setFont(NodeManager.getCustomFont("Poppins Regular", 14));
        mt11.setTextFill(NodeManager.getTextColor());
        settingsPanelAccount.getChildren().add(mt11);

        NodeManager.setPosition(mt2, 75, 115, HPos.LEFT, VPos.TOP);
        mt2.setEffect(new DropShadow());
        mt2.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        mt2.setTextFill(Color.rgb(255, 182, 68));
        settingsPanelAccount.getChildren().add(mt2);

        NodeManager.setPosition(mt22, 75, 131, HPos.LEFT, VPos.TOP);
        mt22.setEffect(new DropShadow());
        mt22.setFont(NodeManager.getCustomFont("Poppins Regular", 14));
        mt22.setTextFill(NodeManager.getTextColor());
        settingsPanelAccount.getChildren().add(mt22);

        NodeManager.setPosition(mt3, 75, 160, HPos.LEFT, VPos.TOP);
        mt3.setEffect(new DropShadow());
        mt3.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        mt3.setTextFill(Color.rgb(255, 182, 68));
        settingsPanelAccount.getChildren().add(mt3);

        NodeManager.setPosition(mt33, 75, 176, HPos.LEFT, VPos.TOP);
        mt33.setEffect(new DropShadow());
        mt33.setFont(NodeManager.getCustomFont("Poppins Regular", 14));
        mt33.setTextFill(NodeManager.getTextColor());
        settingsPanelAccount.getChildren().add(mt33);

        disconnectButton.setSize("14px");
        disconnectButton.setFill(Color.RED);

        if (GuiSettingsAccount.SETTINGS_FILE.exists())
        {
            if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("light"))
            {
                leftBar.setStyle("-fx-background-color: rgb(238, 238, 238);");
                settingsPanelAccount.setStyle("-fx-background-color: rgb(255, 255, 255);");
            } else if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("dark"))
            {
                leftBar.setStyle("-fx-background-color: rgb(34, 34, 34);");
                settingsPanelAccount.setStyle("-fx-background-color: rgb(51, 51, 51);");
            }
        } else
        {
            leftBar.setStyle("-fx-background-color: rgb(34, 34, 34);");
            settingsPanelAccount.setStyle("-fx-background-color: rgb(51, 51, 51);");
        }
    }

    private void saveOptions()
    {
        if (GuiSettingsCustomization.comboBox.getSelectionModel().getSelectedIndex() == 0)
            StringWriter.setProperty(GuiSettingsAccount.SETTINGS_FILE, "theme", "light");
        else if (GuiSettingsCustomization.comboBox.getSelectionModel().getSelectedIndex() == 1)
            StringWriter.setProperty(GuiSettingsAccount.SETTINGS_FILE, "theme", "dark");
        else
            StringWriter.setProperty(GuiSettingsAccount.SETTINGS_FILE, "theme", "dark");

        if (GuiSettingsRuntime.slider.getValue() != 50)
            StringWriter.setProperty(GuiSettingsAccount.SETTINGS_FILE, "ram", (int) GuiSettingsRuntime.slider.getValue());
        else
            StringWriter.setProperty(GuiSettingsAccount.SETTINGS_FILE, "ram", 1);
    }
}
