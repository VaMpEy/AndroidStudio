package urinnenet.de.androidfiae02;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends Activity {

    public void makeStringListView() {
        // Datenarray
        String[] cityListArray = {"Bremen", "Husum", "Berlin", "Paris", "Schweinfurt", "Kopenhagen"};

        ArrayAdapter<String> cityListAdapter = new ArrayAdapter<>(
                this, // Die aktuelle Umgebung (diese Activity)
                R.layout.citylist_layout, // ID des Layouts des Items
                R.id.citylist_textview, // ID des TextViews
                cityListArray // Daten
        );

        ListView listView = findViewById(R.id.citylist_listview);
        listView.setAdapter(cityListAdapter);

        // über anonyme Klasse
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String eintrag = parent.getAdapter().getItem(position).toString();
//                Toast.makeText(ListViewActivity.this,eintrag,Toast.LENGTH_SHORT).show();
////                Toast.makeText(getApplicationContext(),eintrag,Toast.LENGTH_SHORT).show();
//            }
//        });

        // über Lambda Ausdruck
        listView.setOnItemClickListener(((parent, view, position, id) -> {
            String eintrag = parent.getAdapter().getItem(position).toString();
            Toast.makeText(ListViewActivity.this,eintrag,Toast.LENGTH_SHORT).show();
        }));
    }

    public void makeArticleListView() {
        Article[] articleArray = {
                new Article("Badelatschen",12.50),
                new Article("Gummistiefel",28.90),
                new Article("Holzschuhe",89.10)
        };

        ArrayAdapter<Article> articleArrayAdapter = new ArrayAdapter<>(
                this,
                R.layout.articlelist_layout,
                R.id.articlelist_textview,
                articleArray
        );

        ListView listView = findViewById(R.id.articlelist_listview);
        listView.setAdapter(articleArrayAdapter);

        // Preis anzeigen wenn auf Artikel geklickt wird
        listView.setOnItemClickListener(((parent,view, position, id) -> {
            Article article = (Article) parent.getAdapter().getItem(position);
            String articlePrice = String.format("%.2f Euro",article.getPrice());
            Toast.makeText(ListViewActivity.this,articlePrice,Toast.LENGTH_SHORT).show();
        }));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        makeStringListView();
        makeArticleListView();
    }
}
