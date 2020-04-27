package fun.oook.webchat.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author ZhouYu
 * @version 1.0.0
 * @since 2020/4/27
 */
public final class IdUtils {

    public static String shortId() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    public static String longNumericId() {
        return RandomStringUtils.randomNumeric(13);
    }
}
