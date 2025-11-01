package studio.abos.life.content;

import lombok.experimental.UtilityClass;
import studio.abos.life.core.food.Nutrients;
import studio.abos.life.core.geometry.Measure3;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.misc.Harvestable;
import studio.abos.life.core.physics.MassShape;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

@UtilityClass
public class Maps {

    // Wheat
    public final Map<BlockOrganism.RipeCategory, Measure3> WHEAT_MEASURE = new EnumMap<>(BlockOrganism.RipeCategory.class);
    public final Map<BlockOrganism.RipeCategory, Float> WHEAT_MASS = new EnumMap<>(BlockOrganism.RipeCategory.class);
    public final Map<BlockOrganism.RipeCategory, Nutrients> WHEAT_NUTRIENTS = new EnumMap<>(BlockOrganism.RipeCategory.class);
    public final Map<BlockOrganism.RipeCategory, Function<Shape, Collection<Function<Harvestable, MassShape>>>> WHEAT_YIELD = new EnumMap<>(BlockOrganism.RipeCategory.class);
    // Human Head
    public final Map<BlockOrganism.RipeCategory, Measure3> HUMAN_HEAD_MEASURE = new EnumMap<>(BlockOrganism.RipeCategory.class);
    public final Map<BlockOrganism.RipeCategory, Float> HUMAN_HEAD_MASS = new EnumMap<>(BlockOrganism.RipeCategory.class);
    public final Map<BlockOrganism.RipeCategory, Nutrients> HUMAN_HEAD_NUTRIENTS = new EnumMap<>(BlockOrganism.RipeCategory.class);
    public final Map<BlockOrganism.RipeCategory, Function<Shape, Collection<Function<Harvestable, MassShape>>>> HUMAN_HEAD_YIELD = new EnumMap<>(BlockOrganism.RipeCategory.class);
    
    static {
        // Wheat
        WHEAT_MEASURE.put(BlockOrganism.RipeCategory.BABY, Measure3.cube(0.001f));
        WHEAT_MEASURE.put(BlockOrganism.RipeCategory.YOUNG, new Measure3(0.001f, 0.05f, 0.001f));
        WHEAT_MEASURE.put(BlockOrganism.RipeCategory.MATURE, new Measure3(0.001f, 1f, 0.001f));
        WHEAT_MEASURE.put(BlockOrganism.RipeCategory.EXPIRED, new Measure3(0.001f, 0.8f, 0.001f));
        WHEAT_MASS.put(BlockOrganism.RipeCategory.BABY, 0.001f);
        WHEAT_MASS.put(BlockOrganism.RipeCategory.YOUNG, 0.002f);
        WHEAT_MASS.put(BlockOrganism.RipeCategory.MATURE, 0.02f);
        WHEAT_MASS.put(BlockOrganism.RipeCategory.EXPIRED, 0.01f);
        // TODO add real nutrients
        WHEAT_NUTRIENTS.put(BlockOrganism.RipeCategory.BABY, Nutrients.NONE);
        WHEAT_NUTRIENTS.put(BlockOrganism.RipeCategory.YOUNG, Nutrients.NONE);
        WHEAT_NUTRIENTS.put(BlockOrganism.RipeCategory.MATURE, Nutrients.NONE);
        WHEAT_NUTRIENTS.put(BlockOrganism.RipeCategory.EXPIRED, Nutrients.NONE);
        WHEAT_YIELD.put(BlockOrganism.RipeCategory.BABY, Functions.NO_YIELD);
        WHEAT_YIELD.put(BlockOrganism.RipeCategory.YOUNG, Functions.NO_YIELD);
        WHEAT_YIELD.put(BlockOrganism.RipeCategory.MATURE, Functions.WHEAT_YIELD);
        WHEAT_YIELD.put(BlockOrganism.RipeCategory.EXPIRED, Functions.ROTTEN_CROP_YIELD);
        // Human Head
        HUMAN_HEAD_MEASURE.put(BlockOrganism.RipeCategory.BABY, Measure3.cube(0.1f));
        HUMAN_HEAD_MEASURE.put(BlockOrganism.RipeCategory.YOUNG, Measure3.cube(0.15f));
        HUMAN_HEAD_MEASURE.put(BlockOrganism.RipeCategory.MATURE, Measure3.cube(0.3f));
        HUMAN_HEAD_MEASURE.put(BlockOrganism.RipeCategory.EXPIRED, Measure3.cube(0.25f));
        HUMAN_HEAD_MASS.put(BlockOrganism.RipeCategory.BABY, 1.5f);
        HUMAN_HEAD_MASS.put(BlockOrganism.RipeCategory.YOUNG, 3f);
        HUMAN_HEAD_MASS.put(BlockOrganism.RipeCategory.MATURE, 5f);
        HUMAN_HEAD_MASS.put(BlockOrganism.RipeCategory.EXPIRED, 4.5f);
        // TODO add real nutrients
        HUMAN_HEAD_NUTRIENTS.put(BlockOrganism.RipeCategory.BABY, Nutrients.NONE);
        HUMAN_HEAD_NUTRIENTS.put(BlockOrganism.RipeCategory.YOUNG, Nutrients.NONE);
        HUMAN_HEAD_NUTRIENTS.put(BlockOrganism.RipeCategory.MATURE, Nutrients.NONE);
        HUMAN_HEAD_NUTRIENTS.put(BlockOrganism.RipeCategory.EXPIRED, Nutrients.NONE);
        // TODO add yield
        HUMAN_HEAD_YIELD.put(BlockOrganism.RipeCategory.BABY, Functions.NO_YIELD);
        HUMAN_HEAD_YIELD.put(BlockOrganism.RipeCategory.YOUNG, Functions.NO_YIELD);
        HUMAN_HEAD_YIELD.put(BlockOrganism.RipeCategory.MATURE, Functions.NO_YIELD);
        HUMAN_HEAD_YIELD.put(BlockOrganism.RipeCategory.EXPIRED, Functions.NO_YIELD);
    }

}
