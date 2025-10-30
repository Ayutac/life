package studio.abos.life.core.engine;

import studio.abos.life.core.physics.MassShape;
import studio.abos.life.core.physics.Universe;

import java.util.Collection;
import java.util.LinkedList;

public class ServerEngine {

    protected Collection<Universe> multiverse = new LinkedList<>();

    protected Collection<MassShape> objects = new LinkedList<>();

    public void tick() {
        final Collection<MassShape> discard = new LinkedList<>();
        for (final MassShape object : objects) {
            object.getUniverse().applyGravityTo(object);
            object.move();
            if (object.getUniverse().isOutside(object)) {
                discard.add(object);
            }
        }
        objects.removeAll(discard);
    }

}
