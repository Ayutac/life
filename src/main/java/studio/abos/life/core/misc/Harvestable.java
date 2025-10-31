package studio.abos.life.core.misc;

import lombok.NonNull;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.physics.Living;

import java.util.Collection;

/**
 * A {@link Living} that can be harvested.
 */
public interface Harvestable extends Living {

    Collection<Shape> getYield(final @NonNull Shape tool);

}
