# Exercise 2.1: Understanding Reactive Programming

## Overview

Reactive programming is a programming paradigm oriented around data streams and the propagation of change. It enables developers to build asynchronous, event-driven applications that are scalable, resilient, and responsive.

This document explains the **core principles** of reactive programming — **Observables**, **Subscribers**, and **Schedulers** — and compares reactive programming with traditional imperative programming.

---

## Core Principles of Reactive Programming

### 1. Observables
- **Definition:** An Observable is a data producer that emits a stream of data or events over time.
- **Role:** It can emit zero or more values and can either complete or emit an error.
- **Example:** A stream of mouse clicks, API responses, or sensor readings.

### 2. Subscribers (Observers)
- **Definition:** A Subscriber (or Observer) is a consumer that subscribes to an Observable to receive emitted values, errors, or completion signals.
- **Role:** It defines how to handle each item emitted by the Observable, how to handle errors, and what to do when the Observable completes.

### 3. Schedulers
- **Definition:** Schedulers control the execution context of an Observable and its operators.
- **Role:** They manage threading and concurrency, determining where and when tasks are executed (e.g., main thread, background thread).
- **Use case:** Performing network requests asynchronously and observing the results on the UI thread.

---

## Comparison: Reactive Programming vs Traditional Imperative Programming

| Aspect                  | Reactive Programming                          | Imperative Programming                        |
|-------------------------|----------------------------------------------|----------------------------------------------|
| **Programming Model**   | Declarative: Define data flows and transformations | Imperative: Define step-by-step instructions  |
| **Data Handling**       | Works with asynchronous streams of data/events | Usually synchronous, blocking operations      |
| **Control Flow**        | Event-driven, data propagates automatically | Control flows explicitly using loops, conditionals |
| **Concurrency**         | Built-in support with Schedulers and async streams | Manual threading and synchronization required |
| **Error Handling**      | Propagated through streams to subscribers   | Try-catch blocks and error codes              |
| **Scalability & Responsiveness** | High, designed for responsive, scalable systems | Depends on manual management                   |
| **Example Use Case**    | UI events, real-time data updates, network responses | Traditional batch processing, simple scripts  |

---

## Summary

Reactive programming allows developers to **react** to data changes and events by working with asynchronous streams, making applications more efficient and easier to maintain, especially in environments requiring high responsiveness and concurrency.

Traditional imperative programming focuses on **how** to do things step-by-step, which can become complex and less efficient when handling asynchronous data and events.

---

## Reference

- [ReactiveX Official Documentation](http://reactivex.io/)

---