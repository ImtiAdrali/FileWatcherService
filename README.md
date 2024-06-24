# File Watcher Service
The **FileWatcherService** is a Java class that monitors a specified directory for file creation, modification, and deletion events. It uses the Java NIO.2 File Watching API to efficiently watch for changes in the file system.

## Usage
To use the **FileWatcherService**, follow these steps:

1.	Import the necessary classes:
```java
import com.imit.service.FileWatcherService;
import java.io.IOException;
```
2.	Create a new instance of the **FileWatcherService** by providing the path to the directory you want to watch:
```java
String pathToWatch = "/path/to/directory";
FileWatcherService fileWatcherService = new FileWatcherService(pathToWatch);
```
3.	Start the file watcher service:
java
Copy
fileWatcherService.startWatching();
The startWatching() method will continuously monitor the specified directory and print out information about any file creation, modification, or deletion events.

## Example
Here's an example of how to use the **FileWatcherService**

```java
public static void main(String[] args) {
    try {
        String pathToWatch = "/path/to/directory";
        FileWatcherService fileWatcherService = new FileWatcherService(pathToWatch);
        fileWatcherService.startWatching();
    } catch (IOException e) {
        System.out.println("Error initializing file watcher service: " + e.getMessage());
    }
}
```

This will start the file watcher service and monitor the /path/to/directory for any file changes.

## Features
- Monitors a specified directory for file creation, modification, and deletion events.
- Utilizes the Java NIO.2 File Watching API for efficient file system monitoring.
- Prints out informative messages about the detected file events.
- Runs continuously until interrupted.
- Dependencies
- The FileWatcherService class does not have any external dependencies. It uses only the standard Java runtime libraries.

## Limitations
- The **FileWatcherService** can only monitor a single directory at a time. If you need to watch multiple directories, you'll need to create multiple instances of the class.
- The file watcher service runs in a continuous loop and does not provide a way to stop it programmatically. If you need to stop the watcher, you'll need to interrupt the thread or use a separate mechanism to control the lifecycle of the service.

## Contributing
If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request on the project's GitHub repository.
