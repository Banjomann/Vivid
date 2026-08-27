# Vivid Mod Family Roadmap

This document records the current direction for Vivid and prospective companion
mods. Features remain subject to prototyping and playtesting before their scope
is considered final.

## Family principles

- Vivid is the required foundation and must provide a complete progression on
  its own.
- Vivid Dust, Scorched Dust, and Umbral Dust remain foundational resources in
  base Vivid. They are not separate mods or universal color categories.
- Companion mods should have a distinct gameplay domain rather than exist only
  to hold more content.
- Integrations between companion mods should be optional wherever practical.
- Features should support conventional inventory automation when that does not
  undermine their gameplay purpose.
- Color is not a family-wide progression system. Individual features may use
  color when it has a clear cosmetic or functional purpose.

## Base Vivid

Vivid centers on using the power of life to improve processes, equipment, and
the world. Its planned progression is discovery, cultivation, imbuement,
specialization, mastery, and bounded world impact.

### Existing foundation

- Vivid Dust, its storage block, and overworld stone and deepslate ores
- Scorched Dust, its storage block, and Nether ore
- Umbral Dust, its storage block, and End ore
- Supporting world generation, recipes, loot tables, tags, models, and textures

### Cultivation

Cultivation should make continued Vivid progression sustainable without letting
one mining trip create an unlimited dust loop.

The current direction is to cultivate a secondary resource, provisionally
called Living Essence. Renewable biological inputs provide the ongoing material
cost, while foundational dust acts as a finite catalyst or charge. Cultivation
therefore stretches mined dust and supports automation without manufacturing
more dust directly.

Potential constraints include processing time, substantial biomass use,
periodic dust recharge, environmental requirements, and efficiency bonuses for
varied biological inputs. The initial implementation should remain compact and
prove that the interaction is worthwhile before adding a multiblock system.

### Imbuement

The Imbuement Station is a deterministic, automation-compatible alternative to
ritual or enchanting-style progression. It should use explicit slots, recipes,
and costs rather than random choices, experience-level gambling, or loose items
placed in the world.

Imbuement changes an item's behavior or identity while remaining compatible
with ordinary enchantments. Vivid, Scorched, and Umbral serve as affinities
within this system.

### Specialization and mastery

Imbued equipment should require meaningful choices instead of accumulating
every available benefit. An item may have one affinity, one specialization,
limited adaptation capacity, and a late-game mastery trait.

Mastery should develop through relevant use and culminate in a small number of
behavioral capstones. It should not be a universal item-level experience bar or
an unrestricted collection of numerical bonuses.

### Bounded world impact

Late-game Vivid systems may improve a visible, limited area through effects such
as crop support, replanting, passive-animal care, restoration, hostile-spawn
suppression, or biome-aware ecological benefits. These systems should consume
resources or have explicit throughput limits, and they should improve vanilla
systems rather than replace them with invisible global bonuses.

## Arbitrary-color Vivid blocks

Base Vivid will provide a Dyeing Station and Vivid variants of eligible
dyed or dyeable blocks. This is a focused building feature, not a universal
color-based progression mechanic.

### Dyeing Station

- Converts foundational dust into an internal Vivid Dye buffer.
- Preserves a `1:2:4` conversion ratio for Vivid, Scorched, and Umbral Dust.
- Accepts hexadecimal and RGB input through a color picker.
- Shows the selected color and resulting block before processing.
- Consumes Vivid Dye for each converted or recolored block.
- Retains its selected color so hoppers, pipes, and storage systems can process
  batches automatically.
- May later support copying a color from an existing Vivid block.

### One-way variant conversion

Any vanilla color of an eligible block family may be used as the initial input.
The Dyeing Station converts it directly into the corresponding Vivid variant,
and the station's selected RGB value determines the output color. Separate
recipes for each vanilla color are neither needed nor planned.

The conversion is one-way. A Vivid variant may be recolored in the station but
does not convert back into a vanilla color variant.

Each Vivid block family has one registered variant, such as Vivid Wool or Vivid
Concrete. Its exact 24-bit color belongs to the individual item or placed block.
An uncolored Vivid variant is white and visually matches the corresponding
vanilla white block.

### Initial eligibility

Strong initial candidates are:

- Wool
- Carpet
- Concrete
- Concrete powder
- Terracotta
- Glass
- Glass panes
- Candles

Blocks are eligible when their vanilla variants differ primarily by a uniform
tint. Blocks with distinct artwork, geometry, or behavior per color are
excluded. Plain terracotta is eligible; glazed terracotta is explicitly
excluded.

Beds, banners, shulker boxes, signs, and other blocks with more complex state or
rendering may be evaluated later.

### Technical gate

Arbitrary per-block RGB values require persistent data, client synchronization,
item preservation, and tint-aware rendering. A non-ticking block entity is the
straightforward storage model, but its cost in large decorative builds must be
measured.

Vivid Wool should be implemented first as a technical prototype. Validation
must cover large builds, chunk loading and saving, breaking and placement,
Pick Block, drops, pistons, structure operations, client synchronization, and
rendering performance before the remaining block families are added.

## Planned companion mods

No repository is required until work on a companion mod begins. These entries
preserve their intended boundaries in the meantime.

### Vivid Technology

Adds energy-powered machines, alloys, processing, logistics, and automated
resource acquisition using Vivid's foundational materials. Forge Energy is the
expected interoperability layer unless a distinct Vivid energy system later
proves necessary. A general-purpose automated mining device belongs here rather
than in base Vivid.

### Vivid Lighting

Adds decorative and functional light-producing blocks crafted from Vivid's
foundational resources. Arbitrary or broad color selection is central here,
but it does not impose color mechanics on other family mods.

### Vivid Mobs

Adds passive and hostile entities shaped by Vivid, Scorched, and Umbral forces.
Creatures should have distinctive behaviors, habitats, player responses, and
relationships to foundational resources rather than being recolored vanilla
mob variants.

### Vivid Biomes

Adds optional world-generation content including biomes, vegetation, natural
blocks, terrain features, ambience, and biome-specific structures. Base Vivid
may react to vanilla or modded biome context but will not add custom biomes.

Vivid Biomes and Vivid Mobs should integrate when both are installed without
making either companion mod depend on the other. Custom biomes should have a
distinct ecological or gameplay purpose rather than rely on unusual foliage
colors alone.

## Idea nursery

Ideas that do not yet justify committed scope should remain here until they
have a distinct player purpose, a clear project boundary, and a plausible
implementation path.

- Companion-mod integrations among Technology, Lighting, Mobs, and Biomes
- Biome-aware Vivid world effects
- Complex arbitrary-color block families
- Data-driven compatibility for eligible blocks from other mods
