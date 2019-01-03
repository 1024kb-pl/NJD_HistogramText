package histogram.config;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class HistogramConfigurationLoaderTest {
    private HistogramConfigurationLoader loader = new HistogramConfigurationLoader();

    @Test
    public void shouldReturnDefaultConfigWhenFileNoExist() {
        //given
        HistogramConfiguration expected = new HistogramConfiguration();

        //is
        HistogramConfiguration result = loader.loadProperties("ANY_NO_EXIST_FILE");

        //expected
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldLoadConfigurationFromFile() {
        //given
        HistogramConfiguration expected = new HistogramConfiguration();
        expected.setShouldIgnoreWhiteSpaces(false);
        expected.setIgnoreCharacters(new HashSet<>(Arrays.asList('.', '\\', '-', ';', '+', '?', '!')));

        //is
        HistogramConfiguration result = loader.loadProperties("src/test/resources/histogram-test-config.properties");

        //expected
        Assert.assertEquals(expected, result);
    }
}
