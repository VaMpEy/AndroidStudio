package tfreese.de.glossary;

import java.io.InputStream;
import java.util.List;

public interface GlossaryDAO {
    List<String> getItemList(InputStream inputStream);
    String getDefinition(InputStream inputStream);
}
