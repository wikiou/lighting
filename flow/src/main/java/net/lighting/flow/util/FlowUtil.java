package net.lighting.flow.util;


public class FlowUtil {

    public static boolean hasText(String s) {
        return s != null && s.trim().length() > 0;
    }

    public static String getText(Object o) {
        return o == null ? "" : o.toString().trim();
    }
    
}
