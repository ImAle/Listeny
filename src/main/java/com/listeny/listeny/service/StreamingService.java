package com.listeny.listeny.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.listeny.listeny.models.Cancion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class StreamingService extends Application {

    private MediaPlayer mediaPlayer;
    private List<Cancion> canciones;

    public StreamingService(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public void start(Stage primaryStage) {
        int currentSongIndex = 0;
        playCurrentSong(currentSongIndex);

        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                if (canciones.size() > 1) {
                    playNextSong(currentSongIndex);
                }
            }
        });

        primaryStage.setScene(new Scene(null));
        primaryStage.show();
    }

    private void playCurrentSong(int currentSongIndex) {
        Media media = new Media(canciones.get(currentSongIndex).getUrl());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public void playNextSong(int currentSongIndex) {
        currentSongIndex = (currentSongIndex + 1) % canciones.size();
        mediaPlayer.stop();
        playCurrentSong(currentSongIndex);
        playNextSong(currentSongIndex);
    }

    public void playPreviousSong(int currentSongIndex) {
        currentSongIndex = (currentSongIndex + canciones.size() - 1) % canciones.size();
        mediaPlayer.stop();
        playCurrentSong(currentSongIndex);
        playNextSong(currentSongIndex);
    }

    public void playRandomSong(int currentSongIndex) {
        if (canciones.size() > 1) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(canciones.size());
            currentSongIndex = randomIndex;
        }
        mediaPlayer.stop();
        playCurrentSong(currentSongIndex);
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public static void main(String[] args) {

        List<Cancion> canciones = new ArrayList<>();
                StreamingService stream = new StreamingService(canciones);
        stream.start(new Stage());
    }
}
