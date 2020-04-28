# automationChallenge
**Approach:**<br/>
	- To ensure reusability of the script I tried to have every thing dynamic.<br/>
	- Configurations are added in a properties file.<br/>
	- Test data are saved in Json file.<br/>
	- Mobile automation using page object model.<br/>
	- RestAssured for APIs and used request and response specifications so it can be used and altered.<br/>
	- Only added the used methods and concepts enough for the task scope.<br/>
**Tools/libraries:**<br/>
	- Appium for mobile automation as it is open source and can be used for both platforms.<br/>
	- Selenium and TestNG for all the libraries included for automation.<br/>
	- RestAssured for APIs automation using java.<br/>
**Execution:**<br/>
	- Ensure that java, maven and appium are installed and added to the environment variables.<br/>
	- Clone the project and import it into your IDE.<br/>
	- Ensure all dependancies are added and imported in the POM xml.<br/>
	- Update the properties file and the test data file in the resources folder.<br/>
	- Run the mobile test or the API test from the test folder.<br/>
**Assumptions:**<br/>
	- The test is being conducted on a real device.<br/>
	- The objective of the task is to assess the skills and way of thinking.<br/>
	- The test is conducted on the same device to get over the private key step.<br/>
**Notes:**<br/>
	- PDF with the issues and comments is added<br/>
	- The PIN service was down and I didn’t receive sms so I couldn’t complete and validate scenario 2 but it was updated in the last commit.<br/>
	- Due to the issue I faced I used priority in mobile test execution to ensure scenario 1 will run first.<br/>
