package studio.abos.life.core.food;

import studio.abos.life.core.misc.Living;

/**
 * A {@link Living} that is eatable.
 */
public interface Eatable extends Living {

    Nutrients getNutrientValues();

}
