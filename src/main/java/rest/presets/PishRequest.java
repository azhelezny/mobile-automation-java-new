package rest.presets;

import com.google.api.client.http.FileContent;
import com.testdroid.api.http.MultipartFormDataContent;
import enums.RestMethod;
import properties.Settings;
import rest.RestRequestStructure;

import java.io.File;

/**
 * @author Andrey Zhelezny
 *         Date: 3/6/18
 */
public class PishRequest extends RestRequestStructure {

    public PishRequest(String filePath) {
        super(Settings.TESTDROID_UPLOAD_URL, RestMethod.POST);
        applyBasicAuthenticatioin(Settings.get().testDroidUser(), Settings.get().testDroidPwd());
        MultipartFormDataContent multipartContent = new MultipartFormDataContent();
        FileContent fileContent = new FileContent("application/octet-stream", new File(filePath));

    }
}
