package ca.primealgorithmics.cli.translate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translate.TranslateOption;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import javax.naming.Reference;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

@Component
@Slf4j
public class TranslationServiceImpl implements TranslationService {

    Translate translate = TranslateOptions.getDefaultInstance().getService();

    //System.out.printf("Translated Text:\n\t%s\n", translation.getTranslatedText());
    @Override
    public String translate(String text, Locale from, Locale to) throws IOException {
        System.out.println("from: " + TranslateOption.sourceLanguage(from.getLanguage()));
        System.out.println("to: " + TranslateOption.sourceLanguage(to.getLanguage()));
        Translation translation = translate.translate(
                text,
                TranslateOption.sourceLanguage(from.getLanguage()),
                TranslateOption.targetLanguage(to.getLanguage()),
                // Use "base" for standard edition, "nmt" for the premium model.
                TranslateOption.model("base"));
        String str = translation.getTranslatedText();
        Path path = (Path) Paths.get("c:\\dev\\trans.txt");
        byte[] strToBytes = str.getBytes();

        Files.write(path, strToBytes);

        return translation.getTranslatedText();
    }
}
