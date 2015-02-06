package ajsoftware.com.zagodoj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class UserDetailsActivity extends ActionBarActivity {
    private static final String TAG = UserDetailsActivity.class.getSimpleName();


    protected TextView mName;
    protected TextView mSurname;
    protected TextView mCity;
    protected TextView mPhone;
    protected String mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        Intent intent = getIntent();
        String name = intent.getStringExtra("position");
        mName = (TextView) findViewById(R.id.user_detail_name);
        mSurname = (TextView) findViewById(R.id.user_detail_surname);
        mPhone = (TextView) findViewById(R.id.user_detail_phone);


        ParseQuery<ParseUser> query = ParseUser.getQuery();
        query.whereEqualTo("username", name);
        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> parseUsers, ParseException e) {
                if(e == null){
                    //mUser = parseUsers.get(0);

                    int i =0;
                    for(ParseUser user : parseUsers){
                        mUser = user.getObjectId();
                        i++;
                        Toast.makeText(getApplicationContext(), "Działa" + mUser, Toast.LENGTH_LONG).show();
                    }
                }else{
                    Log.i(TAG, e.getMessage());
                }
            }
        });


        //mName.setText(mUser.getUsername());
        //mUser.getUsername();
        //mSurname.setText(mUser.getString("surname"));
        //mPhone.setText(mUser.getString("phone"));



    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
