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
    }

    public void pressTestButton() {
        testButton.doClick();
    }


    public void add(ModuleUI child) throws IllegalArgumentException{
        if (child.getPane().getParent() == null)
        {
            pane.add(child.getPane());
            return;
        }

            child.getPane().getParent().remove(child.getPane());
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
    }

}
