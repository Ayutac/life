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
import studio.abos.life.core.misc.Owner;
import studio.abos.life.core.physics.MassShape;
import studio.abos.life.core.physics.Universe;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.SequencedSet;
import java.util.function.Function;

/**
 * Like a limb, torso.
 */
public class BlockOrganismInventoryForwarder extends BlockOrganism implements InventoryHolder {

    @Getter
    protected final Collection<Shape> ownedShapes = new HashSet<>();
    @Getter
    protected final SequencedSet<Inventory> inventories = new LinkedHashSet<>();

    public BlockOrganismInventoryForwarder(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final float health, final @NonNull Function<Long, RipeCategory> ripeCategory, final @NonNull Map<RipeCategory, Measure3> ripeMeasure, final @NonNull Map<RipeCategory, Float> ripeMass, final @NonNull Map<RipeCategory, Nutrients> ripeNutrients, final @NonNull Map<RipeCategory, Function<Shape, Collection<Function<Harvestable, MassShape>>>> ripeYield) {
        super(universe, minimalPosition, health, ripeCategory, ripeMeasure, ripeMass, ripeNutrients, ripeYield);
    }

    public BlockOrganismInventoryForwarder(final @NonNull Owner owner, final Vec3 relativeMinimalPosition, final float health, final @NonNull Function<Long, RipeCategory> ripeCategory, final @NonNull Map<RipeCategory, Measure3> ripeMeasure, final @NonNull Map<RipeCategory, Float> ripeMass, final @NonNull Map<RipeCategory, Nutrients> ripeNutrients, final @NonNull Map<RipeCategory, Function<Shape, Collection<Function<Harvestable, MassShape>>>> ripeYield) {
        super(owner, relativeMinimalPosition, health, ripeCategory, ripeMeasure, ripeMass, ripeNutrients, ripeYield);
    }

    @Override
    public void addOwnedShape(final @NonNull Shape shape) {
        ownedShapes.add(shape);
    }

    @Override
    public void removeOwnedShape(final @NonNull Shape shape) {
        ownedShapes.remove(shape);
    }

    @Override
    public void addInventory(final @NonNull Inventory inventory) {
        inventories.add(inventory);
        if (owner != null) {
            owner.addInventory(inventory);
        }
    }

    @Override
    public void removeInventory(final @NonNull Inventory inventory) {
        inventories.remove(inventory);
        if (owner != null) {
            owner.removeInventory(inventory);
        }
    }

}
