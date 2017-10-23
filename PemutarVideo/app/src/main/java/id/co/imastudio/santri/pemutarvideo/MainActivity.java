package id.co.imastudio.santri.pemutarvideo;

import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
   //deklarasi variabel
    private VideoView videoV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        videoV = (VideoView)findViewById(R.id.videoView);
        videoV.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.v));
        videoV.setMediaController(new MediaController(this));
        videoV.requestFocus();
        videoV.start();
    }
    //ini agar ketika play lanjut otomatis
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
