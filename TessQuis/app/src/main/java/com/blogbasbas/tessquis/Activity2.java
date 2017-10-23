package com.blogbasbas.tessquis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Activity2 extends AppCompatActivity {


    CheckBox checkBox_buah, checkBox_makanan, checkBox_minuman, checkBox_sampah;
    Button button_next_2;
    int nilai;
    int tangkap_intent;
    @BindView(R.id.checkbox_buah)
    CheckBox checkboxBuah;
    @BindView(R.id.checkbox_makanan)
    CheckBox checkboxMakanan;
    @BindView(R.id.checkbox_minuman)
    CheckBox checkboxMinuman;
    @BindView(R.id.checkbox_sampah)
    CheckBox checkboxSampah;
    @BindView(R.id.button_next_2)
    Button buttonNext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ButterKnife.bind(this);

        // pengambilan nilai yang di lempar oleh Activity Sebelumnya menggunakan method getIntent() lalu digabungkan dengan pemberian method getIntExtra(), sesuai dengan tipe
        // data yang sudah dilemparkan activity sebelumnya
        tangkap_intent = getIntent().getIntExtra("nilai", 0);
        // menyamakan nilai dari variabel nilai dengan nilai dari variabel tangkap_intent
        nilai = tangkap_intent;
        //Casting Widget
    /*    checkBox_buah = (CheckBox) findViewById(R.id.checkbox_buah);
        checkBox_makanan = (CheckBox) findViewById(R.id.checkbox_makanan);
        checkBox_minuman = (CheckBox) findViewById(R.id.checkbox_minuman);
        checkBox_sampah = (CheckBox) findViewById(R.id.checkbox_sampah);
        button_next_2 = (Button) findViewById(R.id.button_next_2);
*/

    }

    @OnClick({R.id.checkbox_buah, R.id.checkbox_makanan, R.id.checkbox_minuman, R.id.checkbox_sampah, R.id.button_next_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.checkbox_buah:
                nilai = 10;
                break;
            case R.id.checkbox_makanan:
                nilai = 0;
                break;
            case R.id.checkbox_minuman:
                nilai = 0;
                break;
            case R.id.checkbox_sampah:
                nilai = 0;
                break;
            case R.id.button_next_2:

                Intent intent = new Intent(getApplicationContext(),Activity3.class);
                //untuk melempar nilai dari activity ke activity yang lain
                intent.putExtra("nilai2", nilai);
                //untuk untuk menjalankan intentnya
                startActivity(intent);



                break;
        }
    }
}
