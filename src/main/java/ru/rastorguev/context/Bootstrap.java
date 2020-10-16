package ru.rastorguev.context;

import javafx.application.Application;
import ru.rastorguev.view.Interface;
import sun.awt.OSInfo;
import sun.misc.OSEnvironment;

import static ru.rastorguev.constant.Constant.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.ProcessBuilder.*;

public final class Bootstrap {

    private static List<String> commandOutput;
    private static boolean isContains;

    public void init() {
        commandOutput = new ArrayList<>();
        setLaunchType();
        Application.launch(Interface.class);

        System.out.println();



        //System.out.println(OSInfo.getWindowsVersion().toString());
    }

    private void setLaunchType() {
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

    public static boolean isAdmin() throws Exception {
        if (OSInfo.getOSType().toString().contains(WINDOWS)) {
                final Class cl = Class.forName(NTSYSTEM);
                Method method = cl.getMethod(GET_GROUP_IDS);
                String[] groups = (String[]) method.invoke(cl.newInstance());
                for (String group : groups) {
                    if (group.equals(ADMINISTRATOR))
                        return true;
                }
                return false;
        } else {
            return false;
        }
    }

}