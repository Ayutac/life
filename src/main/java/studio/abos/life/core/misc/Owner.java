package studio.abos.life.core.misc;

import lombok.NonNull;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.physics.MassShape;

import java.util.Collection;

/**
 * A {@link MassShape} that can own shapes in an abstract way.
 */
public interface Owner extends MassShape {

    Collection<Shape> getOwnedShapes();

    void addOwnedShape(final @NonNull Shape shape);

    void removeOwnedShape(final @NonNull Shape shape);

    default boolean ownsShape(final @NonNull Shape shape) {
        return getOwnedShapes().contains(shape);
    }

}
