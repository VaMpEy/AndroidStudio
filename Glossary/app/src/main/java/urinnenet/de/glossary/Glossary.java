package urinnenet.de.glossary;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Glossary {
    private ArrayList<GlossaryEntry> list;

    public ArrayList<GlossaryEntry> getList() {

        String file = "res/raw/glossary.txt";

        ArrayList<GlossaryEntry> list = new ArrayList<>();
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                GlossaryEntry glossaryEntry = new GlossaryEntry(line);
                list.add(glossaryEntry);
            }
        } catch (IOException e) {
            Log.i("IOException", e.getMessage());
        }

        return list;
    }

    public void setList(ArrayList<GlossaryEntry> list) {
        this.list = list;
    }
}
