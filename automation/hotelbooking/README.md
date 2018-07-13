# Hotel Booking Web Application Tests

These are tests to verify the Hotel Booking Form, for this purpose these tests use TestNG testing framework. Please follow the steps below to build and run the tests.

### How to Build:

* Clone this project
* Launch eclipse and open hotelbooking-tests project in eclipse.
* Install TestNG plugin from eclipse marketeplace.
* Wait for the dependencies to be downloaded
* Build the project

### How to Run:
* Before running the tests, download the copy of the geckodriver and chromdriver to one of the environment variable paths e.g. /usr/local/bin
* From Package Explorer, expand config folder, right click on TestNG_Custom_Config.xml file and select **Run As => TestNG Suite** option
* Wait for the test execution to finish
* Test Results can be seen on "Results of running suite" tab within eclipse or in test_output directory which can be found alongside in project folder.
* By default it will try to run for both Firefox and Chrome browsers.
