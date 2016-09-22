package org.self.learn;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerShowCase {

	public static void main(String[] args) throws IOException, TemplateException {
		/**
		 * You should do this ONLY ONCE in the whole application life-cycle:
		 * Create and adjust the configuration singleton
		 */
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File("C:/Users/PP04244/workspace/citigold-enrolment/fremarker-template-showcase/src/main/resources/templates"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

        /**
         * You usually do these for MULTIPLE TIMES
         * in the application life-cycle
         * Create a data-model
         */

        Map<String, Object> root = new HashMap<>();
        root.put("user", "Big Joe");
        Product latest = new Product();
        latest.setUrl("products/greenmouse.html");
        latest.setName("green mouse");
        root.put("latestProduct", latest);

        //Get the template (uses cache internally)
        Template temp = cfg.getTemplate("free-marker-showcase.ftl");

        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
        String print = "";
        out.write(print);
        System.out.println(print);
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
	}
}
