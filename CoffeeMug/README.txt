To run these automated tests yoy will need to have installed:
1. The latest version of Intellij;
2. Java
3. Maven
4. Chrome v90 (see below)

To run them:
1. download the project from git
2. Open the project in Intellij
3. Navigate to:
CoffeeMug -> src -> test -> java

4. The following are test scenario files that have tests in them that can be run:
* AgefieldTest
* EmailFieldTest
* NameFieldTests
* SubmitButtonTests
* SurnameFieldTests

5. To run tests: click the green cricle with a small trangle on the line counter and choose "Run" option. To run all test cases within a scenario, press the green circle next to the class name in a given file. To run specific tests, do the same with a green arrow and circle next to a particular method.

If you are using a varsion of Chrome other than v.90:
1. Go here: https://chromedriver.chromium.org/downloads and download version that supports the chrome version you use;
2. Extract the .exe file and rehname it to chromedriver;
3. Go to project folder you downloaded from git and go to CoffeeMug\src\main\resources
4. Replace the chromedriver file present there with the new one;



