package studio.abos.life.core.agent.goal;

import studio.abos.life.core.geometry.Vec3;
import studio.abos.life.core.physics.Universe;

public record MoveGoal(Universe universe, Vec3 position) implements Goal {
}
