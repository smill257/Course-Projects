# -*- coding: utf-8 -*-
"""
Created on Tue Oct 15 18:36:12 2024

@author: Sam Miller
"""
import hashlib

# Function to rotate bits to the right
def rotateRight(xor_result):
    # Perform right rotate by shifting right and accounting for overflow
    right_rotated = (xor_result >> 1) | ((xor_result & 1) << 7)
    return right_rotated

# Main decryption function
def decrypt_message(encrypted_message):
    # Convert the hexadecimal message into a list of decimal values
    rotated_left_list = []
    
    # Collect decimal values from hexadecimal pairs
    for i in range(0, len(encrypted_message), 2):
        hex_pair = encrypted_message[i:i + 2]
        decimal_value = int(hex_pair, 16)
        rotated_left_list.append(decimal_value)

    # initialize variables for decryption
    Index_Value = 0
    input_chars = []
    encryption_key = [ord('a')]  # ASCII value of 'a' (97)
    
    # processing the first char
    xor_result = rotateRight(rotated_left_list[0]) ^ encryption_key[0]
    input_chars.append(chr(xor_result))  # Convert decimal back to char
    
    # processing chars
    for i in range(1, len(rotated_left_list)):
        rotated_value = rotateRight(rotated_left_list[i])  # reversing the bit rotation
        xor_result = rotated_value ^ rotated_left_list[i - 1]  # XOR with the previous encrypted byte
        input_chars.append(chr(xor_result))  # Convert the result to a character

    # joining the characters to form the final decrypted message
    decrypted_message = ''.join(input_chars)
    return decrypted_message


def find_hash_of_string(input_string):
  
    # encoding the string to bytes using utf-8 encoding
   input_bytes = input_string.encode('utf-8') 
   #update the hash object with the input bytes
   sha256_hash = hashlib.sha256()
   
   #generate the hash object with the input bytes
   sha256_hash.update(input_bytes)
   
   #get the hexadecimal representation of the hash
   hex_digest = sha256_hash.hexdigest()
   
   return hex_digest

if __name__=='__main__':
    #example string to hash
    input_string = "You broke the Blocks"
    
    #find and print the hash
    
    hash_result = find_hash_of_string(input_string)
    print(f'The SHA-256 hash of the string is: {hash_result}')

if __name__ == '__main__':
    # encrypted msg from instructions
    encrypted_message = "703e966d1ed86f08daf503d6678e99eb09d47f18"

    # Decrypt the message
    decrypted_message = decrypt_message(encrypted_message)

    # Output the decrypted message
    print("Decrypted Message:", decrypted_message)
