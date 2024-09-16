# Project Structure
## Dependencies
The project relies on several key dependencies specified in the pom.xml file:

```xml
<dependencies>
   <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.24.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
    <scope>test</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/com.github.javafaker/javafaker -->
<dependency>
    <groupId>com.github.javafaker</groupId>
    <artifactId>javafaker</artifactId>
    <version>1.0.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.2</version>
</dependency>
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.16.1</version>
</dependency>
```



## Package drivers Overview

The `drivers` package contains primary classes which are `BaseDriver` and `PageDriver`.

## Classes

### `BaseDriver`

The `BaseDriver` class manages the initialization and teardown of the WebDriver instance used for browser automation. It includes the following features:

- **Base URL**: Defines a base URL for the test environment.
  
- **Driver Initialization (`setDriver`)**: 
  - Initializes the appropriate WebDriver (Chrome, Firefox, or Edge) based on the specified browser type.
  - Sets the initialized WebDriver instance in the `PageDriver` class for centralized management.

- **Screenshot Capture (`getScreenshot`)**:
  - Captures a screenshot during test execution.
  - Saves the screenshot to a specified directory under the project’s root directory with a filename based on the test case name.

- **Driver Teardown (`tearDown`)**:
  - Ensures that the WebDriver instance is properly closed after all tests have completed.

### `PageDriver`

The `PageDriver` class is a singleton design pattern implementation used to manage WebDriver instances in a thread-safe manner. It includes:

- **ThreadLocal WebDriver**: 
  - Utilizes `ThreadLocal` to store and manage WebDriver instances in a thread-safe way, ensuring that each thread has its own instance of WebDriver.

- **Singleton Instance**:
  - Ensures that only one instance of `PageDriver` exists at any time.

- **Driver Management**:
  - Provides methods to set and get the WebDriver instance associated with the current thread.

## How `BaseDriver` Uses `PageDriver`

- **Setting the Driver**:
  - In the `setDriver` method, `BaseDriver` initializes the WebDriver instance based on the specified browser type and sets this instance in `PageDriver` using `PageDriver.getInstance().setDriver(driver)`.

- **Getting the Current Driver**:
  - For actions such as taking screenshots, `BaseDriver` retrieves the current WebDriver instance via `PageDriver.getCurrentDriver()`, ensuring that it interacts with the WebDriver instance correctly.




## Package pages Overview


### `P002_SignUpNavigationPage`

- **Purpose**: Manages navigation to the signup page.
- **Elements**:
  - `loginPageButton`: Button to navigate to the login page.
  - `signUpPageButton`: Button to navigate to the signup page.
- **Methods**:
  - `navigateToLoginPage()`: Clicks the button to navigate to the login page.
  - `navigateToSignUpPage()`: Clicks the button to navigate to the signup page.

### `P003_CreateAccountPage`

- **Purpose**: Represents the create account page where users can sign up.
- **Elements**:
  - `firstNameInput`, `lastNameInput`, `emailInput`, `phoneInput`, `passwordInput`, `confirmPasswordInput`: Form fields for user details.
  - `passwordEyeIcon`, `confirmPasswordEyeIcon`: Icons to toggle password visibility.
  - `registerButton`: Button to submit the registration form.
  - `emailExistMessage`: Message displayed when the email already exists.
- **Methods**:
  - `fillCreateAccountForm()`: Fills out the registration form and submits it.
  - `getEmailExistMessage()`: Retrieves the email existence message.

### `P004_CreateAccountSuccessPage`

- **Purpose**: Represents the page shown after a successful account creation.
- **Elements**:
  - `continueShoppingButton`: Button to continue shopping after account creation.
- **Methods**:
  - `clickContinueShopping()`: Clicks the continue shopping button.

### `P005_HoverCategoriesPage` 

#### Purpose

Represents the page where various product categories are accessible via hover interactions.

#### Elements

- **`allCategoriesButton`**: Button to reveal all categories.
- **`subMenuOption`**: Sub-menu option under a category.
- **`subSelectMenuOption`**: Secondary sub-menu option under a category.
- **`selectMenuOption`**: Final menu option to select a specific product category.

#### Methods

