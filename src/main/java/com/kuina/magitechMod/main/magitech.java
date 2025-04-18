package com.kuina.magitechMod.main;

import com.kuina.magitechMod.regi.tab.magitech.magitechTabs;
import com.kuina.magitechMod.regi.tab.magitechallitems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@SuppressWarnings("removal")
@Mod("magitech")
public class magitech {

    public static final String MOD_ID = "magitech";

    public magitech() {


            IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
            magitechallitems.magitechItems.ITEMS.register(bus);
            magitechallitems.magitechFluids.FLUIDS.register(bus);
            magitechallitems.magitechBlocks.Blocks.BLOCKS.register(bus);
            magitechTabs.MOD_TABS.register(bus);
    }

}
