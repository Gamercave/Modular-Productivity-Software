package Main;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Root {
    private JPanel pane;
    private JButton testButton;


    public Root(){
    testButton.setName("testButton");
    pane.setName("panex");
    }
    public void add(Root child){
        pane.add(child.getPane());
    }

    public Container getPane() {
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
