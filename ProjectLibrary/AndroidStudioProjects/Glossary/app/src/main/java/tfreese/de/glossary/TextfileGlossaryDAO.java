package tfreese.de.glossary;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TextfileGlossaryDAO implements GlossaryDAO {

    @Override
    public List<String> getItemList(InputStream inputStream) {
        List<String> itemList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String item;
        try {
            while ((item = reader.readLine()) != null) {
                itemList.add(item);
            }
        } catch (IOException e) {
            Log.e("IOException", "getItemList: " + e.getMessage());
        }
        return itemList;
    }

    public String getDefinition(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder definition = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                definition.append(line);
                definition.append("\n");
            }
        } catch (IOException e) {
            Log.e("IOException", "getDefinitionText: " + e.getMessage());
        }
        return definition.toString();
    }
}
