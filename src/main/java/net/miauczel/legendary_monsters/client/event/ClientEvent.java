package net.miauczel.legendary_monsters.client.event;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.miauczel.legendary_monsters.ClientProxy;
import net.miauczel.legendary_monsters.LegendaryMonsters;
import net.miauczel.legendary_monsters.client.ModBlockEntityWithoutLevelRenderer;
import net.miauczel.legendary_monsters.client.RenderUtils;
import net.miauczel.legendary_monsters.client.event.gui.CustomBossBar;
import net.miauczel.legendary_monsters.config.ModConfig;
import net.miauczel.legendary_monsters.effect.ModEffects;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Effect.CameraShakeEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.PossessedPaladin.PossessedPaladinEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.IAnimatedBoss.TheObliterator.TheObliteratorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.Pets.SkeloraptorEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.ShulkerTower.Shulker_MimicEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Mobs.SpaceStation.Flameborn.AnnihilationPursuer.AnnihilationPursuerEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.BigShulkerBulletEntity;
import net.miauczel.legendary_monsters.entity.AnimatedMonster.Projectile.ThrownEntity.EntityThrownEntity;
import net.miauczel.legendary_monsters.item.ModItems;
import net.miauczel.legendary_monsters.mixin.CameraInvoker;
import net.minecraft.client.Camera;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.data.Main;
import net.minecraft.network.protocol.game.ClientboundPlayerLookAtPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.lang.reflect.Method;
import java.util.Iterator;

@OnlyIn(Dist.CLIENT)
public class ClientEvent {

    public ClientEvent() {
    }

    private static final ResourceLocation[] TYPE_A_TEXTURES = new ResourceLocation[]{
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/annihilation_portal/type_a/annihilation_portal_0.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/annihilation_portal/type_a/annihilation_portal_1.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/annihilation_portal/type_a/annihilation_portal_2.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/annihilation_portal/type_a/annihilation_portal_3.png"),
            new ResourceLocation(LegendaryMonsters.MOD_ID, "textures/entity/annihilation_portal/type_a/annihilation_portal_4.png")
    };

