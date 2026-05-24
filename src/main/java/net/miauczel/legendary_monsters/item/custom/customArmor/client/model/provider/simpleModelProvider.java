package net.miauczel.legendary_monsters.item.custom.customArmor.client.model.provider;

import net.miauczel.legendary_monsters.item.custom.customArmor.client.model.ArmorModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.function.Function;
import java.util.function.Supplier;

public class simpleModelProvider implements ArmorModelProvider {
    private final ArmorModel model;

    public simpleModelProvider(Supplier<LayerDefinition> definitionSupplier, Function<ModelPart, ArmorModel> model) {
        this.model = model.apply(definitionSupplier.get().bakeRoot());
    }

    @Override
    public ArmorModel getModel(LivingEntity living, ItemStack stack, EquipmentSlot slot) {
        return model;
    }
}