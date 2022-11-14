def check_guess(guess, answer):
    global score
    still_guessing = True
    attempt = 0
    while still_guessing and attempt < 3:
        if guess.lower() == answer.lower():
            print("Correct Answer")
            score = score + 1
            still_guessing = False
        else:
            if attempt < 2:
                guess = input("Sorry Wrong Answer, Try Again")
            attempt = attempt + 1
    if attempt == 3:
        print("The Correct Answer is ",answer)

score = 0
print("Guess the Bird")
guess1 = input("Which bird lives at the North Pole? ")
check_guess(guess1, "Kiwi")
guess2 = input("Which is the bird that hangs on a tree? ")
check_guess(guess2,"bat")
guess3 = input("Which is the most colorful bird? ")
check_guess(guess3,"parrot")
print("Your Score is "+str(score))