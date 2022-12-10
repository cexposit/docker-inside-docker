package com.kaizten.task;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KaiztenProcessBuilder {

    public static void execute(String[] commandToExecute) {
        System.out.println("COMMAND TO EXECUTE: " + Arrays.toString(commandToExecute));
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(commandToExecute);
        try {
            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            StringBuilder outputError = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = errorReader.readLine()) != null) {
                outputError.append(line + '\n');
            }
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println("\tOutput: " + output);
                System.out.println("\tOutputError: " + outputError);
            } else {
                System.out.println("Failure!");
                System.out.println("\tOutput: " + output);
                System.out.println("\tOutputError: " + outputError);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
