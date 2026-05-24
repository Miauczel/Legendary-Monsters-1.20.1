package net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses;

import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.AnnihilationPursuer.AnnihilationPursuerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.level.Level;

public abstract class AbstractChorusling extends IAnimatedMob{
    public AbstractChorusling(EntityType entity, Level world) {
        super(entity, world);
    }
    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractFlameborn.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, AnnihilationPursuerEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, TheObliteratorEntity.class, true));

        super.registerGoals();
    }
}
