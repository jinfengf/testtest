package storyCharacters;

import net.mindview.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by jiguang on 2018/6/8.
 */

public class StoryCharactersGenerator implements Generator<StoryCharacters>, Iterable<StoryCharacters>{
    private Class[] types = {GoodGuys.class, BadGuys.class};
    private Random rand = new Random(2);
    private int size;

    public StoryCharactersGenerator() {
    }

    public StoryCharactersGenerator(int sz) {
        size = sz;
    }

    class StoryCharactersIterator implements Iterator<StoryCharacters> {
        private int count = size;
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public StoryCharacters next() {
            count--;
            return StoryCharactersGenerator.this.next();
        }
    }

    @Override
    public Iterator<StoryCharacters> iterator() {
        return new StoryCharactersIterator();
    }

    @Override
    public StoryCharacters next() {
        try {
            return (StoryCharacters) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        StoryCharactersGenerator gen = new StoryCharactersGenerator();
        for (int i = 0; i < 3; i++) {
            System.out.println(gen.next());
        }
        for (StoryCharacters s : new StoryCharactersGenerator(3)) {
            System.out.println(s);
        }
    }
}
