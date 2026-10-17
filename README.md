#  Java Chat App

A real-time console-based chat application built with **pure Java SE**.  
Multiple clients connect simultaneously to a server and broadcast messages to each other.

---

##  How It Works

- **Server** listens on port 8080 and handles each client on a separate thread
- **Client** connects, sends messages, and receives broadcasts from all other clients instantly

---

## Tech Stack

| Topic | Implementation |
|---|---|
| Language | Java 25 (SE only) |
| Networking | `ServerSocket`, `Socket` |
| Concurrency | `Thread`, `Runnable` |
| Build Tool | Maven |
| Boilerplate | Lombok |

---
