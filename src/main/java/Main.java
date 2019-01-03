import histogram.HistogramFacade;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HistogramFacade histogramFacade = new HistogramFacade();
        histogramFacade.saveHistogramToCSV("Qwea123a1d", "output.csv");
        Map<Character, Long> histogram = histogramFacade.generateHistogram("QA@ #10p-");

        histogram.entrySet().stream().forEach(System.out::println);
    }
}
