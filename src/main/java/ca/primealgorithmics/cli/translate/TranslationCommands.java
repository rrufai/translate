package ca.primealgorithmics.cli.translate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;
import java.util.Locale;

@ShellComponent
@Slf4j
public class TranslationCommands {

    private final TranslationService service;

    @Autowired
    public TranslationCommands(TranslationService service) {
        this.service = service;
    }

    @ShellMethod("Translate text from one language to another.")
    public String translate(
            @ShellOption String text,
            @ShellOption(defaultValue = "en_US") Locale from,
            @ShellOption Locale to) throws IOException {

        // invoke service
        return service.translate(text, from, to);

    }
}