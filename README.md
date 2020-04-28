# automationChallenge
Approach:
	- To ensure reusability of the script I tried to have every thing dynamic.
	- Configurations are added in a properties file.
	- Test data are saved in Json file.
	- Mobile automation using page object model.
	- RestAssured for APIs and used request and response specifications so it can be used and altered.
	- Only added the used methods and concepts enough for the task scope.
Tools/libraries:
	- Appium for mobile automation as it is open source and can be used for both platforms.
	- Selenium and TestNG for all the libraries included for automation.
	- RestAssured for APIs automation using java.
Execution:
	- Ensure that java, maven and appium are installed and added to the environment variables.
	- Clone the project and import it into your IDE.
	- Ensure all dependancies are added and imported in the POM xml.
	- Update the properties file and the test data file in the resources folder.
	- Run the mobile test or the API test from the test folder.
Assumptions:
	- The test is being conducted on a real device.
	- The objective of the task is to assess the skills and way of thinking.
	- The test is conducted on the same device to get over the private key step.
Notes:
	- PDF with the issues and comments is added
	- The PIN service was down and I didn’t receive sms so I couldn’t complete and validate scenario 2 but it was updated in the last commit.
	- Due to the issue I faced I used priority in mobile test execution to ensure scenario 1 will run first.
