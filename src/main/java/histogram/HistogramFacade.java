package histogram;

import histogram.CSV.HistogramCSVGenerator;
import histogram.factory.HistogramFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class HistogramFacade {

    private HistogramFactory histogramFactory;
    private HistogramCSVGenerator histogramCSVGenerator = new HistogramCSVGenerator();

    public HistogramFacade() {
        this.histogramFactory = new HistogramFactory();
    }

    public HistogramFacade(String propertyFileName) {
        histogramFactory = new HistogramFactory(propertyFileName);
    }

    public Map<Character, Long> generateHistogram(String text) {
        return histogramFactory.createHistogram(text);
    }

    public String generateHistogramCSV(String text) {
        Map<Character, Long> histogram = histogramFactory.createHistogram(text);
        return histogramCSVGenerator.convertHistogramToCSV(histogram);
    }

    public void saveHistogramToCSV(String text, String fileName) {
        Map<Character, Long> histogram = histogramFactory.createHistogram(text);
        String histogramCSV = histogramCSVGenerator.convertHistogramToCSV(histogram);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(histogramCSV);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
