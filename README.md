# Hotel Booking Web Application Tests

These are tests to verify the Hotel Booking Form, for this purpose these tests use TestNG testing framework. Please follow the steps below to build and run the tests.

Also note that for sake of this exercise, eclipse default Java project is used to build and Run the tests but ideally this should be done using either Maven or Gradle.

### How to Build:
* Clone this project
* Launch eclipse and install TestNG plugin from > Help > Eclipse Marketplace
* Import Project as > File => Import => General => Projects From Folder or Archive
* Select the directory where project is cloned and select the project folder and click finish
* Once the sources are imported to the Package Explorer, right click on the project and go to properties option
* Under Java Build Path => Classpath, Add the Selenium and TestNG dependencies and close the dialog box.
* Now Build the project

### How to Run:
* Before running the tests, download the copy of the geckodriver and chromdriver to one of the environment variable paths e.g. /usr/local/bin

* From Package Explorer, expand config folder, right click on TestNG_Custom_Config.xml file and select * Run As => TestNG Suite * option
* Wait for the test execution to finish
* Test Results can be seen on "Results of running suite" tab within eclipse or test_output directory can be found alongside of project folder.
* By default it will try to run for Firefox and Chrome browsers.


