import Core.Module;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        ArrayList<Module> modules = new ArrayList<Module>();
        int i = 1;
        modules.add(new Module("0"));
        modules.add(new Module("1"));
        while (i<1000){
            String parent = modules.get(modules.size()-1).getModuleID();
            String parent2 = modules.get(modules.size()-2).getModuleID();
            Module child = new Module(parent);
            Module child2 = new Module(parent2);
            modules.add(child);
            modules.add(child2);
            i++;
        }
        i = 0;
        String IDs[] = new String[2000];
        while (i<2000){
            IDs[i] = modules.get(i).getModuleID();
            i++;
        }
        i = 0;
        ArrayList<String> Clone = new ArrayList<>();
        while(i<2000){
            Clone.add(IDs[i]);
            i++;
        }
        i = 0;

        while (i<2000)
        {
           int indexOfID = Clone.indexOf(IDs[i]);
           String idAtIndex = IDs[i];
           boolean flag = (indexOfID!=i);
            if(flag)
            {
                System.out.println("true");

            }
            i++;

        }
        System.out.println("Done");

    }
}