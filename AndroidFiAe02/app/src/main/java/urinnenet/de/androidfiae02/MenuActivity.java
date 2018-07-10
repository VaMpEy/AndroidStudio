package urinnenet.de.androidfiae02;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ActionBar actionBar = getActionBar();

        // Titel
        actionBar.setTitle("Titel");

        // Untertitel
        actionBar.setSubtitle("Untertitel");

        // Icon
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_item_1:
                actionItem4onClicked(item);
                break;

            case R.id.action_item_2:
                Toast.makeText(this,"item 2 (TOASTy)",Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_item_3:
                actionItem4onClicked(item);
                break;
        }
        return true;
    }

    public void actionItem4onClicked(MenuItem item) {
        Toast.makeText(this,item.getTitle(),Toast.LENGTH_SHORT).show();
    }

    public void showOtherActivity(MenuItem item) {
        Intent intent = new Intent(this,OtherActivity.class);
        startActivity(intent);
    }
}
