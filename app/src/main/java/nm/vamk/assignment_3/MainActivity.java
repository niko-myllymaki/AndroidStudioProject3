package nm.vamk.assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        setInitialImage();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ImageView newImageView = findViewById(R.id.companyLogoPortrait);
        String date = getCurrentDateTime();

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            newImageView.setImageResource(R.drawable.logo_2);
            Toast.makeText(this, date, Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            newImageView.setImageResource(R.drawable.logo_1);
            Toast.makeText(this, date, Toast.LENGTH_SHORT).show();

        }
    }

    public void setInitialImage() {
        ImageView initialImageView = findViewById(R.id.companyLogoPortrait);
        initialImageView.setImageResource(R.drawable.logo_1);
    }

    public String getCurrentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }


}