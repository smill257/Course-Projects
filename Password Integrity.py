# -*- coding: utf-8 -*-
"""
Created on Tue Oct  1 16:17:34 2024

@author: Sam Miller
"""
import re
#imported to look for a specified pattern insided the string and return a match object if it finds the match

def isValid(password):
    #checking the length of the password
    if len(password) < 8 or len(password) > 15: 
        print("Invalid Password: Password length should be between 8 and 15 characters.")
        return False
    
    #check to see if password has a space
    if (" " in password):
        print("Invalid Password: Password should not contain any spaces.")
        return False
    
    #checking to see if password contains at least on digit (0-9)
    if not re.search(r'\d', password):
        print("Invalid Password: Password should contain at least one digit (0-9).")
        return False
    
    #checking to see if it meets lowercase a-z
    if not re.search(r'[a-z]', password):
        print("Invalid Password: Password should contain at least one lowercase letter (a-z).")
        return False
    
    #checking to see if it meets uppercase a-z
    if not re.search(r'[A-Z]', password):
        print("Invalid Password: Password should contain at least one uppercase letter (A-Z).")
        return False
    
    #check if the password contains at least one special character(@, #, %, &, !, $, etc.)
    if not re.search(r'[@#%&!$]', password):
        print("Invalid Password: Password should contain at least one special character (@, #, %, &, !, $, etc.).")
        return False
     
    return True
    
    #test function
password = input("Enter your password: ")
if isValid(password):
    print("Password is valid.")
else:
    print("Password is not valid.")
   
