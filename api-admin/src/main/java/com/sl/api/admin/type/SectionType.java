package com.sl.api.admin.type;

public enum SectionType {
	DIV(10), VERTICAL_LAYOUT(20), HORIZONTAL_LAYOUT(30);

    private int value;

    SectionType(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    public String getName() {
    	return name();
    }
    
}
