// package CodeJ;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MusicPlayer {
    public static void main(String[] args) {
        try {
            // Đọc file nhạc
            File musicFile = new File("nhac.wav"); // Đảm bảo file nhạc là định dạng .wav
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Lời bài hát
            String lyrics = "Đây là câu đầu tiên của bài hát theo sau là từng chữ sẽ xuất hiện dần dần.";

            // Chia lời bài hát thành từng chữ
            String[] words = lyrics.split(" ");

            // Tổng thời gian của bài hát (305 giây = 305000 milliseconds)
            int totalDuration = 305000; // 305 giây

            // Thời gian hiển thị mỗi từ (chia đều tổng thời gian bài hát cho số từ)
            int wordDuration = totalDuration / words.length;

            // Bắt đầu phát nhạc
            System.out.println("Đang phát nhạc...");
            clip.start();

            // In từng chữ ra màn hình theo thời gian quy định
            for (String word : words) {
                System.out.print(word + " ");
                Thread.sleep(wordDuration); // Nghỉ giữa mỗi từ theo thời gian chia đều
            }

            System.out.println(); // Xuống dòng sau khi in xong toàn bộ lời bài hát

            // Đợi cho đến khi nhạc phát xong
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            System.out.println("Kết thúc phát nhạc!");
        } catch (Exception e) {
            System.out.println("Có lỗi xảy ra khi phát nhạc: " + e.getMessage());
        }
    }
}
