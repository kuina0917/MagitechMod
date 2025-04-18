package com.kuina.magitechMod.regi.tab;

import com.kuina.magitechMod.main.magitech;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.AMETHYST_BLOCK;
import static net.minecraft.world.level.block.Blocks.STONE;
import static net.minecraft.world.level.block.SoundType.AMETHYST;
import static net.minecraft.world.level.block.SoundType.ANVIL;

/*すべてのアイテムのクラスごとの分類と、アイテム登録class
バニラアイテムはタブ表示用の仮置きアイテム
モッドアイテムの場合は.アイテム名.get();
 */

public class magitechallitems {
    public static final Item[] ITEMS = {
            magitechItems.low_mana_ingot.get(),
            magitechItems.middle_mana_ingot.get(),
            magitechItems.high_mana_ingot.get(),
            magitechItems.mana_stone.get(),
    };
    public static final Fluid[] FLUIDS = {
    };

            public static class magitechItems {
                public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, magitech.MOD_ID);
                public static final RegistryObject<Item> low_mana_ingot = ITEMS.register("low_mana_ingot", com.kuina.magitechMod.item.low_mana_ingot::new);
                public static final RegistryObject<Item> middle_mana_ingot = ITEMS.register("middle_mana_ingot", () -> new Item(new Item.Properties()));
                public static final RegistryObject<Item> high_mana_ingot = ITEMS.register("high_mana_ingot", () -> new Item(new Item.Properties()));
                public static final RegistryObject<BlockItem> mana_stone = ITEMS.register("mana_stone", ()->new BlockItem(magitechBlocks.Blocks.mana_stone.get(), new Item.Properties()));
                public static final RegistryObject<BlockItem> mana_jem_stone = ITEMS.register("mana_jem_stone", ()->new BlockItem(magitechBlocks.Blocks.mana_jem_stone.get(), new Item.Properties()));


            }

            public static class magitechBlocks {

                public static class Blocks {
                    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, magitech.MOD_ID);
                    public static final RegistryObject<Block> mana_stone = BLOCKS.register("mana_stone", () -> new Block(BlockBehaviour.Properties.copy(STONE)
                            .strength(2.0f, 1.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.STONE)));
                    public static final RegistryObject<Block> mana_jem_stone = BLOCKS.register("mana_jem_stone", () -> new Block(BlockBehaviour.Properties.copy(mana_stone.get())
                            .strength(2.0f, 1.0f)
                            .requiresCorrectToolForDrops()
                            .sound(AMETHYST)));



                }

            }
            public static class magitechFluids{
                public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, "magitech");
            }
}










