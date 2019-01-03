package histogram;

import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class HistogramFacadeTest {

    @Test
    public void shouldReturnCSVStringForTest() {
        //given
        HistogramFacade facade = new HistogramFacade();
        String text = "aba!#4av";
        String expected = "4,1\na,3\nb,1\nv,1";

        //is
        String result = facade.generateHistogramCSV(text);
        result = HistogramTestsUtils.removeLastNewLine(result);

        //expected
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldGenerateHistogram() {
        //given
        HistogramFacade facade = new HistogramFacade("src/test/resources/histogram-test-config.properties");
        String text = "aa? !##bb\nc";
        ImmutableMap<Character, Long> expected = ImmutableMap.<Character, Long>builder()
                .put('a', 2L)
                .put('b', 2L)
                .put('c', 1L)
                .put('#', 2L)
                .put('\n', 1L)
                .put(' ', 1L)
                .build();
        //is
        Map<Character, Long> result = facade.generateHistogram(text);

        //expected
        Assert.assertEquals(expected, result);
    }
}
