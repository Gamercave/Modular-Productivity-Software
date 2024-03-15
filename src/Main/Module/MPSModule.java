package Main.Module;

import Main.ModuleDirectory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.HashMap;

public class MPSModule {
    private String id;
    private final HashMap<String, MPSModule> children;

    private MPSModule parent;
    private int nestLevel;
    private javax.swing.JPanel JPanel;
    private JButton testButton;


    public MPSModule(String id) {// Only for use when creating root Module

        children = new HashMap<>();
        this.id = id;
        this.parent = null;
        nestLevel = 0;
        JPanel.addMouseListener(this.getMouseListener());
        testButton.addActionListener(this.getButtonListener());
        setNamesOfUiItems();
        ModuleDirectory.addModule(this);
    }

    public MPSModule(MPSModule parent) {

        children = new HashMap<>();
        parent.addModule(this);
        this.parent = parent;
        nestLevel = parent.getNestLevel()+1;
        JPanel.addMouseListener(this.getMouseListener());
        testButton.addActionListener(this.getButtonListener());
        setNamesOfUiItems();
        ModuleDirectory.addModule(this);
    }
    public void move( MPSModule moveToo) {
        // ITS CHILD CAN BE MOVED TOO MEANING HIGHER IN HEIRACHY CAN GO TO LOWER IN HEIRARCHY
        if (parent!= moveToo ) {
            if (parent != null)
            {
                parent.removeModule(this);
            }

            moveToo.addModule(this);
            return;
        }
        return;

    }
    private void addModule (MPSModule child) {
        String childID = getChildID();
        child.setID(childID);
        child.setNestLevel(nestLevel++);
        children.put(childID, child);
        JPanel.add(child.getPane());


        this.validate();

    }


    private void removeModule(MPSModule child) {
        children.remove(child.getID());
        JPanel.remove(child.getPane());
        this.validate();
    }

    public ActionListener getButtonListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel.setLocation(new Point(50,50));
            }
        };
    }
    public MouseListener getMouseListener(){
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                move(ModuleDirectory.findModule(e.getLocationOnScreen()));
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }


    public boolean contains(MPSModule child) {
        Boolean childInMap;
        Boolean childInWindow;
        if (children.get(child.getID()) != null) {
            childInMap = children.get(child.getID()).equals(child);
        } else {
            childInMap = false;
        }

        childInWindow = Arrays.stream(JPanel.getComponents()).toList().contains(child.getPane());
        return childInWindow && childInMap;
    }

    public Container getPane() {
        return JPanel;
    }

    private void setNamesOfUiItems() {
        int i = 0;
        for (Component c: JPanel.getComponents())
        {
            if (c.getName() == null)
            {
                c.setName(c.getClass()+ Integer.toString(i));
            }
        }

    }



    public boolean isInBounds(Point point) {
        Rectangle rectangle = JPanel.getBounds();
        rectangle.setLocation(JPanel.getLocationOnScreen());
        return rectangle.contains(point);


        //return pane.getBounds().contains(point);
    }
    private void validate() {
        JPanel.validate();
    }


    private void setNestLevel(int i) {
        nestLevel = i;
    }


    private String getChildID() {
        String childID = id + "," + (children.size() + 1);
        return childID;
    }

    public String getID() {
        return id;
    }

    private void setID(String NewID) {
        this.id = NewID;
    }

    public int getNumChildren() {
        return children.size();
    }

    public Point getPosition() {

        return JPanel.getLocationOnScreen();
    }






    public MPSModule getParent() {
            return parent;
    }

    public int getNestLevel() {
        return nestLevel;
    }

    public void pressTestButton() {
        testButton.doClick();
    }
}
