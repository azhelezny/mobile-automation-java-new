package rest.presets;

import enums.RestMethod;
import properties.Settings;
import rest.RestRequestStructure;

import java.util.Base64;

/**
 * @author Andrey Zhelezny
 *         Date: 3/6/18
 */
public class PishRequest extends RestRequestStructure {

    public PishRequest(String url, RestMethod method) {
        super(url, method);
        String userName = Settings.get().testDroidUser();
        String userPwd = Settings.get().testDroidPwd();
        byte[] bytesToEncode = ("Basic " + userName + ":" + userPwd).getBytes();
        putHeader("Authentication", Base64.getEncoder().encodeToString(bytesToEncode));
    }
}
