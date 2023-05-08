import java.util.ArrayList;

public class MyFarm {

    //declaration section
    ArrayList<Plot> row;
    public static void main(String[] args) {
        MyFarm LettuceCode = new MyFarm();
    }

    public MyFarm(){
    //construct my arraylist of objects
        {
            row = new ArrayList<>();

            //fill my arraylist
            for (int i = 0; i < 10; i++) {
                row.add(new Plot());
            }
        }//creates ArrayList for row of plots
        //methods to run

            //consolidatedInfo();

            //practice problems
            consolidatedInfo();
            plantWithMaxNumberNeedsWater();
            plantWithMinNumber();
            plantWithMaxNumber();

    }//MyFarm is the constructor method

    //how many total plants are there in the row?
    public void totalPlants() {
        int total = 0;
        System.out.println("*****TOTAL PLANTS*****");
        for (int s = 0; s < row.size(); s++) {
            total = total + row.get(s).numberOfPlants;
        }
        System.out.println("Total plants in the row: " + total);
    }//totalPlants()

    public void addLettuce() {
        row.add(new Plot());
        row.get(row.size() - 1).numberOfPlants = 42;
        row.get(row.size() - 1).plantName = "lettuce";
        row.get(row.size() - 1).needsWater = true;
    }

    public void plotInfo() {
        //test object by using the printPlotInfo method
        for (int i=0; i < row.size(); i++) {
            row.get(i).plotNumber = i + 1;
            row.get(i).printPlotInfo();
        }
    }

    public void printPlantNames() {
        //print the name of each plant in the row and its index
        System.out.println("*****PLANT NAMES*****");
        for (int i=0; i < row.size(); i++) {
            System.out.print((i + 1) + ": " + row.get(i).plantName + ", ");
        }
    }

    public void consolidatedInfo() {
        System.out.println("*****PLOT INFO*****");
        for (int i=0; i < row.size(); i++) {
            if (row.get(i).needsWater) {
                System.out.println("Row " + (i + 1) + " has " + row.get(i).numberOfPlants + " " + row.get(i).plantName + " plants which need water");
            } else {
                System.out.println("Row " + (i + 1) + " has " + row.get(i).numberOfPlants + " " + row.get(i).plantName + " plants which do not need water");

            }
        }

    }

    public void addTulip() {
        // at index 3, add a new tulip plot with 70 plants that do not need water
        // call printPlantNames() method before and after your addition to make sure it worked
        row.get(3).numberOfPlants = 70;
        row.get(3).plantName = "tulip";
        row.get(3).needsWater = false;
    }

    public void tomatoLocations() {
        // print indexes of all tomato plants
        // call printPlantNames() method to make sure you're getting the correct indexes
        Boolean seenTomato = false;
        System.out.println("*****TOMATO PLANT LOCATIONS*****");
        System.out.print("There are tomato plants at the following row(s): ");
        for (int i=0; i < row.size(); i++) {
            if (!seenTomato) {
                if (row.get(i).plantName == "tomato") {
                    System.out.print((i+1));
                    seenTomato = true;
                }
            } else {
                if (row.get(i).plantName == "tomato") {
                    System.out.print(", " + (i+1));
                }
            }
        }
        System.out.println();
    }

