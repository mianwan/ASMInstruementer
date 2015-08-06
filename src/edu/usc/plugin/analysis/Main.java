package edu.usc.plugin.analysis;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.println();
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassVisitor cv = new MyAdapter(cw);
        String path = "/home/mian/IdeaProjects/ASMInstruementer/out/production/ASMInstruementer/edu/usc/plugin/analysis/Test.class";
        InputStream file = new FileInputStream(path);
        ClassReader cr = new ClassReader(file);
        cr.accept(cv, 0);

        //Dump the instrumented class
        String newPath = "/home/mian/IdeaProjects/ASMInstruementer/out/production/ASMInstruementer_new/edu/usc/plugin/analysis";
        File newFile = new File(newPath);
        newFile.mkdirs();
        OutputStream out = new FileOutputStream(new File(newFile, "Test.class"));
        out.write(cw.toByteArray());
        out.flush();
        out.close();
    }
}
