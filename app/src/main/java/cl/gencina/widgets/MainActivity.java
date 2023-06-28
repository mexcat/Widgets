package cl.gencina.widgets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextClock;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(getApplicationContext(),"Buenas ", Toast.LENGTH_SHORT).show();

        SeekBar seekBar = findViewById(R.id.seekBar);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Empezamos en un " + progressChangedValue + "%",
                        Toast.LENGTH_SHORT).show();
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                progressBar.setProgress(progressChangedValue);
                Toast.makeText(MainActivity.this, "Terminamos en un " + progressChangedValue + "%",
                        Toast.LENGTH_SHORT).show();
            }
        });
        progressBar.getProgress();
    }
}