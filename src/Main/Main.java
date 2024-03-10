package Main;

import Main.Module.MPSModule;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MPSModule main = new MPSModule("1");
        main.addModule(new MPSModule(main));
        main.addModule(new MPSModule(main));
        JFrame jFrame = new JFrame();
        jFrame.add(main.getWidnow().getPane());
        jFrame.setVisible(true);
        System.out.println("Hello World");
    }
}