import numbers

def checkNumbers(num1, num2):

#only evaluate number types
    if not isinstance(num1, numbers.Number) or not isinstance(num2, numbers.Number):
        return "false";
    
    highest = max(num1, num2)
    if num1==num2:
        return "-1";
    elif highest == num2:
        return "true";
    else:
        return "false";

numOne = input("Enter first number:  ")
print "You entered:  {}".format(numOne)
numTwo = input("Enter second number:  ")
print "You entered:  {}".format(numTwo)

print "Is second number larger: {} ".format(checkNumbers(numOne,numTwo))