package studio.abos.life.core.food;

import lombok.NonNull;
import studio.abos.life.core.physics.Living;

/**
 * A {@link Living} that needs {@link Nutrients} and can eat
 */
public interface Eater extends Living {

    Nutrients getCurrentNutrients();

    void setCurrentNutrients(final @NonNull Nutrients nutrients);

    Nutrients getOptionalNutrients();

    void setOptionalNutrients(final @NonNull Nutrients nutrients);

    default void eat(final @NonNull Eatable eatable) {
        setCurrentNutrients(getCurrentNutrients().add(eatable.getNutrientValues()));
        eatable.setHealth(0f);
    }

}
