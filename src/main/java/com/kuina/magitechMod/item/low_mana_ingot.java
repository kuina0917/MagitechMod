package com.kuina.magitechMod.item;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class low_mana_ingot extends Item {
    public low_mana_ingot() {
        super(new Properties()
                .fireResistant()
                .rarity(Rarity.COMMON)
                .stacksTo(64));
    }}