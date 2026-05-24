package net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.CloudyTemple;

import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.CloudGolem.Cloud_GolemEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.OriginClasses.IAnimatedMonster;
import net.miauczel.legendary_monsters.entity.ai.goal.IAttackGoal;
import net.miauczel.legendary_monsters.entity.ai.goal.IMoveGoal;
import net.miauczel.legendary_monsters.entity.ai.navigation.EntityRotationPatcher;
import net.miauczel.legendary_monsters.entity.ai.navigation.ModPathNavigation;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.sound.ModSounds;
import net.miauczel.legendary_monsters.util.EntityUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class StratlingEntity extends IAnimatedMonster implements Merchant {
    public StratlingEntity(EntityType entity, Level world) {
        super(entity, world);
        xpReward = 5;
populateTrades();
        this.setPersistenceRequired();
    }
    @Override
    public void setTradingPlayer(@Nullable Player player) {
        this.tradingPlayer = player;
    }

    @Override
    @Nullable
    public Player getTradingPlayer() {
        return this.tradingPlayer;
    }

    @Override
    public MerchantOffers getOffers() {
        return this.offers;
    }

    @Override
    public void overrideOffers(MerchantOffers offers) {
        this.offers = offers;
    }
    private MerchantOffers offers = new MerchantOffers();
    private Player tradingPlayer;

    @Override
    public void notifyTrade(MerchantOffer offer) {
        offer.increaseUses();
    }

    @Override
    public void notifyTradeUpdated(ItemStack stack) {
    }
    private boolean hasTraded = false;

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack,0.0f);
        if (itementity != null) {
            itementity.setGlowingTag(true);
            itementity.setExtendedLifetime();
        }
        return itementity;
    }
    @Override
    public int getVillagerXp() {
        return 0;
    }

    @Override
    public void overrideXp(int pXp) {
    }
    private void startTrading(Player pPlayer) {
        if (this.getTarget() == null) {
            this.setTradingPlayer(pPlayer);
            this.openTradingScreen(pPlayer, this.getDisplayName(), 1);
            this.hasTraded = true;
        }
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (itemstack.getItem() != Items.VILLAGER_SPAWN_EGG && this.isAlive()  && !this.isSleeping() && !pPlayer.isSecondaryUseActive()) {
            if (this.isBaby()) {
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            } else {
                boolean flag = this.getOffers().isEmpty();
                if (pHand == InteractionHand.MAIN_HAND) {
                    if (flag && !this.level().isClientSide) {
                    }

                    pPlayer.awardStat(Stats.TALKED_TO_VILLAGER);
                }

                if (flag) {
                    return InteractionResult.sidedSuccess(this.level().isClientSide);
                } else {
                    if (!this.level().isClientSide && !this.offers.isEmpty()) {
                        this.startTrading(pPlayer);
                    }

                    return InteractionResult.sidedSuccess(this.level().isClientSide);
                }
            }
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
    }
    public void populateTrades() {
        List<MerchantOffer> allPossibleOffers = new ArrayList<>();
        int randomPrice = Mth.nextInt(getRandom(), 8, 32);
        ItemStack itemstack1 = new ItemStack(Items.GOLDEN_CARROT, Mth.nextInt(this.random, 2, 5));
        ItemStack itemstack3 = new ItemStack(Items.BREAD, Mth.nextInt(this.random, 2, 4));
        ItemStack itemstack2 = new ItemStack(Items.BOOK, Mth.nextInt(this.random, 3, 5));

        ItemStack itemstack4 = new ItemStack(Items.GLOW_BERRIES, Mth.nextInt(this.random, 6, 10));

        ItemStack itemstack5 = new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 3, 5));

        ItemStack itemstack6 = new ItemStack(Items.DIAMOND, Mth.nextInt(this.random, 2, 3));

        ItemStack itemstack7 = new ItemStack(Items.NAME_TAG, Mth.nextInt(this.random, 1, 1));

        ItemStack itemstack8 = new ItemStack(Items.LAPIS_LAZULI, Mth.nextInt(this.random, 1, 3));

        ItemStack itemstack9 = new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 6, 8));

        ItemStack itemstack12 = new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 1, 2));
        ItemStack itemstack11 = new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 10, 25));
        ItemStack itemstack10 = new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 10, 25));

        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(Items.AMETHYST_SHARD, randomPrice),
                createRandomEnchantedBook(),
                10, 1, 0.05F
        ));
        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 10, 13)),
                Items.ENDER_PEARL.getDefaultInstance(),
                3, 1, 0.05F
        ));
        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 8, 12)),
                itemstack6,
                6, 1, 0.05F
        ));
        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 10, 20)),
                Items.EMERALD_BLOCK.getDefaultInstance(),
                6, 1, 0.05F
        ));
        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 12, 48)),
                createRandomEnchantedBook(),
                2, 1, 0.05F
        ));
        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 12, 48)),
                createRandomEnchantedBook(),
                2, 1, 0.05F
        ));
        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 7, 10)),
                itemstack1,
                10, 1, 0.05F
        ));
        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 4, 8)),
                itemstack2,
                10, 1, 0.05F
        ));
        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 6, 9)),
                itemstack3,
                10, 1, 0.05F
        ));

        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(Items.AMETHYST_SHARD, Mth.nextInt(this.random, 3, 4)),
                itemstack4,
                10, 1, 0.05F
        ));
        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(Items.BOOK, Mth.nextInt(this.random, 2, 3)),
                itemstack5,
                7, 1, 0.05F
        ));
        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(Items.LAPIS_LAZULI, Mth.nextInt(this.random, 1, 3)),
                itemstack5,
                7, 1, 0.05F
        ));
                allPossibleOffers.add(new MerchantOffer(
                new ItemStack(ModItems.CLOUD_ROD.get(), 1),
                itemstack10,
                3, 1, 0.05F
        ));
        ItemStack itemStack = new ItemStack(
                ModItems.MUSIC_DISC_CLOUD_GOLEM.get(), 1);

        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(ModItems.CLOUD_ROD.get(), 6),itemStack,
                3, 1, 0.05F
        ));

        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(ModItems.CHISELED_ANCIENT_DRIPTONE_SHARD.get(), 1),itemstack11,
                10, 1, 0.05F
        ));
        allPossibleOffers.add(new MerchantOffer(
                new ItemStack(ModItems.ANCIENT_SPIKE.get(), 1),itemstack12,
                30, 1, 0.05F
        ));

        Collections.shuffle(allPossibleOffers, new Random(this.random.nextLong()));

        MerchantOffers selectedOffers = new MerchantOffers();
        Set<String> usedKeys = new HashSet<>();
        for (MerchantOffer offer : allPossibleOffers) {
            String key = getOfferKey(offer);
            if (!usedKeys.contains(key)) {
                usedKeys.add(key);
                selectedOffers.add(offer);
            }
            if (selectedOffers.size() >= 7) {
                break;
            }
        }
        this.offers = selectedOffers;
    }
    public int ticksUntilNextAllert=0;
    private void handleAlerting(){
        if (ticksUntilNextAllert <=0){
            if (this.getTarget() !=null){
            alertOthers();
            }
        }
        ticksUntilNextAllert--;
    }
    private void alertOthers() {

        ticksUntilNextAllert=100;
        double d0 = this.getAttributeValue(Attributes.FOLLOW_RANGE);
        AABB aabb = AABB.unitCubeFromLowerCorner(this.position()).inflate(d0, 10.0D, d0);
        this.level().getEntitiesOfClass(StratlingEntity.class, aabb, EntitySelector.NO_SPECTATORS).stream().filter((p_34463_) -> {
            return p_34463_ != this;
        }).filter((p_289465_) -> {
            return p_289465_.getTarget() == null;
        }).filter((p_289463_) -> {if (this.getTarget() !=null) {
            return !p_289463_.isAlliedTo(this.getTarget());
        }else return this.isAlliedTo(p_289463_);
        }).forEach((p_289464_) -> {
            p_289464_.setTarget(this.getTarget());
        });
    }
    private String getOfferKey(MerchantOffer offer) {
        String costA = offer.getCostA().getItem().getDescriptionId() + "_" + offer.getCostA().getCount();
        String result = offer.getResult().getItem().getDescriptionId() + "_" + offer.getResult().getCount();
        String costB = "";
        if (!offer.getCostB().isEmpty()) {
            costB = offer.getCostB().getItem().getDescriptionId() + "_" + offer.getCostB().getCount();
        }
        return costA + "_" + costB + "_" + result;
    }
    private ItemStack createRandomEnchantedBook() {
        ItemStack enchantedBook = new ItemStack(Items.ENCHANTED_BOOK);
        Enchantment randomEnchant = getRandomEnchantment();
        int randomLevel = Mth.nextInt(this.random, 1, randomEnchant.getMaxLevel());
        EnchantedBookItem.addEnchantment(enchantedBook, new EnchantmentInstance(randomEnchant, randomLevel));
        return enchantedBook;
    }

    private Enchantment getRandomEnchantment() {
        List<Enchantment> enchantments = BuiltInRegistries.ENCHANTMENT.stream()
                .filter(enchantment -> enchantment.category == EnchantmentCategory.WEAPON || enchantment.category == EnchantmentCategory.ARMOR
                        || enchantment.category == EnchantmentCategory.DIGGER
                        || enchantment.category == EnchantmentCategory.ARMOR_FEET
                        || enchantment.category == EnchantmentCategory.ARMOR_HEAD|| enchantment.category == EnchantmentCategory.ARMOR_LEGS
                        || enchantment.category == EnchantmentCategory.BOW|| enchantment.category == EnchantmentCategory.CROSSBOW|| enchantment.category == EnchantmentCategory.TRIDENT) // Customize categories
                .toList();

        return enchantments.get(this.random.nextInt(enchantments.size()));
    }

    @Override
    public boolean showProgressBar() {
        return false;
    }

    @Override
    public SoundEvent getNotifyTradeSound() {
        return SoundEvents.VILLAGER_YES;
    }

    @Override
    public boolean isClientSide() {
        return false;
    }
    private void sendActionBarMessageToPlayer(Player player, String message) {
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.connection.send(new ClientboundSetActionBarTextPacket(Component.translatable(message)));
        }
    }
    @Override
    public void tick() {
        for(Player livingentity : this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(1.3D, 0.0D, 1.3D))) {
            if (this.getTarget() == null) {
                sendActionBarMessageToPlayer(livingentity, "legendary_monsters.message.stratling_interaction");
            }
        }
        handleAlerting();
        updateWithAttack();
        if (this.level().isClientSide()) {
            this.idleAnimationState.animateWhen(this.getAttackState() == 0, this.tickCount);
        }
