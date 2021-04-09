package APIs;

import helper.Endpoints;
import helper.WebServiceHelper;
import io.restassured.response.Response;

import java.util.ArrayList;

/**
 * Responsible for the business logic in Drs APIs
 */
public class DoctorsApis {


    WebServiceHelper webServiceHelper;

    public DoctorsApis()
    {
        webServiceHelper = new WebServiceHelper();
    }

    //Receive the response of the get request for DrAPI
    public Response callDrAPI()
    {
        return webServiceHelper.execute(Endpoints.getDoctorsEndpoint(), WebServiceHelper.HttpMethod.GET);
    }

    //Receive the response of the get request for DrSubAPI
    public Response callDrSubsequentAPI(String lastKey)
    {
        return webServiceHelper.execute(Endpoints.getSubsequentDoctorsEndpoint(lastKey), WebServiceHelper.HttpMethod.GET);
    }

    //Extract the lastkey from response of DrAPI
    public String getLastKey(Response doctorsResponse)
    {
        return doctorsResponse.then().extract().path("lastKey");
    }

    //Extract the name from the reponse of DrAPI
    public ArrayList<String> getDrsNamesList(Response doctorsResponse)
    {
        return doctorsResponse.then().extract().path("doctors.name");
    }

    //Compare the names in list one to names in list two and save the duplicates in a new list
    public ArrayList<String> getDrDuplicates(ArrayList<String> drsNamesList, ArrayList<String> subDrsNamesList)
    {
        ArrayList<String> duplicates =  new ArrayList<>();
        for (String name : drsNamesList)
        {
            if (subDrsNamesList.contains(name))
                duplicates.add(name);
        }
        return duplicates;
    }

}
