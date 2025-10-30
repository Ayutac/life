package studio.abos.life.core.food;

import lombok.With;

@With
public record Nutrients(float carbs, float proteins, float fats, float vitamins, float minerals, float water) {

    public static final Nutrients NONE = new Nutrients(0f, 0f, 0f, 0f, 0f, 0f);

    public Nutrients {
        if (carbs < 0f || proteins < 0f || fats < 0f || vitamins < 0f || minerals < 0f || water < 0f) {
            throw new IllegalArgumentException("Nutrients cannot be negative!");
        }
    }

    public Nutrients add(final Nutrients nutrients) {
        return new Nutrients(carbs + nutrients.carbs, proteins + nutrients.proteins, fats + nutrients.fats, vitamins + nutrients.vitamins, minerals + nutrients.minerals, water + nutrients.water);
    }

    public static Nutrients water(final float amount) {
        return NONE.withWater(amount);
    }

}
