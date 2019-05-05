package com.gameFx.hiRank.io;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileOperations implements JsonOperations {
    @Override
    public <T> List<T> readJsonToPojoList(String fileName, Class<T> clazz) {
        String data = "";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            data = stream.collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Arrays.asList(new Gson().fromJson(data, clazz));
    }

    @Override
    public void writePojoToJson(String fileName, List gameList) {
        Path path = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(new Gson().toJson(gameList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
