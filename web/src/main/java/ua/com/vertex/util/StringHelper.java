package ua.com.vertex.util;

import org.springframework.util.StringUtils;

/**
 * Created by sweet_home on 22.10.16.
 */
public class StringHelper {

    public String deleteAll(String from, String toDelete) {
        return StringUtils.deleteAny(from, toDelete);
    }
}
