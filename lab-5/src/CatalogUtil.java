import java.awt.*;
import java.io.*;
import java.net.URI;
import java.io.File;

public class CatalogUtil {
    public static void save(Catalog catalog) throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path)throws InvalidCatalogException,FileNotFoundException,IOException,ClassNotFoundException {//...
        Catalog catalog=new Catalog(path);
        try
                (var oos = new ObjectInputStream(new FileInputStream(path))) {
            catalog= (Catalog) oos.readObject();
            return catalog;
        }
    }
        public static void view(Document doc) {
            try{
                Desktop desktop = Desktop.getDesktop();

                if(doc.getLocation().startsWith("http"))
                    desktop.browse(new URI(doc.getLocation()));
                else if(Tag.isViewAvailable(doc))
                    desktop.open(new File(doc.getLocation()));
                else
                    throw new ViewTagException("No available view for document");
            }
            catch (Exception e){
                System.out.println(e.toString());
            }
        }
}
