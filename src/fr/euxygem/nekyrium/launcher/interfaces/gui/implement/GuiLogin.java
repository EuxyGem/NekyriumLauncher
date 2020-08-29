package fr.euxygem.nekyrium.launcher.interfaces.gui.implement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import fr.euxygem.nekyrium.launcher.file.FileManager;
import fr.euxygem.nekyrium.launcher.interfaces.GuiManager;
import fr.euxygem.nekyrium.launcher.interfaces.NodeManager;
import fr.euxygem.nekyrium.launcher.interfaces.gui.Gui;
import fr.euxygem.nekyrium.launcher.security.AuthenticationManager;
import fr.euxygem.nekyrium.launcher.security.authentication.response.AuthenticationResponse;
import fr.euxygem.nekyrium.launcher.utility.ConsoleWriter;
import fr.euxygem.nekyrium.launcher.utility.StringWriter;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.io.File;
import java.net.URI;

/**
 * @author EuxyGem
 **/

public class GuiLogin extends Gui
{
    public static final File PROFILE_FILE = new File(FileManager.getLauncherDirectory(), "profile.nekyrium");
    private static final JFXCheckBox rememberMe = new JFXCheckBox("Rester connecté");
    private static final JFXPasswordField passwordField = new JFXPasswordField();
    private static final JFXTextField emailField = new JFXTextField(StringWriter.getProperty(GuiLogin.PROFILE_FILE, "e-mail"));
    private static final StackPane notificationStack = new StackPane();

    private static void clearEmailAndPasswordFields()
    {
        emailField.clear();
        passwordField.clear();
    }

    private static void authenticate(GuiManager guiManager)
    {
        if (!emailField.getText().contains("@") || !emailField.getText().contains(".") || passwordField.getText().length() == 0)
        {
            notificationStack.setVisible(true);
            return;
        } else
        {
            try
            {
                AuthenticationResponse authenticationResponse = new AuthenticationManager().authenticate(emailField.getText(), passwordField.getText());

                StringWriter.setProperty(GuiLogin.PROFILE_FILE, "access-token", authenticationResponse.getAccessToken());
                StringWriter.setProperty(GuiLogin.PROFILE_FILE, "client-token", authenticationResponse.getClientToken());
                StringWriter.setProperty(GuiLogin.PROFILE_FILE, "e-mail", emailField.getText());
                if (rememberMe.isPressed())
                    StringWriter.setProperty(GuiLogin.PROFILE_FILE, "stay-connected", "true");
                else if (!rememberMe.isPressed())
                    StringWriter.setProperty(GuiLogin.PROFILE_FILE, "stay-connected", "false");
                else
                    StringWriter.setProperty(GuiLogin.PROFILE_FILE, "stay-connected", "false");
                StringWriter.setProperty(GuiLogin.PROFILE_FILE, "username", authenticationResponse.getSelectedProfile().getName());
                StringWriter.setProperty(GuiLogin.PROFILE_FILE, "uuid", authenticationResponse.getSelectedProfile().getId());

                guiManager.displayGui(new GuiHome(), true);
            } catch (Exception exception)
            {
                ConsoleWriter.warn("Une erreur est survenue : " + exception.getClass().getName() + " --> " + exception.getMessage());
                notificationStack.setVisible(true);
            }
        }
        clearEmailAndPasswordFields();
    }

    static void disconnect(GuiManager guiManager)
    {
        try
        {
            new AuthenticationManager().invalidate(StringWriter.getProperty(GuiLogin.PROFILE_FILE, "access-token"), StringWriter.getProperty(GuiLogin.PROFILE_FILE, "client-token"));

            StringWriter.setProperty(GuiLogin.PROFILE_FILE, "access-token", "");
            StringWriter.setProperty(GuiLogin.PROFILE_FILE, "client-token", "");
            StringWriter.setProperty(GuiLogin.PROFILE_FILE, "e-mail", "");
            StringWriter.setProperty(GuiLogin.PROFILE_FILE, "stay-connected", "");
            StringWriter.setProperty(GuiLogin.PROFILE_FILE, "username", "");
            StringWriter.setProperty(GuiLogin.PROFILE_FILE, "uuid", "");

            guiManager.displayGui(new GuiLogin(), true);
        } catch (Exception exception)
        {
            ConsoleWriter.warn("Une erreur est survenue : " + exception.getClass().getName() + " --> " + exception.getMessage());
        }

        clearEmailAndPasswordFields();
    }

