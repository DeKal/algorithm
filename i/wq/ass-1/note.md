For this problem add(20, 30) = 50, we can write a simple function: 
add = (x, y) => x + y

For this problem add(20)(30) = 50, we can write a high order function like 
add = (x) => (y) => x +  y;

To combine 2 solution, we can check if we pass more than one param, then we will return x+y. Otherwise, we can return the high order part (y) => x +  y
add = (x, yOriginal) => yOriginal ? x + yOriginal : (y) => x +  y;