package com.example.asynctask;

import android.widget.TextView;
import java.util.Random;

public class AsyncTask {

    // Variabel TextView untuk memperbarui UI
    private TextView mTextView;

    // Konstruktor yang menerima TextView
    public AsyncTask(TextView tv) {
        mTextView = tv;
    }

    // Metode yang meniru doInBackground
    protected String doInBackground() {
        // Generate angka acak antara 0 dan 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Durasi tidur dihitung
        int s = n * 200;

        // Membuat thread tertidur selama durasi tertentu
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mengembalikan hasil dalam bentuk String
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    // Metode yang meniru onPostExecute untuk memperbarui TextView
    protected void onPostExecute(String result) {
        if (mTextView != null) {
            mTextView.setText(result);
        }
    }

    // Metode untuk menjalankan doInBackground dan onPostExecute
    public void execute() {
        String result = doInBackground();
        onPostExecute(result);
    }
}
