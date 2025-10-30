package studio.abos.life.core.physics;

/**
 * A {@link MassShape} with an additional discarding condition (health).
 * @see #setHealth(float)
 */
public interface Living extends MassShape {

    /**
     * @see #setHealth(float)
     */
    float getHealth();

    /**
     * Sets the health of this {@link Living}.
     * @param health allowed to be negative, but then the living will probably vanish soon
     */
    void setHealth(final float health);

    /**
     * If the {@link Living} has positive health.
     */
    default boolean isAlive() {
        return getHealth() > 0f;
    }

}