    /*
@SubscribeEvent
public static void renderPortals(RenderLivingEvent.Pre renderLivingEvent){
    LivingEntity entity = renderLivingEvent.getEntity();
    PoseStack matrixstack = renderLivingEvent.getPoseStack();
    if (entity instanceof Player player){
        if (player.isUsingItem() && player.getMainHandItem().getItem() == ModItems.TESSERACT.get()){
            matrixstack.pushPose();
            MultiBufferSource bufferSource = renderLivingEvent.getMultiBufferSource();
            int partialTicks = (int) renderLivingEvent.getPartialTick();
            ResourceLocation[] texArr = TYPE_A_TEXTURES;
            int total = texArr.length;
            int frame = (int)((entity.tickCount + partialTicks) * 12.0F / 20.0F) % total;
            ResourceLocation tex = texArr[Math.floorMod(frame, total)];
            VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityTranslucentEmissive(tex));
            final int FULL_BRIGHT = LightTexture.pack(15, 15);
            double dy = 0.1f;
            RenderUtils.renderQuad(4,0,dy,0,90,0,0,consumer,matrixstack, OverlayTexture.NO_OVERLAY,FULL_BRIGHT);
            double dx = player.getX();
            double dz = player.getZ();
            for (int k = 0; k < 5; ++k) {
                float f3 = (float) k * (float) Math.PI * 2 / 5 + ((float) Math.PI * 2 / 10F);
                float multiplier = 7.5f;
                RenderUtils.renderQuad(2, Mth.cos(f3) * multiplier,dy,Mth.sin(f3) * multiplier,90,0,0,consumer,matrixstack, OverlayTexture.NO_OVERLAY,FULL_BRIGHT);
            }
            for (int k = 0; k < 5; ++k) {
                float f3 = (float) k * (float) Math.PI * 2 / 5 + ((float) Math.PI * 2 / 10F);
                float multiplier = 4f;

                RenderUtils.renderQuad(2, Mth.cos(f3) * multiplier, dy, Mth.sin(f3) * multiplier, 90, 0, 0, consumer, matrixstack, OverlayTexture.NO_OVERLAY, FULL_BRIGHT);
            }
            matrixstack.popPose();
        }
    }
}*/
   /* @SubscribeEvent
    public static void renderPortals(RenderLevelStageEvent event) {
        if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_PARTICLES)
            return;
    
        var mc = Minecraft.getInstance();
        var player = mc.player;
        if (player == null) return;

        if (!player.isUsingItem() || player.getMainHandItem().getItem() != ModItems.TESSERACT.get())
            return;
        Item item = player.getMainHandItem().getItem();
        ItemStack itemStack = item.getDefaultInstance();
        PoseStack poseStack = event.getPoseStack();
        var camPos = event.getCamera().getPosition();

        MultiBufferSource.BufferSource buffer = mc.renderBuffers().bufferSource();

        float pt = event.getPartialTick();
        ResourceLocation[] texArr = TYPE_A_TEXTURES;
        int total = texArr.length;
        int frame = (int)((player.tickCount + pt) * 12.0F / 20.0F) % total;
        ResourceLocation tex = texArr[Math.floorMod(frame, total)];

        RenderType rt = RenderType.entityTranslucentEmissive(tex);
        VertexConsumer consumer = buffer.getBuffer(rt);

        int FULL_BRIGHT = LightTexture.pack(15, 15);

        poseStack.pushPose();
double bigsize = Mth.clamp((player.getTicksUsingItem()*2)*0.1,0,4);

        double smallsize = Mth.clamp((player.getTicksUsingItem())*0.1,0,2);

        double dy = 0.1f;
        poseStack.translate(player.getX() - camPos.x, player.getY() - camPos.y, player.getZ() - camPos.z);
//System.out.println("Size: " + bigsize);
        RenderUtils.renderQuad((float) bigsize, 0, dy, 0, 90, 0, 0,
                consumer, poseStack, OverlayTexture.NO_OVERLAY, FULL_BRIGHT);

        for (int k = 0; k < 5; ++k) {
            float f3 = (float) k * (float) Math.PI * 2 / 5 + ((float) Math.PI * 2 / 10F);
            float multiplier = 7.5f;
            RenderUtils.renderQuad((float) smallsize, Mth.cos(f3) * multiplier,dy,Mth.sin(f3) * multiplier,90,0,0,consumer,poseStack, OverlayTexture.NO_OVERLAY,FULL_BRIGHT);
        }
        for (int k = 0; k < 5; ++k) {
            float f3 = (float) k * (float) Math.PI * 2 / 5 + ((float) Math.PI * 2 / 10F);
            float multiplier = 4f;

            RenderUtils.renderQuad((float) smallsize, Mth.cos(f3) * multiplier, dy, Mth.sin(f3) * multiplier, 90, 0, 0, consumer, poseStack, OverlayTexture.NO_OVERLAY, FULL_BRIGHT);
        }
        poseStack.popPose();

        buffer.endBatch(rt);
    }*/
    @SubscribeEvent
    public static void renderPortals(RenderLevelStageEvent event) {

        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return;
        Player player = mc.player;
        if (player != null) {
            if (!player.isUsingItem() || player.getMainHandItem().getItem() != ModItems.TESSERACT.get()) return;
            if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_PARTICLES) return;
            PoseStack matrix = event.getPoseStack();
            Camera cam = event.getCamera();
            Vec3 camPos = cam.getPosition();

            float pt = event.getPartialTick();

            MultiBufferSource.BufferSource buffer = mc.renderBuffers().bufferSource();

            matrix.pushPose();
            matrix.translate(-camPos.x, -camPos.y, -camPos.z);


            double x = Mth.lerp(pt, player.xOld, player.getX());
            double y = Mth.lerp(pt, player.yOld, player.getY());
            double z = Mth.lerp(pt, player.zOld, player.getZ());

            matrix.pushPose();
            matrix.translate(x, y, z);
            ResourceLocation[] texArr = TYPE_A_TEXTURES;
            int total = texArr.length;
            int frame = (int) ((player.tickCount + pt) * 12.0F / 20.0F) % total;
            ResourceLocation tex = texArr[Math.floorMod(frame, total)];

            RenderType rt = RenderType.entityTranslucentEmissive(tex);
            VertexConsumer vertexConsumer = buffer.getBuffer(rt);

            double dy = 0.1f;

            int FULL_BRIGHT = LightTexture.pack(15, 15);

            double bigsize = Mth.clamp((player.getTicksUsingItem() * 2) * 0.1, 0, 4);
            double smallsize = Mth.clamp((player.getTicksUsingItem()) * 0.1, 0, 2);

            RenderUtils.renderQuad((float) bigsize, 0, dy, 0, 90, 0, 0, vertexConsumer, matrix, OverlayTexture.NO_OVERLAY, FULL_BRIGHT);
            for (int k = 0; k < 5; ++k) {
                float f3 = (float) k * (float) Math.PI * 2 / 5 + ((float) Math.PI * 2 / 10F);
                float multiplier = 7.5f;
                RenderUtils.renderQuad((float) smallsize, Mth.cos(f3) * multiplier, dy, Mth.sin(f3) * multiplier, 90, 0, 0, vertexConsumer, matrix, OverlayTexture.NO_OVERLAY, FULL_BRIGHT);
            }
            for (int k = 0; k < 5; ++k) {
                float f3 = (float) k * (float) Math.PI * 2 / 5 + ((float) Math.PI * 2 / 10F);
                float multiplier = 4f;
                RenderUtils.renderQuad((float) smallsize, Mth.cos(f3) * multiplier, dy, Mth.sin(f3) * multiplier, 90, 0, 0, vertexConsumer, matrix, OverlayTexture.NO_OVERLAY, FULL_BRIGHT);
            }

            matrix.popPose();


            matrix.popPose();
            buffer.endBatch();
        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {

        if (event.phase == TickEvent.Phase.START) {
            ModBlockEntityWithoutLevelRenderer.incrementTick();
        }
        if (event.phase == TickEvent.Phase.END) {


            Minecraft mc = Minecraft.getInstance();
            if (mc.player == null) return;
            //Camera Change
            boolean isRidingWarp = ((mc.player.getVehicle() instanceof TheObliteratorEntity theWarpedOneEntity)
                    && theWarpedOneEntity.getAttackState() != 20 && theWarpedOneEntity.getAttackState() != 19 && theWarpedOneEntity.getAttackState() != 18)
                    || mc.player.getVehicle() instanceof EntityThrownEntity bulletEntity && bulletEntity.isVehicle()
                    || mc.player.getVehicle() instanceof BigShulkerBulletEntity BigShulkerbulletEntity && BigShulkerbulletEntity.isVehicle()
                    || mc.player.getVehicle() instanceof Shulker_MimicEntity ShulkerMimicEntity && ShulkerMimicEntity.isVehicle()
                    || mc.player.getVehicle() instanceof AnnihilationPursuerEntity AnnihilationPursuer && AnnihilationPursuer.isVehicle()
                    || mc.player.getVehicle() instanceof PossessedPaladinEntity PossessedPaladin && PossessedPaladin.isVehicle();

            if (isRidingWarp && !CameraApplied) {

                previousCameraType = mc.options.getCameraType();
                mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
                CameraApplied = true;
            } else if (!isRidingWarp && CameraApplied) {

                mc.options.setCameraType(previousCameraType);
                CameraApplied = false;
            }
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onPreRenderEntity(RenderLivingEvent.Pre event) {
        if (ClientProxy.blockedEntityRenders.contains(event.getEntity().getUUID())) {
            if (!LegendaryMonsters.PROXY.isFirstPersonPlayer(event.getEntity())) {
                MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Post(event.getEntity(), event.getRenderer(), event.getPartialTick(), event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight()));
                event.setCanceled(true);
            }
            ClientProxy.blockedEntityRenders.remove(event.getEntity().getUUID());
        }
    }

    @SubscribeEvent
    public static void onCameraSetup(ViewportEvent.ComputeCameraAngles event) {
        Player player = Minecraft.getInstance().player;
        float delta = Minecraft.getInstance().getFrameTime();
        float ticksExistedDelta = player.tickCount + delta;

        if (player != null) {
            float shakeAmplitude = 0.0F;
            Iterator<CameraShakeEntity> iterator = player.level().getEntitiesOfClass(CameraShakeEntity.class, player.getBoundingBox().inflate(20.0)).iterator();

            while (iterator.hasNext()) {
                CameraShakeEntity cameraShake = iterator.next();
                if (cameraShake.distanceTo(player) < cameraShake.getRadius()) {
                    shakeAmplitude += cameraShake.getShakeAmount(player, delta);
                }
            }

            if (shakeAmplitude > 1.0F) {
                shakeAmplitude = 1.0F;
            }

            event.setPitch((float) (event.getPitch() + shakeAmplitude * Math.cos(ticksExistedDelta * 3.0F + 2.0F) * 25.0));
            event.setYaw((float) (event.getYaw() + shakeAmplitude * Math.cos(ticksExistedDelta * 5.0F + 1.0F) * 25.0));
            event.setRoll((float) (event.getRoll() + shakeAmplitude * Math.cos(ticksExistedDelta * 4.0F) * 25.0));

            MobEffect stunEffect = ModEffects.STUN.get();
            MobEffectInstance effectInstance = player.getEffect(stunEffect);
            if (effectInstance != null) {
                float stunShakeAmplitude = (1 + effectInstance.getAmplifier()) * 0.01F;
                event.setPitch((float) (event.getPitch() + stunShakeAmplitude * Math.cos(ticksExistedDelta * 3.0F + 2.0F) * 25.0));
                event.setYaw((float) (event.getYaw() + stunShakeAmplitude * Math.cos(ticksExistedDelta * 5.0F + 1.0F) * 25.0));
                event.setRoll((float) (event.getRoll() + stunShakeAmplitude * Math.cos(ticksExistedDelta * 4.0F) * 25.0));

            }
            MobEffect curseEffect = ModEffects.PHARAONS_CURSE.get();
            MobEffectInstance curseInstance = player.getEffect(curseEffect);
            if (curseInstance != null) {
                event.setRoll(event.getRoll() + 180.0F);
                /**  float rotationSpeed = 10F; // Prędkość obrotu, możesz dostosować według potrzeb
                 float rollRotation = (ticksExistedDelta * rotationSpeed) % 360;
                 event.setRoll(rollRotation);*/
            }
        }
    }
    @SubscribeEvent
    public static void computeCameraAngles(ViewportEvent.ComputeCameraAngles event) {
        Entity camEntity = Minecraft.getInstance().getCameraEntity();
        if (camEntity == null) return;

        if (!camEntity.isPassenger()) return;
        if (!event.getCamera().isDetached()) return;

        Entity vehicle = camEntity.getVehicle();
        if (vehicle == null) return;

        double wanted;
        if (vehicle instanceof SkeloraptorEntity) wanted = 2.0D;
        else if (vehicle instanceof TheObliteratorEntity) wanted = 3.0D;
        else if (vehicle instanceof Shulker_MimicEntity
                || vehicle instanceof EntityThrownEntity
                || vehicle instanceof BigShulkerBulletEntity
                || vehicle instanceof AnnihilationPursuerEntity
                || vehicle instanceof PossessedPaladinEntity) wanted = 4.0D;
        else return;

        Camera cam = event.getCamera();
        CameraInvoker inv = (CameraInvoker) (Object) cam;

        double maxZoom = inv.legendaryMonsters$invokeGetMaxZoom(wanted);
        inv.legendaryMonsters$invokeMove(-maxZoom, 0.0D, 0.0D);
    }

    private static boolean CameraApplied = false;
    private static CameraType previousCameraType;


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void renderBossOverlay(CustomizeGuiOverlayEvent.BossEventProgress event) {
        if (ModConfig.MOB_CONFIG.allowCustomBossBar.get()) {
            if (ClientProxy.bossBarRenderTypes.containsKey(event.getBossEvent().getId())) {
                int renderTypeFor = ClientProxy.bossBarRenderTypes.get(event.getBossEvent().getId());

                CustomBossBar customBossBar = CustomBossBar.customBossBars.getOrDefault(renderTypeFor, null);
                if (customBossBar == null) return;

                event.setCanceled(true);
                customBossBar.renderBossBar(event);

            }
        }
    }
}

