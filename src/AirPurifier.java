public class AirPurifier{
    String model;
    String serialNo;
    String filter;
    boolean power;
    int fanSpeed;
    int pm_level;

    static int modelCount = 5;
    static String mostPopularModel(){
        return "Xiaomi Air Purifier 4";
    };

    public static void main(String[] args){
        AirPurifier a = new AirPurifier("Xiaomi 4 Air Purifier Lite", "XM5489872542TH");
        System.out.println("The line up of Xiaomi AirPurifier have " + AirPurifier.modelCount + " models.");
        System.out.println("The most popular model is " + AirPurifier.mostPopularModel());
        System.out.println("PM2.5 level is " + a.getPMLevel());
        a.turnOn();
        a.setFanSpeed(2);
        a.checkFilter();
        a.turnOff();


    }

    AirPurifier(String model, String serialNo){
        this.model = model;
        this.serialNo = serialNo;
        this.pm_level = (int) ((Math.random() * (125.0 - 2.0)) + 2.0); // Ref Random from https://www.baeldung.com/java-generating-random-numbers-in-range
        this.fanSpeed = 2;
        this.filter = "Good";
    }

    AirPurifier(String serialNo){
        this("Xiaomi Pro", serialNo);
    }

    public void turnOn(){
        this.power = true;
        System.out.println("[STATUS] " + model + " (S/N:" + serialNo + ") : Air purifier is opened.");
    }
    public void turnOff(){
        this.power = false;
        System.out.println("[STATUS] " + model + " (S/N:" + serialNo + ") : Air purifier is turning off.");
    }

    public void setFanSpeed(int speed){
        this.fanSpeed = speed;
        System.out.println("[STATUS] " + model + " (S/N:" + serialNo + ") : Set fan speed to level " + speed);
    }

    public int getPMLevel(){
        return this.pm_level;
    }

    public void checkFilter(){
        System.out.println("[STATUS] " + model + " (S/N:" + serialNo + ") : Air filter in this machine is " + filter + " efficiency.");
    }

}