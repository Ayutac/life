package studio.abos.life.core.character;

import studio.abos.life.core.physics.Ageable;

/**
 * Something that can {@link Ageable age}, with a {@link Personality}.
 */
public interface Person extends Ageable {

    Personality getPersonality();

}
