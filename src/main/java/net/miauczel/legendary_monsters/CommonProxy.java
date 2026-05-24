package net.miauczel.legendary_monsters;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(
        modid = "legendary_monsters",
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class CommonProxy {
    public Object getModBlockEntityWithoutLevelRenderer() {
        return null;
    }
    public void releaseRenderingEntity(UUID id) {
    }
    public void blockRenderingEntity(UUID id) {
    }
    public boolean isFirstPersonPlayer(Entity entity) {
        return false;
    }
    public static Map<UUID, Integer> bossBarRenderTypes = new HashMap<>();

    public static Map<UUID, String> bossBarNames = new HashMap<>();

    public CommonProxy() {
    }

    public Player getClientSidePlayer() {
        return null;
    }

    public boolean isKeyDown(int keyType) {
        return false;
    }

    public Object getItemRender() {
        return null;
    }
    public void init() {
    }
    public void clientInit() {
    }
    public void removeBossBarRender(UUID bossBar) {
    }

    public void setBossBarRender(UUID bossBar, int renderType) {
    }
}
