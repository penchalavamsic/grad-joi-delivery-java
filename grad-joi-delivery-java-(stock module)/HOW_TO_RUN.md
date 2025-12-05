# How to Run the Project

This guide provides instructions on how to compile and run the Java code for the JOI Delivery project.

## Prerequisites
- **Java Development Kit (JDK) 24**: Ensure you have Java 24 installed. You can verify this by running `java -version` in your terminal.

## Running from an IDE (IntelliJ IDEA, Eclipse, VS Code)
The easiest way to run the project is using an Integrated Development Environment (IDE).

1.  **Open the Project**: Open the `grad-joi-delivery-java` folder in your IDE.
2.  **Locate the File**: Navigate to `src/main/java/com/tw/joi/delivery/problems/SampleProblem.java`.
3.  **Run**: Right-click on the file or the `main` method inside it and select **Run 'SampleProblem.main()'**.

## Running from the Command Line

If you prefer using the terminal, follow these steps. Ensure you are in the root directory of the project (`grad-joi-delivery-java`).

### 1. Compile the Application
First, compile the Java source file. We will place the compiled bytecode in the `bin` directory.

```bash
# Ensure the bin directory exists (if not, create it)
mkdir -p bin

# Compile SampleProblem.java
javac -d bin src/main/java/com/tw/joi/delivery/problems/SampleProblem.java
```

### 2. Run the Application
Once compiled, you can run the application using the fully qualified class name.

```bash
java -cp bin com.tw.joi.delivery.problems.SampleProblem
```

### 3. Running Tests
To run the manual test class `ManualSampleProblemTest`:

**Compile the Test:**
You need to include the compiled application classes (in `bin`) in the classpath so the test can find them.

```bash
javac -d bin -cp bin src/test/java/com/tw/joi/delivery/problems/ManualSampleProblemTest.java
```

**Run the Test:**
Execute the test class.

```bash
java -cp bin com.tw.joi.delivery.problems.ManualSampleProblemTest
```
