package studio.abos.life.core.character;

public record Relationship(float platonic, float romantic, float sexual) {

    public static final Relationship NEUTRAL = new Relationship(0f, 0f, 0f);

}
