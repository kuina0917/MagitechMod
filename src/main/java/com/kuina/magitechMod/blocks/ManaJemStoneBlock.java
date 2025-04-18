package com.kuina.magitechMod.blocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static net.minecraft.world.level.block.SoundType.AMETHYST;

public class ManaJemStoneBlock extends GlowingBlock {
    public ManaJemStoneBlock() {
        // コピー元のブロック（例：STONE）のプロパティを継承
        super(BlockBehaviour.Properties.copy(Blocks.STONE)
                .requiresCorrectToolForDrops()
                .sound(AMETHYST)
);
    }
}