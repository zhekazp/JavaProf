Service: Design a TimeService class with a getCurrentTime() method that returns a formatted string with the current time.

Output Component: Create a TimePrinter class that will use TimeService to get the current time and print it to the console.

Annotations: Use @Component to annotate TimeService and @Component for TimePrinter. @Autowired is used to inject TimeService into TimePrinter.

Testing: In the main method, load the Spring context and use TimePrinter to print the current time to the console.