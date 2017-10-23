package id.co.imastudio.santri.popupmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //variabel
    TextView teksmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //deklarasi variabel
        teksmenu = (TextView) findViewById(R.id.teksMenu);
        Button btnUp = (Button) findViewById(R.id.btnPopUp);
        btnUp.setOnClickListener(new View.OnClickListener() {
            //event button
            @Override
            public void onClick(View v) {
                PopupMenu menuPopUp = new PopupMenu(MainActivity.this,
                        v);
                menuPopUp.setOnMenuItemClickListener(MainActivity.this);
                menuPopUp.inflate(R.menu.menu_main);
                menuPopUp.show();
            }
        });
    }
    //method ketika salah satu popup menu dipilih
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSatu:
                teksmenu.setText("ini menu satu");
                return true;

            case R.id.menuDua:
                teksmenu.setText("ini menu dua");
                return true;
            case R.id.shareItem:
                Intent share = new Intent(Intent.ACTION_SEND);

                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Ini Judul Share");
                share.putExtra(Intent.EXTRA_TEXT, "http://www.imastudio.co.id");
                startActivity(Intent.createChooser(share, "Share Link!"));
        }
        return true;
    }}



