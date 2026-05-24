package net.miauczel.legendary_monsters.util;

import com.mojang.logging.LogUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;
import org.slf4j.Logger;

import java.io.File;

public class ModSavedData extends SavedData {
    public ModSavedData(){}
    public static final String DATA_NAME = "legendary_monsters_worlddata";

    private boolean defeatedObliterator;

    public  boolean isDefeatedObliterator() {
        return defeatedObliterator;
    }

public ModSavedData load(CompoundTag compoundTag){

ModSavedData data = new ModSavedData();
data.defeatedObliterator = compoundTag.getBoolean("defeatedObliterator");

return data;
}

    public static ModSavedData get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(
                new ModSavedData()::load, ModSavedData::new,
                DATA_NAME
        );
    }

    @Override
    public CompoundTag save(CompoundTag pCompoundTag) {
       pCompoundTag.putBoolean("defeatedObliterator",defeatedObliterator);
    return pCompoundTag;
    }

    public void setDefeatedObliterator(boolean value) {
        if (this.defeatedObliterator != value) {
            this.defeatedObliterator = value;
            setDirty();
        }
    }
}
