package studio.abos.life.core.agent;

import studio.abos.life.core.agent.goal.Goal;
import studio.abos.life.core.physics.Living;

import java.util.SequencedSet;

/**
 * A {@link Living} with its own agency. Capable of path-finding.
 */
public interface Agent extends Living {

    /**
     * Returns the {@link Goal goals} of this {@link Agent}, sorted by their priority.
     */
    SequencedSet<Goal> getCurrentGoals();

    default float getMaxRunningSpeed() {
        return 0f;
    }

    default float getMaxFlyingSpeed() {
        return 0f;
    }

}
