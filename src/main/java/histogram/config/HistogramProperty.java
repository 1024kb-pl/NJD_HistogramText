package histogram.config;

enum HistogramProperty {
    IGNORE_WHITE_SPACES("histogram.ignore.white-spaces"),
    IGNORE_CHARACTERS("histogram.ignore.characters");

    private final String key;

    HistogramProperty(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}
