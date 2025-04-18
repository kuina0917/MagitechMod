package com.kuina.magitechMod.regi.tab.magitech;

import com.kuina.magitechMod.regi.tab.magitechallitems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.kuina.magitechMod.regi.tab.magitechallitems.magitechItems.high_mana_ingot;
import static com.kuina.magitechMod.regi.tab.magitechallitems.magitechItems.low_mana_ingot;

public class magitechTabs {
    public static final DeferredRegister<CreativeModeTab> MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,"magitech");

    public static final RegistryObject<CreativeModeTab> magitech_Item = MOD_TABS.register("magithehitems",
            ()->{return CreativeModeTab.builder()
                    .icon(()->new ItemStack(magitechallitems.magitechItems.high_mana_ingot.get()))
                    .title(Component.translatable("itemGroup.magithitems"))
                    .displayItems(((param, output) ->{
                        for(Item item: magitechallitems.ITEMS){
                            output.accept(item);
                        }
                    }))


                    .build();

            });
}
