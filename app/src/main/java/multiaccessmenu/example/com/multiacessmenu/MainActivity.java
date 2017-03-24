package multiaccessmenu.example.com.multiacessmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

// Must extends BaseActivity in order to always call the configurations set in BaseActivity
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //hideToolbar(true);
        setToolbarTitle("Main Activity");
        setContentView(R.layout.activity_main);
    }
}
