# API tests

The project contains API test example for https://developer.mercedes-benz.com/products/vehicle_status/specifications/vehicle_status_api
Tests are based on Java + Gradle + RestAssured + Allure reports.

# Setup
1. Open the project in IDE
2. Install Gradle https://gradle.org/install/
3. Open build.gradle and reload all Gradle project
4. Download Allure framework https://github.com/allure-framework/allure2/releases and put it into the project directory or add its path to Path variable

# Test run
1. Be sure that folders /allure-results, /allure-report are empty for each build
2. Run tests by running console command 'gradlew clean test'.
After tests are completed folder /allure-results is generated with run results.
3. Generate Allure report by running console command 'allure generate allure-results --clean -o allure-report'.
A generated report is saved in /allure-report folder.
4. To open Allure report run console command 'allure serve allure-results'

You can also run tests in IDE by clicking on green run button near each test method or test class.