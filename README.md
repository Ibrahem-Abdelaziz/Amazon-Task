# Amazon Automation Testing

## ⚙️ Installation

### 1. Clone the repository

git clone https://github.com/Ibrahem-Abdelaziz/Amazon-Task.git


### 2. Install dependencies
Ensure **Java JDK 25** and **Maven** are installed and configured on your system.

Dependencies used (from [Maven Repository](https://mvnrepository.com/)):
- Selenium Java  
- TestNG  
- WebDriverManager  

Example "pom.xml":
```xml
 <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.35.0</version> <!-- latest stable release as of Aug 12 2025 :contentReference[oaicite:0]
        </dependency>

        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-testng</artifactId>
            <version>2.29.1</version> <!-- latest clearly published version :contentReference[oaicite:1]{index=
        </dependency>

        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.11.0</version> <!-- latest published version :contentReference[oaicite:2]{index=2} -->
            <scope>test</scope>
        </dependency>
    </dependencies>

### 3. Run the tests
Run from terminal:
```bash
mvn clean test
```
or from your IDE using the `testng.xml` file.

---

## 🧪 Test Scenarios

### Scenario 1 — Search and Add to Cart
1. Open [https://www.amazon.com/](https://www.amazon.com/)
2. Search for **"car accessories"**
3. Select the **first item** from the results.
4. Add the item to the **cart**.
5. Go to the **cart** and verify the item was added successfully.

### Scenario 2 — Today’s Deals
1. Open **Today’s Deals**.
2. From filters on the left:
   - Select **Headphones** and **Grocery**.
   - Under Discounts, select **10% off or more**.
3. Navigate to the **4th page**.
4. Select any item and **add it to the cart**.

---

## 🧱 Project Structure

```
Amazon-Task/
│
├── pom.xml
├── testng.xml
├── Screenshots/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/
│   │           ├── HomePage.java
│   │           ├── SearchResultsPage.java
│   │           ├── ProductPage.java
│   │           ├── CartPage.java
│   │           └── PageBase.java
│   │           └── TodayDealsPage.java
│   │
│   └── test/
│   │   └── java/
│   │       └── tests/
│   │            └── AddToCartTest.java
│   │            └── TestBase.java
│   │            └── TodayDealsTest.java
│   └── utlilites/
│       └── Helper.java
└── README.md


**Framework Design:**  
- Page Object Model (POM)  
- TestNG Framework  
- Maven for build management  
- WebDriverManager for driver setup  
---

## 🧠 Skills Demonstrated
- Java (JDK 25)  
- Selenium WebDriver  
- TestNG  
- Maven  
- POM design  
---

## 👤 Author
**Ibrahem Abdelaziz**  
Software QA Engineer – EFG Holding  
📧 Ibrahemabdelaziz1298@gmail.com 
📞 01110281303
