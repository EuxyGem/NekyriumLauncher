package fr.euxygem.nekyrium.launcher.interfaces.gui.implement;

import fr.euxygem.nekyrium.launcher.interfaces.GuiManager;
import fr.euxygem.nekyrium.launcher.interfaces.NodeManager;
import fr.euxygem.nekyrium.launcher.interfaces.gui.Gui;
import fr.euxygem.nekyrium.launcher.utility.StringWriter;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author EuxyGem
 **/

public class GuiHomeSocials extends Gui
{
    @Override
    public void initializeGui(GuiManager guiManager)
    {
        GridPane socialsPanel = new GridPane();
        ImageView discordView = new ImageView("/assets/images/discord.png"), twitterView = new ImageView("/assets/images/twitter.png"), youtubeView = new ImageView("/assets/images/youtube.png");
        Rectangle discordRect = new Rectangle(), twitterRect = new Rectangle(), youtubeRect = new Rectangle();
        StackPane discordStack = new StackPane(), twitterStack = new StackPane(), youtubeStack = new StackPane();

        super.initializeGui(guiManager);

        this.gui.setEffect(new DropShadow());

        this.gui.getChildren().add(GuiHome.navigationPanel);
        this.gui.getChildren().add(GuiHome.logoView);
        this.gui.getChildren().add(GuiHome.clockLabel);

        NodeManager.setPosition(socialsPanel, 0, 0, HPos.CENTER, VPos.TOP);
        socialsPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
        socialsPanel.setEffect(new DropShadow());
        this.gui.add(socialsPanel, 0, 1);

        socialsPanel.getChildren().add(GuiHome.elevator);

        NodeManager.setPosition(discordRect, 0, 0, HPos.CENTER, VPos.CENTER);
        discordRect.setFill(Color.rgb(34, 34, 34));
        discordRect.setWidth(150);
        discordRect.setHeight(150);
        discordRect.setArcWidth(25);
        discordRect.setArcHeight(25);
        //discordRect.setOnMouseClicked(event -> OPEN LINK);
        discordStack.getChildren().add(discordRect);

        NodeManager.setPosition(discordView, 0, 0, HPos.CENTER, VPos.CENTER);
        discordView.setFitWidth(115);
        discordView.setFitHeight(115);
        discordStack.getChildren().add(discordView);

        NodeManager.setPosition(twitterRect, 0, 25, HPos.CENTER, VPos.TOP);
        twitterRect.setFill(Color.rgb(34, 34, 34));
        twitterRect.setWidth(150);
        twitterRect.setHeight(150);
        twitterRect.setArcWidth(25);
        twitterRect.setArcHeight(25);
        //twitterRect.setOnMouseClicked(event -> OPEN LINK);
        socialsPanel.getChildren().add(twitterRect);

        NodeManager.setPosition(twitterView, 0, 0, HPos.CENTER, VPos.CENTER);
        twitterView.setFitWidth(115);
        twitterView.setFitHeight(115);
        twitterStack.getChildren().add(twitterView);

        NodeManager.setPosition(youtubeRect, 0, 0, HPos.CENTER, VPos.TOP);
        youtubeRect.setFill(Color.rgb(34, 34, 34));
        youtubeRect.setWidth(150);
        youtubeRect.setHeight(150);
        youtubeRect.setArcWidth(25);
        youtubeRect.setArcHeight(25);
        //youtubeRect.setOnMouseClicked(event -> OPEN LINK);
        youtubeStack.getChildren().add(youtubeRect);

        NodeManager.setPosition(youtubeView, 0, 0, HPos.CENTER, VPos.CENTER);
        youtubeView.setFitWidth(115);
        youtubeView.setFitHeight(115);
        youtubeStack.getChildren().add(youtubeView);

        NodeManager.setPosition(discordStack, -175, 25, HPos.CENTER, VPos.TOP);
        discordStack.setMaxSize(150, 150);
        discordStack.setOpacity(0.8);
        discordStack.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(discordStack, 0.25, 0.8, 1));
        discordStack.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(discordStack, 0.25, 1, 0.8));
        //discordStack.setOnMouseClicked(event -> OPEN LINK);
        socialsPanel.getChildren().add(discordStack);

        NodeManager.setPosition(twitterStack, 0, 25, HPos.CENTER, VPos.TOP);
        twitterStack.setMaxSize(150, 150);
        twitterStack.setOpacity(0.8);
        twitterStack.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(twitterStack, 0.25, 0.8, 1));
        twitterStack.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(twitterStack, 0.25, 1, 0.8));
        //twitterStack.setOnMouseClicked(event -> OPEN LINK);
        socialsPanel.getChildren().add(twitterStack);

        NodeManager.setPosition(youtubeStack, 175, 25, HPos.CENTER, VPos.TOP);
        youtubeStack.setMaxSize(150, 150);
        youtubeStack.setOpacity(0.8);
        youtubeStack.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(youtubeStack, 0.25, 0.8, 1));
        youtubeStack.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(youtubeStack, 0.25, 1, 0.8));
        //youtubeStack.setOnMouseClicked(event -> OPEN LINK);
        socialsPanel.getChildren().add(youtubeStack);

        if (GuiSettingsAccount.SETTINGS_FILE.exists())
        {
            if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("light"))
            {
                socialsPanel.setStyle("-fx-background-color: rgb(255, 255, 255);");
                discordRect.setFill(Color.rgb(238, 238, 238));
                twitterRect.setFill(Color.rgb(238, 238, 238));
                youtubeRect.setFill(Color.rgb(238, 238, 238));
            } else if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("dark"))
            {
                socialsPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
                discordRect.setFill(Color.rgb(34, 34, 34));
                twitterRect.setFill(Color.rgb(34, 34, 34));
                youtubeRect.setFill(Color.rgb(34, 34, 34));
            }
        } else
        {
            socialsPanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
            discordRect.setFill(Color.rgb(34, 34, 34));
            twitterRect.setFill(Color.rgb(34, 34, 34));
            youtubeRect.setFill(Color.rgb(34, 34, 34));
        }
    }
}
