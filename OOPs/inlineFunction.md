## Inline Functions
### **Introduction**
Method inlining is a way to optimize compiled source code at runtime by replacing the invocations of the most often executed methods with its bodies.

### **General Steps involved in a Function Call**
But let's take step back and understand how a function call works at runtime. When the program encounters a function call instruction the CPU stores the memory address of that particular instruction before the function call, copies the arguments of the function on the stack and finally transfers control to the specified function. The CPU then executes the function code, stores the function return value in a predefined memory location/register and returns control to the calling function. 

Easy peasy, right? Now coming back to inline functions, keeping in mind the above explanation, what are the situation when it's good to replace that function call statement with the actual code. One scenario is : When the function is executed for large number of times and replacing it with its body would reduce the execution time. This is done by the JVM itself. To be more precise, ***it's the responsibility of the Just-In-Time (JIT) compiler***, which is a part of the JVM; `javac` only produces a bytecode and lets JIT do the magic and optimize the source code.

### **How JIT Does It?**
Essentially, the **JIT compiler tries to inline the methods that we often call so that we can avoid the overhead of a method invocation.** It takes two things into consideration when deciding whether to inline a method or not.

First, it uses counters to keep track of how many times we invoke the method. When the method is called more than a specific number of times, it becomes “hot”. This threshold is set to 10,000 by default, but we can configure it via the JVM flag during Java startup. We definitely don't want to inline everything since it would be time-consuming and would produce a huge bytecode.

We should keep in mind that inlining will take place only when we get to a stable state. This means that we’ll need to repeat the execution several times to provide enough profiling information for the JIT compiler.

**The JIT inlines static, private, or final methods in general.** And while public methods are also candidates for inlining, not every public method will necessarily be inlined. The JVM needs to determine that there's only a single implementation of such a method. Any additional subclass would prevent inlining and the performance will inevitably decrease.

### **Can we guarantee method inlining?**

A simple answer is **No**. There is no guarantee that a function will be inlined in java. Yes, you can use a `public` `static` method in the code when placed in a public class. The java compiler **may** do inline expansion on a `static` or `final` method, but that is not guaranteed.

Even being “hot” does not guarantee that the method will be inlined. If it's too big, the JIT won't inline it. The acceptable size is limited by the *-XX:FreqInlineSize=* flag, which specifies the maximum number of bytecode instructions to inline for a method.