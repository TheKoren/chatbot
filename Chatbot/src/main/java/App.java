import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

public class App {
    public static void main(String[] args) {
        try {
            // Initialize the parser
            InputStream modelIn = new FileInputStream("en-parser-chunking.bin");
            ParserModel model = new ParserModel(modelIn);
            Parser parser = ParserFactory.create(model);

            // Parse the input sentence
            String sentence = "Hello, how are you today?";
            Parse[] parsed = ParserTool.parseLine(sentence, parser, 1);

            // Loop through the parsed sentence and print out the tokens
            for (Parse p : parsed) {
                System.out.println("Token: " + p.getCoveredText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
