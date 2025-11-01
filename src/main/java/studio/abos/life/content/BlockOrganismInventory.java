package studio.abos.life.content;

import lombok.Getter;
import lombok.NonNull;
import studio.abos.life.core.food.Nutrients;
import studio.abos.life.core.geometry.Measure3;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.geometry.Vec3;
import studio.abos.life.core.misc.Harvestable;
import studio.abos.life.core.misc.Inventory;
import studio.abos.life.core.misc.InventoryHolder;
import studio.abos.life.core.physics.MassShape;
import studio.abos.life.core.physics.Universe;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;

/**
 * Like a hand.
 */
public class BlockOrganismInventory extends BlockOrganism implements Inventory {

    @Getter
    protected final Collection<Shape> items = new LinkedList<>();

    public BlockOrganismInventory(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final float health, final @NonNull Function<Long, RipeCategory> ripeCategory, final @NonNull Map<RipeCategory, Measure3> ripeMeasure, final @NonNull Map<RipeCategory, Float> ripeMass, final @NonNull Map<RipeCategory, Nutrients> ripeNutrients, final @NonNull Map<RipeCategory, Function<Shape, Collection<Function<Harvestable, MassShape>>>> ripeYield) {
        super(universe, minimalPosition, health, ripeCategory, ripeMeasure, ripeMass, ripeNutrients, ripeYield);
    }

    public BlockOrganismInventory(final @NonNull InventoryHolder owner, final @NonNull Vec3 relativeMinimalPosition, final float health, final @NonNull Function<Long, RipeCategory> ripeCategory, final @NonNull Map<RipeCategory, Measure3> ripeMeasure, final @NonNull Map<RipeCategory, Float> ripeMass, final @NonNull Map<RipeCategory, Nutrients> ripeNutrients, final @NonNull Map<RipeCategory, Function<Shape, Collection<Function<Harvestable, MassShape>>>> ripeYield) {
        super(owner, relativeMinimalPosition, health, ripeCategory, ripeMeasure, ripeMass, ripeNutrients, ripeYield);
        owner.addInventory(this);
    }
}
