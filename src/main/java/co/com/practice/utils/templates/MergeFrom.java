package co.com.practice.utils.templates;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class MergeFrom {
    private final String templateFile;

    private static final FreemarkerTemplate freemarkerTemplate = new FreemarkerTemplate();

    public MergeFrom(String templateFile) {
        this.templateFile = templateFile;
    }

    public static MergeFrom template(String template) {
        return new MergeFrom(template);
    }

    public String withFieldsFrom(Map<String, String> fieldValues) {
        Template template = freemarkerTemplate.getTemplate(templateFile);

        Writer writer = new StringWriter();

        try {
            template.process(fieldValues, writer);
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException("Failed to merge test data template", e);
        }

        return writer.toString();
    }
}
