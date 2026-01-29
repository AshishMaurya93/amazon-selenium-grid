# Amazon Selenium Grid Automation

This project demonstrates automated testing using **Selenium WebDriver** executed on **multiple browsers** with **Selenium Grid (Docker)** and triggered through **Jenkins CI**.

---

## Tools & Technologies
- Java  
- Selenium WebDriver  
- TestNG  
- Maven  
- Docker (Selenium Grid)  
- Git & GitHub  
- Jenkins  

---

## Test Scenario
- Launch Amazon website
- Validate application accessibility
- Execute tests in parallel on:
  - Chrome
  - Firefox
  - Microsoft Edge

---

## Selenium Grid Setup
Start Selenium Grid using Docker:

```bash
docker-compose up -d


Grid UI:

http://localhost:4444/ui

Running the Tests
mvn clean test
Jenkins Integration
Source code pulled from GitHub

Maven used for build and execution

Test results displayed in Jenkins console

Key Highlights
Cross-browser testing

Parallel execution using TestNG

Docker-based Selenium Grid

Continuous Integration using Jenkins

Author
Ashish Maurya