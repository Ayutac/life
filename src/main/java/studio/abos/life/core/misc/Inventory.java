package studio.abos.life.core.misc;

import studio.abos.life.core.geometry.Shape;

import java.util.List;

public interface Inventory extends Shape {

    List<Shape> getItems();

}
