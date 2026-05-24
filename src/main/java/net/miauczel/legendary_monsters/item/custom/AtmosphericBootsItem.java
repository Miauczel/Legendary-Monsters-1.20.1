    package net.miauczel.legendary_monsters.item.custom;

    import net.miauczel.legendary_monsters.LegendaryMonsters;
    import net.minecraft.network.chat.Component;
    import net.minecraft.world.item.ArmorItem;
    import net.minecraft.world.item.ArmorMaterial;
    import net.minecraft.world.item.ItemStack;
    import net.minecraft.world.item.TooltipFlag;
    import net.minecraft.world.level.Level;
    import net.minecraftforge.common.MinecraftForge;
    import net.minecraftforge.eventbus.api.IEventBus;
    import net.minecraftforge.fml.common.Mod;
    import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

    import java.util.List;

    @Mod.EventBusSubscriber(modid = LegendaryMonsters.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public class AtmosphericBootsItem extends ArmorItem {





        public AtmosphericBootsItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
            super(pMaterial, pType, pProperties);
            IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
            modEventBus.register(this);
            MinecraftForge.EVENT_BUS.register(this);
        }
        @Override
        public void setDamage(ItemStack stack, int damage) {
                super.setDamage(stack, 0);
        }


        @Override
        public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
            super.appendHoverText(itemstack, world, list, flag);
            list.add(Component.translatable("item.legendary_monsters.atm_boots1"));
        }
    }
