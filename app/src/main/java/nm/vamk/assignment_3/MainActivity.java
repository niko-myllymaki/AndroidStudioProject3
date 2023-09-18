package nm.vamk.assignment_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialImage();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ImageView newImageView = findViewById(R.id.companyLogoPortrait);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //Toast.makeText(this, "Landscape orientation", Toast.LENGTH_SHORT).show();
            newImageView.setImageResource(R.drawable.logo_2);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            //Toast.makeText(this, "Portrait orientation", Toast.LENGTH_SHORT).show();
            newImageView.setImageResource(R.drawable.logo_1);

        }
    }

    public void setInitialImage() {
        ImageView initialImageView = findViewById(R.id.companyLogoPortrait);
        initialImageView.setImageResource(R.drawable.logo_1);
    }
}