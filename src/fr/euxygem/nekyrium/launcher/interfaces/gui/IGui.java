package fr.euxygem.nekyrium.launcher.interfaces.gui;

import fr.euxygem.nekyrium.launcher.interfaces.GuiManager;
import javafx.scene.layout.GridPane;

/**
 * @author EuxyGem
 **/

public interface IGui
{
    void initializeGui(GuiManager guiManager);

    GridPane getGuiToDisplay();
}
