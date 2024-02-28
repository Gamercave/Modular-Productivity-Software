package Main;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Root {
    private JPanel pane;


    public Root(){
         pane = new JPanel();
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

    public Boolean Contains(Root window) {
        return Arrays.stream(pane.getComponents()).toList().contains(window.getPane());

    }

    public void remove(Root window) {
        pane.remove(window.getPane());
    }
}
