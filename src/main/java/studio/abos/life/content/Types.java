package studio.abos.life.content;

public interface Types {

    BlockItem.Type WHEAT = (universe, minimalPosition) -> new BlockOrganism(universe, minimalPosition, 1f, Functions.DEFAULT_CROP_AGE_CATEGORY, Maps.WHEAT_MEASURE, Maps.WHEAT_MASS, Maps.WHEAT_NUTRIENTS, Maps.WHEAT_YIELD);

}
