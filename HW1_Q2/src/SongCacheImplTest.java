import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

class SongCacheImplTest {
    @Test
    public static void main(String[] args) {
        cacheIsWorking();
    }

    /**
     * I modified some of the test code due to that on my side,
     * the assertThat is not working, so I used JUnit 5 and assertEquals
     * */
    public static void cacheIsWorking() {
        SongCache cache = new SongCacheImpl();
        cache.recordSongPlays("ID-1", 3);
        cache.recordSongPlays("ID-1", 1);
        cache.recordSongPlays("ID-2", 2);
        cache.recordSongPlays("ID-3", 5);

        assertEquals(cache.getPlaysForSong("ID-1"), "4");
        assertEquals(cache.getPlaysForSong("ID-9"), "-1");
        assertEquals(cache.getTopNSongsPlayed(2), Arrays.asList("ID-3","ID-1"));
        assertEquals(cache.getTopNSongsPlayed(0), new ArrayList<>());

        /***
         * Old Test Code:
         * @Test
         * public void cacheIsWorking() {
         * SongCache cache = new SongCacheImpl();
         * cache.recordSongPlays("ID-1", 3);
         * cache.recordSongPlays("ID-1", 1);
         * cache.recordSongPlays("ID-2", 2);
         * cache.recordSongPlays("ID-3", 5);
         * assertThat(cache.getPlaysForSong("ID-1"), is(4));
         * assertThat(cache.getPlaysForSong("ID-9"), is(-1));
         * assertThat(cache.getTopNSongsPlayed(2), contains("ID-3",
         * "ID-1"));
         * assertThat(cache.getTopNSongsPlayed(0), is(empty()));
         * }
         *
         */
    }



}