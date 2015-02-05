package ajsoftware.com.zagodoj;

import android.app.Application;
import android.widget.Button;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by andrzejj on 05.02.15.
 */
public class ZagodojApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "QvnCSz5DF9s1IBQQODZRmhPhElZjzZvveqFSTOPM", "GVU7YzFK2AlrjvnnqHbGeNjq1HQwMWPe551NcNRG");


    }
}