    @Override
    public void initializeGui(GuiManager guiManager)
    {
        ImageView logoView = new ImageView("/assets/images/icon.png");
        JFXButton forgotPassword = new JFXButton("Mot de passe oublié");
        Label connectionLabel = new Label("SE CONNECTER"), notificationLabel = new Label("Votre e-mail ou mot de passe est incorrect !");
        LinearGradient gradient = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop(0, Color.rgb(255, 182, 68)), new Stop(1, Color.rgb(255, 131, 38)));
        MaterialDesignIconView accountIcon = new MaterialDesignIconView(MaterialDesignIcon.ACCOUNT), passwordIcon = new MaterialDesignIconView(MaterialDesignIcon.LOCK), warningIcon = new MaterialDesignIconView(MaterialDesignIcon.ALERT);
        Rectangle connectionRectangle = new Rectangle(), notificationRect = new Rectangle();
        StackPane loginStack = new StackPane();

        super.initializeGui(guiManager);

        this.gui.addEventHandler(KeyEvent.KEY_PRESSED, event ->
        {
            if (event.getCode().getName().equalsIgnoreCase("ENTER"))
                authenticate(guiManager);
        });

        this.gui.setEffect(new DropShadow());

        NodeManager.setPosition(logoView, 0, 10, HPos.CENTER, VPos.TOP);
        logoView.setFitWidth(250);
        logoView.setFitHeight(250);
        this.gui.getChildren().add(logoView);

