package net.miauczel.legendary_monsters.item.custom.customArmor.armorItem;

import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.Message.AnnihilatorHelmetAbilityMessage;
import net.miauczel.legendary_monsters.Particle.ModParticles;
import net.miauczel.legendary_monsters.Particle.custom.Circle;
import net.miauczel.legendary_monsters.damagetype.ModDamageTypes;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.item.custom.customArmor.AbstractArmorItem;
import net.miauczel.legendary_monsters.item.custom.customArmor.ModArmorMaterials;
import net.miauczel.legendary_monsters.item.custom.customArmor.client.model.AnnihilatorArmorModel;
import net.miauczel.legendary_monsters.item.custom.customArmor.client.model.provider.ArmorModelProvider;
import net.miauczel.legendary_monsters.item.custom.customArmor.client.model.provider.simpleModelProvider;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.BlockUtils;
import net.miauczel.legendary_monsters.util.MathUtils;
import net.miauczel.legendary_monsters.Message.MessageArmorKey;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;

public class AnnihilatorArmorItem extends AbstractArmorItem {
    private static final String LOCATION = makeCustomTextureLocation(LegendaryMonsters.MOD_ID, "annihilator");

    public AnnihilatorArmorItem(Type pType) {
        super(ModArmorMaterials.ANNIHILATOR, pType, new Properties().rarity(Rarity.EPIC).fireResistant());
    }

    public AnnihilatorArmorItem(ModArmorMaterials modArmorMaterials, Type pType, Properties rarity) {
        super(modArmorMaterials, pType, rarity);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @org.jetbrains.annotations.Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        if (getPieceType("helmet")) {
            pTooltipComponents.add(Component.translatable("item.legendary_monsters.annihilator_helmet1").withStyle(ChatFormatting.GRAY));
        }
        if (getPieceType("chestplate")) {
            pTooltipComponents.add(Component.translatable("item.legendary_monsters.annihilator_chestplate1").withStyle(ChatFormatting.GRAY));
        }
        if (getPieceType("leggings")) {
            pTooltipComponents.add(Component.translatable("item.legendary_monsters.annihilator_leggings1").withStyle(ChatFormatting.GRAY));
        }
        if (getPieceType("boots")) {
            pTooltipComponents.add(Component.translatable("item.legendary_monsters.annihilator_boots1").withStyle(ChatFormatting.GRAY));
        }

    }

    public boolean getPieceType(String piece) {
        switch (piece) {
            case "boots" -> {
                return this.getEquipmentSlot() == Type.BOOTS.getSlot() && getType() == Type.BOOTS;
            }
            case "helmet" -> {
                return this.getEquipmentSlot() == Type.HELMET.getSlot() && getType() == Type.HELMET;
            }
            case "chestplate" -> {
                return this.getEquipmentSlot() == Type.CHESTPLATE.getSlot() && getType() == Type.CHESTPLATE;
            }
            case "leggings" -> {
                return this.getEquipmentSlot() == Type.LEGGINGS.getSlot() && getType() == Type.LEGGINGS;
            }
            default -> {
                return false;
            }
        }
    }

    public void onKeyPacket(Player player, ItemStack itemStack, int Type) {
        if (getPieceType("helmet")) {
            if (player != null && !player.getCooldowns().isOnCooldown(this)) {
                int UUID = player.getUUID().hashCode();
                LegendaryMonsters.sendMSGToServer(new AnnihilatorHelmetAbilityMessage(0, UUID, 0));
            }
        }

    }

    public boolean usedChestplate = false;

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if (getPieceType("helmet")) {
            if (pEntity instanceof Player living) {
                int type = 6;
                if (living.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.ANNIHILATOR_HELMET.get() && pLevel.isClientSide && LegendaryMonsters.PROXY.getClientSidePlayer() == pEntity && LegendaryMonsters.PROXY.isKeyDown(type)) {
                    LegendaryMonsters.sendMSGToServer(new MessageArmorKey(EquipmentSlot.HEAD.ordinal(), living.getId(), type));
                    this.onKeyPacket(living, pStack, type);
                }
            }
        }
        if (getPieceType("chestplate")) {
            if (chestplateTicks >= 0 && chestplateTicks < 10) {
                chestplateTicks++;
                Sphereparticle(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 0.35f, 0, 2, (Player) pEntity);
            }
        }

