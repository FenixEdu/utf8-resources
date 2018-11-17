package org.fenixedu.utf8.resources;

import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.spi.ResourceBundleControlProvider;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */
public class UTF8ResourceBundleControlProvider implements ResourceBundleControlProvider {

    private static final Logger logger = Logger.getLogger(UTF8ResourceBundleControlProvider.class.getName());

    private final UTF8ResourceBundleControl utf8ResourceBundleControl = new UTF8ResourceBundleControl();

    private static final String RESOURCES_BASENAME_PROPERTY = "utf8.resources.base.names";
    private static final String DEFAULT_RESOURCES_BASENAME = "resources";
    private final Set<String> RESOURCE_BASE_NAMES;


    public UTF8ResourceBundleControlProvider() {
        String utf8ResourceBaseNameValues = System.getProperty(RESOURCES_BASENAME_PROPERTY, DEFAULT_RESOURCES_BASENAME);
        logger.info("Initializing UTF8 Resource Bundle for baseNames prefixes " + utf8ResourceBaseNameValues);
        RESOURCE_BASE_NAMES =
                Stream.of(utf8ResourceBaseNameValues.split(",")).collect(Collectors.toSet());
    }

    @Override
    public ResourceBundle.Control getControl(final String baseName) {
        if (isUTF8BaseName(baseName)) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine("Loading UTF8 Bundle for " + baseName);
            }
            return utf8ResourceBundleControl;
        } else {
            return null;
        }
    }

    private boolean isUTF8BaseName(final String baseName) {
        return RESOURCE_BASE_NAMES.stream().anyMatch(baseName::startsWith);
    }

}