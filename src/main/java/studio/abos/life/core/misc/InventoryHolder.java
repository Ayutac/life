package studio.abos.life.core.misc;

import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.physics.MassShape;

import java.util.Collection;
import java.util.List;

public interface InventoryHolder extends MassShape {

    List<Inventory> getInventories();

    // TODO proper inventory management

    default void addItems(Collection<? extends Shape> newItems) {
        if (getInventories().isEmpty()) {
            return;
        }
        getInventories().getFirst().getItems().addAll(newItems);
    }

    default void addItem(Shape newItem) {
        if (getInventories().isEmpty()) {
            return;
        }
        getInventories().getFirst().getItems().add(newItem);
    }

}