       /* if (getPieceType("chestplate")) {
            if (pEntity instanceof Player player) {
                Level level = pLevel;
                // System.out.println("ChestplateTicks: " + chestplateTicks);
                if (chestplateTicks >= 0 && chestplateTicks < 10) {
                    Sphereparticle(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 0.35f, 0, 2, player);
                }
                boolean max = player.getHealth() <= player.getMaxHealth() * 0.5f;
                if (max && !player.getCooldowns().isOnCooldown(this)) {
                    player.getCooldowns().addCooldown(ModItems.ANNIHILATOR_CHESTPLATE.get(), MathUtils.toSeconds(20));
                    //player.playSound(ModSounds.TOTEM_USE, 1, 1);
                        level.playSound(null, BlockUtils.blockPosVec3(player.position()), ModSounds.TOTEM_USE, SoundSource.PLAYERS, 1, 1);
                        ParticleOptions particleOptions = new Circle.RingData(0, (float) Math.PI / 2f, 30, 0, 1, 0, 1, 100, false, Circle.EnumRingBehavior.GROW);
                     //   level1.sendParticles(particleOptions, player.getX(), player.getY() + 0.25f, player.getZ(), 1, 0, 0, 0, 0);
                    level.addParticle(particleOptions,player.getX(), player.getY() + 0.25f, player.getZ(),0,0,0);

                    player.addEffect(new MobEffectInstance(ModEffects.UNBREAKABLE.get(), MathUtils.toSeconds(4), 0));
                    // level.playSound(player, BlockUtils.blockPosVec3(player.position()), ModSounds.TOTEM_USE, SoundSource.PLAYERS, 1, 1);
                    AABB aabb = player.getBoundingBox().inflate(5);
                    for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, aabb)) {
                        if (entity == player)
                            continue;
                        if (entity instanceof TamableAnimal tamableAnimal && tamableAnimal.isTame() && tamableAnimal.getOwner() == player)
                            continue;
                        entity.hurt(ModDamageTypes.causeAnnihilationDamage(player, player), 15);
                        entity.setSecondsOnFire(3);
                    }
                    chestplateTicks = 0;
                }
            }
        }*/
        if (getPieceType("boots")){
            if (pEntity instanceof Player player){
                if (player.hasEffect(MobEffects.WEAKNESS)){
                    player.removeEffect(MobEffects.WEAKNESS);
                }else if (player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            }
     /*       BlockHitResult hitResult = VoidBelow(pEntity.level(), (Player) pEntity, ClipContext.Fluid.NONE);
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = hitResult.getBlockPos();
                if (blockPos. = Blocks.VOID_AIR.defaultBlockState())
            }*/
        }
    }

