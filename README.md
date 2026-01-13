# 🌐 Java HttpClient Demo (JDK 11+)

A simple **plain Java** application demonstrating how to make outbound HTTP requests using the built-in **JDK `java.net.http.HttpClient`** (Java 11+).

This project calls a public external API (JSONPlaceholder) and implements basic CRUD-style HTTP operations against the `/todos` resource. The goal is to understand the **request/response lifecycle in raw Java**, how to handle status codes, and how JSON parsing works when you are not using Spring.

---

## 🎯 Goals of This Project

- Learn how to make outbound HTTP calls in **plain Java** (no Spring)
- Understand the built-in **JDK HttpClient** introduced in Java 11+
- Practice the full HTTP lifecycle:
    - Build an `HttpRequest`
    - Send with `HttpClient`
    - Receive an `HttpResponse`
    - Parse JSON into Java types
- Learn how to handle errors (example: throwing a custom exception for `404`)
- Write tests to validate your client behavior

---

## 🛠 Tech Stack

- ☕ Java 11+ (video uses Java 21, but 11+ works)
- 📦 Maven
- 🌐 `java.net.http.HttpClient` (JDK built-in)
- 🧩 Jackson (`ObjectMapper`) for JSON parsing
- ✅ JUnit 5 for tests
- 🧪 JSONPlaceholder (external public API)

---

## 🌍 External API Used

This project calls the **JSONPlaceholder** API:  
https://jsonplaceholder.typicode.com

It uses the `/todos` resource to demonstrate:
- 📥 Fetching all todos
- 🔍 Fetching a todo by ID
- ✍️ Creating a todo
- 🔄 Updating a todo
- 🗑 Deleting a todo

---

## 🧩 Key Concepts Demonstrated

### 🔗 JDK HttpClient Basics
- Creating a reusable `HttpClient`
- Building requests with `HttpRequest.newBuilder()`
- Using `URI.create(...)` (requests require a `URI`, not a `String`)
- Sending requests:
    - `client.send(...)` (synchronous)
    - (Optional next step) `client.sendAsync(...)` (asynchronous)
- Handling responses with `HttpResponse.BodyHandlers`

### 🧠 JSON Parsing (No Spring)
- Receiving raw JSON as a `String`
- Using Jackson `ObjectMapper` to convert JSON → Java records
- Deserializing lists using `TypeReference<List<Todo>>` (generics + type erasure)