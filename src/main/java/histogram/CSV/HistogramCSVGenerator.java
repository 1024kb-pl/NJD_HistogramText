package histogram.CSV;

import java.util.Map;

public class HistogramCSVGenerator {
    private static final char SEPARATOR = ',';
    private static final char NEW_LINE = '\n';

    public String convertHistogramToCSV(Map<Character, Long> histogram) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Long> entry : histogram.entrySet()) {
            sb.append(entry.getKey());
            sb.append(SEPARATOR);
            sb.append(entry.getValue());
            sb.append(NEW_LINE);
        }

        return sb.toString();
    }


}
