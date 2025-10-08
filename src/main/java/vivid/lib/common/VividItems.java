package vivid.lib.common;

import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class VividItems {    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Constants.MODID);
    
    public static List<String> ITEM_NAMES = ITEMS.getEntries().stream()
                                            .filter(item -> item.getKey().location().getNamespace().equals(Constants.MODID))
                                            .map(item -> item.getRegisteredName())
                                            .collect(Collectors.toList());

    public static final DeferredHolder<Item, DustItem> VIVID_DUST_ITEM = ITEMS.register(
        Constants.VIVID_DUST_ITEM_NAME,
        () -> new VividDustItem()
    );
}
