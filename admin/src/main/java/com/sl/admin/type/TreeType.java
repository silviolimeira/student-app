package com.sl.admin.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TreeType {
	DIV(10,"Division"), 
	VERTICAL_LAYOUT(20, "Vertical Layout"), 
	HORIZONTAL_LAYOUT(30, "Horizontal Layout");

    private int value;
    private String title;

    TreeType(int value, String title) {
        this.value = value;
        this.title = title;
    }

    public int getValue() {
        return value;
    }
    
    public String getName() {
    	return name();
    }
    
    public String getTitle() {
    	return title;
    }
    
}
