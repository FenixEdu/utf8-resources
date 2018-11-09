package org.fenixedu.utf8.resources;

import java.util.ResourceBundle;
import java.util.spi.ResourceBundleControlProvider;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */
public class UTF8ResourceBundleControlProvider implements ResourceBundleControlProvider {

    private static final UTF8ResourceBundleControl utf8ResourceBundleControl = new UTF8ResourceBundleControl();

    public UTF8ResourceBundleControlProvider() {
        System.out.printf("Initializing %s%n", getClass().getSimpleName());
    }


    @Override
    public ResourceBundle.Control getControl(final String baseName) {
        System.out.printf("[%s] Loading bundle with baseName: %s%n", getClass().getSimpleName(), baseName);
        return baseName.startsWith("resources") ? utf8ResourceBundleControl : null;
    }

    public static UTF8ResourceBundleControl getUtf8ResourceBundleControl() {
        return utf8ResourceBundleControl;
    }
}
