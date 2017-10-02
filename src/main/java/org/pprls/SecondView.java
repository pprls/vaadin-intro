package org.pprls;

import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.declarative.Design;

@DesignRoot
public class SecondView extends Panel implements View {

    private TextField ft;
    private Button button;
    private Label label;

    public SecondView(){
        Design.read(this);

        MyEventBus.register(this);

        button.addClickListener(click -> {
            MyEventBus.post(new MyEvent.SecondButtonEvent(ft.getValue()));
            UI.getCurrent().getNavigator().navigateTo("");
        });

    }

    @Subscribe
    public void arbitraryNambedMethod1(final MyEvent.FirstButtonEvent event) {
        label.setValue(event.getText());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Welcome first view");
    }
}
