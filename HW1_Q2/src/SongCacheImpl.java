import java.util.*;


public class SongCacheImpl implements SongCache {
    private static Map<String, Integer> records = new HashMap<>();
    //private static PriorityQueue<String, Integer> recs;
    @Override
    synchronized public void recordSongPlays(String songId, int numPlays) {
        if (records.containsKey(songId)) {
            records.put(songId, records.get(songId) + numPlays);
        }else{
            records.put(songId, numPlays);
        }
    }

    @Override
    public String getPlaysForSong(String songId) {
        if (records.containsKey(songId)){
            return ""+records.get(songId);
        }else {
            return "-1";
        }
    }

    @Override
    synchronized public List<String> getTopNSongsPlayed(int n) {
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(records.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return -(o1.getValue()).compareTo(o2.getValue());
            }
        });
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i<n){
            res.add(list.get(i).getKey());
            i++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
