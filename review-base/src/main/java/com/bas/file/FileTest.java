package com.bas.file;

import java.io.File;

public class FileTest {
    static long mb = 1024 * 1024;
    public static void main(String[] args) {
        File file = new File("F:\\upload");
        System.out.println(file.getFreeSpace() / mb);
    }
}
