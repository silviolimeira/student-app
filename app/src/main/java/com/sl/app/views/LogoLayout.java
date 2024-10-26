package com.sl.app.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class LogoLayout extends HorizontalLayout {

    private Image image;

    public LogoLayout() {
        image = new Image("images/logo.png", "Logomarca");
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(image);
    }
}
