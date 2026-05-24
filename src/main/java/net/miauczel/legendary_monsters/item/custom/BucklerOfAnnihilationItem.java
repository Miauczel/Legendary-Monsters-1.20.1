package net.miauczel.legendary_monsters.item.custom;

import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.AnnihilationSweepParticle;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.SmallAnnihilationBombEntity;
import net.miauczel.legendary_monsters.entity.ModEntities;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class BucklerOfAnnihilationItem extends ShieldItem {
    public BucklerOfAnnihilationItem(Properties pProperties) {
        super(pProperties.durability(800));
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {

        int useDuration = this.getUseDuration(pStack) - pTimeCharged;
        if (pLivingEntity instanceof Player player) {
            if (useDuration > 10 && player.isShiftKeyDown()) {
                pLevel.playSound(
                        null,
                        player.getX(), player.getY(), player.getZ(),
                        ModSounds.DIMENSIONAL_BOMB_EXPLODE_SMALL.get(),
                        SoundSource.PLAYERS,
                        1.0f, 1.0f
                );
                pLevel.playSound(
                        null,
                        player.getX(), player.getY(), player.getZ(),
                        ModSounds.GENERIC_ARM_SWING.get(),
                        SoundSource.PLAYERS,
                        1.0f, 1.0f
                );
                createSweep(player,0.35f, 0.25f, -10, false, 1);
             //   player.playSound(ModSounds.DIMENSIONAL_BOMB_EXPLODE_SMALL.get(), 1, 1);

                float f = Mth.cos(player.yBodyRot * ((float) Math.PI / 180F));
                float f1 = Mth.sin(player.yBodyRot * ((float) Math.PI / 180F));
                double theta = (player.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                float vec = 0;
                float vec2 = 1;
                float offset = 0;
                if (player.level().isClientSide) {
                    player.level().addParticle(ModParticles.ANNIHILATION_EXPLOSION.get(), (float) (player.getX() + vec2 * vecX + f * offset), 1.5f, (float) (player.getZ() + vec2 * vecZ + f1 * offset), 0, 0, 0);
                }
                shootAnnihilationBomb(player,1,player.getX(), player.getY()+1, player.getZ(),0);
                shootAnnihilationBomb(player,1,player.getX(), player.getY()+1, player.getZ(),15);
                shootAnnihilationBomb(player,1,player.getX(), player.getY()+1, player.getZ(),30);

                float r = 1.75f;
                double rad = Math.toRadians(player.getYRot() + 90);
                float cos = r * Mth.cos((float) rad);
                float sin = r * Mth.sin((float) rad);
                float boxWidth = 0.05f;
                AABB attackRange = player.getBoundingBox().inflate(boxWidth, 1.5f, boxWidth).expandTowards(cos, 0, sin);
                List<LivingEntity> list = player.level().getEntitiesOfClass(LivingEntity.class,attackRange);
                for (LivingEntity entity : player.level().getEntitiesOfClass(LivingEntity.class, attackRange)){
if (entity != player && !(entity instanceof TamableAnimal animal && animal.getOwner() == player)){

                        boolean flag = entity.hurt(player.damageSources().playerAttack(player), (float) (10 * ModConfig.MOB_CONFIG.BucklerOfAnnihilationSlashDamageMultiplier.get()));
                        if (flag){
                            entity.setSecondsOnFire(3);
                            Vec3 vec3 = entity.getDeltaMovement();
                            float factor = 1.25f;
                            entity.setDeltaMovement(vec3.x*factor,vec3.y*factor,vec3.z*factor);
                            pLevel.playSound(
                                   null,
                                    player.getX(), player.getY(), player.getZ(),
                                    ModSounds.THE_OBLITERATOR_STUN.get(),
                                    SoundSource.PLAYERS,
                                    1.0f, 1.0f
                            );
                           // player.playSound(ModSounds.THE_WARPED_ONE_STUN.get(),1f,1);
                            pStack.hurtAndBreak(1, player, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
                            if (!player.getCooldowns().isOnCooldown(this)) {
                                player.getCooldowns().addCooldown(this, 25);
                            }
                        }
                    }

                }
            }
        }
        super.releaseUsing(pStack, pLevel, pLivingEntity, pTimeCharged);
    }
    public void shootAnnihilationBomb(Player player, float velocity, double x, double y, double z,int inaccuracy) {


        SmallAnnihilationBombEntity chorusBomb = new SmallAnnihilationBombEntity(ModEntities.SMALL_ANNIHILATION_BOMB_ENTITY.get(), player.level(), (LivingEntity) player,
                (float) (8 * ModConfig.MOB_CONFIG.BucklerOfAnnihilationProjectileDamageMultiplier.get()));

        chorusBomb.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, velocity * 1, inaccuracy);
        chorusBomb.setPosRaw(x, y, z);


        chorusBomb.setOwner(player);
        //chorusBomb.setPos(x, y, z);
        player.level().addFreshEntity(chorusBomb);


    }
    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(Component.translatable("item.legendary_monsters.buckler_of_annihilation1"));
    }
    public void createSweep(Player player,float pos, float posOffset, float yHeight, boolean reverse, float scale) {
        float f = Mth.cos(player.yBodyRot * ((float) Math.PI / 180F));
        float f1 = Mth.sin(player.yBodyRot * ((float) Math.PI / 180F));
        double theta = (player.yBodyRot) * (Math.PI / 180);
        theta += Math.PI / 2;
        double vecX = Math.cos(theta);
        double vecZ = Math.sin(theta);
        float vec = pos;
        float offset = posOffset;
        double x = (player.getX() + vec * vecX + f * offset);
        double z = (player.getZ() + vec * vecZ + f1 * offset);
        if (player.level().isClientSide) {
            double d0 = x;
            double d1 = player.getY() + player.getBbHeight() / 2 - 0;
            double d2 = z;
            float yaw = (float) Math.toRadians(-player.yBodyRot + (reverse ? 180 : 0));
            double lookX = -Math.cos(yaw);
            double lookZ = -Math.sin(yaw);
            float pitch = (reverse ? -1 : 1) * (float) Math.atan2(yHeight, Math.sqrt(lookX * lookX + lookZ * lookZ));
            player.level().addParticle(new AnnihilationSweepParticle.SweepData(player.getScale() * scale, yaw, pitch), d0, d1, d2, 0, 0, 0);

        }
    }

}
