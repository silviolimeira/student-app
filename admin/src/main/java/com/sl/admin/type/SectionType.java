package com.sl.admin.type;

import java.util.HashMap;
import java.util.Map;

public enum SectionType {
	DIV(1), VERTICAL_LAYOUT(2), HORIZONTAL_LAYOUT(3);

    private int value;
    private static Map<Object, Object> map = new HashMap<>();

    private SectionType(int value) {
        this.value = value;
    }

    static {
        for (SectionType sectionType : SectionType.values()) {
            map.put(sectionType.value, sectionType);
        }
    }

    public static String getName(int sectionType) {
        return map.get(sectionType).toString();
    }

    public int getValue() {
        return value;
    }
}
