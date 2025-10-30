package studio.abos.life.core.physics;

/**
 * Something that can age.
 */
public interface Ageable {

    long getAge();

    void setAge(final long age);

    void ageOneTick();

}
