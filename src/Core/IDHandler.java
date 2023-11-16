package Core;
public final class IDHandler {
    // gets database connection to see how many modules are currently in use
    private static IDHandler _INSTANCE;
    private static Integer moduleCount;
    private static Module applicationWindow;

    public static String getModuleID(Module getIDFor){
        createHandler();
        String moduleID = "Error";
        if (moduleCount == 0)
        {
            applicationWindow = getIDFor;
            moduleCount++;
            return "0";
        } else {
            /* ID DETERMINING SYSTEM NEEDED IDEALLY USE PARENTS ID
             so possibly
               string of letters string of numbers so on so forth so A-Z = modules 0-25 at top of tree with the next set being plain digits
               and then  you would be able to seperate the first block from second block and determine where a module is;
             */
        }

        return moduleID;
    }


    private IDHandler()
    {

        moduleCount = 0;
    }
    private static boolean createHandler() {
        if (_INSTANCE.equals(null))
        {
            _INSTANCE = new IDHandler();
        }

        return true;
    }

}