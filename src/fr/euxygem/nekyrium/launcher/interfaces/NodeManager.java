package fr.euxygem.nekyrium.launcher.interfaces;

import fr.euxygem.nekyrium.launcher.interfaces.gui.implement.GuiSettingsAccount;
import fr.euxygem.nekyrium.launcher.utility.StringWriter;
import javafx.animation.FadeTransition;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 * @author EuxyGem
 **/

public class NodeManager
{
    public static void setPosition(Node node, double translateX, double translateY, HPos horizontalPosition, VPos verticalPosition)
    {
        node.setTranslateX(translateX);
        node.setTranslateY(translateY);
        GridPane.setHgrow(node, Priority.ALWAYS);
        GridPane.setVgrow(node, Priority.ALWAYS);
        GridPane.setHalignment(node, horizontalPosition);
        GridPane.setValignment(node, verticalPosition);
    }

    public static void setCursorAndOpacityAndTransitionOnMouseEntered(Node node, double duration, double fromValue, double toValue)
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(duration), node);

        fadeTransition.setFromValue(fromValue);
        fadeTransition.setToValue(toValue);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();

        node.setCursor(Cursor.HAND);
    }

    public static void setCursorAndOpacityAndTransitionOnMouseExited(Node object, double duration, double fromValue, double toValue)
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(duration), object);

        fadeTransition.setFromValue(fromValue);
        fadeTransition.setToValue(toValue);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();

        object.setCursor(Cursor.DEFAULT);
    }

    public static Color getTextColor()
    {
        Color textColor = null;

        if (GuiSettingsAccount.SETTINGS_FILE.exists())
        {
            if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("light"))
                textColor = Color.rgb(60, 60, 60);
            else if (StringWriter.getProperty(GuiSettingsAccount.SETTINGS_FILE, "theme").equalsIgnoreCase("dark"))
                textColor = Color.rgb(195, 195, 195);
        } else
            textColor = Color.rgb(195, 195, 195);

        return textColor;
    }

    public static Font getCustomFont(String fontName, double fontSize)
    {
        Font.loadFont(NodeManager.class.getResourceAsStream("/assets/fonts/" + fontName + ".ttf"), fontSize);
        return Font.font(fontName, FontWeight.NORMAL, FontPosture.REGULAR, fontSize);
    }
}
