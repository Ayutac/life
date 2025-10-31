package studio.abos.life.content;

import lombok.Getter;
import lombok.NonNull;
import studio.abos.life.core.food.Nutrients;
import studio.abos.life.core.geometry.Measure3;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.geometry.Vec3;
import studio.abos.life.core.misc.Inventory;
import studio.abos.life.core.misc.InventoryHolder;
import studio.abos.life.core.physics.Universe;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SequencedSet;

/**
 * Like a limb.
 */
public class BlockInventoryForwarder extends BlockItem implements InventoryHolder {

    @Getter
    protected final Collection<Shape> ownedShapes = new HashSet<>();
    @Getter
    protected final SequencedSet<Inventory> inventories = new LinkedHashSet<>();

    public BlockInventoryForwarder(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final @NonNull Measure3 measure, final float mass, final float health, final @NonNull Nutrients nutrients) {
        super(universe, minimalPosition, measure, mass, health, nutrients);
    }

    public BlockInventoryForwarder(final InventoryHolder owner, final @NonNull Vec3 relativeMinimalPosition, final @NonNull Measure3 measure, final float mass, final float health, final @NonNull Nutrients nutrients) {
        super(owner, relativeMinimalPosition, measure, mass, health, nutrients);
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
