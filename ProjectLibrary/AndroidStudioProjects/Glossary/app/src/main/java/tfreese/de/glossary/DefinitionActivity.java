package tfreese.de.glossary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.InputStream;

public class DefinitionActivity extends Activity {

    private int getResourceIdFromString(String resourceId) {
        return getResources().getIdentifier(resourceId.toLowerCase(), "raw", getPackageName());
    }

    private void updateItemView(String item) {
        TextView textView = findViewById(R.id.textViewItem);
        textView.setText(item);
    }

    private void updateDefinitionView(String item) {
        int resId = getResourceIdFromString(item);
        InputStream inputStream = getResources().openRawResource(resId);
        GlossaryDAO dao = new TextfileGlossaryDAO();
        String definition = dao.getDefinition(inputStream);
        TextView textView = findViewById(R.id.textViewDefinition);
        textView.setText(definition);
    }

    private void updateView() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("item")) {
                String item = intent.getStringExtra("item");
                updateItemView(item);
                updateDefinitionView(item);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definition);
        updateView();
    }
}
