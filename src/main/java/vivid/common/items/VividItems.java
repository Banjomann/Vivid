package vivid.common.items;

import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import vivid.common.Constants;
import vivid.common.blocks.VividBlocks;

public class VividItems {    
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Constants.MODID);
    
    public static List<String> itemNames() {
        return ITEMS.getEntries().stream()
            .filter(item -> item.getKey().location().getNamespace().equals(Constants.MODID))
            .map(item -> item.getRegisteredName())
            .collect(Collectors.toList());
    }

    public static final DeferredHolder<Item, DustItem> VIVID_DUST_ITEM = ITEMS.register(
        Constants.VIVID_DUST_ITEM_NAME,
        key -> new VividDustItem(new Item.Properties())
    );
    public static final DeferredHolder<Item, DustItem> SCORCHED_DUST_ITEM = ITEMS.register(
        Constants.SCORCHED_DUST_ITEM_NAME,
        key -> new DustItem(new Item.Properties())
    );
    public static final DeferredHolder<Item, DustItem> UMBRAL_DUST_ITEM = ITEMS.register(
        Constants.UMBRAL_DUST_ITEM_NAME,
        key -> new DustItem(new Item.Properties())
    );

    public static final DeferredItem<BlockItem> VIVID_DUST_BLOCK_ITEM = registerBlockItem(VividBlocks.VIVID_DUST_BLOCK);
    public static final DeferredItem<BlockItem> SCORCHED_DUST_BLOCK_ITEM = registerBlockItem(VividBlocks.SCORCHED_DUST_BLOCK);
    public static final DeferredItem<BlockItem> UMBRAL_DUST_BLOCK_ITEM = registerBlockItem(VividBlocks.UMBRAL_DUST_BLOCK);
    public static final DeferredItem<BlockItem> VIVID_ORE_BLOCK_ITEM = registerBlockItem(VividBlocks.VIVID_ORE_BLOCK);
    public static final DeferredItem<BlockItem> VIVID_DEEPSLATE_ORE_BLOCK_ITEM = registerBlockItem(VividBlocks.VIVID_DEEPSLATE_ORE_BLOCK);
    public static final DeferredItem<BlockItem> SCORCHED_ORE_BLOCK_ITEM = registerBlockItem(VividBlocks.SCORCHED_ORE_BLOCK);
    public static final DeferredItem<BlockItem> UMBRAL_ORE_BLOCK_ITEM = registerBlockItem(VividBlocks.UMBRAL_ORE_BLOCK);

    private static DeferredItem<BlockItem> registerBlockItem(DeferredBlock<?> block) {
        return ITEMS.registerSimpleBlockItem(block.getId().getPath(), block);
    }
}
