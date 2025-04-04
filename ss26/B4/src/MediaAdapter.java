public class MediaAdapter implements MediaPlayer {
    private final AdvanceMediaPlayer mediaPlayer;
    public MediaAdapter() {
        mediaPlayer = new AdvanceMediaPlayer();
    }

    @Override
    public void play(String audioType, String fileName){
        if(audioType.equals("mp4")){
            mediaPlayer.playMp4(fileName);
        }else if(audioType.equals("vlc")){
            mediaPlayer.playVlc(fileName);
        }
    }
}
