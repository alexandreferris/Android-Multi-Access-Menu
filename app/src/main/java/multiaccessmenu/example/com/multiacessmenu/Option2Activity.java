package multiaccessmenu.example.com.multiacessmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Option2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbarTitle("Option 2");
        setContentView(R.layout.activity_option2);
    }
}
