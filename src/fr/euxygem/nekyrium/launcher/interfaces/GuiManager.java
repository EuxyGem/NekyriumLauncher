package fr.euxygem.nekyrium.launcher.interfaces;

import fr.euxygem.nekyrium.launcher.NekyriumLauncher;
import fr.euxygem.nekyrium.launcher.interfaces.gui.IGui;
import javafx.animation.FadeTransition;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author EuxyGem
 **/

public class GuiManager
{
    private final Stage stage;
    private final GridPane mainPanel = new GridPane();

    public GuiManager(Stage stage)
    {
        this.stage = stage;
    }

    public void initializeGui()
    {
        this.stage.setTitle(NekyriumLauncher.NAME[5] + " " + NekyriumLauncher.VERSION[1]);
        this.stage.getIcons().add(new Image("assets/images/icon.png"));
        this.stage.setWidth(1280);
        this.stage.setHeight(720);
        this.stage.setMinWidth(1280);
        this.stage.setMinHeight(720);
        this.stage.centerOnScreen();

        NodeManager.setPosition(this.mainPanel, 0, 0, HPos.CENTER, VPos.CENTER);
        this.mainPanel.setStyle("-fx-background-image: url(assets/images/background.png); -fx-background-position: center; -fx-background-size: cover;");

        this.stage.setScene(new Scene(this.mainPanel));
        this.stage.show();
    }

    public void displayGui(IGui iGui, boolean transition)
    {
        this.mainPanel.getChildren().clear();
        this.mainPanel.getChildren().add(iGui.getGuiToDisplay());

        iGui.getGuiToDisplay().getChildren().clear();
        iGui.initializeGui(this);

        if (transition)
        {
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.25), iGui.getGuiToDisplay());

            fadeTransition.setFromValue(0.0D);
            fadeTransition.setToValue(1.0D);
            fadeTransition.setAutoReverse(true);
            fadeTransition.play();
        }
    }

    public Stage getStage()
    {
        return stage;
    }
}
