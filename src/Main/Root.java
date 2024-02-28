package Main;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Root {
    private JPanel pane;


    public Root(){
    }
    public void add(Root child){
        pane.add(child.getPane());
    }

    private Component getPane() {
        return pane;
    }

    public Point getPosition(){
        return new Point(pane.getX(), pane.getY());
    }

    public Boolean Contains(Root widnow) {
        return Arrays.stream(pane.getComponents()).toList().contains(widnow.getPane());

    }

    public void remove(Root widnow) {
        pane.remove(widnow.getPane());
    }
}
