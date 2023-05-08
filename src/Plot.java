public class Plot {

    public String plantName;
    public int numberOfPlants;
    public boolean needsWater;
    public int randomNumber;
    public int plotNumber;

    public Plot(){
        //task: assign a random value between 10 and 100
        numberOfPlants = (int)(Math.random()*90+10);

        //task2: assign a random "string" name to plantName
        randomNumber = (int)(Math.random()*5);

        if (randomNumber == 0) {
            plantName = "tomato";
        } else if (randomNumber == 1) {
            plantName = "carrot";
        } else if (randomNumber == 2) {
            plantName = "lettuce";
        } else if (randomNumber == 3) {
            plantName = "tulip";
        } else /*if (randomNumber == 4)*/ {
            plantName = "empty";
            numberOfPlants = 0;
        }

        //do now:randomly assign true or false to needsWater
        int waterID = (int)(Math.random()*2);
        if (waterID == 0 && !plantName.equals("empty")){
            needsWater = true;
        } else {
            needsWater = false;
        }

    }//Plot() this is called the constructor method

    public void printPlotInfo() {
        System.out.println("***PLOT " + plotNumber + " INFO***");
        System.out.println("Plant name: " + plantName);
        System.out.println("There are " + numberOfPlants + " plants");
        if (needsWater) {
            System.out.println("These plants need water");
        } else {
            System.out.println("These plants do not need water");
        }
        System.out.println();
    }

}
