# Foundational Resource Generation

These values describe Vivid's current world-generation targets. They should be
revisited after playtesting in newly generated chunks rather than inferred from
existing terrain.

| Resource | Eligible terrain | Vein size | Attempts per chunk | Height |
| --- | --- | ---: | ---: | --- |
| Vivid Ore | Overworld stone | 7 | 4 | Y 16 to 64, uniform |
| Vivid Deepslate Ore | Overworld deepslate | 7 | 8 | Y -31 to 0, uniform |
| Scorched Ore | Netherrack | 5 | 16 | 10 blocks above the bottom to 10 below the top, uniform |
| Umbral Ore | End stone in all End biomes | 5 | 4 | Y 0 to 80, uniform |

The two Vivid placements cover different vertical spans. Their separate attempt
counts are intentional: the deepslate band is narrower, so its higher count
keeps discovery coherent without restoring the previous overall abundance.
