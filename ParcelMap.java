import java.util.HashMap;
import java.util.Map;

public class ParcelMap {
    private Map<String, Parcel> parcelMap;

    public ParcelMap() {
        parcelMap = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcelMap.put(parcel.getParcelId(), parcel);
        Log.getInstance().logEvent("Parcel added: " + parcel.getParcelId());
    }

    public Parcel getParcel(String parcelId) {
        return parcelMap.get(parcelId);
    }

    
}
