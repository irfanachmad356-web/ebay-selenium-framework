# Ebay Automation Framework (Private Repository)

This repository contains a fully functional **Selenium Test Automation Framework** using:
- Java 17  
- Maven  
- TestNG  
- Selenium WebDriver  
- ExtentReports  
- Page Object Model (POM)

This documentation explains **how to run the project smoothly from scratch**, even for first-time users.

---

# ✅ 1. Prerequisites

Pastikan laptop sudah terinstall:

### **✔ Java 17**
Cek versi:
```bash
java -version
```
Jika belum terinstall → download di:  
https://adoptium.net/

---

### **✔ Maven**
Cek versi:
```bash
mvn -version
```
Jika belum ada → install dari:  
https://maven.apache.org/download.cgi

---

### **✔ IDE (Eclipse / IntelliJ)**
Disarankan:
- Eclipse for Java Developers  
- IntelliJ Community Edition

---

### **✔ Web Browser**
Framework ini menggunakan **ChromeDriver**, jadi pastikan terinstall:
- Google Chrome

---

# ✅ 2. Clone Repository

Jika kamu memiliki access ke repository private ini, jalankan:

```bash
git clone <PRIVATE_REPO_URL>
```

Masuk ke folder project:

```bash
cd ebay-automation-framework
```

---

# ✅ 3. Install Dependencies

Jalankan:

```bash
mvn clean install
```

Command ini akan:
- Mendownload Selenium, TestNG, ExtentReports
- Compile seluruh source code
- Setup project secara otomatis

---

# ✅ 4. Struktur Project

```
src
 ├── main
 │   └── java
 │       └── com.achmadirfan.framework
 │           ├── config       # Global config (properties)
 │           ├── core         # Base utilities & abstract components
 │           ├── pages        # All Page Objects
 │           └── reporting    # ExtentReports + TestNG Listeners
 │
 └── test
     └── java
         └── com.achmadirfan.tests
             ├── filters     # Filter test scenario
             └── search      # Search functionality test
```

---

# ✅ 5. How to Run the Tests (3 Methods)

## **🔹 Method A — Run From Maven (recommended)**

```bash
mvn clean test
```

Ini akan:
- Start ChromeDriver
- Jalankan seluruh TestNG suite
- Generate Test Report otomatis

---

## **🔹 Method B — Run From TestNG XML**

Di IDE, buka file:

```
testng.xml
```

Klik kanan → **Run As → TestNG Suite**

---

## **🔹 Method C — Run Individual Tests**

Contoh:

```
src/test/java/com/achmadirfan/tests/search/SearchItemTest.java
```

Klik kanan → **Run As → TestNG Test**

---

# ✅ 6. Test Scenarios Included

### **1️⃣ Cell Phones Filter Test**
- Navigate category  
- Apply 3 filters (Condition, Price, Location)  
- Verify filter count correct  

Class:  
`CellPhonesFilterTest.java`

---

### **2️⃣ Search Item Test**
- Search for “MacBook”  
- Validate search result name  

Class:  
`SearchItemTest.java`

---

# ✅ 7. Viewing Test Reports (ExtentReports)

Setelah test selesai, laporan HTML otomatis dibuat:

```
/reports/index.html
```

Untuk melihat:

1. Buka folder `reports`
2. Klik dua kali `index.html`
3. Report akan terbuka di browser

Report berisi:
- Test steps  
- Passed/Failed status  
- Automatic screenshots for FAILED test cases
- System information  

---

# ✅ 8. Configuration File

Framework menggunakan file:

```
src/main/java/com/achmadirfan/framework/config/GlobalData.properties
```

Di sini kamu bisa konfigurasi:

- Browser: chrome / firefox / edge  

---

# 🧑‍💻 Author

**Achmad Irfan**  
QA Automation Engineer  
Selenium | Java | TestNG | REST API | Maven | POM  

---

Jika Anda memiliki pertanyaan atau membutuhkan akses tambahan, feel free to reach out.
