import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public Catalog(String name, String path){
        this.name = name;
        this.path = path;
    }

    public Catalog(String path) {
        this.path = path;
    }

    public void add(Document doc) {
        documents.add(doc);
    }

public Document findById(String id) {
    return this.documents
            .stream()
            .filter(d -> d.getId().equals(id))
            .findAny()
            .orElse(null);
    }
    public String getPath(){
        return this.path;
    }
}
