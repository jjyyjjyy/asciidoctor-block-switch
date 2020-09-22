package io.github.jjyy.registry;

import io.github.jjyy.processor.BlockSwitchProcessor;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.extension.JavaExtensionRegistry;
import org.asciidoctor.jruby.extension.spi.ExtensionRegistry;

/**
 * @author jy
 */
public class BlockSwitchRegistry implements ExtensionRegistry {

    @Override
    public void register(Asciidoctor asciidoctor) {
        JavaExtensionRegistry javaExtensionRegistry = asciidoctor.javaExtensionRegistry();
        javaExtensionRegistry.docinfoProcessor(new BlockSwitchProcessor());
    }
}
