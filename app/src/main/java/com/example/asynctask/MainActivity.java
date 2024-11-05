package com.example.asynctask;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private static final String TEXT_STATE = "currentText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi TextView dari layout
        mTextView = findViewById(R.id.textView1);

        // Mengembalikan teks TextView jika ada savedInstanceState
        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        // Menampilkan pesan sementara di TextView
        mTextView.setText("Napping... ");

        // Memulai AsyncTask
        new AsyncTask(mTextView).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Menyimpan teks TextView saat aktivitas dimusnahkan
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}
