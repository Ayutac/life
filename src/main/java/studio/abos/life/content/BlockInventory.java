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
import java.util.LinkedList;

/**
 * Like a hand.
 */
public class BlockInventory extends BlockItem implements Inventory {

    @Getter
    protected final Collection<Shape> items = new LinkedList<>();

    public BlockInventory(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final @NonNull Measure3 measure, final float mass, final float health, final @NonNull Nutrients nutrients) {
        super(universe, minimalPosition, measure, mass, health, nutrients);
    }

    public BlockInventory(final InventoryHolder owner, final @NonNull Vec3 relativeMinimalPosition, final @NonNull Measure3 measure, final float mass, final float health, final @NonNull Nutrients nutrients) {
        super(owner, relativeMinimalPosition, measure, mass, health, nutrients);
        owner.addInventory(this);
    }

}
