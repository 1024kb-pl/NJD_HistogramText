package histogram.factory;

import histogram.config.HistogramConfiguration;
import histogram.config.HistogramConfigurationLoader;

import java.util.Map;
import java.util.TreeMap;

public class HistogramFactory {
    private String propertyFileName = "src/main/resources/histogram.properties";
    private final HistogramConfigurationLoader histogramConfigurationLoader = new HistogramConfigurationLoader();

    public HistogramFactory() {
    }

    public HistogramFactory(String propertyFileName) {
        this.propertyFileName = propertyFileName;
    }

    public Map<Character,Long> createHistogram(String text) {
        HistogramConfiguration config = histogramConfigurationLoader.loadProperties(propertyFileName);
        Map<Character, Long> histogram = new TreeMap<>();

        for(Character character : text.toLowerCase().toCharArray()) {
            if (!isWhiteSpace(config, character) && !isForbiddenChar(config, character)) {
                histogram.merge(character, 1L, Long::sum);
            }
        }

        return histogram;
    }


    private boolean isWhiteSpace(HistogramConfiguration config, Character character) {
        return config.shouldIgnoreWhiteSpaces()
               && HistogramConfigurationLoader.WHITE_SPACPES.contains(character);
    }

    private boolean isForbiddenChar(HistogramConfiguration config, Character character) {
        return config.getIgnoreCharacters().contains(character);
    }
}
