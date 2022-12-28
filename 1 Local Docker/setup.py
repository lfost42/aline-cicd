"""Prepares Aline Financial microservices Docker images by adding 
submodules to each microservice and compile maven packages"""
import os

# Get a list of files
files = os.listdir('.')

# Make a list of microservices
microservices = [file for file in files if file.endswith('microservice')]
microservices.append('aline-gateway')
print(microservices)

# Loop through each microservice to add submodules and compile maven package.
for microservice in microservices:
    os.chdir(microservice)

    # Add git submodules
    os.system("git submodule deinit -f .")
    os.system("git submodule update --init --remote --merge")

    # Move back into parent directory
    current_dir = os.getcwd()
    parent_dir = os.path.abspath(os.path.join(current_dir, '..'))
    os.chdir(parent_dir)
