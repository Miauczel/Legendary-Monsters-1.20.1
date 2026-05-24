package net.miauczel.legendary_monsters.entity.client.Render.BlockEntity.SomberTrapdoor;

import net.minecraft.util.StringRepresentable;

public enum  SomberTrapdoorPart implements StringRepresentable {
    UP("up"),
    MIDDLE("middle"),
    DOWN("down");

    private final String name;

    private SomberTrapdoorPart(String pName) {
        this.name = pName;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}