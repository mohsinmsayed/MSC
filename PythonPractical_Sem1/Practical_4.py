import random
import array

MAX_LEN = 12

DIGITS = ['0','1','2','3','4','5','6','7','8','9']
LOWERCASE_CHAR = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
UPPERCASE_CHAR = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
SYMBOLS = ['!','@','#','$','%','^','&','*','/','?','>','<','~']

COMBINED_LIST = DIGITS + LOWERCASE_CHAR + UPPERCASE_CHAR + SYMBOLS

random_digit = random.choice(DIGITS)
random_lowercase = random.choice(LOWERCASE_CHAR)
random_uppercase = random.choice(UPPERCASE_CHAR)
random_symbol = random.choice(SYMBOLS)

temp_password = random_digit + random_lowercase + random_uppercase + random_symbol

for x in range(MAX_LEN - 4):
    temp_password = temp_password + random.choice(COMBINED_LIST)
    temp_password_list = array.array('u',temp_password)
    random.shuffle(temp_password_list)

password = ""

for x in temp_password_list:
    password = password + x

print(f'Generated Password: {password}')