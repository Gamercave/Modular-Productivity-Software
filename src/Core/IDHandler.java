package Core;

public final class IDHandler {
    // gets database connection to see how many modules are currently in use
    private static IDHandler _INSTANCE;
    private static Integer moduleCount;
    private IDHandler()
    {
        moduleCount = 0;
    }
    public static String getModuleID(String parentModuleID){
        createHandler();
        // ensures we have an ID handler - this might not be needed as a handler should be made on start up, this is just a fail-safe
        String moduleID;
        moduleID = parentModuleID+ moduleCount;
        moduleCount++;

        return moduleID;
    }
    private static boolean createHandler() {
        if (_INSTANCE==null){
            _INSTANCE = new IDHandler();
        }
        return true;
    }

}
