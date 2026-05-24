package net.miauczel.legendary_monsters.keyBind;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class ModKeybinds {
    public static final KeyMapping MOSSY = new KeyMapping("key.legendary_monsters.mossy_chestplate_ability", InputConstants.KEY_R, "key.categories.legendary_monsters");
    public static final KeyMapping HELMET = new KeyMapping("key.legendary_monsters.helmet_ability", InputConstants.KEY_C, "key.categories.legendary_monsters");

    public static final KeyMapping SKELORAPTOR_ROAR = new KeyMapping("key.legendary_monsters.roar_ability", InputConstants.KEY_R, "key.categories.legendary_monsters");

    public static final KeyMapping SKELORAPTOR_ATTACK = new KeyMapping("key.legendary_monsters.skeloraptor_attack_ability", InputConstants.Type.MOUSE,
            GLFW.GLFW_MOUSE_BUTTON_LEFT, "key.categories.legendary_monsters");
    public static final KeyMapping FIERY = new KeyMapping("key.legendary_monsters.fiery_boots_ability", InputConstants.KEY_X, "key.categories.legendary_monsters");
}



