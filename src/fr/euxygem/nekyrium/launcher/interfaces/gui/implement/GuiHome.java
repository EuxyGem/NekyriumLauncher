package fr.euxygem.nekyrium.launcher.interfaces.gui.implement;

import com.jfoenix.controls.JFXButton;
import com.sun.javafx.tk.Toolkit;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.euxygem.nekyrium.launcher.interfaces.GuiManager;
import fr.euxygem.nekyrium.launcher.interfaces.NodeManager;
import fr.euxygem.nekyrium.launcher.interfaces.gui.Gui;
import fr.euxygem.nekyrium.launcher.utility.StringWriter;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.time.LocalTime;

/**
 * @author EuxyGem
 **/

public class GuiHome extends Gui
{
    static final Label clockLabel = new Label();
    static final GridPane navigationPanel = new GridPane();
    static final ImageView logoView = new ImageView("/assets/images/logo.png");
    static final Rectangle elevator = new Rectangle();

    @Override
    public void initializeGui(GuiManager guiManager)
    {
        GridPane homePanel = new GridPane();
        ImageView imageSkull = new ImageView("https://minotar.net/helm/" + StringWriter.getProperty(GuiLogin.PROFILE_FILE, "username")), discordView = new ImageView("/assets/images/discord.png"), twitterView = new ImageView("/assets/images/twitter.png"), youtubeView = new ImageView("/assets/images/youtube.png");
        JFXButton homeLabel = new JFXButton("Accueil"), newsLabel = new JFXButton("Actualité"), socialsLabel = new JFXButton("Réseaux sociaux"), aboutLabel = new JFXButton("À propos"), settingsLabel = new JFXButton("Paramètres"), disconnectLabel = new JFXButton("Se déconnecter");
        Label usernameLabel = new Label(StringWriter.getProperty(GuiLogin.PROFILE_FILE, "username")), startLabel = new Label("JOUER"), noNews = new Label("Pas de nouveautées.");
        LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop(0, Color.rgb(255, 182, 68)), new Stop(1, Color.valueOf("#ff8644")));
        MaterialDesignIconView settingsButton = new MaterialDesignIconView(MaterialDesignIcon.SETTINGS), disconnectButton = new MaterialDesignIconView(MaterialDesignIcon.EXIT_TO_APP);
        Rectangle profileRectangle = new Rectangle(), discordRect = new Rectangle(), twitterRect = new Rectangle(), youtubeRect = new Rectangle(), startButton = new Rectangle();
        Separator profileSeparator = new Separator();
        StackPane profileStack = new StackPane(), discordStack = new StackPane(), twitterStack = new StackPane(), youtubeStack = new StackPane(), startStack = new StackPane();
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->
        {
            LocalTime currentTime = LocalTime.now();
            clockLabel.setText(currentTime.getHour() + ":" + (String.valueOf(currentTime.getMinute()).length() == 1 ? "0" + currentTime.getMinute() : currentTime.getMinute()));
        }), new KeyFrame(Duration.seconds(1)));
        double profileWidth = 175;
        double usernameWidth = Toolkit.getToolkit().getFontLoader().computeStringWidth(usernameLabel.getText(), usernameLabel.getFont()) + 50;

        super.initializeGui(guiManager);

        if (usernameWidth < profileWidth)
            profileRectangle.setWidth(profileWidth);
        else
            profileWidth = usernameWidth;

        this.gui.setEffect(new DropShadow());

        navigationPanel.getChildren().clear();

        NodeManager.setPosition(navigationPanel, 0, 0, HPos.CENTER, VPos.TOP);
        navigationPanel.setMaxHeight(50);
        this.gui.getChildren().add(navigationPanel);

        NodeManager.setPosition(homePanel, 0, 0, HPos.CENTER, VPos.TOP);
        this.gui.add(homePanel, 0, 1);

        NodeManager.setPosition(imageSkull, 150, 0, HPos.LEFT, VPos.CENTER);
        imageSkull.setFitWidth(25);
        imageSkull.setFitHeight(25);
        imageSkull.setOpacity(0.8);
        imageSkull.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(imageSkull, 0.25, 0.8, 1));
        imageSkull.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(imageSkull, 0.25, 1, 0.8));
        imageSkull.setOnMouseClicked(event -> profileStack.setVisible(!profileStack.isVisible()));
        navigationPanel.getChildren().add(imageSkull);

        NodeManager.setPosition(discordRect, 0, 0, HPos.CENTER, VPos.CENTER);
        discordRect.setEffect(new DropShadow());
        discordRect.setWidth(60);
        discordRect.setHeight(60);
        discordRect.setArcWidth(25);
        discordRect.setArcHeight(25);
        discordStack.getChildren().add(discordRect);

        NodeManager.setPosition(discordView, 0, 0, HPos.CENTER, VPos.CENTER);
        discordView.setFitWidth(25);
        discordView.setFitHeight(25);
        discordStack.getChildren().add(discordView);

        NodeManager.setPosition(twitterRect, 0, 0, HPos.CENTER, VPos.CENTER);
        twitterRect.setEffect(new DropShadow());
        twitterRect.setWidth(60);
        twitterRect.setHeight(60);
        twitterRect.setArcWidth(25);
        twitterRect.setArcHeight(25);
        twitterStack.getChildren().add(twitterRect);

        NodeManager.setPosition(twitterView, 0, 0, HPos.CENTER, VPos.CENTER);
        twitterView.setFitWidth(25);
        twitterView.setFitHeight(25);
        twitterStack.getChildren().add(twitterView);

        NodeManager.setPosition(youtubeRect, 0, 0, HPos.CENTER, VPos.CENTER);
        youtubeRect.setEffect(new DropShadow());
        youtubeRect.setWidth(60);
        youtubeRect.setHeight(60);
        youtubeRect.setArcWidth(25);
        youtubeRect.setArcHeight(25);
        youtubeStack.getChildren().add(youtubeRect);

        NodeManager.setPosition(youtubeView, 0, 0, HPos.CENTER, VPos.CENTER);
        youtubeView.setFitWidth(25);
        youtubeView.setFitHeight(25);
        youtubeStack.getChildren().add(youtubeView);

        NodeManager.setPosition(logoView, 0, 0, HPos.CENTER, VPos.CENTER);
        this.gui.getChildren().add(logoView);

        NodeManager.setPosition(homeLabel, 250, 0, HPos.LEFT, VPos.CENTER);
        homeLabel.setTextFill(Color.rgb(255, 182, 68));
        homeLabel.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        homeLabel.setOpacity(0.8);
        homeLabel.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(homeLabel, 0.25, 0.8, 1));
        homeLabel.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(homeLabel, 0.25, 1, 0.8));
        homeLabel.setOnMouseClicked(event ->
        {
            homeLabel.setTextFill(Color.rgb(255, 182, 68));
            newsLabel.setTextFill(NodeManager.getTextColor());
            socialsLabel.setTextFill(NodeManager.getTextColor());
            aboutLabel.setTextFill(NodeManager.getTextColor());
            guiManager.displayGui(this, false);
        });
        navigationPanel.getChildren().add(homeLabel);

        NodeManager.setPosition(newsLabel, 400, 0, HPos.LEFT, VPos.CENTER);
        newsLabel.setTextFill(NodeManager.getTextColor());
        newsLabel.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        newsLabel.setOpacity(0.8);
        newsLabel.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(newsLabel, 0.25, 0.8, 1));
        newsLabel.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(newsLabel, 0.25, 1, 0.8));
        newsLabel.setOnMouseClicked(event ->
        {
            homeLabel.setTextFill(NodeManager.getTextColor());
            newsLabel.setTextFill(Color.rgb(255, 182, 68));
            socialsLabel.setTextFill(NodeManager.getTextColor());
            aboutLabel.setTextFill(NodeManager.getTextColor());
            guiManager.displayGui(new GuiHomeNews(), false);
        });
        navigationPanel.getChildren().add(newsLabel);

        NodeManager.setPosition(socialsLabel, 550, 0, HPos.LEFT, VPos.CENTER);
        socialsLabel.setTextFill(NodeManager.getTextColor());
        socialsLabel.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        socialsLabel.setOpacity(0.8);
        socialsLabel.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(socialsLabel, 0.25, 0.8, 1));
        socialsLabel.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(socialsLabel, 0.25, 1, 0.8));
        socialsLabel.setOnMouseClicked(event ->
        {
            homeLabel.setTextFill(NodeManager.getTextColor());
            newsLabel.setTextFill(NodeManager.getTextColor());
            socialsLabel.setTextFill(Color.rgb(255, 182, 68));
            aboutLabel.setTextFill(NodeManager.getTextColor());
            guiManager.displayGui(new GuiHomeSocials(), false);
        });
        navigationPanel.getChildren().add(socialsLabel);

        NodeManager.setPosition(aboutLabel, 750, 0, HPos.LEFT, VPos.CENTER);
        aboutLabel.setTextFill(NodeManager.getTextColor());
        aboutLabel.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        aboutLabel.setOpacity(0.8);
        aboutLabel.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(aboutLabel, 0.25, 0.8, 1));
        aboutLabel.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(aboutLabel, 0.25, 1, 0.8));
        aboutLabel.setOnMouseClicked(event ->
        {
            homeLabel.setTextFill(NodeManager.getTextColor());
            newsLabel.setTextFill(NodeManager.getTextColor());
            socialsLabel.setTextFill(NodeManager.getTextColor());
            aboutLabel.setTextFill(Color.rgb(255, 182, 68));
            guiManager.displayGui(new GuiHomeAbout(), false);
        });
        navigationPanel.getChildren().add(aboutLabel);

        NodeManager.setPosition(elevator, 0, 0, HPos.LEFT, VPos.CENTER);
        elevator.setWidth(2);
        elevator.setHeight(250);
        homePanel.getChildren().add(elevator);

        NodeManager.setPosition(profileRectangle, 0, 0, HPos.CENTER, VPos.CENTER);
        profileRectangle.setWidth(profileWidth);
        profileRectangle.setHeight(107);
        profileRectangle.setArcWidth(25);
        profileRectangle.setArcHeight(25);
        profileStack.getChildren().add(profileRectangle);

        NodeManager.setPosition(clockLabel, -150, 50, HPos.RIGHT, VPos.TOP);
        clockLabel.setTextFill(NodeManager.getTextColor());
        clockLabel.setFont(NodeManager.getCustomFont("Poppins Bold", 50));
        this.gui.getChildren().add(clockLabel);

        NodeManager.setPosition(usernameLabel, 0, 10, HPos.CENTER, VPos.TOP);
        usernameLabel.setEffect(new DropShadow());
        usernameLabel.setTextFill(NodeManager.getTextColor());
        usernameLabel.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        profileStack.getChildren().add(usernameLabel);

        NodeManager.setPosition(settingsLabel, 0, 47, HPos.CENTER, VPos.TOP);
        settingsLabel.setTextFill(NodeManager.getTextColor());
        settingsLabel.setGraphic(settingsButton);
        settingsLabel.setOpacity(0.8);
        settingsLabel.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(settingsLabel, 0.25, 0.8, 1));
        settingsLabel.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(settingsLabel, 0.25, 1, 0.8));
        settingsLabel.setOnMouseClicked(event -> guiManager.displayGui(new GuiSettingsAccount(), true));
        settingsLabel.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        profileStack.getChildren().add(settingsLabel);

        NodeManager.setPosition(disconnectLabel, 0, 72, HPos.CENTER, VPos.TOP);
        disconnectLabel.setTextFill(NodeManager.getTextColor());
        disconnectLabel.setGraphic(disconnectButton);
        disconnectLabel.setOpacity(0.8);
        disconnectLabel.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(disconnectLabel, 0.25, 0.8, 1));
        disconnectLabel.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(disconnectLabel, 0.25, 1, 0.8));
        disconnectLabel.setOnMouseClicked(event -> GuiLogin.disconnect(guiManager));
        disconnectLabel.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        profileStack.getChildren().add(disconnectLabel);

        NodeManager.setPosition(startButton, 0, 0, HPos.CENTER, VPos.CENTER);
        startButton.setEffect(new DropShadow());
        startButton.setFill(gradient);
        startButton.setWidth(175);
        startButton.setHeight(60);
        startButton.setArcWidth(60);
        startButton.setArcHeight(60);

        NodeManager.setPosition(startLabel, 0, 0, HPos.CENTER, VPos.CENTER);
        startLabel.setTextFill(Color.rgb(51, 51, 51));
        startLabel.setFont(NodeManager.getCustomFont("Poppins Bold", 14));

        settingsButton.setFill(NodeManager.getTextColor());
        settingsButton.setSize("14px");

        disconnectButton.setFill(Color.RED);
        disconnectButton.setSize("14px");

        NodeManager.setPosition(noNews, 0, 0, HPos.CENTER, VPos.CENTER);
        noNews.setEffect(new DropShadow());
        noNews.setFont(NodeManager.getCustomFont("Poppins Regular", 14));
        noNews.setTextFill(NodeManager.getTextColor());
        homePanel.getChildren().add(noNews);

        NodeManager.setPosition(profileSeparator, 0, 40, HPos.CENTER, VPos.TOP);
        profileSeparator.setEffect(new DropShadow());
        profileSeparator.setMaxWidth(profileWidth - 50);
        profileStack.getChildren().add(profileSeparator);

        NodeManager.setPosition(profileStack, 162.5 - (profileWidth / 2), 65, HPos.LEFT, VPos.TOP);
        profileStack.setMaxSize(profileWidth, 107);
        profileStack.setVisible(false);
        profileStack.setAlignment(Pos.TOP_CENTER);
        this.gui.getChildren().add(profileStack);

        NodeManager.setPosition(discordStack, -25, -75, HPos.RIGHT, VPos.CENTER);
        discordStack.setMaxSize(60, 60);
        discordStack.setOpacity(0.8);
        discordStack.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(discordStack, 0.25, 0.8, 1));
        discordStack.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(discordStack, 0.25, 1, 0.8));
        //discordStack.setOnMouseClicked(event -> OPEN LINK);
        homePanel.getChildren().add(discordStack);

        NodeManager.setPosition(twitterStack, -25, 0, HPos.RIGHT, VPos.CENTER);
        twitterStack.setMaxSize(60, 60);
        twitterStack.setOpacity(0.8);
        twitterStack.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(twitterStack, 0.25, 0.8, 1));
        twitterStack.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(twitterStack, 0.25, 1, 0.8));
        //twitterStack.setOnMouseClicked(event -> OPEN LINK);
        homePanel.getChildren().add(twitterStack);

        NodeManager.setPosition(youtubeStack, -25, 75, HPos.RIGHT, VPos.CENTER);
        youtubeStack.setMaxSize(60, 60);
        youtubeStack.setOpacity(0.8);
        youtubeStack.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(youtubeStack, 0.25, 0.8, 1));
        youtubeStack.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(youtubeStack, 0.25, 1, 0.8));
        //youtubeStack.setOnMouseClicked(event -> OPEN LINK);
        homePanel.getChildren().add(youtubeStack);

        NodeManager.setPosition(startStack, 0, -25, HPos.CENTER, VPos.BOTTOM);
        startStack.setMaxSize(175, 60);
        startStack.setOpacity(0.8);
        startStack.getChildren().addAll(startButton, startLabel);
        startStack.setOnMouseEntered(event ->
        {
            NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(startButton, 0.25, 0.8, 1);
            NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(startLabel, 0.25, 0.8, 1);
            startButton.setFill(Color.rgb(255, 182, 68));
        });
        startStack.setOnMouseExited(event ->
        {
            NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(startButton, 0.25, 1, 0.8);
            NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(startLabel, 0.25, 1, 0.8);
            startButton.setFill(gradient);
        });
        startStack.setOnMouseClicked(event -> guiManager.displayGui(new GuiUpdate(), true));
        homePanel.getChildren().add(startStack);

        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        if (GuiSettingsAccount.SETTINGS_FILE.exists())
        {
            if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("light"))
            {
                homePanel.setStyle("-fx-background-color: rgb(255, 255, 255);");
                elevator.setFill(Color.rgb(255, 255, 255));
                discordRect.setFill(Color.rgb(238, 238, 238));
                twitterRect.setFill(Color.rgb(238, 238, 238));
                youtubeRect.setFill(Color.rgb(238, 238, 238));
                profileRectangle.setFill(Color.rgb(255, 255, 255));
            } else if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("dark"))
            {
                homePanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
                elevator.setFill(Color.rgb(51, 51, 51));
                discordRect.setFill(Color.rgb(34, 34, 34));
                twitterRect.setFill(Color.rgb(34, 34, 34));
                youtubeRect.setFill(Color.rgb(34, 34, 34));
                profileRectangle.setFill(Color.rgb(51, 51, 51));
            }
        } else
        {
            homePanel.setStyle("-fx-background-color: rgb(51, 51, 51);");
            elevator.setFill(Color.rgb(51, 51, 51));
            discordRect.setFill(Color.rgb(34, 34, 34));
            twitterRect.setFill(Color.rgb(34, 34, 34));
            youtubeRect.setFill(Color.rgb(34, 34, 34));
            profileRectangle.setFill(Color.rgb(51, 51, 51));
        }
    }
}
