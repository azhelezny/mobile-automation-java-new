package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Andrey Zhelezny
 *         Date: 3/5/18
 */
public class CommandLineUtils {
    public static String executeCommandLineCommandLocally(String command, boolean traceErrors) {
        return execute(command, traceErrors);
    }

    private static String execute(String command) {
        return execute(command, true);
    }

    private static String execute(String command, boolean traceError) {
        String result = "";
        Runtime rt = Runtime.getRuntime();
        Process pr;
        try {
            String fullCommand = command + ((traceError) ? " 2>&1" : "");
            pr = rt.exec(fullCommand);
            result = traceProcess(pr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String traceProcess(Process process) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String inputString;
        StringBuilder result = new StringBuilder();
        try {
            while ((inputString = input.readLine()) != null) {
                result.append(inputString).append("\n");
                System.out.println(inputString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
        return result.toString().trim();
    }
}
