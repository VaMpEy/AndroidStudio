package tfreese.de.glossary;

public class GlossaryItem  {
    private String name;
    private String definition;

    public GlossaryItem(String name, String definition) {
        this.name = name;
        this.definition = definition;
    }

    public String getName() {
        return name;
    }

    public String getDefinition() {
        return definition;
    }

}