- **`hoverOverAllCategories()`**: Hovers over the "All Categories" button to reveal the category menu.
- **`hoverOverSubMenu()`**: Hovers over a sub-menu option to reveal additional options.
- **`hoverOverSubSelectMenu()`**: Hovers over a secondary sub-menu option.
- **`selectMenu()`**: Selects a specific menu option from the revealed options.

### `P006_SelectProductPage`

#### Purpose

Represents the page where products are listed and can be selected for further actions.

#### Elements

- **`ratingElement`**: Element representing product ratings.
- **`addToCartButton`**: Button to add the selected product to the cart.

#### Methods

- **`selectRating()`**: Scrolls to and selects a product rating.
- **`selectProduct()`**: Scrolls to and adds a product to the cart.

### `P007_AddProductToCartPage`

#### Purpose

Handles interactions related to adding products to the shopping cart.

#### Elements

- **`productSize`**: Element representing the size of the product.
- **`addToCartButton`**: Button to add the selected product to the cart.
- **`goToCartButton`**: Button to navigate to the cart.

#### Methods

- **`addProductToCart()`**: Selects a product size, adds the product to the cart, and navigates to the cart.

### `P008_CheckoutProductPage`

#### Purpose

Represents the checkout page where users provide their details and confirm their purchase.

#### Elements

- **`checkoutButton`**: Button to proceed to checkout.
- **`firstNameField`**: Input field for the user's first name.
- **`lastNameField`**: Input field for the user's last name.
- **`emailField`**: Input field for the user's email address.
- **`districtDropdown`**: Dropdown menu for selecting a district.
- **`addressField`**: Input field for the user's address.
- **`phoneNumberField`**: Input field for the user's phone number.
- **`paymentMethod`**: Radio button for selecting the payment method.
- **`confirmPaymentButton`**: Button to confirm payment.

#### Methods

- **`checkoutProduct()`**: Completes the checkout process by filling in the user details, selecting a payment method, and confirming the payment.

### `P009_OrderConfirmationPage`

- **Purpose**: Represents the order confirmation page shown after completing a purchase.
- **Elements**:
  - `confirmMessage`: Message confirming the order.
  - `orderDetailsPageLink`: Link to view order details.
  - `ordersList`: List of orders.
  - `hoverlogOutOption`, `accountLogout`: Elements for logging out of the account.
- **Methods**:
  - `getConfirmationMessage()`: Retrieves the confirmation message.
  - `clickOrderDetailsPageLink()`: Clicks the link to view order details.
  - `clickOrderList()`: Clicks to view the list of orders.
  - `logout()`: Logs out of the account.


## Package tests Overview

## Test Classes

### `TC000_SubmitOrderTest`

- **Purpose**: Tests the end-to-end process of creating an account, adding products to the cart, checking out, and verifying the order confirmation.
- **Test Steps**:
  1. Navigate to the login page and then to the signup page.
  2. Fill out and submit the account creation form.
  3. Continue shopping after account creation.
  4. Add products to the cart by hovering over all categories.
  5. Select rating and filter out the specific product.
  5. Complete the checkout process.
  6. Verify the order confirmation message.
  7. View order details and log out.



## Package utilities Overview

### `CommonMethods`

- **Purpose**: Contains common methods used across different page classes, such as waiting for elements, sending text, clicking elements, etc.
- **Methods**:
  - `waitUntilElementVisible()`: Waits until an element is visible.
  - `sendText()`: Sends text to an input field.
  - `hoverClickElement()`: Hovers over an element and then clicks it.
  - `hoverElement()`: Hovers over an element.
  - `scrollToElement()`: Scrolls the window to make an element visible.
  - `scrollTheWindow()`: Scrolls the window horizontally and vertically.
  - `timeOut()`: Waits for a specified amount of time.

Each page class is initialized using `PageFactory.initElements()`, and `PageDriver.getCurrentDriver()` provides the WebDriver instance to interact with the page elements.



### `Listeners`

### Dependencies

- **ExtentReports**: Provides advanced reporting capabilities.
- **TestNG**: The test framework used for managing and running test cases.

### Key Components

- **ExtentTest**: Represents an individual test in the ExtentReports.
- **ExtentReports**: Manages the creation and generation of the overall test report.
- **ThreadLocal<ExtentTest>**: Ensures that each thread gets its own `ExtentTest` instance, useful in parallel test execution.

