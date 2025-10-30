package studio.abos.life.core.agent.goal;

import studio.abos.life.core.geometry.Shape;

public record MoveToGoal(Shape target) implements Goal {
}
