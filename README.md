# Exercise 11

This exercise is about unit testing.

## Step 1

Please clone this repository onto your local computer. On the command line, you would enter: `git clone https://github.com/idh-cologne-tools-ressourcen-infra/exercise-11`, and create a new branch using your UzK username as a name.

## Step 2
The code in `de.ukoeln.idh.teaching.tri.ex11.ATM` mimics the behavior of an ATM. If started, a user is asked to enter the amount of money they want to withdraw. The program replies with a list of numbers, representing the number of banknotes of each type that an ATM would return. E.g., if a user asks for 80 Euros, the ATM replies with `0,0,0,1,1,1,0`, representing one 50€ note, one 20€ note and one 10€ note. The numbers are thus sorted from highest to lowest ([Which Euro banknotes are in use?](https://en.wikipedia.org/wiki/Euro_banknotes)). 

More interaction with the ATM:
```
Please enter amount: 80
0,0,0,1,1,1,0

Please enter amount: 40
0,0,0,0,2,0,0

Please enter amount: 50000
100,0,0,0,0,0,0

Please enter amount: 0
Incorrect value

Please enter amount: -5
Incorrect value

Please enter amount: 7
Incorrect value

Please enter amount: exit
```

As you can see, the ATM is somewhat error proof: You cannot withdraw 0€, negative numbers or numbers that can not be expressed in Euro banknotes.

Run the program, play with it. Can you crash the program via user input? Inspect the code and try to understand how it works and why.

(Selecting a useful set of banknotes is a surprisingly hard task. The algorithm implemented in this ATM class always gives out the least number of banknotes, which is absolutely not what people want when they are in front of an ATM).

## Step 3
The class `de.ukoeln.idh.teaching.tri.ex11.TestATM`, is currently empty. The class is supposed to contain unit tests for the ATM class.

Please implement unit tests for the methods `canWidthdraw(int)` and `withdraw(int)` in `ATM`. Each method should be tested with expected and unexpected input.

## Step 4
Commit your program to the repository and push it to the repository.