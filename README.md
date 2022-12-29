**oop_ex1**
 Author Eden Mor
 # observer pattern implements
 **using UndoableStringBuilder class from assignment 0**
observer pattern In software design and engineering, is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.
**in this assignment we have 2 parts**
## part 1
**in this assignment we needed to implemente the observer design pattern using the following classes:**

## GroupAdmin class that implements from the Sender interface
in this class we had to implement thos methods:
```java
package observer;
register- subscribe 
unregister- unsubscriber 
# append & insert strings to the UndoableStringBuilder object
public void insert
public void append 
# strings from the UndoableStringBuilder
public void Delete
# previous actions on the UndoableStringBuilder.
public void undo
```
The GroupAdmin class automatically notifyObserver (because of the shallow copy) whenever there is a change to the UndoableStringBuilder.


## ConcreteMember that implement from the Member interface 
the class has a member that is reciving massegeses frome the class groupadmin 
This class implementes update method that whenever the update method is called, the ConcreteMember class updates its internal copy of the UndoableStringBuilder object with the current state of the shared UndoableStringBuilder. 

# part 2
In this part we were asked to check the size of the object in the heap. We found out that one of the parameters for checking the efficiency of the code is the size of the object in the JVM memory. 

there are 3 methods that we were given to used to test the efficiency.

The method objectFootprint - shows all the references that the object contains the size of each reference (including overhead)

The method objectTotalSize - displays the total size of the object. This method is the most relevant to us in this assignment.

The jvmInfo method – displays the process ID of the JVM and the total amount of memory for the benefit of the program.
