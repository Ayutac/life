package studio.abos.life.core.food;

import lombok.NonNull;
import studio.abos.life.core.physics.Living;

/**
 * A {@link Living} that needs {@link Nutrients} and can eat
 */
public interface Eater extends Living {

    Nutrients getCurrentNutrients();

    void setCurrentNutrients(final @NonNull Nutrients nutrients);

    Nutrients getOptimalNutrients();

    void setOptimalNutrients(final @NonNull Nutrients nutrients);

    boolean canEat(final @NonNull Eatable eatable);

    default void eat(final @NonNull Eatable eatable) {
        setCurrentNutrients(getCurrentNutrients().add(eatable.getNutrientValues()));
        eatable.setHealth(0f);
    }

}
