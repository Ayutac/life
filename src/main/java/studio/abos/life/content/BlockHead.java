package studio.abos.life.content;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import studio.abos.life.core.character.Person;
import studio.abos.life.core.character.Personality;
import studio.abos.life.core.character.Relationship;
import studio.abos.life.core.food.Nutrients;
import studio.abos.life.core.geometry.Measure3;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.geometry.Vec3;
import studio.abos.life.core.misc.Harvestable;
import studio.abos.life.core.misc.Inventory;
import studio.abos.life.core.physics.MassShape;
import studio.abos.life.core.physics.Universe;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;

public class BlockHead extends BlockOrganismInventoryHolder implements Person, Inventory {

    @Getter
    @Setter
    protected Personality personality;
    @Getter
    protected final Map<Person, Relationship> relationships = new HashMap<>();
    @Getter
    protected final Collection<Shape> items = new LinkedList<>(); // mouth

    public BlockHead(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final float health, final @NonNull Function<Long, RipeCategory> ripeCategory, final @NonNull Map<RipeCategory, Measure3> ripeMeasure, final @NonNull Map<RipeCategory, Float> ripeMass, final @NonNull Map<RipeCategory, Nutrients> ripeNutrients, final @NonNull Map<RipeCategory, Function<Shape, Collection<Function<Harvestable, MassShape>>>> ripeYield, final @NonNull Personality personality) {
        super(universe, minimalPosition, health, ripeCategory, ripeMeasure, ripeMass, ripeNutrients, ripeYield);
        this.personality = personality;
        addInventory(this);
    }

    @FunctionalInterface
    public interface Type {

        BlockHead create(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final @NonNull Personality personality);

    }
}
