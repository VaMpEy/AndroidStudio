package tfreese.de.glossary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.List;

public class MainActivity extends Activity {

    private void fillListView(ListView listView) {
        GlossaryDAO dao = new TextfileGlossaryDAO();
        InputStream inputStream = getResources().openRawResource(R.raw.glossary);
        List<String> itemList = dao.getItemList(inputStream);
        ArrayAdapter<String> itemListAdapter = new ArrayAdapter<>(
                this, R.layout.listitem_layout, R.id.listitem_textview, itemList);
        listView.setAdapter(itemListAdapter);
    }

    private void setupListView(ListView listView) {
        fillListView(listView);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String item = parent.getAdapter().getItem(position).toString();
            Intent intent = new Intent(getApplicationContext(), DefinitionActivity.class);
            intent.putExtra("item", item);
            startActivity(intent);
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.glossary_listview);
        setupListView(listView);
    }
}
