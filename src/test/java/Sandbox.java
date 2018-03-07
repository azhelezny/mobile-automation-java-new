import rest.RestResponseStructure;
import rest.presets.PishRequest;

import java.io.IOException;

/**
 * @author Andrey Zhelezny
 *         Date: 3/7/18
 */
public class Sandbox {
    public static void main(String... args) throws IOException {
        PishRequest request = new PishRequest("/Users/azhelezny/projects/here/qaFrameworkForHere/src/main/resources/helloKitty.apk");
        RestResponseStructure response =  request.executeBasic();
    }
}
