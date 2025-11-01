package studio.abos.life.content;

import studio.abos.life.core.food.Nutrients;
import studio.abos.life.core.geometry.Measure3;

public interface Types {

    // crops
    BlockItem.Type WHEAT = (universe, minimalPosition) -> new BlockOrganism(universe, minimalPosition, 1f, Functions.DEFAULT_CROP_AGE_CATEGORY, Maps.WHEAT_MEASURE, Maps.WHEAT_MASS, Maps.WHEAT_NUTRIENTS, Maps.WHEAT_YIELD);

    // misc
    BlockItem.Type MUSH = (universe, minimalPosition) -> new BlockItem(universe, minimalPosition, Measure3.cube(0.05f), 0.1f, 1f, Nutrients.NONE);


}
