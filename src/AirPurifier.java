/* Description of AirPurifier Class

## Instance variables
* model    - The name model of air purifier.
* serialNo - Specific letter of air purifier.
* filter   - Quality of air filter.
* power    - Working status of air purifier.
* fanSpeed - Speed of fan in air purifier.
* pm_level - PM2.5 level form sensor in air purifier.

## Instance methods
* turnOn      - Turn on the air purifier.
* turnOff     - Turn off the air purifier.
* setFanSpeed - Set fan speed of air purifier. (pass integer speed value)
* getPMLevel  - Get quality value of air from environment air purifier. (return integer value)
* checkFilter - Check air filter efficiency of air purifier.

## Class variables
* MAXc        - Max value of xiaomi air purifier models in case the number of models is increased in the future.
* countModel  - Array contain amount of air purifier in each model.
* Nmodel      - Array contain name of air purifier in each model.
* modelCount  - Amount model of xiaomi air purifier have.

## Class methods
* mostPopularModel - show the popular model of xiaomi air purifier from manufacturer.
* */

public class AirPurifier{
    String model;
    String serialNo;
    String filter;
    boolean power;
    int fanSpeed;
    int pm_level;

    static int MAXc = 100;
    static int[] countModel = new int[MAXc];
    static  String[] Nmodel = new String[MAXc];
    static int modelCount;

    static String mostPopularModel(){
        int countcheck = countModel[0];
        if(countModel[0] == 0){
            return "NOT HAVE ANY PRODUCT";
        }
        else {
            for (int j : countModel)
                if (j > countcheck)
                    countcheck = j;
            for (int i =0;i<countModel.length;i++)
                if(countModel[i] == countcheck)
                    return Nmodel[i];

        }
        return "";
    }

    public static void main(String[] args){
        AirPurifier a = new AirPurifier("Xiaomi 4 Air Purifier Lite", "XM5489872542TH");
        AirPurifier b = new AirPurifier("Xiaomi 4 Air Purifier Lite", "XM6487888741TH");
        AirPurifier c = new AirPurifier("Xiaomi Pro Air Purifier", "XM1713546664TH");
        AirPurifier d = new AirPurifier("Xiaomi 4 Air Purifier Compact", "XM3427848798TH");

        System.out.println("The line up of Xiaomi AirPurifier have " + AirPurifier.modelCount + " models.");
        System.out.println("The most popular model is " + AirPurifier.mostPopularModel());
        System.out.println("PM2.5 level is " + a.getPMLevel() + " µg/m3");

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
        for(int i=0;i< Nmodel.length;i++){
            if(model.equalsIgnoreCase(Nmodel[i])){
                countModel[i] = countModel[i] + 1;
                break;
            }
            else if(!model.equalsIgnoreCase(Nmodel[i]) && Nmodel[i] != null){
                continue;
            }
            else{
                Nmodel[i] = model;
                modelCount = modelCount + 1;
                countModel[i] = countModel[i] + 1;
                break;
            }
        }
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