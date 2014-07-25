package securecraftprotect.common.registry;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class DocumentRegistry {
    public static List<DocumentInfo> documentList = new ArrayList<DocumentInfo>();

    public static void registerDocument(String name, int level) {
            documentList.add(new DocumentInfo(name, level));
    }

    public static class DocumentInfo {
        public final String name;
        public final int level;

        public DocumentInfo(String name, int level) {
            this.name = name;
            this.level = level;
        }
    }
}
