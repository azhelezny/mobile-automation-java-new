package utils;

import java.io.File;

/**
 * @author Andrey Zhelezny
 *         Date: 3/5/18
 */
public class PathUtils {
    public static String getOsPath(String path, String... pathFragments) {
        String separator = File.separator;
        StringBuilder result = new StringBuilder();
        result.append((separator.equals("\\")) ? path.replace("/", "\\") : path.replace("\\", "/"));
        for (String pathFragment : pathFragments)
            result.append(separator).append(pathFragment);
        return result.toString();
    }
}
