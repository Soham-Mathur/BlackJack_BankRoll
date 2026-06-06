# BlackJack_BankRoll 🃏

A Java-based command-line Blackjack session tracker designed for players who want to monitor their real-world or online Blackjack sessions.

Instead of simulating cards, this application lets you record the outcome of each hand while automatically tracking your bankroll, profit/loss, and overall win rate throughout the session.

---

## Features

### 💰 Bankroll Management

* Set a custom starting balance for each session
* Real-time balance updates after every hand
* Automatic profit/loss calculation at session end
* Session ends automatically when balance reaches zero

### 🎲 Supported Outcomes

Track the following Blackjack results:

* Win
* Lose
* Push
* Blackjack
* Double Down
* Two-Way Split
* Three-Way Split

### ✅ Smart Validation

* Prevents bets larger than your current balance
* Rejects negative or zero-value bets
* Blocks Double Down when funds are insufficient
* Blocks Split attempts when funds are insufficient
* Handles invalid and non-numeric input safely

### 📊 Session Statistics

* Final profit/loss summary
* Win percentage across all hands
* Balance displayed after every hand
* Animated reveal for final profit/loss

---

## Getting Started

1. Clone or download the repository
2. Open in IntelliJ IDEA (or any Java IDE)
3. Run `Main.java`
4. Enter your starting balance and begin logging hands

No external dependencies — pure Java.

---

## Example Session

```text
Please enter your starting balance: 500

How much are you willing to bet: 25

What event occurred:
1. Win
2. Lose
3. Push
4. Blackjack
5. Double Down
6. Two-Way Split
7. Three-Way Split
Enter the Number ----> 1

You WON!!

*********************************
Your current balance is 550.00$
*********************************

Do you want to play again (y/n): n

Your final balance comes out to 550.00$
And your profit was.....
....
...
..

**********************************************************
Your total Profit/Loss came up to... 50.00$
And your win percentage was... 100.00%
**********************************************************
```

---

## Payout Rules

| Outcome         | Payout                   |
|-----------------|--------------------------|
| Win             | 1:1 on your original bet |
| Lose            | Lose your original bet   |
| Push            | Original bet refunded    |
| Blackjack       | 3:2 on your original bet |
| Double Down     | 2:1 on your original bet |
| Two-Way Split   | 1:1 per hand won         |
| Three-Way Split | 1:1 per hand won         |

---

## Technical Concepts Demonstrated

### Object-Oriented Programming

* Interface-based polymorphism — each outcome is its own class implementing a shared `Bank` interface
* Encapsulation of payout logic away from session control
* Separation of concerns between `Main` and individual outcome classes

### Java Features

* Modern switch expressions (arrow syntax)
* Static Scanner shared across classes
* Input validation using `hasNextDouble()` and `hasNextInt()`
* Loop-based validation with `while` and `do-while`

### Design Structure

```
Bank (Interface)
│
├── Win
├── Lose
├── Push
└── BlackJack

TwoSplit
ThreeSplit

Main
└── Controls full session flow
```

> Note: `TwoSplit` and `ThreeSplit` are not part of the `Bank` interface as their
> `moneyLeft()` method takes an additional `wins` parameter.

---

## Error Handling

The application protects against:

* Non-numeric and invalid input at every prompt
* Invalid menu selections
* Zero or negative bets
* Bets exceeding the current balance
* Insufficient funds for Double Down
* Insufficient funds for Two-Way or Three-Way splits

---

## Future Improvements

### Planned Features

* Multiple split support
* Insurance bet tracking
* `Bank` interface redesign to include split classes
* Session history logging with CSV and text file export
* Better implimentation of OOP 

### ⚠️ Major Upcoming Update

A fully playable Blackjack game — built directly into the terminal:

* Real deck generation and shuffling
* Full dealer logic
* Hit, Stand, Double Down, and Split decisions
* Complete end-to-end gameplay experience

No more manual result entry — play and track your sessions in one place.

---

## Tech Stack

| Technology | Details       |
|------------|---------------|
| Language   | Java          |
| JDK        | 26            |
| IDE        | IntelliJ IDEA |

---

## Why This Project?

Most Blackjack applications focus on gameplay.

**BlackJack_BankRoll** focuses on **session tracking** — letting players monitor bankroll changes, analyze hand outcomes, and review performance over a full session without manually calculating winnings after every hand.

It also serves as a demonstration of object-oriented design principles in Java, built as part of an early programming portfolio.