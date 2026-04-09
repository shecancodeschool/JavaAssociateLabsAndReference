# 📦 Java Garbage Collection (GC) – Research Summary

This document provides an overview of the garbage collection process in Java, how it works internally, and common pitfalls developers should avoid—such as memory leaks.

---

## 🧠 What is Garbage Collection?

**Garbage Collection (GC)** is the process by which the Java Virtual Machine (JVM) automatically manages memory. It reclaims memory used by objects that are no longer accessible in a running application, helping prevent memory overflow and manual memory handling bugs.

---

## ⚙️ How Does Garbage Collection Work?

The JVM memory is divided into different areas:

- **Young Generation**: Where all new objects are allocated. It’s divided into:
    - Eden Space
    - Survivor Spaces (S0, S1)
- **Old Generation (Tenured)**: Where long-lived objects are stored.
- **Metaspace**: Stores class metadata (replaces PermGen from Java 8 onwards).

**Garbage collection process:**
1. Objects are first created in the **Eden** space.
2. If they survive multiple GC cycles, they are promoted to the **Old Generation**.
3. The GC algorithm runs periodically to free memory from unreachable objects.

---

## 🧹 Types of Garbage Collectors

Java offers several types of garbage collectors:

| Collector       | Description |
|----------------|-------------|
| **Serial GC**  | Simple, single-threaded collector for small applications. |
| **Parallel GC**| Multi-threaded, suitable for high-throughput apps. |
| **CMS (Concurrent Mark Sweep)** | Low pause time, but deprecated since Java 9. |
| **G1 GC**      | Default from Java 9+, balances throughput and low pause times. |
| **ZGC / Shenandoah** | Scalable, ultra-low pause collectors (Java 11+ and 12+ respectively). |

---

## 🧨 Common Pitfalls: Memory Leaks

Even with automatic GC, memory leaks can still occur. Common causes include:

- **Unclosed resources** (e.g., streams, connections)
- **Static references** that prevent GC from collecting unused objects
- **Listeners or callbacks** that aren't removed
- **ThreadLocals** that retain references unintentionally
- **Large object retention** in long-lived collections (like `Map`, `List`)

---

## ✅ Best Practices

- Use `try-with-resources` for automatic resource management.
- Remove unused listeners, observers, or callbacks.
- Avoid static references unless necessary.
- Use tools like:
    - **VisualVM**
    - **JConsole**
    - **JDK Mission Control**
    - **Eclipse Memory Analyzer (MAT)**
- Monitor heap and GC logs using JVM flags like `-Xlog:gc*` or `-verbose:gc`.

---

## 🔍 Example JVM Flags for Tuning

```bash
java -Xms512m -Xmx1024m -XX:+UseG1GC -jar myapp.jar
