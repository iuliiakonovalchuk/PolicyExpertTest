#PolicyExpect - Automation framework

## Quick setup
- Java 8 ([Install docs](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html))
- Install IDE (e.g. Intelij Idea)
- Clone the repo
- Install dependencies `mvn compile`

## How to run tests
Run the following command in terminal:
```
mvn test
```

## Framework overview

The tech stack used:
- Java language (functional style)
- Maven, TestNg, Junit, Jackson library, Selenium

This framework was created to test pages with a lot of field/selects elements and the next logic depends on the information filled by user before.
The following design patterns used to build it:
- **Chain of Responsibility**. It helps to avoid coupling the input data to logic of setting data. 
It allows to change only input data with no modification of code.
It uses Java Functional Interfaces (UnaryOperator and Function).
- **Page Fragments**. It allows to represent the part of page as fragment (called widget), to store there information separate to widgets. So the class will contains the information of specific section and not the whole page.
- **Page Object**. Since only one page was tested, it was not fully implemented, but when it is time to proceed to the next page, BasePage class should contains methods to cope with page similarities.

## Framework structure
**src** <br />
-**main** <br />
--**configs**: add there general properties, e.g. screen resolutions, base url etc <br />
-**test** <br />
--java.com.policyexport.home <br />
---**base**: contains abstract base classes. Contains general methods <br />
---**dto**: contains data transfer object, i.e. representation of json object <br />
---**pages**.enquirydetails: Contains classes which represents Pages in Enquire section (e.g. Details, Quotes, Extras etc) <br />
----**fragments**: Contains fragments (widgets, sub-pages, pop-ups) which are part of page <br />
---**tests**: Contains tests <br />
---**utils**: Contains support classes e.g. save the page states and parse/read test data from json object <br />
-**resources**: Contains jsons with test data <br />

## How to add new tests
Currently, this framework covers only sub-forms of Details page (About you, Statements about you, About your property, Statements about your property).

Follow the next steps to add the next sub-form "About safety and security":
- Expand the existing json in the **resource** folder:
    - in short flow select values to cover the short flow (no expanded questions)
    - in expanded flow select values so that the most branches are covered
 
- Add representation of new json section as java classes (using Jackson library):
    - add a new class in dto, describe there all fields
    - add references to the new class into TestDataDto
    - in utils/TestData.java add methods to get the value inside the subnode easier (optionally)
 
- Add page states:
    - add variables into utils/PageStatesBucket.java
    - add variable to save page states in to utils/TestData.java
 
- Add new class into fragments package
    - specify there selectors for input and select elements
    - specify there part of the label text next to toggle (it will be used in xpath builder)
    - add custom methods if needed
    
- Add flow to fill all inputs in this section in EnquiryDetailsPage
    - It returns function UnaryOperator<TestData> so it can be used in test flow DetailsPageTest    


## Next steps
So far, not all fields were covered in the Details sections. So that's why no assertions in the text. Once all section filled, it should use TestNG assert function to check the next page opened or in case of negative test, error messages are shown.

The next steps to improve the framework may include:
- Add BDD tests (Gherkin language). Cucumber, Serenity libraries have already been added as a maven dependency.
In the feature files, it will use the high level of application flow, and all edge cases to the Details page should be covered in the existing test flows.
To avoid specifying the test data in features files, it should used json (can be names as feature name to use the specific json) as input parameter.

- Further refactoring where it is needed, e.g. move widget level methods into BaseWidget class to re-use as much as possible
- Include reporting (can be done after implementing Cucumber tests)
- Add Jenkinsfile (or another CI file to manage CI/CD process)

