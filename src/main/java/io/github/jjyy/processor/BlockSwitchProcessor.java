package io.github.jjyy.processor;

import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.DocinfoProcessor;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

/**
 * @author jy
 */
public class BlockSwitchProcessor extends DocinfoProcessor {

    @Override
    public String process(Document document) {
        String css = readResource("/blockSwitch.css");
        String javascript = readResource("/blockSwitch.js");
        return String.format("<style>%n%s%n</style>%n"
            + "<script src=\"https://cdn.bootcss.com/zepto/1.2.0/zepto.min.js\"></script>%n"
            + "<script type=\"text/javascript\">%n%s%n</script>%n", css, javascript);
    }

    private String readResource(String name) {
        Reader reader = new InputStreamReader(getClass().getResourceAsStream(name));
        try {
            StringWriter writer = new StringWriter();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer)) >= 0) {
                writer.write(buffer, 0, read);
            }
            return writer.toString();
        } catch (Exception ex) {
            throw new IllegalStateException("Failed to read '" + name + "'", ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                // Continue
            }
        }
    }
}
