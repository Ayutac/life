package studio.abos.life.core.character;

public record Personality(float openness, float conscientiousness, float extraversion, float agreeableness, float neuroticism) {

    public static final Personality NEUTRAL = new Personality(0f, 0f, 0f, 0f, 0f);

}
