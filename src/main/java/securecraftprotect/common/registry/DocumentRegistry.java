package securecraftprotect.common.registry;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class DocumentRegistry {
    private static final Logger logger = LogManager.getLogger();
    public static List<DocumentInfo> documentList = new ArrayList<DocumentInfo>();

    public static void registerDocument(Class scp, String name, int level) {
            documentList.add(new DocumentInfo(scp, name, level));
    }

    public static class DocumentInfo {
        public final Class scp;
        public final String name;
        public final int level;

        public DocumentInfo(Class scp, String name, int level) {
            this.scp = scp;
            this.name = name;
            this.level = level;
        }
    }
}
