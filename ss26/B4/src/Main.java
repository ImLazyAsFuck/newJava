public class Main{
    public static void main(String[] args){
        MediaPlayer player = new MediaAdapter();

        player.play("mp4", "video.mp4");
        player.play("vlc", "movie.vlc");
        player.play("mp3", "song.mp3");
    }
}