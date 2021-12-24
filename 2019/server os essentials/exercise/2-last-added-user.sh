#!/bin/bash --

# Opgave:
# Schrijf een script oef2.sh dat controleert of je de laatst
# toegevoegde user bent.
# Mogelijke output:
# student@desktop:~/bin$ ./oef2.sh
# Ik ben student en ben niet de laatst toegevoegde user.
# De laatst toegevoegde user is testuser.
# student@desktop:~/bin$ su - testuser
# Password:
# testuser@desktop:~$ /home/student/bin/oef2.sh
# Ik ben testuser en ben de laatst toegevoegde user.

# oefening:
vLastAddedUser=$(sudo tail -n 1 /etc/passwd | cut -d ":" -f 1)

echo -n "Ik ben $USER en ik ben "
if [ $vLastAddedUser = $USER ]
then
    echo "de laatst toegevoegde user"
else
    echo "niet de laatst toegevoegde user"
    echo "De laatst toegevoegde user is $vLastAddedUser"
fi
