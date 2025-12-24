# Operating-Platforms

The Gaming Room Client and Software Requirements
The client for this project was "The Gaming Room," a company looking to expand its Android-only game, "Draw It or Lose It," into a multi-platform, web-based experience. The primary requirement was to create a scalable server-side application that could support multiple teams and players while ensuring all game and team names remained unique. Technically, the client required the game service to use a Singleton pattern to ensure only one instance existed in memory at a time.

Development Successes and Process
I believe I did particularly well in documenting the Object-Oriented Programming (OOP) principles and design patterns. Clearly explaining how Inheritance allowed the Game, Team, and Player classes to share logic from a base Entity class helped show how the code remains maintainable. Working through the design document was extremely helpful for the coding phase because it forced me to visualize the relationships between objects before I actually started writing the Java files. It made implementing the Iterator pattern much easier since I had already planned how to traverse collections to check for unique names.

Reflections and Future Improvements
If I could revise one part of my work, I would improve the Scalability section of the design constraints. While the Singleton pattern meets the current "one instance" requirement, I’d like to better outline how to transition to a distributed state—perhaps using a database like PostgreSQL or a cache—so the application doesn't hit a bottleneck as more players join.

Interpreting User Needs
I interpreted the user’s needs by focusing on platform-agnostic design. Since the client wanted to reach users on Windows, Mac, and mobile, it was vital to implement a REST API using JSON data exchange. Considering user needs during the design phase is essential because it prevents "wasting time" writing separate logic for every different device, ensuring a consistent experience for everyone regardless of their operating platform.

Design Approach and Future Strategies
My approach focused on decoupling the server-side logic from the client interface using a client-server architecture. In the future, I will use strategies like UML class modeling and technical constraint analysis early in the process. This allows me to address memory management—like object pooling to avoid "stuttering" animations—and security requirements, such as HTTPS encryption, before they become issues in the final prototype.