    public void totalCarrots() {
        // how many total carrot plants are there?
        int numberOfCarrots = 0;
        int numberOfCarrotPlots = 0;
        for (int i=0; i < row.size(); i++) {
            if (row.get(i).plantName == "carrot") {
                numberOfCarrots += row.get(i).numberOfPlants;
                numberOfCarrotPlots++;
            }
        }
        System.out.println("There are " + numberOfCarrots + " total carrot plants in " + numberOfCarrotPlots + " plots");
    }
    public void averageNumberOfPlants() {
        // what is the average number of plants across the whole row?
        int averagePlants = 0;
        for (int i=0; i < row.size(); i++) {
            averagePlants += row.get(i).numberOfPlants;
        }
        averagePlants = (averagePlants / row.size());
        System.out.println("On average, there are " + averagePlants + " plants in each plot in the row");
    }
    public void numberOfEmptyPlots() {
        // how many plots are empty
        // call printPlantNames() method to check
        int numberOfEmptyPlots = 0;
        for (int i=0; i < row.size(); i++) {
            if (row.get(i).plantName == "empty") {
                numberOfEmptyPlots++;
            }
        }
        System.out.println("There are " + numberOfEmptyPlots + " empty plots");

    }
    public void everyOtherNeedsWater(){
        // change the value of needsWater to be true for every other plot
        for (int i=0; i < row.size(); i+=2) {
            row.get(i).needsWater = true;
        }
    }
    public void greaterThan10() {
        // how many plots have more than 10 plants in the plot?
        int numberOfgrTenPlots = 0;
        for (int i=0; i < row.size(); i++) {
            if (row.get(i).numberOfPlants > 10) {
                numberOfgrTenPlots++;
            }
        }
        System.out.println("There are " + numberOfgrTenPlots + " plots with more than ten plants");

    }
    public void plantWithMaxNumber() {
        // which plant type has the most total plants?
        //variable definition
        int numTomatoPlants = 0;
        int numTulipPlants = 0;
        int numLettucePlants = 0;
        int numCarrotPlants = 0;
        int currMax = 0;
        String typeMostPlants = "nothing";
        for (int i=0; i < row.size(); i++) {
            if (row.get(i).plantName.equals("carrot")) {
                numCarrotPlants += row.get(i).numberOfPlants;
                if (numCarrotPlants > numTomatoPlants && numCarrotPlants > numTulipPlants && numCarrotPlants > numLettucePlants) {
                    typeMostPlants = row.get(i).plantName;
                    currMax = numCarrotPlants;
                }
            }
            else if (row.get(i).plantName.equals("tulip")) {
                numTulipPlants += row.get(i).numberOfPlants;
                if (numTulipPlants > numTomatoPlants && numTulipPlants > numCarrotPlants && numTulipPlants > numLettucePlants) {
                    typeMostPlants = row.get(i).plantName;
                    currMax = numTulipPlants;
                }
            }
            else if (row.get(i).plantName.equals("tomato")) {
                numTomatoPlants += row.get(i).numberOfPlants;
                if (numTomatoPlants > numCarrotPlants && numTomatoPlants > numTulipPlants && numTomatoPlants > numLettucePlants) {
                    typeMostPlants = row.get(i).plantName;
                    currMax = numTomatoPlants;
                }
            }
            else if (row.get(i).plantName.equals("lettuce")) {
                numLettucePlants += row.get(i).numberOfPlants;
                if (numLettucePlants > numTomatoPlants && numLettucePlants > numTulipPlants && numLettucePlants > numCarrotPlants) {
                    typeMostPlants = row.get(i).plantName;
                    currMax = numLettucePlants;
                }
            }
        }
        System.out.println("The plant type with the most plants is " + typeMostPlants + " with " + currMax + " plants");
    }
    public void plantWithMinNumber() {
        // which plant type has the least total plants (not counting empty plots)?
        //variable definition
        int numTomatoPlants = 0;
        int numTulipPlants = 0;
        int numLettucePlants = 0;
        int numCarrotPlants = 0;
        int currMin = 0;
        String typeLeastPlants = "nothing";
        for (int i=0; i < row.size(); i++) {
            if (row.get(i).plantName.equals("carrot")) {
                numCarrotPlants += row.get(i).numberOfPlants;
            }
            else if (row.get(i).plantName.equals("tulip")) {
                numTulipPlants += row.get(i).numberOfPlants;
            }
            else if (row.get(i).plantName.equals("tomato")) {
                numTomatoPlants += row.get(i).numberOfPlants;
            }
            else if (row.get(i).plantName.equals("lettuce")) {
                numLettucePlants += row.get(i).numberOfPlants;
            }
        }
        if (numCarrotPlants < numTomatoPlants && numCarrotPlants < numTulipPlants && numCarrotPlants < numLettucePlants && numCarrotPlants > 0) {
            typeLeastPlants = "carrot";
            currMin = numCarrotPlants;
        }
        else if (numTulipPlants < numTomatoPlants && numTulipPlants < numCarrotPlants && numTulipPlants < numLettucePlants && numTulipPlants > 0) {
            typeLeastPlants = "tulip";
            currMin = numTulipPlants;
        }
        else if (numTomatoPlants < numCarrotPlants && numTomatoPlants < numTulipPlants && numTomatoPlants < numLettucePlants && numTomatoPlants > 0) {
            typeLeastPlants = "tomato";
            currMin = numTomatoPlants;
        }
        else if (numLettucePlants < numTomatoPlants && numLettucePlants < numTulipPlants && numLettucePlants < numCarrotPlants && numLettucePlants > 0) {
            typeLeastPlants = "lettuce";
            currMin = numLettucePlants;
        }
/*        System.out.println(numTomatoPlants);
        System.out.println(numCarrotPlants);
        System.out.println(numTulipPlants);
        System.out.println(numLettucePlants);*/
        System.out.println("The plant type with the fewest plants is " + typeLeastPlants + " with " + currMin + " plants");
    }
    public void plantWithMaxNumberNeedsWater(){
        // which plant type has the most total plants (not counting empty plots) that needs water?
        //variable definition
        int numTomatoPlants = 0;
        int numTulipPlants = 0;
        int numLettucePlants = 0;
        int numCarrotPlants = 0;
        int numEmptyPlants = 0;
        String typeMostPlants = "nothing";
        for (int i=0; i < row.size(); i++) {
            if (row.get(i).plantName == "carrot") {
                if (row.get(i).needsWater) {
                    numCarrotPlants += row.get(i).numberOfPlants;
                }
                if (numCarrotPlants > numTomatoPlants && numCarrotPlants > numTulipPlants && numCarrotPlants > numLettucePlants && numCarrotPlants > numEmptyPlants) {
                    typeMostPlants = row.get(i).plantName;
                }
            }
            else if (row.get(i).plantName == "tulip") {
                if (row.get(i).needsWater) {
                    numTulipPlants += row.get(i).numberOfPlants;
                }
                if (numTulipPlants > numTomatoPlants && numTulipPlants > numCarrotPlants && numTulipPlants > numLettucePlants && numTulipPlants > numEmptyPlants) {
                    typeMostPlants = row.get(i).plantName;
                }
            }
            else if (row.get(i).plantName == "tomato") {
                if (row.get(i).needsWater) {
                    numTomatoPlants += row.get(i).numberOfPlants;
                }
                if (numTomatoPlants > numCarrotPlants && numTomatoPlants > numTulipPlants && numTomatoPlants > numLettucePlants && numTomatoPlants > numEmptyPlants) {
                    typeMostPlants = row.get(i).plantName;
                }
            }
            else if (row.get(i).plantName == "lettuce") {
                if (row.get(i).needsWater) {
                    numLettucePlants += row.get(i).numberOfPlants;
                }
                if (numLettucePlants > numTomatoPlants && numLettucePlants > numTulipPlants && numLettucePlants > numCarrotPlants && numLettucePlants > numEmptyPlants) {
                    typeMostPlants = row.get(i).plantName;
                }
            }
        }
/*        System.out.println(numTomatoPlants);
        System.out.println(numCarrotPlants);
        System.out.println(numTulipPlants);
        System.out.println(numLettucePlants);*/
        System.out.println("The plant type with the most plants which need water is " + typeMostPlants);
    }

}//class MyFarm
