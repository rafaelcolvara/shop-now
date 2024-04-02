import json
import random
import string

def generate_random_string(length):
    return ''.join(random.choices(string.ascii_lowercase, k=length))

def generate_random_email():
    username_length = random.randint(5, 15)
    domain_length = random.randint(5, 10)
    return f"{generate_random_string(username_length)}-{generate_random_string(domain_length)}@gmail.com"

def generate_random_record():
    username = generate_random_string(8) + 'ri' + generate_random_string(1)
    password = ''.join(random.choices(string.digits, k=4))
    email = generate_random_email()
    full_name = generate_random_string(random.randint(5, 10))
    return {
        "username": username,
        "password": password,
        "email": email,
        "fullName": full_name
    }

# Generate 100,000 records
num_records = 100000
output_file = 'user-files/resources/usuarios.tsv'

with open(output_file, 'w') as f:
    for _ in range(num_records):
        record = generate_random_record()
        json.dump(record, f)
        f.write('\n')
