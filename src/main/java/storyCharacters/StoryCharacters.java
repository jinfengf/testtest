package storyCharacters;

/**
 * Created by jiguang on 2018/6/8.
 */

public class StoryCharacters {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
