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

    Function<Long, BlockOrganism.RipeCategory> DEFAULT_CROP_RIPE_CATEGORY = ripeCategory(1, 3, 11);
    Function<Long, BlockOrganism.RipeCategory> DEFAULT_HUMAN_RIPE_CATEGORY = ripeCategory(3, 27, 150);

    static Function<Long, BlockOrganism.RipeCategory> ripeCategory(final int babyDayCycles, final int youngDayCycles, final int matureDayCycles) {
        if (babyDayCycles > youngDayCycles || youngDayCycles > matureDayCycles) {
            throw new IllegalArgumentException("Parameters must be non-strictly increasing!");
        }
        return age -> {
            if (age < Math.multiplyExact(Math.multiplyExact(FlatUniverse.DEFAULT_DAY_LENGTH, babyDayCycles), 2)) {
                return BlockOrganism.RipeCategory.BABY;
            }
            if (age < Math.multiplyExact(Math.multiplyExact(FlatUniverse.DEFAULT_DAY_LENGTH, youngDayCycles), 2)) {
                return BlockOrganism.RipeCategory.YOUNG;
            }
            if (age < Math.multiplyExact(Math.multiplyExact(FlatUniverse.DEFAULT_DAY_LENGTH, matureDayCycles), 2)) {
                return BlockOrganism.RipeCategory.MATURE;
            }
            return BlockOrganism.RipeCategory.EXPIRED;
        };
    }

    Function<Shape, Collection<Function<Harvestable, MassShape>>> NO_YIELD = tool -> List.of();

    Function<Harvestable, MassShape> WHEAT_YIELD_SINGLE = wheat -> Types.WHEAT.create(wheat.getUniverse(), wheat.getMinimalPosition());

    Function<Shape, Collection<Function<Harvestable, MassShape>>> WHEAT_YIELD = tool -> Collections.nCopies(15, WHEAT_YIELD_SINGLE);

    Function<Shape, Collection<Function<Harvestable, MassShape>>> ROTTEN_CROP_YIELD = tool -> List.of(crop -> Types.MUSH.create(crop.getUniverse(), crop.getMinimalPosition()));

}
