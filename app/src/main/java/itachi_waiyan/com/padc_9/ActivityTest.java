package itachi_waiyan.com.padc_9;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityTest extends AppCompatActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context,ActivityTest.class);
        return intent;
    }

    TextView tvGreeting;
    ImageView imageView,imageView2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        tvGreeting = findViewById(R.id.tv_greeting);
        tvGreeting.setText("Good afternoon");

        imageView = findViewById(R.id.image_view);
        imageView2 = findViewById(R.id.image_view);
        imageView2.setImageResource(R.drawable.koala);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
