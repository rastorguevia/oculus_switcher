package ru.rastorguev.constant;

public final class Constant {

    public static final String CMD = "cmd.exe";

    public static final String C = "/c";

    public static final String CONFIGURATION_DATA = "sc qc OVRService";

    public static final String SET_TYPE = "sc config OVRService start= ";

    public static final String AUTO = "auto";

    public static final String DEMAND = "demand";

    public static final String MAIN_SCENE = "src/main/java/ru/rastorguev/view/fxml/scene.fxml";

    public static final String LOGO_YELLOW = "file:src/main/java/ru/rastorguev/view/image/logo-yellow.png";

    public static final String LOGO_GREEN = "file:src/main/java/ru/rastorguev/view/image/logo-green.png";

    public static final String LOGO_RED = "file:src/main/java/ru/rastorguev/view/image/logo-red.png";

    public static final String START = "sc start OVRService";

    public static final String STOP = "sc stop OVRService";

    public static final String RESTART = "sc stop OVRService && sc start OVRService";

}