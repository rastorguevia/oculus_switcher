package ru.rastorguev.context;

import javafx.application.Application;
import ru.rastorguev.view.Interface;

import static ru.rastorguev.constant.Constant.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.ProcessBuilder.*;

public final class Bootstrap {

    private static List<String> commandOutput;
    private static boolean isContains;

    public void init() {

        Application.launch(Interface.class);

        commandOutput = new ArrayList<>();

        try {
            final ProcessBuilder pb = new ProcessBuilder();
            pb.redirectOutput(Redirect.INHERIT);
            pb.redirectError(Redirect.INHERIT);

            pb.command(CMD, C, CONFIGURATION_DATA);
            final BufferedReader input = new BufferedReader(new InputStreamReader(pb.start().getInputStream()));

            String line;
            while((line = input.readLine()) != null) {
                commandOutput.add(line);
            }
            //the fourth line contains information about the startup type
            if (!commandOutput.isEmpty()) isContains = commandOutput.get(4).contains(DEMAND);
            if (!isContains) {
                pb.command(CMD, C, SET_TYPE + DEMAND);
                pb.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
