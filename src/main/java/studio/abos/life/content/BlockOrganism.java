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
import studio.abos.life.core.physics.MassShape;
import studio.abos.life.core.physics.Universe;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

public class BlockOrganism extends BlockItem implements Eater, Harvestable {

    @Getter
    @Setter
    protected Nutrients currentNutrients;
    @Getter
    @Setter
    protected Nutrients optimalNutrients;
    protected @NonNull Function<Long, AgeCategory> ageCategory;
    @Getter
    protected @NonNull final Map<AgeCategory, Function<Shape, Collection<MassShape>>> ageYield;

    public enum AgeCategory {
        BABY, // seed in case of plants
        YOUNG,
        MATURE,
        ROTTEN
    }

    public BlockOrganism(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final @NonNull Measure3 measure, final float mass, final float health, final Nutrients nutrients, final @NonNull Function<Long, AgeCategory> ageCategory, final @NonNull Map<AgeCategory, Function<Shape, Collection<MassShape>>> ageYield) {
        super(universe, minimalPosition, measure, mass, health, nutrients);
        this.ageCategory = ageCategory;
        this.ageYield = Map.copyOf(ageYield);
    }

    public AgeCategory getAgeCategory() {
        return ageCategory.apply(age);
    }

    @Override
    public boolean canEat(final @NonNull Eatable eatable) {
        return false; // TODO implement
    }

    @Override
    public Collection<MassShape> getYield(final @NonNull Shape tool) {
        return ageYield.get(getAgeCategory()).apply(tool);
    }
}
