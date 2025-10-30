package studio.abos.life.core.physics;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import studio.abos.life.core.geometry.Measure3;
import studio.abos.life.core.geometry.Vec3;

public class BlockLiving extends Block implements Living {

    @Getter
    @Setter
    protected float health;

    public BlockLiving(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final @NonNull Measure3 measure, final float mass, final @NonNull Vec3 velocity, final float health) {
        super(universe, minimalPosition, measure, mass, velocity);
        this.health = health;
    }

    public BlockLiving(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final @NonNull Measure3 measure, final float mass, final float health) {
        this(universe, minimalPosition, measure, mass, Vec3.ZERO, health);
    }
}
