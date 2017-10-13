package org.pprls;

import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.declarative.Design;
import org.pprls.client.PerformanceBondClient;
import org.pprls.model.PerformanceBondDto;

import java.util.List;

@DesignRoot
public class FirstView extends Panel implements View {

    private TextField ft;
    private Button button;
    private Label label;

    public FirstView(){
        Design.read(this);

        MyEventBus.register(this);

        button.addClickListener(click -> {
            MyEventBus.post(new MyEvent.FirstButtonEvent(ft.getValue()));
            UI.getCurrent().getNavigator().navigateTo("View2");
        });
    }

    @Subscribe
    public void arbitraryNambedMethod2(final MyEvent.SecondButtonEvent event) {
        PerformanceBondClient client = new PerformanceBondClient();

        List<PerformanceBondDto> dtos = client.findByName(event.getText());
        label.setValue(event.getText());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        Notification.show("Welcome first view");
    }
}
