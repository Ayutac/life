package studio.abos.life.core.misc;

import lombok.NonNull;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.physics.Living;

public interface Harvester extends Living, InventoryHolding {

    boolean canHarvest(final @NonNull Harvestable harvestable, final @NonNull Shape tool);

    default void harvest(final @NonNull Harvestable harvestable, final @NonNull Shape tool) {
        addItems(harvestable.getYield(tool));
        harvestable.setHealth(0f);
    }

}
