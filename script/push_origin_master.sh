#!/bin/bash
# push  to  master branch remote repository

echo "* Checkout local  master "
git checkout master
echo "* Push  changes into  remote  origin/master"
git push origin master

read -rp "* Done. Press any key to continue..." key  
