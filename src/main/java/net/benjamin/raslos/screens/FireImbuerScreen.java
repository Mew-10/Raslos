package net.benjamin.raslos.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.benjamin.raslos.RaslosMod;
import net.benjamin.raslos.container.FireImbuerContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class FireImbuerScreen extends ContainerScreen<FireImbuerContainer>
{
    private final ResourceLocation GUI = new ResourceLocation(RaslosMod.MOD_ID,
            "textures/gui/fire_imbuer_gui.png");

    public FireImbuerScreen(FireImbuerContainer container, PlayerInventory inv, ITextComponent name)
    {
        super(container, inv, name);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y)
    {
        drawString(matrixStack, Minecraft.getInstance().fontRenderer,"Energy: " + container.getEnergyLevel(),
                28, 10, 0xffffff);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y)
    {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);

        this.blit(matrixStack, i + 13, j + 9, 176, 0, 11, 64 - container.getEnergyLevel());
    }
}
