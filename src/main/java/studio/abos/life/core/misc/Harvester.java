package studio.abos.life.core.misc;

import lombok.NonNull;
import studio.abos.life.core.engine.ServerEngine;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.physics.Living;
import studio.abos.life.core.physics.MassShape;

import java.util.Collection;

public interface Harvester extends Living, InventoryHolder {

    boolean canHarvest(final @NonNull Harvestable harvestable, final @NonNull Shape tool);

    default void harvest(final @NonNull ServerEngine serverEngine, final @NonNull Harvestable harvestable, final @NonNull Shape tool) {
        final Collection<MassShape> yield = harvestable.getYield(tool);
        yield.forEach(serverEngine::addObject);
        addItems(yield);
        harvestable.setHealth(0f);
    }

}
