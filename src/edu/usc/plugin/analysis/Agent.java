package edu.usc.plugin.analysis;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by mian on 8/6/15.
 */
public class Agent {
    public static void logInvoke() throws FileNotFoundException {
        try {
            throw new Exception("mw");
        } catch (Exception e) {
            OutputStream os = new FileOutputStream("/home/mian/CALL.log", true);
            PrintStream ps = new PrintStream(os);
            e.printStackTrace(ps);
            ps.flush();
            ps.close();
        }
    }
}
