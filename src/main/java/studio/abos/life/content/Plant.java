package studio.abos.life.content;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import studio.abos.life.core.food.Eatable;
import studio.abos.life.core.food.Eater;
import studio.abos.life.core.food.Nutrients;
import studio.abos.life.core.geometry.Measure3;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.geometry.Vec3;
import studio.abos.life.core.misc.Harvestable;
import studio.abos.life.core.physics.Ageable;
import studio.abos.life.core.physics.BlockLiving;
import studio.abos.life.core.physics.MassShape;
import studio.abos.life.core.physics.Universe;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

public class Plant extends BlockLiving implements Ageable, Eatable, Eater, Harvestable {

    @Getter
    @Setter
    protected long age;
    @Getter
    @Setter
    protected Nutrients nutrientValues;
    @Getter
    @Setter
    protected Nutrients currentNutrients;
    @Getter
    @Setter
    protected Nutrients optimalNutrients;
    @Getter
    protected final Map<AgeCategory, Function<Shape, Collection<MassShape>>> ageYield;

    public enum AgeCategory {
        SEED,
        YOUNG,
        MATURE,
        ROTTEN
    }

    public Plant(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final @NonNull Measure3 measure, final float mass, final float health, final long age, final @NonNull Map<AgeCategory, Function<Shape, Collection<MassShape>>> ageYield) {
        super(universe, minimalPosition, measure, mass, health);
        this.age = age;
        this.ageYield = Map.copyOf(ageYield);
    }

    @Override
    public void ageOneTick() {
        age++;
    }

    public AgeCategory getAgeCategory() {
        return AgeCategory.SEED; // TODO implement
    }

    @Override
    public boolean canEat(final @NonNull Eatable eatable) {
        return false; // TODO implement
    }

    @Override
    public Collection<MassShape> getYield(@NonNull Shape tool) {
        return ageYield.get(getAgeCategory()).apply(tool);
    }
}
