package nm.vamk.assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import android.widget.TextView;
import android.os.Handler;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private TextView textViewRandomNumber;
    private TextView textViewLastOrientationRandomNumber;
    private int randomNumber;
    private Runnable randomNumberUpdate;
    private Random random = new Random();
    private Handler handler = new Handler();
    private String dateTimeForToast = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        textViewRandomNumber = findViewById(R.id.tw_random_number);
        textViewLastOrientationRandomNumber = findViewById(R.id.tw_last_orientation_random_number);
        textViewLastOrientationRandomNumber.setText(getString(R.string.last_orientation_random_number, 0));

        randomNumberUpdate = new Runnable() {
            @Override
            public void run() {
                randomNumber = random.nextInt(100) + 1;
                textViewRandomNumber.setText(getString(R.string.random_number, randomNumber));
                //Run again after 1 second
                handler.postDelayed(this, 1000);
            }
        };
        // Start the initial update
        handler.post(randomNumberUpdate);
    }

    //Save UI state
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        dateTimeForToast = getCurrentDateTime();
        outState.putString("savedDateTime", dateTimeForToast);
        outState.putInt("savedRandomNumber", randomNumber);
    }

    //Restore the saved UI state
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        dateTimeForToast = savedInstanceState.getString("savedDateTime", "");
        int randomNumberOfLastOrientation = savedInstanceState.getInt("savedRandomNumber");
        Toast.makeText(this, dateTimeForToast, Toast.LENGTH_SHORT).show();
        textViewLastOrientationRandomNumber.setText(getString(R.string.last_orientation_random_number, randomNumberOfLastOrientation));
    }

    public String getCurrentDateTime() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return sdf.format(new Date());
    }



}