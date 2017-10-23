package id.co.imastudio.santri.pemutaraudio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import static android.provider.CalendarContract.CalendarCache.URI;

public class MainActivity extends AppCompatActivity {
    //variabel mediaplayer
    MediaPlayer mpPlayer;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //inisialisai button play
            Button btnplay = (Button)findViewById(R.id.btnPlay);
            btnplay.setOnClickListener(new View.OnClickListener() {
                @Override
                //method onclik untuk button play
                public void onClick(View view) {
                    Uri myUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.surah);
                    mpPlayer = new MediaPlayer();
                    mpPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    try {
                        mpPlayer.setDataSource(getApplicationContext(),
                                myUri);
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                        Toast.LENGTH_LONG).show();
                    } catch (SecurityException e) {
                        Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                        Toast.LENGTH_LONG).show();
                    } catch (IllegalStateException e) {
                        Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                        Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        mpPlayer.prepare();
                    } catch (IllegalStateException e) {
                        Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                        Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        Toast.makeText(getApplicationContext(), "You might not set the URI correctly!",
                        Toast.LENGTH_LONG).show();
                    }
                    mpPlayer.start();
                }
            });
            //inisialisai button stop/berhenti
            Button btnStop = (Button)findViewById(R.id.btnStop);
            btnStop.setOnClickListener(new View.OnClickListener() {
                @Override
                //method event button stop
                public void onClick(View v) {
                    if(mpPlayer!=null && mpPlayer.isPlaying()){
                        mpPlayer.stop();
                    }
                }
            });
        }
    }
