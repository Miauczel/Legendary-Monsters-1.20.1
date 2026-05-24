package net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;

public abstract class  LMPartEntity<T extends IAnimatedMonster> extends IAnimatedMonster {
    private final T parent;

    public LMPartEntity(T parent) {
        super(parent.getType(), parent.level());
        this.parent = parent;
    }

    public T getParent() {
        return parent;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        throw new UnsupportedOperationException();
    }
}