if (this.getTarget() instanceof Cloud_GolemEntity) {
    this.setTarget(null);
}
        super.tick();
    }


    protected boolean canDespawn()
    {

        return false;
    }

    protected boolean shouldDespawnInPeaceful() {
        return false;
    }
    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (this.getHealth() == this.getMaxHealth()) {
           // updateAttributes();
        }
        this.hasTraded = compound.getBoolean("HasTraded");

        if (this.hasTraded && compound.contains("Offers", 10)) {
            this.offers = new MerchantOffers(compound.getCompound("Offers"));
        } else {
            this.populateTrades();
        }

    }
    /*
    public void updateAttributes() {
        double healthMultiplier = ModConfig.MOB_CONFIG.StratlingHealthMultiplier.get();
        double damageMultiplier = ModConfig.MOB_CONFIG.StratlingDamageMultiplier.get();

        AttributeInstance healthAttribute = this.getAttribute(Attributes.MAX_HEALTH);
        AttributeInstance attackDamageAttribute = this.getAttribute(Attributes.ATTACK_DAMAGE);

        double baseHealth = 30D; // podstawowe zdrowie moba
        double baseAttackDamage = 5D; // podstawowe obrażenia moba

        double newHealth = baseHealth * healthMultiplier;
        double newAttackDamage = baseAttackDamage * damageMultiplier;

        if (healthAttribute != null && healthAttribute.getBaseValue() != newHealth) {
            healthAttribute.setBaseValue(newHealth);
            this.setHealth((float) newHealth); // Aktualizuj bieżące zdrowie, aby pasowało do maksymalnego zdrowia
        }

        if (attackDamageAttribute != null && attackDamageAttribute.getBaseValue() != newAttackDamage) {
            attackDamageAttribute.setBaseValue(newAttackDamage);
        }
    }
    */

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
        EntityUtil.applyHealthMultiplier(this,ModConfig.MOB_CONFIG.StratlingHealthMultiplier.get());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);

        compound.putBoolean("HasTraded", this.hasTraded);

        if (this.hasTraded && !this.offers.isEmpty()) {
            compound.put("Offers", this.offers.createTag());
        }
    }


    @Override

    protected void registerGoals() {

       this.goalSelector.addGoal(5, new RandomStrollGoal(this, 3.0D, 80));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
     //   this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.goalSelector.addGoal(2, new IMoveGoal(this, false, 3.0D));
        this.goalSelector.addGoal(1, new StratlingAttackGoal(this, 0, 2, 0, 25, 25, 3.5F){
            public boolean canUse() {
            return super.canUse() && StratlingEntity.this.getRandom().nextFloat() * 40.0F < 16.0F
                    && StratlingEntity.this.getTarget() != null && StratlingEntity.this.getAttackState() !=3;
        }});

        this.goalSelector.addGoal(1, new IAttackGoal(this, 0, 3, 0, 35, 35, 5F){
            public boolean canUse() {
                return super.canUse() && StratlingEntity.this.getRandom().nextFloat() * 40.0F < 16.0F
                        && StratlingEntity.this.getTarget() != null && StratlingEntity.this.getAttackState() !=2;
            }});

    }
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,  30)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0F)
                .add(Attributes.FOLLOW_RANGE, 20D)
                .add(Attributes.ARMOR, 5D)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                .add(Attributes.ATTACK_KNOCKBACK, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 6);
    }
    public AnimationState idleAnimationState = new AnimationState();

    public AnimationState upperCutAnimationState = new AnimationState();
    public AnimationState slapAnimationState = new AnimationState();

    public AnimationState deathAnimationState = new AnimationState();
    public AnimationState getAnimationState(String input) {
       if (input == "slap") {
            return this.slapAnimationState;
        } else if (input == "idle") {
            return this.idleAnimationState;
        }
        else if (input == "uppercut") {
            return this.upperCutAnimationState;
        }

        else {
            return new AnimationState();
        }
    }


    public void setSleep(boolean sleep) {
        this.setAttackState(sleep ? 1 : 0);
    }
    public void onSyncedDataUpdated(EntityDataAccessor<?> p_21104_) {
        if (ATTACK_STATE.equals(p_21104_)) {
            if (this.level().isClientSide)
                switch (this.getAttackState()) {
                    case 0 -> this.stopAllAnimationStates();
                    case 1 -> {
                        this.stopAllAnimationStates();
                        this.idleAnimationState.startIfStopped(this.tickCount);
                    }
                     case 2 -> {
                        this.stopAllAnimationStates();
                        this.slapAnimationState.startIfStopped(this.tickCount);
                    }




                    case 3 -> {
                        this.stopAllAnimationStates();
                        this.upperCutAnimationState.startIfStopped(this.tickCount);
                    }
                }
        }

        super.onSyncedDataUpdated(p_21104_);
    }
    public void stopAllAnimationStates() {
        this.idleAnimationState.stop();

        this.upperCutAnimationState.stop();
        this.slapAnimationState.stop();
        this.deathAnimationState.stop();
    }
    private void dash(float a1,float a2,float minD){
        if (this.onGround()) {

            LivingEntity target = this.getTarget();

            if(this.getTarget() != null) {
                assert target != null;
                double distanceToTarget =
                        this.distanceToSqr(target.getX(), target.getY(), target.getZ());
                if (distanceToTarget > minD) {

                    Vec3 vector3d = this.getDeltaMovement();
                    float f = this.getYRot() * (float) (Math.PI / 180.0);
                    Vec3 vector3d1 = new Vec3((double) (-Mth.sin(f)), this.getDeltaMovement().y, (double) Mth.cos(f)).scale(a1).add(vector3d.scale(a2));
                    this.setDeltaMovement(vector3d1.x, this.getDeltaMovement().y, vector3d1.z);
                }
            }}
    }
    private void AreaAttack(float range, float height, float arc, float damage) {
        List<LivingEntity> entitiesHit = this.getEntityLivingBaseNearby(range, height, range, range);
        for (LivingEntity entityHit : entitiesHit) {
            float entityHitAngle = (float) ((Math.atan2(entityHit.getZ() - this.getZ(), entityHit.getX() - this.getX()) * (180 / Math.PI) - 90) % 360);
            float entityAttackingAngle = this.yBodyRot % 360;
            if (entityHitAngle < 0) {
                entityHitAngle += 360;
            }
            if (entityAttackingAngle < 0) {
                entityAttackingAngle += 360;
            }


            float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
            float entityHitDistance = (float) Math.sqrt((entityHit.getZ() - this.getZ()) * (entityHit.getZ() - this.getZ()) + (entityHit.getX() - this.getX()) * (entityHit.getX() - this.getX()));
            if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                if (!isAlliedTo(entityHit) && !(entityHit instanceof StratlingEntity) &&!(entityHit instanceof Cloud_GolemEntity)&& entityHit != this) {


                   boolean flag =  entityHit.hurt(this.damageSources().mobAttack(this), (float) ((damage * ModConfig.MOB_CONFIG.StratlingDamageMultiplier.get())));
if (flag){
 //   playSound(ModSounds.POSESSED_PALADIN_ATTACK.get(),1,1.5f);
}
                }
            }
        }
    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.getAttackState() !=14 ||this.getAttackState() !=17){
            this.setNoGravity(false);
        }

            for (int i = 0; i < 0.5; ++i) {

                this.level().addParticle(ParticleTypes.CLOUD, this.getRandomX(1D), this.getRandomY(), this.getRandomZ(1D), 0D, 0.025D, 0D);
            }
        }
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CGA.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.CGH.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CGD.get();
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new EntityRotationPatcher(this);
    }
    protected PathNavigation createNavigation(Level worldIn) {
        return new ModPathNavigation(this, worldIn);
    }
    public void updateWithAttack(){
        if (getAttackState()==3){

            if (attackTicks ==8){
                playSound(ModSounds.GENERIC_ARM_SWING.get(),1,2);
                dash(1.3f,1f,3f);
            }
            if (attackTicks ==13){

                AreaAttack(3.2f,3,180,8);
            }
        }
        if (getAttackState()==2){
            if (attackTicks ==7){

                playSound(ModSounds.GENERIC_ARM_SWING.get(),1,2);
            }
            if (attackTicks ==10){
                AreaAttack(3.5f,3,180,5);
            }


        }
    }
    public static class StratlingAttackGoal extends Goal {
        protected final IAnimatedMonster entity;
        private final int getattackstate;
        private final int attackstate;
        private final int attackendstate;
        private final int attackMaxtick;
        private final int attackseetick;
        private final float attackrange;

        public StratlingAttackGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange) {
            this.entity = entity;
            this.setFlags(EnumSet.of( Flag.LOOK, Flag.JUMP));
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        public StratlingAttackGoal(IAnimatedMonster entity, int getattackstate, int attackstate, int attackendstate, int attackMaxtick, int attackseetick, float attackrange, EnumSet<Flag> interruptFlagTypes) {
            this.entity = entity;
            this.setFlags(interruptFlagTypes);
            this.getattackstate = getattackstate;
            this.attackstate = attackstate;
            this.attackendstate = attackendstate;
            this.attackMaxtick = attackMaxtick;
            this.attackseetick = attackseetick;
            this.attackrange = attackrange;
        }

        public boolean canUse() {
            LivingEntity target = this.entity.getTarget();
            return target != null && target.isAlive() && this.entity.distanceTo(target) < this.attackrange && this.entity.getAttackState() == this.getattackstate;
        }

        public void start() {
            this.entity.setAttackState(this.attackstate);
        }

        public void stop() {

            this.entity.setAttackState(this.attackendstate);
            this.entity.attackCooldown = 0;
        }

        public boolean canContinueToUse() {
            return this.entity.attackTicks < this.attackMaxtick;
        }

        public void tick() {
            LivingEntity target = this.entity.getTarget();
            if (this.entity.attackTicks < this.attackseetick && target != null) {
                this.entity.getLookControl().setLookAt(target, 30.0F, 30.0F);
                this.entity.lookAt(target, 30.0F, 30.0F);
            } else {
                this.entity.setYRot(this.entity.yRotO);
            }

        }

        public boolean requiresUpdateEveryTick() {
            return false;
        }
    }


}