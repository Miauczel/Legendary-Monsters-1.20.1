package net.miauczel.legendary_monsters.item.custom.customArmor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.miauczel.legendary_monsters.item.custom.customArmor.client.model.ArmorModel;
import net.miauczel.legendary_monsters.item.custom.customArmor.client.model.provider.ArmorModelProvider;
import net.minecraft.Util;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.*;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractArmorItem extends ArmorItem {

    public AbstractArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    public boolean isFullSetActive(LivingEntity living) {
        return isFullSetActive(living, this.getMaterial());
    }

    public static boolean isFullSetActive(LivingEntity living, ArmorMaterial materials) {
        if (living == null) {
            return false;
        }
        ArmorItem head = living.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof ArmorItem armorItem ? armorItem : null;
        Item chestPlate = living.getItemBySlot(EquipmentSlot.CHEST).getItem();
        ArmorItem chest;
        if (chestPlate instanceof ElytraItem || chestPlate instanceof AirItem) {
            return false;
        } else {
            chest = (ArmorItem) living.getItemBySlot(EquipmentSlot.CHEST).getItem();
        }
        ArmorItem legs = living.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof ArmorItem armorItem ? armorItem : null;
        ArmorItem feet = living.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof ArmorItem armorItem ? armorItem : null;
        return (head != null && legs != null && feet != null) && (head.getMaterial() == materials && chest.getMaterial() == materials && legs.getMaterial() == materials && feet.getMaterial() == materials);
    }

    public Multimap<Attribute, AttributeModifier> getAttributeMods(EquipmentSlot slot) {
        return null;
    }

    @Override
    public @NotNull Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot slot) {
        HashMultimap<Attribute, AttributeModifier> builder = HashMultimap.create();
        builder.putAll(super.getDefaultAttributeModifiers(slot));
        if (this.getAttributeMods(slot) != null) {
            builder.putAll(this.getAttributeMods(slot));
        }
        return builder;
    }

    //region display / model

    protected boolean withCustomModel() { return false; }

    /**
     * @return the model provider to use
     * no need to cache, this implementation does that already
     */
    protected ArmorModelProvider createModelProvider() { return null;}

    @Override
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        if (!withCustomModel()) return;
        consumer.accept(new IClientItemExtensions() {
            private final ArmorModelProvider provider = createModelProvider();

            @Override
            public @NotNull ArmorModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> original) {
                ArmorModel armorModel = provider.getModel(living, stack, slot);
                armorModel.partVisible(slot);
                armorModel.crouching = original.crouching;
                armorModel.riding = original.riding;
                armorModel.young = original.young;
                return armorModel;
            }

            @Override
            public @NotNull Model getGenericArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                //fixes visibility bug because forge pain
                ArmorModel model = getHumanoidArmorModel(livingEntity, itemStack, equipmentSlot, original);
                copyModelProperties(original, model);
                return model;
            }

            @SuppressWarnings("unchecked")
            private <T extends LivingEntity> void copyModelProperties(HumanoidModel<T> original, ArmorModel replacement) {
                original.copyPropertiesTo((HumanoidModel<T>) replacement);
                replacement.rightBoot.copyFrom(original.rightLeg);
                replacement.leftBoot.copyFrom(original.leftLeg);
            }
        });
    }

    /**
     * creates a custom texture for your armor in
     * <br>{@code <nameSpace>:textures/models/armor/custom/<id>.png}
     */
    public static String makeCustomTextureLocation(String nameSpace, String id) {
        return new ResourceLocation(nameSpace, "textures/models/armor/custom/" + id + ".png").toString();
    }

    //endregion
    /**
     * @param registry the Register to add to
     * @param baseName the base name of the armor
     * @param creator a lambda function to create an instance of the armor, mostly a method reference to the constructor
     * @return a Map mapping the ArmorType to the RegObj for the slot
     */
    public static <T extends AbstractArmorItem> Map<Type, RegistryObject<T>> createRegistry(DeferredRegister<Item> registry, String baseName, Function<Type, T> creator) {
        return Util.make(new EnumMap<>(Type.class), map -> {
            for (Type type : Type.values()) {
                map.put(type, registry.register(baseName + "_" + type.getName(), () -> creator.apply(type)));
            }
        });
    }
}