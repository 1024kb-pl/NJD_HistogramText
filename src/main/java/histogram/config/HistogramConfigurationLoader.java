package histogram.config;

import histogram.config.HistogramProperty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class HistogramConfigurationLoader {
    public final static List<Character> WHITE_SPACPES = Arrays.asList(
            '\n', '\t', '\r', ' ');

    public HistogramConfiguration loadProperties(String propertyFileName) {
        HistogramConfiguration config = new HistogramConfiguration();

        try {
            List<String> lines = readFile(propertyFileName);

            for (String line: lines) {
                parseProperty(config, line);
            }

        } catch (IOException e) {
            System.out.println("Histogram properties file does not exist. Factory will use default configuration.");
        }

        return config;
    }

    private List<String> readFile(String fileName) throws IOException {
        List<String> lines = new LinkedList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line = br.readLine();
        while (line != null) {
            lines.add(line);
            line = br.readLine();
        }

        br.close();

        return lines;

    }

    private void parseProperty(HistogramConfiguration config, String line) {
        String value = line.split("=")[1];

        if (isIgnoreWhiteSpacesProperty(line)) {
            config.setShouldIgnoreWhiteSpaces(Boolean.valueOf(value));

        } else if (isIgnoreCharactersProperty(line)) {
            Set<Character> chars = value.chars()
                    .mapToObj(word -> (char) word)
                    .collect(Collectors.toSet());

            config.setIgnoreCharacters(chars);
        }
    }

    private boolean isIgnoreCharactersProperty(String line) {
        return line.contains(HistogramProperty.IGNORE_CHARACTERS.toString());
    }

    private boolean isIgnoreWhiteSpacesProperty(String line) {
        return line.contains(HistogramProperty.IGNORE_WHITE_SPACES.toString());
    }
}
