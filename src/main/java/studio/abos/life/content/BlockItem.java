package studio.abos.life.content;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import studio.abos.life.core.food.Eatable;
import studio.abos.life.core.food.Nutrients;
import studio.abos.life.core.geometry.Measure3;
import studio.abos.life.core.geometry.Vec3;
import studio.abos.life.core.misc.InventoryHolder;
import studio.abos.life.core.physics.Ageable;
import studio.abos.life.core.physics.Block;
import studio.abos.life.core.physics.Universe;

public class BlockItem extends Block implements Ageable, Eatable {

    @Getter
    @Setter
    protected InventoryHolder owner;
    @Getter
    @Setter
    protected float health;
    @Getter
    @Setter
    protected long age;
    @Getter
    @Setter
    protected Nutrients nutrientValues;

    public BlockItem(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final @NonNull Measure3 measure, final float mass, final @NonNull Vec3 velocity, final float health, final @NonNull Nutrients nutrients) {
        super(universe, minimalPosition, measure, mass, velocity);
        this.health = health;
        this.nutrientValues = nutrients;
    }

    public BlockItem(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final @NonNull Measure3 measure, final float mass, final float health, final @NonNull Nutrients nutrients) {
        this(universe, minimalPosition, measure, mass, Vec3.ZERO, health, nutrients);
    }

    public BlockItem(final InventoryHolder owner, final @NonNull Vec3 relativeMinimalPosition, final @NonNull Measure3 measure, final float mass, final float health, final @NonNull Nutrients nutrients) {
        this(owner.getUniverse(), owner.getMinimalPosition().add(relativeMinimalPosition), measure, mass, health, nutrients);
        owner.addOwnedShape(this);
        this.owner = owner;
        setAffectedByGravity(false);
    }

    @Override
    public void ageOneTick() {
        age++;
    }
}
