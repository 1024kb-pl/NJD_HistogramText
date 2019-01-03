package histogram.CSV;

import com.google.common.collect.ImmutableMap;
import histogram.HistogramTestsUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

public class HistogramCSVGeneratorTest {

    HistogramCSVGenerator csvGenerator = new HistogramCSVGenerator();

    @Test
    public void shouldReturnEmptyString() {
        //given
        Map<Character, Long> histogram = Collections.emptyMap();
        String expected = "";

        //is
        String result = csvGenerator.convertHistogramToCSV(histogram);

        //assert
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnCorrectCSVString() {
        //given
        String expected = "a,2\nb,2\nc,3\ne,8";
        ImmutableMap<Character, Long> histogram = ImmutableMap.<Character, Long>builder()
                .put('a', 2L)
                .put('b', 2L)
                .put('c', 3L)
                .put('e', 8L)
                .build();

        //is
        String result = csvGenerator.convertHistogramToCSV(histogram);
        result = HistogramTestsUtils.removeLastNewLine(result);

        //assert
        Assert.assertEquals(expected, result);
    }

}


