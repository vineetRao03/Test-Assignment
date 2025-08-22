# SDET Practice Projects  

This repository contains demo automation scripts built with **Java + Selenium + TestNG**.  
These exercises simulate real-world QA scenarios to strengthen core SDET skills.  

---

## 📱 Responsive Test  

**Purpose:**  
To validate whether a webpage is responsive across multiple devices (Mobile, Tablet, Desktop).  

**How it works:**  
- Uses Selenium to resize the browser window with predefined **Dimension values** for different devices.  
- Runs checks for:  
  - **Mobile (Pixel):** Verifies hamburger menu and navigation visibility.  
  - **Tablet & Desktop:** Validates navigation elements display correctly.  
- Assertions handled with **TestNG**.  

**Tech Used:**  
- Java  
- Selenium WebDriver  
- TestNG  

---

## 🔗 Broken Link Validator  

**Purpose:**  
To check if a webpage contains any **broken links**.  

**How it works:**  
- Extracts all `<a>` tags using Selenium.  
- Retrieves their `href` attributes.  
- Sends an HTTP request for each link using **HttpURLConnection**.  
- Classifies links as:  
  - **Valid (200–399)**  
  - **Broken (400+)**  

**Tech Used:**  
- Java  
- Selenium WebDriver  
- HttpURLConnection (Java Networking API)  

---

## 🚀 Learning Outcome  
- Practiced **cross-device responsive testing**.  
- Automated **broken link validation** to ensure smooth navigation.  
- Gained hands-on exposure with Selenium, TestNG, and Java Networking API.  
