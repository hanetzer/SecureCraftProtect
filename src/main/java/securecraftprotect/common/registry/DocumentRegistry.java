package securecraftprotect.common.registry;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class DocumentRegistry {
    public static List<DocumentInfo> scpList = new ArrayList<DocumentInfo>();

    public static void registerDocument(String name, int level) {
            scpList.add(new DocumentInfo(name, level));
    }

    public static class DocumentInfo {
        public final String name, json;
        public final int level;

        public DocumentInfo(String name, int level) {
            String[] part = name.split(":");
            this.name = part[1];
            this.level = level;
            this.json = "/assets/scp/json/"+part[1]+".json";
        }
    }
}
