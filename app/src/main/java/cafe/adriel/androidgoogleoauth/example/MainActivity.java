package cafe.adriel.androidgoogleoauth.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import cafe.adriel.androidgoogleoauth.GoogleOAuth;
import cafe.adriel.androidgoogleoauth.OnGetTokenCallback;

public class MainActivity extends AppCompatActivity {

    private TextView tokenView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tokenView = (TextView) findViewById(R.id.token);

        GoogleOAuth.Builder(this)
                .setClientId("YOUR_CLIENT_ID")
                .setClientSecret("YOUR_CLIENT_SECRET")
                .setCallback(new OnGetTokenCallback() {
                    @Override
                    public void onSuccess(String token) {
                        tokenView.setText(token);
                    }
                    @Override
                    public void onError(Exception error) {
                        error.printStackTrace();
                    }
                })
                .login();
    }

}