    public int chestplateTicks = -1;

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (getPieceType("chestplate")) {
           // System.out.println("ChestplateTicks: " + chestplateTicks);
            if (chestplateTicks >= 0 && chestplateTicks < 10) {
                Sphereparticle(ModParticles.SMALL_ANNIHILATION_FLAME.get(), 0.35f, 0, 2, player);
            }
            boolean max = player.getHealth() <= player.getMaxHealth() * 0.5f;
            if (max && !player.getCooldowns().isOnCooldown(this)) {
                player.getCooldowns().addCooldown(ModItems.ANNIHILATOR_CHESTPLATE.get(), MathUtils.toTicks(20));
                //player.playSound(ModSounds.TOTEM_USE, 1, 1);
                    level.playSound(null,BlockUtils.blockPosVec3(player.position()) , ModSounds.TOTEM_USE, SoundSource.PLAYERS,1,1);
                    ParticleOptions particleOptions = new Circle.RingData(0, (float) Math.PI / 2f, 30, 0, 1, 0, 1, 100, false, Circle.EnumRingBehavior.GROW);
                 //   level1.sendParticles(particleOptions, player.getX(), player.getY() + 0.25f, player.getZ(), 1, 0, 0, 0, 0);
                level.addParticle(particleOptions,player.getX(), player.getY() + 0.25f, player.getZ(),0,0,0);


                player.addEffect(new MobEffectInstance(ModEffects.UNBREAKABLE.get(), MathUtils.toTicks(4), 0));
               // level.playSound(player, BlockUtils.blockPosVec3(player.position()), ModSounds.TOTEM_USE, SoundSource.PLAYERS, 1, 1);
                AABB aabb = player.getBoundingBox().inflate(5);
                for (LivingEntity entity : level.getEntitiesOfClass(LivingEntity.class, aabb)) {
                    if (entity == player)
                        continue;
                    if (entity instanceof TamableAnimal tamableAnimal && tamableAnimal.isTame() && tamableAnimal.getOwner() == player)
                        continue;
                    entity.hurt(ModDamageTypes.causeAnnihilationDamage(player, player), 15);
                    entity.setSecondsOnFire(3);
                }
                chestplateTicks = 0;
            }
        }
    }


    private void Sphereparticle(ParticleOptions particleType, float height, float vec, float size, Player player) {
        if (player.level().isClientSide) {
            if (player.tickCount % 2 == 0) {
                double d0 = player.getX();
                double d1 = player.getY() + height;
                double d2 = player.getZ();
                double theta = (player.yBodyRot) * (Math.PI / 180);
                theta += Math.PI / 2;
                double vecX = Math.cos(theta);
                double vecZ = Math.sin(theta);
                for (float i = -size; i <= size; ++i) {
                    for (float j = -size; j <= size; ++j) {
                        for (float k = -size; k <= size; ++k) {
                            double d3 = (double) j + (player.getRandom().nextDouble() - player.getRandom().nextDouble()) * 0.5D;
                            double d4 = (double) i + (player.getRandom().nextDouble() - player.getRandom().nextDouble()) * 0.5D;
                            double d5 = (double) k + (player.getRandom().nextDouble() - player.getRandom().nextDouble()) * 0.5D;
                            double d6 = (double) Mth.sqrt((float) (d3 * d3 + d4 * d4 + d5 * d5)) / 0.5 + player.getRandom().nextGaussian() * 0.05D;


                            player.level().addParticle(particleType, d0 + vec * vecX, d1, d2 + vec * vecZ, d3 / d6, d4 / d6, d5 / d6);

                            if (i != -size && i != size && j != -size && j != size) {
                                k += size * 2 - 1;
                            }
                        }
                    }
                }
            }
        }
    }

    /*@Override
        public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
            super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
            if (getPieceType("helmet")) {
                if (pEntity instanceof Player player) {
                    HitResult hitResult = PlayerLookAtHitResult(pLevel, player, ClipContext.Fluid.NONE);
                    if (hitResult.getType() == HitResult.Type.BLOCK) {
                        BlockPos blockPos = BlockPos.containing(hitResult.getLocation());
                        player.teleportTo(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                    }
                }
            }

        }*/
    protected BlockHitResult VoidBelow(Level pLevel, Player pPlayer, ClipContext.Fluid pFluidMode) {
        float f = pPlayer.getXRot();
        float f1 = pPlayer.getYRot();
        Vec3 vec3 = pPlayer.getEyePosition();
        float f2 = Mth.cos(-f1 * ((float) Math.PI / 180F) - (float) Math.PI);
        float f3 = Mth.sin(-f1 * ((float) Math.PI / 180F) - (float) Math.PI);
        float f4 = -Mth.cos(-f * ((float) Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float) Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d1 = Math.toRadians(f + 90);
        double d0 = 10;
        Vec3 vec31 = vec3.add((double) d1 * d0, (double) d1 * d0, (double) d1 * d0);
        return pLevel.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, pFluidMode, pPlayer));
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }

    @Override
    protected boolean withCustomModel() {
        return true;
    }

    @Override
    protected ArmorModelProvider createModelProvider() {
        return new simpleModelProvider(AnnihilatorArmorModel::createBodyLayer, AnnihilatorArmorModel::new);
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return LOCATION;
    }

}
