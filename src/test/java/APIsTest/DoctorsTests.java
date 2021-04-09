package APIsTest;

import APIs.DoctorsApis;
import Base.BaseServiceTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class DoctorsTests extends BaseServiceTest {

    DoctorsApis doctorsApis;
    @BeforeClass
    public void Init()
    {
        doctorsApis= new DoctorsApis();
    }
    @Test
    public void CompareDrNamesWithSubsequentDrNames()
    {
        ArrayList<String> subDrsNamesList,drsNamesList;
        String lastKey;

        Response response =doctorsApis.callDrAPI();
        response.then().spec(responseSpec);

        drsNamesList = doctorsApis.getDrsNamesList(response);

        //System.out.println(drsNamesList);
        lastKey= doctorsApis.getLastKey(response);

        response= doctorsApis.callDrSubsequentAPI(lastKey);


        response.then().spec(responseSpec);
        subDrsNamesList = doctorsApis.getDrsNamesList(response);
        //System.out.println(subDrsNamesList);


        Assert.assertEquals(doctorsApis.getDrDuplicates(drsNamesList,subDrsNamesList).size(),0,
                "number of duplicate names is "+doctorsApis.getDrDuplicates(drsNamesList,subDrsNamesList).size());



    }
}
