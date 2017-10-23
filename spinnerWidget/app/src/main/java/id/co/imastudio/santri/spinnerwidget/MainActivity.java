package id.co.imastudio.santri.spinnerwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //variabel
    TextView tekspilih;
    private Spinner sp_negara;
    private String[] list ={"--pilih--","Indonesia","Philipina","kuala lumpur","singapura","china"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //deklarasi variabel
        tekspilih = (TextView)findViewById(R.id.textview);
        sp_negara=(Spinner)findViewById(R.id.spinner12);
        //inisialisasi array adapter
        sp_negara.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_negara.setAdapter(adapter);
    }
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int posisi, long arg3)

            { tekspilih.setText(list[posisi]);

            }

            @Override
            public void onNothingSelected(AdapterView arg0) {
                //menampilkan teks yang dipilih
                tekspilih.setText("");

            }
    }
