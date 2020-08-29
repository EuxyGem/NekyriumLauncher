package fr.euxygem.nekyrium.launcher.interfaces.gui;

import fr.euxygem.nekyrium.launcher.interfaces.GuiManager;
import fr.euxygem.nekyrium.launcher.interfaces.NodeManager;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;

/**
 * @author EuxyGem
 **/

public class Gui implements IGui
{
    protected GridPane gui = new GridPane();
    protected GuiManager guiManager;

    @Override
    public void initializeGui(GuiManager guiManager)
    {
        this.guiManager = guiManager;

        NodeManager.setPosition(gui, 0, 0, HPos.CENTER, VPos.CENTER);
    }

    @Override
    public GridPane getGuiToDisplay()
    {
        return this.gui;
    }
}
