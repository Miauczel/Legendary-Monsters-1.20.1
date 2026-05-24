package net.miauczel.legendary_monsters.item.custom.CustomItemEvents;

import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.decoration.GlowItemFrame;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import javax.annotation.Nullable;
import java.util.List;

public class SoulGreatSwordRightClick {
    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().getUsedItemHand())
            return;
        double R2 = 0;
        double R1 = 0;
        double particleRadius = 0;
        double particleAmount = 0;
        double fireHeight = 0;
        double xRadius = 0;
        double loop = 0;
        double zRadius = 0;
        execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;

        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.SOUL_GREAT_SWORD.get()) {
            double R2 = 0;
            double R1 = 0;
            double particleRadius = 0;
            double particleAmount = 0;
            double fireHeight = 0;
            double xRadius = 0;
            double loop = 0;
            double zRadius = 0;
            loop = 1;
            particleAmount = 35;
            xRadius = 1;
            zRadius = 1;
            while (loop < particleAmount) {
                world.addParticle(ParticleTypes.SOUL, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), y, (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.05, 0);
                world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, (x + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), y, (z + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.05, 0);
                loop = loop + 1;

            }

            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ModItems.SOUL_GREAT_SWORD.get().asItem()) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(ModEffects.SOUL_RAGE.get(), 200, 0, false, true));
            }

            if (entity instanceof Player _player)
                _player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 280);


            if (world instanceof Level _level) {
                if (!_level.isClientSide()) {
                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float) 1, (float) 1);
                }

            }
            {




            }
        }
    }

}

