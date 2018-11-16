package org.fenixedu.utf8.resources;

import java.util.ResourceBundle;
import java.util.Set;
import java.util.spi.ResourceBundleControlProvider;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */
public class UTF8ResourceBundleControlProvider implements ResourceBundleControlProvider {

    private final UTF8ResourceBundleControl utf8ResourceBundleControl = new UTF8ResourceBundleControl();

    private static final String RESOURCES_BASENAME_PROPERTY = "utf8.resources.base.names";
    private static final String DEFAULT_RESOURCES_BASENAME = "resources";
    private final Set<String> RESOURCE_BASE_NAMES;


    public UTF8ResourceBundleControlProvider() {
        String utf8ResourceBaseNameValues = System.getProperty(RESOURCES_BASENAME_PROPERTY, DEFAULT_RESOURCES_BASENAME);
        RESOURCE_BASE_NAMES =
                Stream.of(utf8ResourceBaseNameValues.split(",")).collect(Collectors.toSet());
    }

    @Override
    public ResourceBundle.Control getControl(final String baseName) {
        return isUTF8BaseName(baseName) ? utf8ResourceBundleControl : null;
    }

    private boolean isUTF8BaseName(final String baseName) {
        return RESOURCE_BASE_NAMES.stream().anyMatch(e -> e.startsWith(baseName));
    }

}