## Background:
The solution is aimed to store all products' details kept in the inventory and also do certain opeartions like (adding new product, buying, selling, profit counting etc). I used java arrayList to solve the problem. Additionally, to solve it efficiently I use MVC design pattern.
MVC design pattern comprises of Model, View and Controller class. The model class represents the object and also handles certain operations regarding the properties of the class. The view class is tasked to represent the content of the data. Finally, being a bridge between model and view, controller
class handles data flow and updates view while data changes.

So in ths prolem, the Product class is the model class containing all detailed properties of Product. The ProductView is the view class. It shows data of product (like showing product details or available balance). And the ProductController is the controller class handles data flow between Product class and ProductView class.
All these classes are instantiated and tested from the demo Main class.

## How to run:
1. Open command prompt or terminal. GO to the directory.
2. Type 'javac Main.java' and enter.
3. Type 'java Main' and enter.

