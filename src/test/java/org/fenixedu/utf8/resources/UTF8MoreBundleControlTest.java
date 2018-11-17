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
public class UTF8MoreBundleControlTest {

    @Test
    public void testLoadingMoreThanOneBundle() {
        String value = ResourceBundle.getBundle("contents.ContentsResources").getString("some.content.value");
        Assert.assertEquals("This is a content value with emojis \uD83E\uDD23\uD83E\uDD23\uD83E\uDD23 in UTF-8", value);
    }

    @Test
    public void testLoadingNonUtf8Bundle() {
        String value = ResourceBundle.getBundle("nonutf8.NonUTF8Resources").getString("some.non.utf8.property");
        Assert.assertEquals("This is a non utf8 property: é", value);
    }

}
