
interface BuildingFeatures {
    void setDimension(float length, float breadth);
    void setColor(String color);
    void setLocation(String location);
    void displayBuildingProperties();
}

interface WelcomeGreeting {
    void greet();
}

class Building implements BuildingFeatures {

    String color;
    String location;
    Float area;
    boolean isStoryBuilding = false;

    class StoreyBuilding {

        int storeys;

        StoreyBuilding(int storeys) {
            if (storeys <= 1) throw new Error("Storey building must have a minimum of 2 floor levels");
            this.storeys = storeys;
            Building.this.isStoryBuilding = true;
        }

        void displayBuildingProperties() {
            System.out.println("The buiding properties:");
            System.out.println("Color:" + Building.this.color);
            System.out.println("Area:" + Building.this.area);
            System.out.println("Location:" + Building.this.location);
            System.out.println("Levels:" + this.storeys);
        }

    }

    public void setDimension (float l, float b) {
        this.area = l * b;
    }

    public void setColor (String color) {
        this.color = color;
    }

    public void setLocation (String location) {
        this.location = location;
    }

    public void displayBuildingProperties() {

        System.out.println("The buiding properties:");
        System.out.println("Color: " + this.color);
        System.out.println("Area: " + this.area);
        System.out.println("Location: " + this.location);
        System.out.println("Storey Building: " + Building.this.isStoryBuilding);
    }

}

public class Main {
    public static void main(String[] args) {
        
        WelcomeGreeting greeting = new WelcomeGreeting() {
            @Override
            public void greet() {
                System.out.println("Hi, Welcome");
            }
        };

        greeting.greet();
        //create an instance of building
        Building house = new Building();

        Building.StoreyBuilding storeyBuilding = house.new StoreyBuilding(100);
        house.setColor("orangered");
        house.setDimension(100, 50);
        house.setLocation("Ikeja, Lagos");

        storeyBuilding.displayBuildingProperties();

    }
}