package Main.Module;

import Main.ModuleDirectory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Random;

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
        pane.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                MPSModule toMoveTo = ModuleDirectory.findModule(e.getLocationOnScreen());
                parent.move(toMoveTo);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        Color[] colors = new Color[3];
        colors[0] = Color.red;
        colors[1] = Color.BLUE;
        colors[2] = Color.ORANGE;
        Color bg = colors[new Random().nextInt(0,2)];
        pane.setBackground(bg);
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
    public void add(ModuleUI child){
        if (child.getPane().getParent() == null)
        {
            pane.add(child.getPane());
            parent.getWidnow().getPane().validate();
            return;
        }
            pane.add(child.getPane());
        parent.getWidnow().getPane().validate();


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
        pane.validate();

    }

    public boolean isInBounds(Point point) {
       //return pane.getBounds().contains(point);
       Dimension dim = new Dimension(pane.getWidth(),pane.getHeight());
               Rectangle rectangle = new Rectangle(pane.getLocationOnScreen(),dim);
               return rectangle.contains(point);
    }

    public void setPosition(Point point) {
        pane.setLocation(point);
        pane.validate();
    }
}
