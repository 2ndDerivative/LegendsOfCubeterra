package cubeterra.structure;

import cubeterra.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.ShiftableStructurePiece;
import net.minecraft.structure.StructureContext;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;

public class CursedDesertTempleGenerator extends ShiftableStructurePiece {
    public CursedDesertTempleGenerator(Random random, int x, int z) {
        super(ModStructurePieceType.CURSED_DESERT_TEMPLE, x, 64, z, 21, 15, 21, getRandomHorizontalDirection(random));
    }

    public CursedDesertTempleGenerator(StructureContext structureContext, NbtCompound nbtCompound) {
        super(ModStructurePieceType.CURSED_DESERT_TEMPLE, nbtCompound);
    }

    protected void writeNbt(StructureContext context, NbtCompound nbt) {
        super.writeNbt(context, nbt);
    }


    @Override
    public void generate(StructureWorldAccess world, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox chunkBox, ChunkPos chunkPos, BlockPos pivot) {
        if (this.adjustToMinHeight(world, -random.nextInt(3))) {
            this.fillWithOutline(world, chunkBox, 0, -4, 0, this.width - 1, 0, this.depth - 1, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);

            int i;
            for (i = 1; i <= 9; ++i) {
                this.fillWithOutline(world, chunkBox, i, i, i, this.width - 1 - i, i, this.depth - 1 - i, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
                this.fillWithOutline(world, chunkBox, i + 1, i, i + 1, this.width - 2 - i, i, this.depth - 2 - i, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            }

            for (i = 0; i < this.width; ++i) {
                for (int j = 0; j < this.depth; ++j) {
                    this.fillDownwards(world, Blocks.SANDSTONE.getDefaultState(), i, -5, j, chunkBox);
                }
            }

            BlockState blockState = Blocks.SANDSTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.NORTH);
            BlockState blockState2 = Blocks.SANDSTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH);
            BlockState blockState3 = Blocks.SANDSTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.EAST);
            BlockState blockState4 = Blocks.SANDSTONE_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.WEST);
            this.fillWithOutline(world, chunkBox, 0, 0, 0, 4, 9, 4, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 1, 10, 1, 3, 10, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.addBlock(world, blockState, 2, 10, 0, chunkBox);
            this.addBlock(world, blockState2, 2, 10, 4, chunkBox);
            this.addBlock(world, blockState3, 0, 10, 2, chunkBox);
            this.addBlock(world, blockState4, 4, 10, 2, chunkBox);
            this.fillWithOutline(world, chunkBox, this.width - 5, 0, 0, this.width - 1, 9, 4, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, this.width - 4, 10, 1, this.width - 2, 10, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.addBlock(world, blockState, this.width - 3, 10, 0, chunkBox);
            this.addBlock(world, blockState2, this.width - 3, 10, 4, chunkBox);
            this.addBlock(world, blockState3, this.width - 5, 10, 2, chunkBox);
            this.addBlock(world, blockState4, this.width - 1, 10, 2, chunkBox);
            this.fillWithOutline(world, chunkBox, 8, 0, 0, 12, 4, 4, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 9, 1, 0, 11, 3, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), 9, 1, 1, chunkBox);
            this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), 9, 2, 1, chunkBox);
            this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), 9, 3, 1, chunkBox);
            this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), 10, 3, 1, chunkBox);
            this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), 11, 3, 1, chunkBox);
            this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), 11, 2, 1, chunkBox);
            this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), 11, 1, 1, chunkBox);
            this.fillWithOutline(world, chunkBox, 4, 1, 1, 8, 3, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 4, 1, 2, 8, 2, 2, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 12, 1, 1, 16, 3, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 12, 1, 2, 16, 2, 2, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 5, 4, 5, this.width - 6, 4, this.depth - 6, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 9, 4, 9, 11, 4, 11, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 8, 1, 8, 8, 3, 8, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 12, 1, 8, 12, 3, 8, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 8, 1, 12, 8, 3, 12, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 12, 1, 12, 12, 3, 12, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 1, 1, 5, 4, 4, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, this.width - 5, 1, 5, this.width - 2, 4, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 6, 7, 9, 6, 7, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, this.width - 7, 7, 9, this.width - 7, 7, 11, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 5, 5, 9, 5, 7, 11, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, this.width - 6, 5, 9, this.width - 6, 7, 11, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
            this.addBlock(world, Blocks.AIR.getDefaultState(), 5, 5, 10, chunkBox);
            this.addBlock(world, Blocks.AIR.getDefaultState(), 5, 6, 10, chunkBox);
            this.addBlock(world, Blocks.AIR.getDefaultState(), 6, 6, 10, chunkBox);
            this.addBlock(world, Blocks.AIR.getDefaultState(), this.width - 6, 5, 10, chunkBox);
            this.addBlock(world, Blocks.AIR.getDefaultState(), this.width - 6, 6, 10, chunkBox);
            this.addBlock(world, Blocks.AIR.getDefaultState(), this.width - 7, 6, 10, chunkBox);
            this.fillWithOutline(world, chunkBox, 2, 4, 4, 2, 6, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, this.width - 3, 4, 4, this.width - 3, 6, 4, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.addBlock(world, blockState, 2, 4, 5, chunkBox);
            this.addBlock(world, blockState, 2, 3, 4, chunkBox);
            this.addBlock(world, blockState, this.width - 3, 4, 5, chunkBox);
            this.addBlock(world, blockState, this.width - 3, 3, 4, chunkBox);
            this.fillWithOutline(world, chunkBox, 1, 1, 3, 2, 2, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, this.width - 3, 1, 3, this.width - 2, 2, 3, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.addBlock(world, Blocks.SANDSTONE.getDefaultState(), 1, 1, 2, chunkBox);
            this.addBlock(world, Blocks.SANDSTONE.getDefaultState(), this.width - 2, 1, 2, chunkBox);
            this.addBlock(world, Blocks.SANDSTONE_SLAB.getDefaultState(), 1, 2, 2, chunkBox);
            this.addBlock(world, Blocks.SANDSTONE_SLAB.getDefaultState(), this.width - 2, 2, 2, chunkBox);
            this.addBlock(world, blockState4, 2, 1, 2, chunkBox);
            this.addBlock(world, blockState3, this.width - 3, 1, 2, chunkBox);
            this.fillWithOutline(world, chunkBox, 4, 3, 5, 4, 3, 17, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, this.width - 5, 3, 5, this.width - 5, 3, 17, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, 3, 1, 5, 4, 2, 16, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);
            this.fillWithOutline(world, chunkBox, this.width - 6, 1, 5, this.width - 5, 2, 16, Blocks.AIR.getDefaultState(), Blocks.AIR.getDefaultState(), false);

            int l;
            for (l = 5; l <= 17; l += 2) {
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), 4, 1, l, chunkBox);
                this.addBlock(world, Blocks.CHISELED_SANDSTONE.getDefaultState(), 4, 2, l, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), this.width - 5, 1, l, chunkBox);
                this.addBlock(world, Blocks.CHISELED_SANDSTONE.getDefaultState(), this.width - 5, 2, l, chunkBox);
            }

            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 10, 0, 7, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 10, 0, 8, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 9, 0, 9, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 11, 0, 9, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 8, 0, 10, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 12, 0, 10, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 7, 0, 10, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 13, 0, 10, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 9, 0, 11, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 11, 0, 11, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 10, 0, 12, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 10, 0, 13, chunkBox);
            this.addBlock(world, Blocks.BLACK_TERRACOTTA.getDefaultState(), 10, 0, 10, chunkBox);

            // Center Diamond
            this.addBlock(world, ModBlocks.SMOOTH_OBSIDIAN.getDefaultState(), 10, 0 , 9, chunkBox);
            this.addBlock(world, ModBlocks.SMOOTH_OBSIDIAN.getDefaultState(), 9, 0 , 10, chunkBox);
            this.addBlock(world, ModBlocks.SMOOTH_OBSIDIAN.getDefaultState(), 11, 0 , 10, chunkBox);
            this.addBlock(world, ModBlocks.SMOOTH_OBSIDIAN.getDefaultState(), 10, 0 , 11, chunkBox);

            // Outer Diamond
            this.addBlock(world, ModBlocks.SMOOTH_OBSIDIAN.getDefaultState(), 8, 0 , 9, chunkBox);
            this.addBlock(world, ModBlocks.SMOOTH_OBSIDIAN.getDefaultState(), 9, 0 , 8, chunkBox);
            this.addBlock(world, ModBlocks.SMOOTH_OBSIDIAN.getDefaultState(), 8, 0 , 11, chunkBox);
            this.addBlock(world, ModBlocks.SMOOTH_OBSIDIAN.getDefaultState(), 11, 0 , 8, chunkBox);
            this.addBlock(world, ModBlocks.SMOOTH_OBSIDIAN.getDefaultState(), 12, 0 , 9, chunkBox);
            this.addBlock(world, ModBlocks.SMOOTH_OBSIDIAN.getDefaultState(), 9, 0 , 12, chunkBox);
            this.addBlock(world, ModBlocks.SMOOTH_OBSIDIAN.getDefaultState(), 12, 0 , 11, chunkBox);
            this.addBlock(world, ModBlocks.SMOOTH_OBSIDIAN.getDefaultState(), 11, 0 , 12, chunkBox);


            for (l = 0; l <= this.width - 1; l += this.width - 1) {
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l, 2, 1, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 2, 2, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l, 2, 3, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l, 3, 1, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 3, 2, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l, 3, 3, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 4, 1, chunkBox);
                this.addBlock(world, Blocks.CHISELED_SANDSTONE.getDefaultState(), l, 4, 2, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 4, 3, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l, 5, 1, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 5, 2, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l, 5, 3, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 6, 1, chunkBox);
                this.addBlock(world, Blocks.CHISELED_SANDSTONE.getDefaultState(), l, 6, 2, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 6, 3, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 7, 1, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 7, 2, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 7, 3, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l, 8, 1, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l, 8, 2, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l, 8, 3, chunkBox);
            }

            for (l = 2; l <= this.width - 3; l += this.width - 3 - 2) {
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l - 1, 2, 0, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 2, 0, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l + 1, 2, 0, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l - 1, 3, 0, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 3, 0, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l + 1, 3, 0, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l - 1, 4, 0, chunkBox);
                this.addBlock(world, Blocks.CHISELED_SANDSTONE.getDefaultState(), l, 4, 0, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l + 1, 4, 0, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l - 1, 5, 0, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 5, 0, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l + 1, 5, 0, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l - 1, 6, 0, chunkBox);
                this.addBlock(world, Blocks.CHISELED_SANDSTONE.getDefaultState(), l, 6, 0, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l + 1, 6, 0, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l - 1, 7, 0, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l, 7, 0, chunkBox);
                this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), l + 1, 7, 0, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l - 1, 8, 0, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l, 8, 0, chunkBox);
                this.addBlock(world, Blocks.CUT_SANDSTONE.getDefaultState(), l + 1, 8, 0, chunkBox);
            }

            this.fillWithOutline(world, chunkBox, 8, 4, 0, 12, 6, 0, Blocks.CUT_SANDSTONE.getDefaultState(), Blocks.CUT_SANDSTONE.getDefaultState(), false);
            this.addBlock(world, Blocks.AIR.getDefaultState(), 8, 6, 0, chunkBox);
            this.addBlock(world, Blocks.AIR.getDefaultState(), 12, 6, 0, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 9, 5, 0, chunkBox);
            this.addBlock(world, Blocks.CHISELED_SANDSTONE.getDefaultState(), 10, 5, 0, chunkBox);
            this.addBlock(world, Blocks.GREEN_TERRACOTTA.getDefaultState(), 11, 5, 0, chunkBox);
        }
    }
}
