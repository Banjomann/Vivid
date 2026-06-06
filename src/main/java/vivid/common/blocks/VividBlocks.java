package vivid.common.blocks;

import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import vivid.common.Constants;

public class VividBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Constants.MODID);

    public static List<String> blockNames() {
        return BLOCKS.getEntries().stream()
            .filter(block -> block.getKey().location().getNamespace().equals(Constants.MODID))
            .map(block -> block.getRegisteredName())
            .collect(Collectors.toList());
    }

    public static final DeferredBlock<Block> VIVID_DUST_BLOCK = BLOCKS.register(
        Constants.VIVID_DUST_BLOCK_NAME,
        key -> new VividDustBlock(key)
    );
    public static final DeferredBlock<Block> SCORCHED_DUST_BLOCK = BLOCKS.register(
        Constants.SCORCHED_DUST_BLOCK_NAME,
        key -> new VividDustBlock(key)
    );
    public static final DeferredBlock<Block> UMBRAL_DUST_BLOCK = BLOCKS.register(
        Constants.UMBRAL_DUST_BLOCK_NAME,
        key -> new VividDustBlock(key)
    );
    public static final DeferredBlock<OreBlock> VIVID_ORE_BLOCK = BLOCKS.register(
        Constants.VIVID_ORE_BLOCK_NAME,
        key -> new VividOreBlock(key)
    );
    public static final DeferredBlock<OreBlock> VIVID_DEEPSLATE_ORE_BLOCK = BLOCKS.register(
        Constants.VIVID_DEEPSLATE_ORE_BLOCK_NAME,
        key -> new VividDeepslateOreBlock(key)
    );
    public static final DeferredBlock<OreBlock> SCORCHED_ORE_BLOCK = BLOCKS.register(
        Constants.SCORCHED_ORE_BLOCK_NAME,
        key -> new OreBlock(key, 3.0F, SoundType.NETHERRACK)
    );
    public static final DeferredBlock<OreBlock> UMBRAL_ORE_BLOCK = BLOCKS.register(
        Constants.UMBRAL_ORE_BLOCK_NAME,
        key -> new OreBlock(key, 3.0F, SoundType.STONE)
    );
}
