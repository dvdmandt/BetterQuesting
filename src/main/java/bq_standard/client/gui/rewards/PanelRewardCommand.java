package bq_standard.client.gui.rewards;

import betterquesting.api.questing.IQuest;
import betterquesting.api.utils.BigItemStack;
import betterquesting.api2.client.gui.misc.GuiPadding;
import betterquesting.api2.client.gui.misc.GuiTransform;
import betterquesting.api2.client.gui.misc.IGuiRect;
import betterquesting.api2.client.gui.panels.CanvasEmpty;
import betterquesting.api2.client.gui.panels.content.PanelGeneric;
import betterquesting.api2.client.gui.panels.content.PanelTextBox;
import betterquesting.api2.client.gui.resources.textures.ItemTexture;
import betterquesting.api2.client.gui.themes.presets.PresetColor;
import betterquesting.api2.utils.QuestTranslation;
import bq_standard.rewards.RewardCommand;
import net.minecraft.init.Blocks;
import org.lwjgl.util.vector.Vector4f;

public class PanelRewardCommand extends CanvasEmpty
{
    private final IQuest quest;
    private final RewardCommand reward;
    
    public PanelRewardCommand(IGuiRect rect, IQuest quest, RewardCommand reward)
    {
        super(rect);
        this.quest = quest;
        this.reward = reward;
    }
    
    @Override
    public void initPanel()
    {
        super.initPanel();
        
        this.addPanel(new PanelGeneric(new GuiTransform(new Vector4f(0F, 0.5F, 0F, 0.5F), 0, -16, 32, 32, 0), new ItemTexture(new BigItemStack(Blocks.command_block))));
        String txt = QuestTranslation.translate("advMode.command") + "\n\n" + (reward.hideCmd ? "[HIDDEN]" : reward.command);
        this.addPanel(new PanelTextBox(new GuiTransform(new Vector4f(0F, 0.5F, 1F, 0.5F), new GuiPadding(36, -16, 0, -16), 0), txt).setColor(PresetColor.TEXT_MAIN.getColor()));
    }
}
