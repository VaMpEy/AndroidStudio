package urinnenet.de.glossary;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Glossary glossary = new Glossary();
        ArrayList<GlossaryEntry> list = glossary.getList();

        ArrayAdapter<GlossaryEntry> glossaryEntryArrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.glosserylist_layout,
                R.id.glosserylist_textview,
                list
        );

        ListView listView = findViewById(R.id.glosserylist_listview);
        listView.setAdapter(glossaryEntryArrayAdapter);

//        // Preis anzeigen wenn auf Artikel geklickt wird
//        listView.setOnItemClickListener(((parent,view, position, id) -> {
//            Article article = (Article) parent.getAdapter().getItem(position);
//            String articlePrice = String.format("%.2f Euro",article.getPrice());
//            Toast.makeText(ListViewActivity.this,articlePrice,Toast.LENGTH_SHORT).show();
//        }));
    }
}
