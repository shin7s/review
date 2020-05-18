package com.alg.bookIQL;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _15_3_3SacnFilePath {
    public static void main(String[] args) {
        String path = "F://ab";
        System.out.println(scanFilepath(path));
    }
    public static List<String> scanFilepath(String path) {

        File file = new File(path);
        List<String> list = new ArrayList<>();
        if (file.isDirectory()) {
            File[] files = file.listFiles((dir, name) -> name.endsWith(".txt") || name.endsWith(".log"));

            if (files != null && files.length > 0) {
                list.addAll(Stream.of(files).map(f -> f.getAbsolutePath()).collect(Collectors.toList()));
            }

            File[] dirs = file.listFiles(pathname -> pathname.isDirectory());
            for (File dir : dirs) {
                list.addAll(scanFilepath(dir.getAbsolutePath()));
            }
        }
        return list;
    }
}
