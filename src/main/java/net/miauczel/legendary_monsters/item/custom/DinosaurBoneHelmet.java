    package net.miauczel.legendary_monsters.item.custom;

    import net.miauczel.legendary_monsters.LegendaryMonsters;
    import net.miauczel.legendary_monsters.item.ModArmorItem;
    import net.miauczel.legendary_monsters.item.custom.customArmor.ModArmorMaterials;
    import net.minecraft.network.chat.Component;
    import net.minecraft.world.effect.MobEffectInstance;
    import net.minecraft.world.effect.MobEffects;
    import net.minecraft.world.entity.EquipmentSlot;
    import net.minecraft.world.entity.player.Player;
    import net.minecraft.world.item.ArmorItem;
    import net.minecraft.world.item.ArmorMaterial;
    import net.minecraft.world.item.ItemStack;
    import net.minecraft.world.item.TooltipFlag;
    import net.minecraft.world.level.Level;
    import net.minecraftforge.common.MinecraftForge;
    import net.minecraftforge.event.TickEvent;
    import net.minecraftforge.eventbus.api.IEventBus;
    import net.minecraftforge.eventbus.api.SubscribeEvent;
    import net.minecraftforge.fml.common.Mod;
    import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

    import java.util.List;

    @Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class DinosaurBoneHelmet extends ArmorItem {


        private static final MobEffectInstance MOSSY_ARMOR_EFFECT =
                new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 1, false, false, true);

        public DinosaurBoneHelmet(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
            super(pMaterial, pType, pProperties);
            IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
            modEventBus.register(this);
            MinecraftForge.EVENT_BUS.register(this);
        }

        private static boolean hasMossyChestplate(Player player) {
            ItemStack chestplateStack = player.getInventory().armor.get(2);

            return !chestplateStack.isEmpty() && chestplateStack.getItem() instanceof ModArmorItem &&
                    ((ModArmorItem) chestplateStack.getItem()).getMaterial() == ModArmorMaterials.DINOSAUR_BONE;
        }
        @SubscribeEvent
        @SuppressWarnings("unused")
        public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
            if (event.phase == TickEvent.Phase.START) {
                Player player = event.player;
                if (!player.level().isClientSide()) {
                    ItemStack chestplateItemStack = player.getInventory().armor.get(EquipmentSlot.CHEST.getIndex());
                    if (!chestplateItemStack.isEmpty() && chestplateItemStack.getItem() instanceof WitheredRibcageItem) {
                        if (hasMossyChestplate(player)) {
                            addMossyArmorEffect(player);
                        } else {
                            removePoisonEffect(player);
                        }
                    }
                }
            }
        }
        private static final MobEffectInstance BONE_EFFECT =
                new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 1, false, false, true);
        private static void addMossyArmorEffect(Player player) {
            boolean hasPlayerEffect = player.hasEffect(BONE_EFFECT.getEffect());

            if (!hasPlayerEffect) {
                player.addEffect(new MobEffectInstance(BONE_EFFECT));
            }
        }
        private static void removePoisonEffect(Player player) {




        }


        @Override
        public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
            super.appendHoverText(itemstack, world, list, flag);
            list.add(Component.literal("\u00A76SPECIAL ABILITY: \u00A76\u00A7l[HEAD PROTECTION] \u00A76 25% chance of ignoring damage from arrows or"));
            list.add(Component.literal("\u00A76mob projectiles"));
        }
    }
