package ca.primealgorithmics.cli.translate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public interface TranslationService {
    String translate(String text, Locale from, Locale to) throws IOException;
}
