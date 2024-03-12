package Main.Module;

import Main.ModuleDirectory;

import java.awt.*;
import java.util.HashMap;

public class MPSModule {
    private String id;
    private final HashMap<String, MPSModule> children;

    private final ModuleUI window;
    private MPSModule parent;
    private int nestLevel;


    public MPSModule(String id) {// Only for use when creating root Module
        this.id = id;
        nestLevel = 0;
        children = new HashMap<>();
        window = new ModuleUI(this);
        this.parent = null;
        ModuleDirectory.addModule(this);
    }

    public MPSModule(MPSModule parent) {

        children = new HashMap<>();
        window = new ModuleUI(this);
        parent.addModule(this);
        this.parent = parent;
        nestLevel = parent.getNestLevel()+1;
        ModuleDirectory.addModule(this);
    }
    public void move( MPSModule moveToo) {
        if (parent!= moveToo ) {
            if (parent !=null)
            {
                parent.removeModule(this);
            }

            moveToo.addModule(this);
        }

    }

    public boolean contains(MPSModule child) {
        Boolean childInMap;
        Boolean childInWindow;
        if (children.get(child.getID()) != null) {
            childInMap = children.get(child.getID()).equals(child);
        } else {
            childInMap = false;
        }

        childInWindow = window.Contains(child.getWidnow());
        return childInWindow && childInMap;
    }



    private void addModule (MPSModule child) {
        String childID = getChildID();
        child.setID(childID);
        child.setNestLevel(nestLevel++);
        children.put(childID, child);
        window.add(child.getWidnow());
        this.validate();

    }


    private void removeModule(MPSModule child) {
        children.remove(child.getID());
        window.remove(child.getWidnow());
        this.validate();

    }

    public boolean isInBounds(Point point) {
        return window.isInBounds(point);
    }
    private void validate() {
        window.validate();
    }


    private void setNestLevel(int i) {
        nestLevel = i;
    }



    public ModuleUI getWidnow() {
        return window;
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

        return window.getPosition();
    }






    public MPSModule getParent() {
            return parent;
    }

    public int getNestLevel() {
        return nestLevel;
    }

}
