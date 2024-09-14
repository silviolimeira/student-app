package com.sl.spring_1.adm.form;

public enum FormEnum {
	
    CAD_SECTION("cad_section"),
    CAD_GROUP("cad_group"),
    CAD_FIELD("cad_field"),
    ;
    private final String modal;

    FormEnum(final String modal) {
        this.modal = modal;
    }

    @Override
    public String toString() {
        return modal;
    }
}
