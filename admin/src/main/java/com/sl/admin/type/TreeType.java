package com.sl.admin.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TreeType {
	DIV(10), VERTICAL_LAYOUT(20), HORIZONTAL_LAYOUT(30);

    private int value;
//    private static Map<Object, Object> map = new HashMap<>();

    TreeType(int value) {
        this.value = value;
    }
    

//    public static List<String> names() {
//    	List<String> list = new ArrayList<>();
//        for (SectionType st : SectionType.values()) {
//    		list.add(st.name());
//        }
//        return list;
//    }

//    static {
//        for (SectionType sectionType : SectionType.values()) {
//            map.put(sectionType.value, sectionType);
//        }
//    }

    public int getValue() {
        return value;
    }
    public String getName() {
    	return name();
    }
}
