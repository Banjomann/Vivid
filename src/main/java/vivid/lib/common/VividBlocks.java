package vivid.lib.common;

import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class VividBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Constants.MODID);
    public static List<String> BLOCK_NAMES = BLOCKS.getEntries().stream()
                                            .filter(block -> block.getKey().location().getNamespace().equals(Constants.MODID))
                                            .map(block -> block.getRegisteredName())
                                            .collect(Collectors.toList());

    public static final DeferredHolder<Block, Block> VIVID_DUST_BLOCK = BLOCKS.register(
        Constants.VIVID_DUST_BLOCK_NAME,
        () -> new VividDustBlock()
    );
    public static final DeferredHolder<Block, OreBlock> VIVID_ORE_BLOCK = BLOCKS.register(
        Constants.VIVID_ORE_BLOCK_NAME,
        () -> new VividOreBlock()
    );
    public static final DeferredHolder<Block, OreBlock> VIVID_DEEPSLATE_ORE_BLOCK = BLOCKS.register(
        Constants.VIVID_DEEPSLATE_ORE_BLOCK_NAME,
        () -> new VividDeepslateOreBlock()
    );
}
