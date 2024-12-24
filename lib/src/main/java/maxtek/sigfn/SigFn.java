package maxtek.sigfn;

import java.util.Map;

public class SigFn {
    public static final int SIGABRT;
    public static final int SIGFPE;
    public static final int SIGILL;
    public static final int SIGINT;
    public static final int SIGSEGV;
    public static final int SIGTERM;

    private static Map<Integer, Handler> handlers;

    static {
        SIGABRT = getSignum("SIGABRT");
        SIGFPE = getSignum("SIGFPE");
        SIGILL = getSignum("SIGILL");
        SIGINT = getSignum("SIGINT");
        SIGSEGV = getSignum("SIGSEGV");
        SIGTERM = getSignum("SIGTERM");
        handlers = new java.util.HashMap<>();
    }

    public static void handle(int signum, Handler handler)
    {
        if (handler == null)
        {
            throw new NullPointerException("handler");
        }
        handleNative(signum);
        handlers.put(signum, handler);
    }

    public static void ignore(int signum)
    {
        ignoreNative(signum);
        handlers.remove(signum);
    }

    public static void reset(int signum)
    {
        resetNative(signum);
        handlers.remove(signum);
    }

    private static void signalHook(int signum)
    {
       handlers.get(signum).handle(signum); 
    }

    private static native int getSignum(String name);

    private static native void handleNative(int signum);

    private static native void ignoreNative(int signum);

    private static native void resetNative(int signum);
}
