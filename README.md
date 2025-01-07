# OpenCart-Automation-Testing Project Report

## Project Overview

**Project Name:** OpenCart-Automation-Testing

**Project Description:**
The OpenCart is an e-commerce application, automated the application with hybrid framework designed to validate the core functionalities of the OpenCart platform. This project integrates various automation testing techniques to provide a comprehensive solution for ensuring software quality. Utilizing a Maven project structure for dependency management, the framework relies on several key libraries like Selenium for browser automation, Apache POI for Excel file manipulation, Log4j for logging, TestNG for test execution, and ExtentReports for detailed reporting.

## Project Structure

The project is organized into several key directories, each serving a specific purpose in the automation testing framework:

### Folder Structure:

1. **src/test/java**: 
   - This folder contains the main test automation code split into four packages:
     - **testcases**: Contains test case classes such as `TC001_RegistrationTest` and `TC001_LoginTest` that define the individual test scenarios.
     - **testBase**: Contains the `BaseClass` which provides the foundational setup for the test execution.
     - **pageObjects**: Includes classes such as `BasePage`, `HomePage`, `LoginPage`, `MyAccountPage`, and `RegistrationPage` implementing the Page Object Model for better maintainability and readability of test scripts.
     - **utilities**: Houses utility classes including `ExcelUtils` for Excel operations and `ExtentReportManager` for managing report generation.

2. **src/test/resources**:
   - **properties.config**: A properties file that contains essential configuration data, including the application URL, username, and password for testing.
   - **log4j2.xml**: Configuration file for Log4j, establishing the logging framework for capturing runtime logs.

3. **logs**:
   - A dedicated folder where logger information for every executed test suite is recorded, facilitating easy debugging and analysis of test execution flow.

4. **reports**:
   - This folder stores the result reports generated after each test suite run, providing insights into the execution status of the tests.

5. **testData**:
   - Contains an Excel file with different input data for the login functionality, enabling data-driven testing capabilities.

6. **testng.xml**:
   - An XML configuration file designed to manage and execute multiple tests in a structured manner, and properly configured within the Maven `pom.xml` for seamless integration.

7. **GitHub Repository**:
   - The entire project codebase is maintained in a GitHub repository, ensuring version control and collaborative development.

## Key Milestones

- **Project Setup & Initial Configuration**: Establishing the test environment and configuring necessary tools and libraries.
- **Framework Designing**: Structuring the hybrid framework and implementing best practices for automation.
- **Test Scripts Development**: Writing automated test scripts for OpenCart functionalities including user registration and login.
- **Properties & Configuration**: Managing application configurations and parameters for test execution through property files.
- **Report Generation & Logging**: Implementing detailed logging and report generation using ExtentReports for enhanced visibility of test results.

## Project Outcome

The OpenCart-Automation-Testing project successfully delivers a robust and scalable automation framework, designed specifically for testing OpenCart’s core functionalities. Key Outcomes include:

- **Enhanced Software Quality**: Through systematic and automated testing, the framework ensures that the application meets quality standards.
- **Increased Test Coverage**: Covering multiple scenarios through automated tests enhances overall coverage and reduces the risk of undetected issues.
- **Faster Feedback Loop**: Automated testing significantly reduces the time needed for validation, enabling quicker releases and faster time-to-market.
- **Reduced Manual Effort**: Automation minimizes the need for manual testing efforts while increasing test reliability and consistency.

By implementing a hybrid framework approach incorporating data-driven framework and testng detailed reporting capabilities, the project positioned as a powerful tool for enhancing the testing process and ensuring the continuous delivery of quality software. 

