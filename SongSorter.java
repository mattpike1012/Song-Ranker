
public class SongSorter{
    // Shell Sort
    String[] songs;
    int gap;
    int i;
    int j;
    String tempSong;
    String jSong;
    // 0 = tempSong > j, 1 = j > tempSong

    public SongSorter(String[] songs){
        this.songs = songs;
        gap = songs.length / 2;
        initialiseISort();
        initialiseJSort();
    }
    /**
     * Sorts through one loop that happens in a shellsort algorithm
     * @param choice Paramater that represents which song is "greater"
     */
    public void sort(int choice){
        if (gap > 0){
            // If "jloop" condition is fulfilled
            if (choice == 1){
                songs[j] = jSong;
                j -= gap;
                if (j >= gap){
                    jSong = songs[j - gap];
                }
            } 
            // if "jloop" is done
            if (!(j >= gap) || choice == 0){
                songs[j] = tempSong;
                i++;
                if (i < songs.length){
                    initialiseJSort();
                }
            }
            // If i loop is done
            if (!(i < songs.length)){
                gap /=2;
                initialiseISort();
                initialiseJSort();
            }
        }
    }
    /**
     * Initialises the "i" sort in a shellsort
     */
    public void initialiseISort(){
        i = gap;
    }
    /**
     * Initialises the "j" sort in a shellsort
     */
    public void initialiseJSort(){
        tempSong = songs[i];
        j = i;
        jSong = songs[j - gap];
    }
}
    