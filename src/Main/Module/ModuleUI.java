package Main.Module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ModuleUI {
    private MPSModule parent;
    private JPanel pane;
    private JButton testButton;


    public ModuleUI(MPSModule parent){
        setNamesOfUiItems();
        this.parent = parent;
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pane.setLocation(10,10);
            }

        });
    }

    private void setNamesOfUiItems() {
        int i = 0;
        for (Component c: pane.getComponents())
        {
        if (c.getName() == null)
        {
            c.setName(c.getClass()+ Integer.toString(i));
        }
        }
        pane.setLocation(0,0);
        pane.setSize(500,500);
    }

    public void pressTestButton() {
        testButton.doClick();
    }

// need to remove the throw as it shoudlnt occur currently doing to variable track higher up as it makes checking moduel IDS easher
    public void add(ModuleUI child) throws IllegalArgumentException{
        if (child.getPane().getParent() == null)
        {
            pane.add(child.getPane());
            return;
        }
            pane.add(child.getPane());



    }

    public Container getPane() {
        return pane;
    }

    public Point getPosition(){
        return new Point(pane.getX(), pane.getY());
    }

    public Boolean Contains(ModuleUI window) {
        return Arrays.stream(pane.getComponents()).toList().contains(window.getPane());

    }

    public void remove(ModuleUI window) {
        pane.remove(window.getPane());
        parent = null;
    }

    public boolean isInBounds(Point point) {
       return pane.getBounds().contains(point);
    }
}
