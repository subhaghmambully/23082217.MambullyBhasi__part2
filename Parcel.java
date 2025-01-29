public class Parcel {
    private String parcelId;
    private int weight;
    private int length;
    private int width;
    private int height;
    private double distance;

    public Parcel(String parcelId, int weight, int length, int width, int height, double distance) {
        this.parcelId = parcelId;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.distance = distance;
    }

    
    public String getParcelId() {
        return parcelId;
    }


    public int getWeight() {
        return weight;
    }

   
    public double getDistance() {
        return distance;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

   
    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

   
    @Override
    public String toString() {
        return "Parcel ID: " + parcelId + ", Weight: " + weight + "kg, Distance: " + distance + "km";
    }
}
