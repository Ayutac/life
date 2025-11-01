package studio.abos.life.content;

import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.misc.Harvestable;
import studio.abos.life.core.physics.FlatUniverse;
import studio.abos.life.core.physics.MassShape;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public interface Functions {

    Function<Long, BlockOrganism.RipeCategory> DEFAULT_CROP_AGE_CATEGORY = age -> {
        if (age < 2 * FlatUniverse.DEFAULT_DAY_LENGTH) { // until 1 day cycle have passed
            return BlockOrganism.RipeCategory.BABY;
        }
        if (age < 6 * FlatUniverse.DEFAULT_DAY_LENGTH) { // until 3 day cycles have passed
            return BlockOrganism.RipeCategory.YOUNG;
        }
        if (age < 22 * FlatUniverse.DEFAULT_DAY_LENGTH) { // until 11 day cycles have passed
            return BlockOrganism.RipeCategory.MATURE;
        }
        return BlockOrganism.RipeCategory.ROTTEN;
    };

    Function<Shape, Collection<Function<Harvestable, MassShape>>> NO_YIELD = tool -> List.of();

    Function<Harvestable, MassShape> WHEAT_YIELD_SINGLE = wheat -> Types.WHEAT.create(wheat.getUniverse(), wheat.getMinimalPosition());

    Function<Shape, Collection<Function<Harvestable, MassShape>>> WHEAT_YIELD = tool -> Collections.nCopies(15, WHEAT_YIELD_SINGLE);

}
