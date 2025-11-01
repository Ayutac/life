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
    @Getter
    protected long ripeAge;
    protected @NonNull Function<Long, RipeCategory> ripeCategory;
    @Getter
    protected @NonNull final Map<RipeCategory, Measure3> ripeMeasure;
    @Getter
    protected @NonNull final Map<RipeCategory, Float> ripeMass;
    @Getter
    protected @NonNull final Map<RipeCategory, Nutrients> ripeNutrients;
    @Getter
    protected @NonNull final Map<RipeCategory, Function<Shape, Collection<Function<Harvestable, MassShape>>>> ripeYield;

    public enum RipeCategory {
        BABY, // seed in case of plants
        YOUNG,
        MATURE,
        ROTTEN
    }

    public BlockOrganism(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final float health, final @NonNull Function<Long, RipeCategory> ripeCategory, final @NonNull Map<RipeCategory, Measure3> ripeMeasure, final @NonNull Map<RipeCategory, Float> ripeMass, final @NonNull Map<RipeCategory, Nutrients> ripeNutrients, final @NonNull Map<RipeCategory, Function<Shape, Collection<Function<Harvestable, MassShape>>>> ripeYield) {
        super(universe, minimalPosition, ripeMeasure.get(RipeCategory.BABY), ripeMass.get(RipeCategory.BABY), health, ripeNutrients.get(RipeCategory.BABY));
        this.ripeCategory = ripeCategory;
        this.ripeMeasure = Map.copyOf(ripeMeasure);
        this.ripeMass = Map.copyOf(ripeMass);
        this.ripeNutrients = Map.copyOf(ripeNutrients);
        this.ripeYield = Map.copyOf(ripeYield);
    }

    public RipeCategory getRipeCategory() {
        return ripeCategory.apply(age);
    }

    @Override
    public void ageOneTick() {
        super.ageOneTick();
        if (canRipe()) {
            ripeOneTick();
        }
    }

    @Override
    public void setAge(final long age) {
        super.setAge(age);
    }

    public boolean canRipe() {
        return false;
    }

    public void ripeOneTick() {
        ripeAge++;
        // TODO cache better
        final RipeCategory category = getRipeCategory();
        setMeasure(ripeMeasure.get(category));
        setMass(ripeMass.get(category));
        setNutrientValues(ripeNutrients.get(category));
    }

    public void setRipeAge(long ripeAge) {
        this.ripeAge = ripeAge;
        final RipeCategory category = getRipeCategory();
        setMeasure(ripeMeasure.get(category));
        setMass(ripeMass.get(category));
        setNutrientValues(ripeNutrients.get(category));
    }

    @Override
    public boolean canEat(final @NonNull Eatable eatable) {
        return false; // TODO implement
    }

    @Override
    public Collection<MassShape> getYield(final @NonNull Shape tool) {
        return ripeYield.get(getRipeCategory()).apply(tool).stream()
                .map(f -> f.apply(this))
                .toList();
    }
}
