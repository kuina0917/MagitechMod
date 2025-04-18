package com.kuina.magitechMod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GlowingBlock extends Block {
    public static final IntegerProperty EMISSION = IntegerProperty.create("emission", 0, 15);
    public static final BooleanProperty INCREASING = BooleanProperty.create("increasing");

    public GlowingBlock(BlockBehaviour.Properties props) {
        super(props.lightLevel(state -> state.getValue(EMISSION)));
        // デフォルト状態
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(EMISSION, 0)
                .setValue(INCREASING, true)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b.add(EMISSION, INCREASING);
    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!world.isClientSide) world.scheduleTick(pos, this, 1);
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource rand) {
        int light = state.getValue(EMISSION);
        boolean inc = state.getValue(INCREASING);

        int next = inc ? light + 1 : light - 1;
        boolean nextInc = inc;
        if (next >= 15)  { next = 15; nextInc = false; }
        else if (next <= 0) { next = 0; nextInc = true; }

        BlockState newState = state
                .setValue(EMISSION, next)
                .setValue(INCREASING, nextInc);
        world.setBlockAndUpdate(pos, newState);
        world.scheduleTick(pos, this, 2);
    }
}