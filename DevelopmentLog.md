# Se-2226 Project Development Log

This document tracks all progress and test development activities related to the Udemy Web App Testing project.

---

## 01.06.2025 — Initial Test Planning

- Defined equivalence classes for search functionality:
    - E1: Valid common keyword
    - E2: Valid multi-word keyword
    - U1–U5: Invalid or edge-case keywords (empty, symbols, too short, etc.)
- Created constants for test inputs
- Created `DiscUdemyTestBot` with basic Selenium automation flow
- Chose `JUnit 5` + `@Test` structure for isolated test methods
- Defined `Automation_Tests.TC_EP_S1` as test class name

---

## 02.06.2025— Search Bot Development & Test Structuring

### Refactored `DiscUdemyTestBot`
- Improved and stabilized the Selenium-based bot to work reliably with `https://www.discudemy.com`.
- Ensured the bot handles connection, search input, course title extraction, and browser teardown.
- Verified that bot performs `connect → search → store → quit` in one call through `searchByKeyword()`.

### Discussed and Finalized Test Strategy
- Decided to write **one `@Test` method per equivalence class case** for clarity.
- Agreed to use named constants like `VALID_KEYWORD_1`, `INVALID_KEYWORD_SPECIAL`, etc. for all inputs.
- Ensured clean, readable method names and descriptive `@DisplayName` annotations.

### Implemented `Automation_Tests.TC_EP_S1`
- Created a full-featured JUnit test class that covers:
    - E1: Valid common keyword (`"python"`)
    - E2: Valid multi-word keyword (`"web development"`)
    - U1: Empty keyword
    - U2: Special characters
    - U3: Too short input
    - U4: Excessively long input
    - U5: Spammy keyword
- Each test method:
    - Uses `DiscUdemyTestBot`
    - Contains a `for` loop to validate course titles
    - Includes a comment explaining:  
      `// Test fails if keyword is not in returned result`
- Bot is instantiated in `@BeforeEach` to ensure test isolation.
- Final class name: `Automation_Tests.TC_EP_S1`.





---

## Next Test Targets

These test cases are next in the queue (assigned to Demir):

| Test ID           | Feature         | Description                                                  | Technique              |
|-------------------|------------------|--------------------------------------------------------------|------------------------|
| **TC-WL-01**       | Favorites         | Add course to favorites from course card                     | Use Case Testing       |
| **TC-EP-TITLE2**   | Course Title      | Reject titles with forbidden characters (!@#$%)              | Equivalence Partitioning |
| **TC-DT-SR1**      | Search            | Filter + keyword combinations (e.g., Free + Turkish + "x")   | Decision Table         |
| **TC-EP-DUR1**     | Video Duration    | Selecting duration returns matching courses                  | Equivalence Partitioning |
| **TC-BVA-TITLE1**  | Course Title      | Title with exactly 100 characters is accepted                | Boundary Value Analysis |

---

**Tools Used**:
- Java 23
- Selenium WebDriver 4.29.0
- JUnit 5
- ChromeDriver
- IntelliJ IDEA Ultimate
- DiscUdemy Web Platform

