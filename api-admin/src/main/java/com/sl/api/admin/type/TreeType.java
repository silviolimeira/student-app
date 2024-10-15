package com.sl.api.admin.type;

public enum TreeType {
	DIV(10), VERTICAL_LAYOUT(20), HORIZONTAL_LAYOUT(30);

    private int value;

    TreeType(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    public String getName() {
    	return name();
    }
    
}
