# PaybackTest


This is a gradle Appium Project, based on BDD using Gherkin(Cucumber). This project is used for testing android applications. It demonstrates payback - coupon activation scenario case here. 

Scenario : User is in logged in state. He searches for Specific partners(Rewe/Aral)coupons using the filter and activates one of the coupons from the list.

<b><h3>Pre- Requisites :</h3></b>

1. Appium Server is required. That can be achieved in 2 ways
    <br/>	a. Appium installation via NodeJS -> npm install -g appium -> start appium
	<br/>    b. Appium Server GUI
    
2. Android SDK tools and its platform tools are installed and Environment path need to be set for the same. 
2. Java 8 and gradle(6.1) build tool is used, for which JAVA_HOME and GRADLE_HOME are to be set.
3. The project uses appium-client 8.0.0 Version.
4. The following settings are required in mobile, if testing directly
<br/>	a. Developer option enabled
<br/>	b. USB debugging enabled
<br/>	c. Install app over USB on - the server installs Appium settings app while connecting for the first time. 
<br/>	d. USB debugging security settings permission enabled. - This overrides WRITE_SECURE_SETTINGS permission while connecting
<br/>	e. APK info or similar app might be required to find appPackage and appActivity capabilities. Use activities with name main activity or default activity from the list.
5. Appium Inspector or UiAutomator (from android SDK tools) are used for inspecting elements


<b><h3>Project Structure Explanation :</h3></b>

1. Test Scripts are written under src/test
2. This Project is run using CucumberRunner over Junit, where everything is glued together.
3. Feature file is under src/test/resources which explains the business flow of the scenario.
4. The corresponding steps to the feature are defined under steps package
5. Hooks are used for executing pre-and post requisites. It is placed inside steps package.
6. Screen package holds locators of required elements for each screen. This is based on Page object Model Structure for easy maintenance. 
8. Logging is done using apache log4j.
9. The capabilities are mentioned as property file under resources.
10. Cucumber reports are generated under reports folder. They are also published over the specified URL after every run.


<b><h3>Assumptions :</b></h3>

1. The app works directly on the android instrument connected either through WIFI or data cable. If working on the emulator, the emulator details are specified in the capabilities for "app".

2. The Scenario works only on the logged in user session, as the inspect tools could not identify the initial login elements due to security settings.
 
3. The test run is done only on android based devices.

4. The test runs twice, each for Rewe and Aral,as specified in the feature file.

5. As per the official PAYBACK app, it is assumed that the preferred partners list and its order provided in the filter is fixed. So the search is based on its index(PreferredParners Enum).

5. Modified inspector specified absolute paths to Relative xpaths and resource-id based xpaths whereever possible for better stability.