        NodeManager.setPosition(connectionRectangle, 0, 0, HPos.CENTER, VPos.CENTER);
        connectionRectangle.setFill(new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop(0, Color.rgb(255, 182, 68)), new Stop(1, Color.valueOf("#ff8326"))));
        connectionRectangle.setWidth(175);
        connectionRectangle.setHeight(60);
        connectionRectangle.setArcWidth(60);
        connectionRectangle.setArcHeight(60);
        loginStack.getChildren().add(connectionRectangle);

        NodeManager.setPosition(connectionLabel, 0, 0, HPos.CENTER, VPos.CENTER);
        connectionLabel.setTextFill(Color.rgb(51, 51, 51));
        connectionLabel.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        loginStack.getChildren().add(connectionLabel);

        NodeManager.setPosition(notificationRect, 0, 0, HPos.CENTER, VPos.CENTER);
        notificationRect.setFill(Color.rgb(237, 67, 55));
        notificationRect.setOpacity(0.8);
        notificationRect.setWidth(375);
        notificationRect.setHeight(50);
        notificationRect.setArcWidth(25);
        notificationRect.setArcHeight(25);
        notificationStack.getChildren().add(notificationRect);

        NodeManager.setPosition(notificationLabel, 0, 0, HPos.CENTER, VPos.CENTER);
        notificationLabel.setTextFill(Color.rgb(51, 51, 51));
        notificationLabel.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        notificationLabel.setGraphic(warningIcon);
        notificationStack.getChildren().add(notificationLabel);

        NodeManager.setPosition(forgotPassword, 0, 90, HPos.CENTER, VPos.CENTER);
        forgotPassword.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        forgotPassword.setTextFill(NodeManager.getTextColor());
        forgotPassword.setEffect(new DropShadow());
        forgotPassword.setOpacity(0.8f);
        forgotPassword.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(forgotPassword, 0.25, 0.8, 1));
        forgotPassword.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(forgotPassword, 0.25, 1, 0.8));
        forgotPassword.setOnMouseClicked(event ->
        {
            try
            {
                Desktop.getDesktop().browse(URI.create("https://my.minecraft.net/fr-fr/password/forgot/"));
            } catch (Exception exception)
            {
                ConsoleWriter.warn("Une erreur est survenue : " + exception.getClass().getName() + " --> " + exception.getMessage());
            }
        });
        forgotPassword.setUnderline(true);
        this.gui.getChildren().add(forgotPassword);

        NodeManager.setPosition(rememberMe, 0, -2, HPos.CENTER, VPos.BOTTOM);
        rememberMe.setTextFill(NodeManager.getTextColor());
        rememberMe.setCheckedColor(Color.rgb(255, 182, 68));
        rememberMe.setOpacity(0.8);
        rememberMe.setOnMouseEntered(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(rememberMe, 0.25, 0.8, 1));
        rememberMe.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(rememberMe, 0.25, 1, 0.8));
        rememberMe.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        gui.getChildren().add(rememberMe);

        NodeManager.setPosition(accountIcon, 0, -76, HPos.CENTER, VPos.CENTER);
        accountIcon.setSize("25");
        accountIcon.setFill(NodeManager.getTextColor());
        this.gui.getChildren().add(accountIcon);

        NodeManager.setPosition(passwordIcon, 0, 12, HPos.CENTER, VPos.CENTER);
        passwordIcon.setSize("25px");
        passwordIcon.setFill(NodeManager.getTextColor());
        this.gui.getChildren().add(passwordIcon);

        warningIcon.setEffect(new DropShadow());
        warningIcon.setSize("25px");
        warningIcon.setFill(Color.rgb(255, 182, 68));

        NodeManager.setPosition(emailField, 0, -40, HPos.CENTER, VPos.CENTER);
        emailField.setStyle("-fx-text-fill: rgb(195, 195, 195);");
        emailField.setUnFocusColor(NodeManager.getTextColor());
        emailField.setFocusColor(Color.rgb(255, 182, 68));
        emailField.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        emailField.setAlignment(Pos.CENTER);
        emailField.setMaxSize(250, 30);
        emailField.setPromptText("E-MAIL");
        emailField.setLabelFloat(true);
        emailField.setOpacity(0.8);
        emailField.setOnMouseEntered(event ->
        {
            NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(emailField, 0.25, 0.8, 1);
            emailField.setCursor(Cursor.TEXT);
        });
        emailField.setOnMouseClicked(event -> notificationStack.setVisible(false));
        emailField.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(emailField, 0.25, 1, 0.8));
        this.gui.getChildren().add(emailField);

        NodeManager.setPosition(passwordField, 0, 50, HPos.CENTER, VPos.CENTER);
        passwordField.setStyle("-fx-text-fill: rgb(195, 195, 195);");
        passwordField.setUnFocusColor(NodeManager.getTextColor());
        passwordField.setFocusColor(Color.rgb(255, 182, 68));
        passwordField.setFont(NodeManager.getCustomFont("Poppins Bold", 14));
        passwordField.setAlignment(Pos.CENTER);
        passwordField.setMaxSize(250, 30);
        passwordField.setPromptText("MOT DE PASSE");
        passwordField.setLabelFloat(true);
        passwordField.setOpacity(0.8);
        passwordField.setOnMouseEntered(event ->
        {
            NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(passwordField, 0.25, 0.8, 1);
            passwordField.setCursor(Cursor.TEXT);
        });
        passwordField.setOnMouseClicked(event -> notificationStack.setVisible(false));
        passwordField.setOnMouseExited(event -> NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(passwordField, 0.25, 1, 0.8));
        this.gui.getChildren().add(passwordField);

        NodeManager.setPosition(loginStack, 0, -25, HPos.CENTER, VPos.BOTTOM);
        loginStack.setMaxSize(175, 60);
        loginStack.setOpacity(0.8);
        loginStack.setOnMouseEntered(event ->
        {
            NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(connectionRectangle, 0.25, 0.8, 1);
            NodeManager.setCursorAndOpacityAndTransitionOnMouseEntered(connectionLabel, 0.25, 0.8, 1);
            connectionRectangle.setFill(Color.rgb(255, 182, 68));
        });
        loginStack.setOnMouseExited(event ->
        {
            NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(connectionRectangle, 0.25, 1, 0.8);
            NodeManager.setCursorAndOpacityAndTransitionOnMouseExited(connectionLabel, 0.25, 1, 0.8);
            connectionRectangle.setFill(gradient);
        });
        loginStack.setOnMouseClicked(event -> authenticate(guiManager));
        this.gui.getChildren().add(loginStack);

        NodeManager.setPosition(notificationStack, -25, -25, HPos.RIGHT, VPos.BOTTOM);
        notificationStack.setMaxSize(375, 50);
        notificationStack.setVisible(false);
        this.gui.getChildren().add(notificationStack);
    }
}
