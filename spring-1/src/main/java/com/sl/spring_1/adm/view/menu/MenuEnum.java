package com.sl.spring_1.adm.view.menu;

public enum MenuEnum {
	
    MODULE_SECTION("module_section"),
    CAD_GROUP("cad_group"),
    CAD_FIELD("cad_field"),
    ;
    private final String modal;

    MenuEnum(final String modal) {
        this.modal = modal;
    }

    @Override
    public String toString() {
        return modal;
    }
}
