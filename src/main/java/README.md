
#  Remote Health Monitoring System (AlertSystem)

This is a Java-based alert and notification system built with multiple modules like EmailNotifier, SMSNotifier, ReminderService, etc. The main entry point for running the system is the `AlertSystem` class.

---

## Project Structure

```
#### src/
#### └── main/
####    └── java/
####        ├── ChatServerSystem/
####        ├── ClientSide/
####        ├── Date/
####        ├── EmailNotifier/
####        ├── EmergencyAlertSystem/
####        ├── ExceptionHandler/
####        ├── Notifi/
####        ├── Notification/
####        ├── PanicButtonSystem/
####        ├── RemiderService/
####        ├── SMSNotifier/
####        ├── VideoConsultation/
####        └── AlertSystem.java   <-- Main class
```

---

## Prerequisites

- **Java JDK 17+**
- **IntelliJ IDEA** (Community or Ultimate)
- **Maven** (integrated in IntelliJ)
- Internet connection (for downloading dependencies)

---

## How to Run the Project in IntelliJ

1. **Clone or Download the Project**
   - Open IntelliJ and go to **File > Open**.
   - Select the project folder (the root that contains `pom.xml`).

2. **Wait for Maven to Load**
   - IntelliJ will automatically import dependencies from `pom.xml`.
   - You may need to click **"Load Maven Project"** if it doesn't do this automatically.

3. **Set Project SDK**
   - Go to **File > Project Structure > Project**.
   - Set SDK to Java 17 or higher.

4. **Locate Main Class**
   - Go to `src/main/java/AlertSystem.java`.

5. **Run the Application**
   - Right-click on `AlertSystem.java`.
   - Click **Run 'AlertSystem.main()'**.

---

## Notes

- Ensure all modules/classes used in `AlertSystem` are implemented and compile without errors.
- If you're using email/SMS functionality, make sure any credentials (e.g., Gmail App Passwords) are set securely.
- The `pom.xml` file should contain the correct dependencies like `jakarta.mail`.

---

## Dependencies (in pom.xml)

```xml
<dependencies>
    <dependency>
        <groupId>com.sun.mail</groupId>
        <artifactId>jakarta.mail</artifactId>
        <version>2.0.1</version>
    </dependency>
    <!-- Add any other module-specific dependencies -->
</dependencies>
```

---

## License

This project is for educational/demo purposes. Use at your own discretion.
