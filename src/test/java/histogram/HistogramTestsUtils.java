package histogram;

public class HistogramTestsUtils {

    public static String removeLastNewLine(String result) {
        if (result.lastIndexOf('\n') == result.length() - 1) {
            return result.substring(0, result.length() - 1);
        }

        return result;
    }
}
