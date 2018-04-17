import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.TravelMode;

import java.io.IOException;

public class MapsTest {

    private static final String API_KEY = "AIzaSyCWr_YG4zNfwED_ND9ykhtBfNWx9yRbZ-U ";

    private static final GeoApiContext context =  new GeoApiContext.Builder().apiKey(API_KEY).build();

    public static void main(String[] args){
        DistanceMatrixApiRequest rq = new DistanceMatrixApiRequest(context);
        DistanceMatrix matrix = null;

        try {
            matrix = rq.origins("mosbach")
                    .destinations("würzburg")
                    .mode(TravelMode.DRIVING)
                    .avoid(DirectionsApi.RouteRestriction.FERRIES)
                    .language("en-EN")
                    .await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(matrix.rows[0].elements[0].distance.inMeters);
    }

}
