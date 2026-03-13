🚀 Cucumber Test Automation Framework


📌 Project Description

The framework validates different login scenarios for the nopCommerce Admin Portal.

🔗 http://admin-demo.nopcommerce.com/login


🛠️ Tech Stack

☕ Java
🥒 Cucumber (BDD)
🌐 Selenium WebDriver
🧪 TestNG
📦 Maven
📝 Log4j2
🧪 Test Scenarios Covered


✅ Valid Login Scenario

User enters valid email and password

User clicks login

User is redirected to dashboard


❌ Invalid Login Scenario

User enters invalid credentials

Error message is displayed


⚠️ Empty Fields Validation

User tries to login without entering credentials

Validation messages are displayed


🧱 Framework Design Pattern

✅ Page Object Model (POM)

✅ BDD with Gherkin

✅ Reusable Step Definitions

✅ Configurable test properties

✅ Logging implementation with Log4j2


📊 Reporting

TestNG Reports

Cucumber HTML Reports

Console Logs with Log4j2

Reports are generated under:

/target/cucumber-reports

▶️ How to Run the Project

1️⃣ Clone Repository

git clone https://github.com/your-username/your-repo.git
2️⃣ Run with Maven

mvn clean test
3️⃣ Run Specific Runner

Run the TestNG runner class from your IDE.
📂 Project Structure

nopcommerce-login-automation
│
├── src/test/java
│   ├── stepDefinitions
│   ├── pageObjects
│   ├── runners
│
├── src/test/resources
│   ├── features
│   │   └── login.feature
│   ├── config.properties
│
├── pom.xml
└── README.md

👨‍💻 Author

Automation Project for practice and demonstration purposes.
