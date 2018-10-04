package net.blay09.mods.forgivingvoid.compat;

import com.google.common.base.Strings;
import net.blay09.mods.forgivingvoid.ForgivingVoidEvent;
import net.blay09.mods.forgivingvoid.ModConfig;
import net.darkhax.gamestages.GameStageHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GameStagesCompat {

    public GameStagesCompat() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onForgivingVoid(ForgivingVoidEvent event) {
        String requiredStage = ModConfig.requiredGameStage;
        if (Strings.isNullOrEmpty(requiredStage)) {
            return;
        }

        EntityPlayer player = event.getPlayer();
        if (!GameStageHelper.hasStage(player, requiredStage)) {
            event.setCanceled(true);
        }
    }
}
