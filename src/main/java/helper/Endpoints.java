package helper;

/**
 * Endpoints is responsible for retrieving endpoints
 */
public class Endpoints {

    public static String DOCTORS_ENDPOINT
            = System.getProperty("target.endpoint") + "/interviews/challenges/android/doctors";

    //The endpoint of the SubDrAPIs
    public static String getSubsequentDoctorsEndpoint(String lastKey) {
        return DOCTORS_ENDPOINT+"-"+lastKey+".json";
    }

    //The endpoint of the DrAPIs
    public static String getDoctorsEndpoint() {
        return DOCTORS_ENDPOINT+".json";
    }

}
