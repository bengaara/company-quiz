
Quiz attempt.

To run these solutions,

install node and python

each question has a corresponding answer file with file name as question number

1. to execute question 1 just run script in the python shell. It will ask for input
2. To execute question 2. Set the vvariable n in the q2-input.txt file, then execute in node as follows:
     with cwd as this folder, run: node "question2 findBadVersion.js" < q2-input.txt

3.


Quiz:



Instructions
•	Attempt all questions
•	Marks are awarded based on the following:
o	Simplicity
o	Readability
o	Maintainability
o	Resource optimization
o	Functionality
o	Security
o	Regulatory requirements

Question 1
Function checkNumbers(number1, number2) takes in 2 numbers and returns a string true if number2 is greater than number1, otherwise it returns String false. If the parameters are equal to each other it returns the string -1.
Using Python, write the function checkNumbers(num1, num2)
Sample Test Cases

Input:50 & num2 = 100
Output:"true"

Input:50 & num2 = 50
Output:"-1"


Question 2:
As Senior Software Engineer, you lead a team of Software Engineers to develop a new software and you use Semantic versioning to version your code. Each of the version is based on a previous version such that all versions after the bad version are also bad.
Supposing that you have n versions [1,2,3,4,5,…..,n] you want to write a software that finds the first bad version, which makes all the versions that follow bad.
In order to determine the bad version, we have an API bool  isFailedTest(version) which tells you whether the version is bad or not (if it fails or passes the test respectively).
Write a function that checks for the first bad version. You should minimize the number of calls to the API

Question 3
As a [good] parent , you want to give your children some sweets and you can only give each child at most one sweet. Each sweet j has a size sj. Each child i has a greed factor gi which is the minimum size of a sweet that the child will be contented with. If sj>=gi, we can assign the sweet j to the child and the child will be content. Write a function that will maximize the number of your children that will be content and output the maximum number that will be content.
•	Assume that the greed factor is always a positive value.
•	You cannot assign more than one cookie to one child.
Example
You have 3 children: x, y and z with greed factor [1,2,3], and you have 2 cookies with sizes [1,1].

Input:[1,2,3], [1,1]
Output:1

Explanation: Though there are 2 cookies their sizes are the same (1) and therefore only one child (whose greed factor is 1) will get contented. You need to output 1.


Question 4:
Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Question 5
You are asked to cut off trees in a forest for a golf event. The forest is represented as a non-negative 2D map, in this map:
•	0 represents the obstacle can't be reached.
•	1 represents the ground can be walked through.
The place with number bigger than 1 represents a tree can be walked through, and this positive number represents the tree's height.
You are asked to cut off all the trees in this forest in the order of tree's height - always cut off the tree with lowest height first. And after cutting, the original place has the tree will become a grass (value 1).
You will start from the point (0, 0) and you should output the minimum steps you need to walk to cut off all the trees. If you can't cut off all the trees, output -1 in that situation.
You are guaranteed that no two trees have the same height and there is at least one tree needs to be cut off.
Example 1:
Input:
[
 [1,2,3],
 [0,0,4],
 [7,6,5]
]
Output: 6
Example 2:
Input:
[
 [1,2,3],
 [0,0,0],
 [7,6,5]
]
Output: -1
Example 3:
Input:
[
 [2,3,4],
 [0,0,5],
 [8,7,6]
]
Output: 6
Explanation: You started from the point (0,0) and you can cut off the tree in (0,0) directly without walking.
Hint: size of the given matrix will not exceed 50x50.