### Methods Implemented from `ITestListener`

#### `onTestStart(ITestResult result)`

- **Purpose**: Called before a test method is invoked.
- **Functionality**:
  - Creates a new test entry in the ExtentReports for the currently running test method.
  - Initializes the `ExtentTest` instance and sets it in `ThreadLocal` to ensure thread-safety.

```java
@Override
public void onTestStart(ITestResult result) 
{
    test = extent.createTest(result.getMethod().getMethodName());
    extentTest.set(test);
}
```

#### `onTestSuccess(ITestResult result)`

- **Purpose**: Called when a test method passes.
- **Functionality**:
  - Logs a success message to the ExtentReports indicating that the test has passed.

```java
@Override
public void onTestSuccess(ITestResult result) 
{
    extentTest.get().log(Status.PASS, "Test Passed");
}
```

#### `onTestFailure(ITestResult result)`

- **Purpose**: Called when a test method fails.
- **Functionality**:
  - Logs the failure and exception details to the ExtentReports.
  - Captures a screenshot of the current state of the application.
  - Attaches the screenshot to the report for further analysis.

```java
@Override
public void onTestFailure(ITestResult result) 
{
    extentTest.get().fail(result.getThrowable());
    
    try 
    {
        driver = PageDriver.getCurrentDriver();
    } 
    catch (Exception e1) 
    {
        e1.printStackTrace();
    }

    // Attach Screenshot to the Report
    String filePath = null;
    
    try 
    {
        filePath = getScreenshot(result.getMethod().getMethodName(), PageDriver.getCurrentDriver());
    } 
    catch (IOException e) 
    {
        e.printStackTrace();
    }
    
    test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
}
```

#### `onFinish(ITestContext context)`

- **Purpose**: Called after all test methods have been executed.
- **Functionality**:
  - Finalizes and writes the ExtentReports to the output file, ensuring that all data is saved and properly formatted.

```java
@Override
public void onFinish(ITestContext context) 
{
    extent.flush();
}
```

### Additional Details

- **Screenshot Method (`getScreenshot`)**: Captures screenshots of the application state when a test fails and returns the file path for inclusion in the report.
- **ExtentFactoryReport**: A factory class used to initialize and provide the `ExtentReports` instance. Ensure this class is configured correctly for generating reports.

## Usage

1. **Initialization**: Ensure `ExtentFactoryReport.getReportObject()` initializes the `ExtentReports` instance.
2. **Add Listener**: Include the `Listeners` class in your TestNG configuration (`testng.xml` or annotations) to enable reporting.

```xml
<suite name="Suite" verbose="1">
    <listeners>
        <listener class-name="utilities.Listeners"/>
    </listeners>
    <test name="Test">
        <!-- Test classes here -->
    </test>
</suite>
```

# TestNG XML Configuration


## Key Components

### 1. `<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">`

- **Purpose**: Declares the DTD (Document Type Definition) for TestNG configuration files. It ensures the XML file adheres to the structure and syntax required by TestNG.

### 2. `<suite name="Suite">`

- **Purpose**: Defines a test suite. The `name` attribute is a user-defined label for the suite. This suite groups one or more tests together.

### 3. `<listeners>`

- **Purpose**: Contains listener classes that hook into the TestNG execution lifecycle. Listeners are used to perform actions at various stages of test execution, such as logging results, generating reports, and taking screenshots.

- **Configuration**: 
  ```xml
  <listener class-name="utilities.Listeners" />
  ```
  This line includes the `Listeners` class, which implements `ITestListener` to provide detailed reporting with ExtentReports.

### 4. `<test name="Test">`

- **Purpose**: Defines a test. Each test can contain one or more classes. The `name` attribute is a user-defined label for the test.

### 5. XML File for `TC000_SubmitOrderTest`

- **Purpose**: Contains a list of test classes that should be executed as part of the test. Each class should be specified with its fully qualified name.

- **Configuration**:
  ```xml
  <classes>
    <class name="tests.TC000_SubmitOrderTest" />
  </classes>
  ```
  This configuration specifies that the `TC000_SubmitOrderTest` class will be executed as part of this test suite.


