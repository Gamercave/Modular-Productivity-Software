package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Root {
    private JPanel pane;
    private JButton testButton;


    public Root(){
    int i = 0;
        for (Component c: pane.getComponents())
        {
        if (c.getName() == null)
        {
            c.setName(c.getClass()+ Integer.toString(i));
        }
        }
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pane.setLocation(10,10);
            }

        });
    }

    public void pressTestButton() {
        testButton.doClick();
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
