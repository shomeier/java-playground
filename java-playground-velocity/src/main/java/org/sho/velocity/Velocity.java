package org.sho.velocity;

import org.apache.commons.io.IOUtils;
import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.ToolManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;

public class Velocity {

    private static final Logger LOGGER = LoggerFactory.getLogger(Velocity.class);

    public static void main(String[] args) throws IOException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("json/google-vison-all-features.json");
        String jsonString = IOUtils.toString(is, "UTF-8");

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty("resource.loader", "class");
        velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
//        velocityEngine.setProperty(Velocity.RESOURCE_LOADER, "string");
//        velocityEngine.addProperty("resource.loader.string.class", StringResourceLoader.class.getName());
        velocityEngine.init();

//        StringResourceRepository repository = StringResourceLoader.getRepository();
//        String templateString = "#set($json = $json.parse($inputString))##\njson: $json";
//        repository.putStringResource("template", templateString );

        ToolManager manager = new ToolManager();
//        manager.autoConfigure(true);
        manager.configure("velocity/tools.xml");
        manager.setVelocityEngine(velocityEngine);
        Context context = manager.createContext();
        final String[] keys = context.getKeys();
        for (String key : keys) {
            LOGGER.info("KEY: {}", key);
        }

        // Template template = velocityEngine.getTemplate("velocity/template-google.vm");
        Template template = velocityEngine.getTemplate("velocity/template-google-colors.vm");
        Map<String, Object> variables = Map.of("ext.ai-imagetagging.tagThreshold", Double.valueOf(0.000001));
        context.put("inputString", jsonString);
        context.put("variables", variables);

        StringWriter writer = new StringWriter();
        template.merge( context, writer );
        LOGGER.info("RESULT: \n{}", writer);
    }
}
