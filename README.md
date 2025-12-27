# Spring AI MCP Server (Stdio)

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk)
![Spring AI](https://img.shields.io/badge/Spring%20AI-1.1.2-green?style=flat-square&logo=spring)
![Spring AI](https://img.shields.io/badge/Spring%20Boot-3.5.9-green?style=flat-square&logo=spring)
![MCP](https://img.shields.io/badge/Protocol-MCP-blue?style=flat-square)

This repository contains a **Model Context Protocol (MCP) Server** implemented using Spring AI. It uses the **Stdio (Standard Input/Output)** transport layer, designed to be run as a subprocess by an MCP Client.

## 👤 Author

**Jashwanth Reddy**

* **GitHub**: [@mrjashwanthreddy](https://github.com/mrjashwanthreddy)
* **LinkedIn**: [@jashwanth-java-developer](https://www.linkedin.com/in/jashwanth-java-developer/)
* **Instagram**: [@mrjashwanthreddy](https://www.instagram.com/mr.jashwanthreddy/)

## 📖 Overview

In the MCP architecture, this server acts as a provider of tools and resources. Because it uses **Stdio**, it does not open a network port. Instead, an MCP Client (like a desktop app, IDE, or another Spring Boot app) spawns this application as a process and communicates with it via standard input (`stdin`) and standard output (`stdout`).

## 🚀 Features

* **Stdio Transport**: Efficient, secure process-based communication.
* **Spring AI Integration**: Leverages Spring AI's MCP server auto-configuration.
* **Tool Exposure**: (Add description of tools here, e.g., *Exposes calculator functions, file system access, etc.*)

## 🛠️ Prerequisites

* **Java 21**
* **Spring Boot** 3.5.9
* **Spring AI** 1.1.2
* **Maven**

## ⚙️ Installation & Build

Since this is a Stdio server, you typically need to build it into an executable JAR file that your client can run.

1.  **Clone the Repository**
    ```bash
    git clone [https://github.com/mrjashwanthreddy/mcpserverstdio.git](https://github.com/mrjashwanthreddy/mcpserverstdio.git)
    cd mcpserverstdio
    ```

2.  **Build the JAR**
    ```bash
    ./mvnw clean package
    ```

    This will create an executable JAR file in the `target/` directory (e.g., `target/mcpserverstdio-0.0.1-SNAPSHOT.jar`).

## 🔌 How to Connect (Usage)

To use this server, you need an **MCP Client**. You cannot "curl" this server because it doesn't use HTTP.

### Client Configuration Example
If you are using the [Spring AI MCP Client](https://github.com/mrjashwanthreddy/mcpclient), configure it to spawn this JAR:

**`application.properties` (in your Client App):**

```properties
# 1.Setup mcp servers in mcp-servers.json file
spring.ai.mcp.client.stdio.servers-configuration=classpath:mcp-servers.json