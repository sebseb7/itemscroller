package fi.dy.masa.itemscroller.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import fi.dy.masa.itemscroller.event.RenderEventHandler;

@Mixin(Screen.class)
public abstract class MixinScreen
{
    @Inject(method = "render", at = @At(value = "TAIL"))
    private void onDrawScreenPost(DrawContext drawContext, int mouseX, int mouseY, float delta, CallbackInfo ci)
    {
        RenderEventHandler.instance().onDrawScreenPost(MinecraftClient.getInstance(), drawContext);
    }
}
