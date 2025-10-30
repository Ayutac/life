package studio.abos.life.core.engine;

import studio.abos.life.core.physics.Living;
import studio.abos.life.core.physics.MassShape;
import studio.abos.life.core.physics.Universe;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class ServerEngine {

    protected Collection<Universe> multiverse = new LinkedList<>();

    protected Collection<MassShape> objects = new LinkedList<>();

    public void tick() {
        final Collection<MassShape> discard = new LinkedList<>();
        for (final MassShape object : objects) {
            object.checkFalling(getObjects());
            if (object.affectedByGravity() && object.isFalling()) {
                object.getUniverse().applyGravityTo(object);
            }
            object.move(getObjects());
            if (object.getUniverse().isOutside(object) || (object instanceof Living living && !living.isAlive())) {
                discard.add(object);
            }
        }
        objects.removeAll(discard);
    }

    public Collection<Universe> getMultiverse() {
        return Collections.unmodifiableCollection(multiverse);
    }

    public Collection<MassShape> getObjects() {
        return Collections.unmodifiableCollection(objects);
    }
}
