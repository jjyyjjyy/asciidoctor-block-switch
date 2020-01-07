package io.github.jjyy.registry;

import io.github.jjyy.processor.BlockSwitchProcessor;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.extension.DocinfoProcessor;
import org.asciidoctor.jruby.extension.spi.ExtensionRegistry;

import java.lang.reflect.Method;

/**
 * @author jy
 */
public class BlockSwitchRegistry implements ExtensionRegistry {

    @Override
    public void register(Asciidoctor asciidoctor) {
        Object javaExtensionRegistry = asciidoctor.javaExtensionRegistry();
        try {
            Method docinfoProcessor = javaExtensionRegistry.getClass().getMethod("docinfoProcessor",
                DocinfoProcessor.class);
            docinfoProcessor.invoke(javaExtensionRegistry, new BlockSwitchProcessor());
        } catch (Exception ex) {
            throw new RuntimeException("Failed to register " + BlockSwitchProcessor.class.getSimpleName());
        }
    }
}
