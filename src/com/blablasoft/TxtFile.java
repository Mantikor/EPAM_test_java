package com.blablasoft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;

public class TxtFile {
    protected List<String> lines = new ArrayList<>();

    public TxtFile(String fileName){
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            this.lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRndString(){
        SecureRandom rnd = new SecureRandom();
        return this.lines.get(rnd.nextInt(this.lines.size()));
    }
}
