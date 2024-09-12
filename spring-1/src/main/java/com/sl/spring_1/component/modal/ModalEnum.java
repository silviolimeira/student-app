package com.sl.spring_1.component.modal;

public enum ModalEnum {
	
    CAD_CLIENTES("cad_clientes"),
    ;
    private final String modal;

    ModalEnum(final String modal) {
        this.modal = modal;
    }

    @Override
    public String toString() {
        return modal;
    }
}
