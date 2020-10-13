package ru.rastorguev.context;

import ru.rastorguev.constant.Constant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.ProcessBuilder.*;

public class Bootstrap {

    private static boolean isContains;

    private static List<String> commands = new ArrayList<>();
    private static List<String> commandOutput = new ArrayList<>();

    static {
        commands.add(Constant.CONFIGURATION_DATA);
        //commands.add(Constant.SQL);
    }

    public void init() {

        try {
            final ProcessBuilder pb = new ProcessBuilder();
            pb.redirectOutput(Redirect.INHERIT);
            pb.redirectError(Redirect.INHERIT);

            pb.command(Constant.CMD, Constant.C, Constant.CONFIGURATION_DATA);
            final BufferedReader input = new BufferedReader(new InputStreamReader(pb.start().getInputStream()));

            String line;
            while((line = input.readLine()) != null) {
                commandOutput.add(line);
            }
            //the fourth line contains information about the startup type
            if (!commandOutput.isEmpty()) isContains = commandOutput.get(4).contains(Constant.DEMAND);
            if (!isContains) {
                pb.command(Constant.CMD, Constant.C, Constant.SET_TYPE_DEMAND);
                pb.start();
            }




//
//            Process process = Runtime.getRuntime().exec(Constant.CONFIGURATION_DATA);
//            process.waitFor();
//            process.destroy();
//
//            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
//
//            String line;
//            while((line = input.readLine()) != null) {
//                System.out.println(line);
//                System.out.println(line.length());
//                strings.add(line);
//            }
//
//            System.out.println(strings.get(4).contains(Constant.DEMAND));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
