package edu.ucsd.xmlqueryprocessor.util;

import com.github.difflib.DiffUtils;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Patch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

public class FileComparer {

    public static void compareFiles(String filePath1, String filePath2) throws IOException {
        List<String> original = Files.readAllLines(new File(filePath1).toPath())
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
        List<String> revised = Files.readAllLines(new File(filePath2).toPath())
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());

        Patch<String> patch = DiffUtils.diff(original, revised);
        System.out.println("Differences found: " + patch.getDeltas().size());
        for (AbstractDelta<String> delta : patch.getDeltas()) {
            System.out.println(delta);
        }
    }

}
