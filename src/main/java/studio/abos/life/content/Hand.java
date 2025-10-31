package studio.abos.life.content;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import studio.abos.life.core.food.Eatable;
import studio.abos.life.core.food.Nutrients;
import studio.abos.life.core.geometry.Measure3;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.geometry.Vec3;
import studio.abos.life.core.misc.Inventory;
import studio.abos.life.core.misc.InventoryHolder;
import studio.abos.life.core.physics.BlockLiving;
import studio.abos.life.core.physics.Universe;

import java.util.Collection;
import java.util.LinkedList;

public class Hand extends BlockLiving implements Eatable, Inventory {

    @Getter
    @Setter
    protected Nutrients nutrientValues;

    @Getter
    protected final Collection<Shape> items = new LinkedList<>();

    public Hand(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final @NonNull Measure3 measure, final float mass, final float health, final @NonNull Nutrients nutrients) {
        super(universe, minimalPosition, measure, mass, health);
        this.nutrientValues = nutrients;
    }

    public Hand(final InventoryHolder owner, final @NonNull Vec3 relativeMinimalPosition, final @NonNull Measure3 measure, final float mass, final float health, final @NonNull Nutrients nutrients) {
        this(owner.getUniverse(), owner.getMinimalPosition().add(relativeMinimalPosition), measure, mass, health, nutrients);
        owner.getInventories().add(this);
        setAffectedByGravity(false);
    }
}
