package vivid.common.blocks;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class OreBlock extends Block {
    public OreBlock(ResourceLocation id) {
        this(id, 3.0F, SoundType.STONE);
    }

    protected OreBlock(ResourceLocation id, float strength, SoundType soundType) {
        super(BlockBehaviour.Properties.of()
            .requiresCorrectToolForDrops()
            .strength(strength, 3.0F)
            .sound(soundType));
    }
}
