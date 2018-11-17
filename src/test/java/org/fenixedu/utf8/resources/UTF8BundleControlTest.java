package org.fenixedu.utf8.resources;

import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */
@RunWith(JUnit4.class)
public class UTF8BundleControlTest {

    @Test
    public void testLoading() {
        String value = ResourceBundle.getBundle("resources.ExtensionResources").getString("some.property.value");
        Assert.assertEquals("This is a special value with emojis \uD83E\uDD23\uD83E\uDD23\uD83E\uDD23", value);
    }

}
