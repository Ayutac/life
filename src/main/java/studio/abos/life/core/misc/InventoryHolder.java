package studio.abos.life.core.misc;

import lombok.NonNull;
import studio.abos.life.core.geometry.Shape;

import java.util.Collection;
import java.util.SequencedSet;

public interface InventoryHolder extends Owner {

    SequencedSet<Inventory> getInventories();

    void addInventory(final @NonNull Inventory inventory);

    void removeInventory(final @NonNull Inventory inventory);

    default boolean containsInventory(final @NonNull Inventory inventory) {
        return getInventories().contains(inventory);
    }

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
