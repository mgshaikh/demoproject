# Function to valiadte a password

def validatePassword(password):
    # Check the length
    if len(password) < 8:
        return False
    # Check for uppercase
    if password.islower():
        return False
    # Check for lowercase
    if password.isupper():
        return False
    # Check for digit
    if password.isdigit():
        return False
    # Check for special character
    if password.isalnum():
        return False
    # If all checks are passed, return True
    return True

# Main program
def main():
    password = input("Enter a password: ")
    if validatePassword(password):
        print("Valid password")
    else:
        print("Invalid password")