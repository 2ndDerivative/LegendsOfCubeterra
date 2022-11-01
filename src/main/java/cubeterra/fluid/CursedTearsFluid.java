package cubeterra.fluid;

import cubeterra.block.ModBlocks;
import cubeterra.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class CursedTearsFluid extends FlowableFluid {
    @Override
    public boolean matchesType(Fluid fluid){
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    public Fluid getStill(){
        return ModFluids.CURSED_TEARS;
    }

    @Override
    public Fluid getFlowing(){
        return ModFluids.CURSED_TEARS_FLOWING;
    }

    @Override
    public Item getBucketItem(){
        return ModItems.CURSED_TEARS_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state){
        return ModBlocks.CURSED_TEARS.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }

    @Override
    public boolean isStill(FluidState state) {
        return false;
    }

    public static class Flowing extends CursedTearsFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder){
            super.appendProperties(builder);
            builder.add(LEVEL);
        }
    }

    public static class Still extends CursedTearsFluid {
        @Override
        public int getLevel(FluidState state){
            return 8;
        }
        @Override
        public boolean isStill(FluidState state){
            return true;
        }
    }

    @Override
    protected boolean isInfinite(){
        return false;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    protected boolean canBeReplacedWith(FluidState fluidState, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction) {
        return false;
    }

    @Override
    protected int getFlowSpeed(WorldView worldView) {
        return 4;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView worldView) {
        return 1;
    }

    @Override
    public int getLevel(FluidState state) {
        return state.get(LEVEL);
    }

    @Override
    public int getTickRate(WorldView worldView) {
        return 10;
    }

    @Override
    protected float getBlastResistance() {
        return 100.0F;
    }
}
