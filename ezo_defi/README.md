Defi Ezo

Gets a string mathematical expression and executes it given the result.

The main idea is:

- Read each char of the expression and determine the type of the operator (Factory pattern) 
- Based on the type of the operator, extract the rest of it. Ex: 
    - If the operator is +, than, it doesn’t not need to read more, the operator is only one char 
    - If the operator is 1, than, it means it is a number and should read the next chars until finish do assemble the number. 
    - if the operator is (, read the expression until find the right ) to match. This mean, the current operator will be another expression representing the expression inside the () 

- With the entire operator, user the builder (Visitor pattern) to create the node and add it to the right place of the structure expression 
- At the end, we will have a structure expression with nodes, calling the resolve of the root node, will trigger all resolve of the children nodes and at the end the result 

What is supported

- Decimal number separated by . (ex 1, 1.5, 23.3) 
- Operator +, -, *, /, ^ 
- Expressions inside parentheses, as many as needed 
- The string can have spaces or not, it doesn’t matter 

What is not supported (yet)

- Negative numbers 
- Functions like sqrt 
- Invalid expressions (it won’t give you beautiful error messages, it will just fail) 

Technical backlog

- Create more jUnit tests (obviously) 
- Support functions like sqrt 
    - Probably just add a new operator on the factory and in the extractor 
    - Add the new node with right priority and resolve method 
    - Implement the visit on builder to add the new node on the structure expression 

- Support negative numbers 
    - Two possible ways to do that: 
        - Change the factory/extractor  to read further when detecting +/- (positive or negative) numbers. *ps It doesn’t seems a good idea 
        - Interpreter a +/- (positive or negative) just as a custom operator but without a left side. Ex: 1 - -1 can be interpreted as 1 - 0 - 1. It seems to be simple to add in the buider structure created 

- Add validations on parser/builder and resolve.  
    - Each node can have a toString(), that in case of a error, it sets a flag of error, raise an exception and the toString() and check this flag and set custom “formatting” where is the error. Ex: 
        - 1 + 2 / (2 - 2) + 1 =&gt; the DividerNode will set the flag of 2/0 error, and its toString() can do like “1 + 2 / --- (2 - 2) -- dividing by zero --- + 1”