package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String name;
        int age;
        String email;
        long phone;

        try (java.io.FileReader fileReader = new java.io.FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            name = bufferedReader.readLine().split(": ")[1];
            age = Integer.parseInt(bufferedReader.readLine().split(": ")[1]);
            email = bufferedReader.readLine().split(": ")[1];
            phone = Long.parseLong(bufferedReader.readLine().split(": ")[1]);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Profile(name, age, email, phone);
    }
}
