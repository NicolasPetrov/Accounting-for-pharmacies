# PharmacyAccountingApp
**PharmacyAccountingApp** is a desktop application with a graphical user interface designed for managing medication and vendor records in pharmacies. It offers a simple and intuitive way to handle data through tables, supporting adding, editing, and deleting entries. The application features a login screen with basic authentication, tabs for managing medications and vendors, and a splash screen for a visual effect upon launch.

<img width="877" alt="screen" src="https://github.com/user-attachments/assets/c5dcb118-ce2c-4211-860a-553c316e98f4" />

This project showcases the development of a Java application using the Swing library to build a GUI. It includes basic authentication, table management via `DefaultTableModel`, and straightforward user input handling, making it a solid foundation for learning desktop application development or extending with additional features.

#### Features

- **Login Screen**: Simple authentication with fixed credentials (username: "admin", password: "admin").
- **Medication Management**: View, add, edit, and delete medication records (ID, name, stock, price).
- **Vendor Management**: Manage vendor data (ID, name, contact information) with similar functionality.
- **Interactive Interface**: Utilizes tabs (`JTabbedPane`) for seamless navigation between sections.
- **Splash Screen**: Displays a splash screen with an image for 3 seconds at startup.
- **Data Tables**: Dynamically updates tables using `DefaultTableModel` with pre-populated sample data.

#### Technical Details

- **Language**: Java (version not specified, compatible with JDK 8 and above)

**Main Libraries:**

- `javax.swing`: For creating the graphical interface (JFrame, JTable, JTabbedPane, etc.).
- `java.awt`: For layout and window management.

#### Key Components

- **Authentication**: Basic login and password check with an error message displayed via `JOptionPane`.
- **Tables**: Dynamic data management in `JTable` using `DefaultTableModel`.
- **Dialog Windows**: Data input and editing via `JOptionPane.showInputDialog`.
- **Multithreading**: GUI launched in the `SwingUtilities.invokeLater` thread for proper Swing operation.
- **Splash Screen**: Displays an image (`splash_image.png`) with a delay via `Thread.sleep`.

#### Error Handling:

Checks for row selection before editing or deleting, with a message displayed if no row is selected.

No input exception handling (e.g., for invalid numbers in ID, Stock, or Price fields).
