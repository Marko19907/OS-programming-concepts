# OS Programming Concepts

The repository contains examples of operating system programming concepts, e.g. threading, synchronization, and inter-process communication. 
Made for the Operating Systems with System Programming (IDATA2305) course, spring 2022.

These projects are mandatory but do not count towards the final grade in the subject.

[![Java CI with Maven](https://github.com/Marko19907/OS-programming-concepts/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/Marko19907/OS-programming-concepts/actions/workflows/maven.yml)

## Contents 

### [Calculations with Threads](/calculations-with-threads)
* [x] Write a multithreaded program in Java that calculates the required statistical values from the given list of numbers.
* [x] Create at least 4 worker threads:
  * [x] Thread to determine the **average** of the given numbers.
  * [x] Thread to determine the **minimum** value.
  * [x] Thread to determine the **maximum** value.
  * [x] Thread to determine the **standard deviation**.
* [x] Output the values from the parent thread once the workers have exited.

### [Dining Philosophers Problem](/dining-philosophers-problem)
* [x] Present a solution to this classic synchronization problem using Java and Java's "Monitor" synchronization mechanism.
  * [x] 5 philosophers are sitting at a round table with a large bowl of spaghetti doing one of three things: eating, thinking, or sleeping.
  * [x] There are 5 chairs, 5 plates, and 5 forks.
  * [x] Philosophers don’t speak with each other.
  * [x] A philosopher must eat with two forks, one for each hand.
  * [x] Each time a philosopher has finished eating, he will drop his forks and start thinking.
  * [x] When a philosopher is done thinking, he will become hungry again.
  * [x] Philosophers can not starve or die in this version of the problem.

### [Producer Consumer Problem](/producer-consumer-problem)
* [x] Create a simple Java application that:
  * [x] Uses a shared buffer of fixed size 5.
  * [x] Has a producer thread that puts 10 data items into the buffer.
  * [x] Has a consumer thread that gets all 10 data items from the buffer.
  * [x] Handle the case of buffer full/empty.
  * [x] Use Java's "Monitor" to synchronize the consumer and producer.
* [x] The buffer size of 5 makes the buffer to small to fit all 10 data items and the solution must take
  necessary steps to secure that the producer can not produce more items if the buffer is full. The
  consumer on the other hand must not try to consume data from the buffer if the buffer is empty.

### [Sleeping Barber Problem](/sleeping-barber-problem)
* [x] Write a multi-threaded application in Java and use Java's "Monitor" for synchronization.
* [x] Barber shop has **one** barber, **one** barber chair, and **5** chairs for waiting customers.
  * [x] If there are no customers, the barber sleeps in his own chair.
  * [x] When a customer arrives, he has to wake up the barber.
  * [x] If there are many customers and the barber is cutting a customer’s hair, then the remaining
    customers either wait if there are empty chairs in the waiting room or they leave if no chairs
    are empty.
