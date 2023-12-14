#!/bin/bash

# An array of cowsay styles
cowsaystyles=("apt" "bud-frogs" "bunny" "calvin" "cheese" "cock" "cower" "daemon" "default" "dragon" "dragon-and-cow" "duck" "elephant" "elephant-in-snake" "eyes" "flaming-sheep" "fox" "ghostbusters" "gnu" "hellokitty" "kangaroo" "kiss" "koala" "kosh" "luke-koala" "mech-and-cow" "milk" "moofasa" "moose" "pony" "pony-smaller" "ren" "sheep" "skeleton" "snowman" "stegosaurus" "stimpy" "suse" "three-eyes" "turkey" "turtle" "tux" "unipony" "unipony-smaller" "vader" "vader-koala" "www")

# Select a random cowsay style
random_cowsay_style=${cowsaystyles[$RANDOM % ${#cowsaystyles[@]}]}

# Check if an argument is provided
if [ $# -eq 0 ]; then
    echo "Usage: $0 <filename>"
    exit 1
fi

# Get the filename from the argument
filename="$1"

# Check if the file has a .java extension
if [[ ! "$filename" =~ \.java$ ]]; then
    cowsay -f "$random_cowsay_style" "Wrong file type. Please provide a .java file."
    exit 1
fi

# Extract the class name without the .java extension
class_name=$(basename "$filename" .java)

# Compile the Java file
javac "$filename"

# Check if compilation was successful
if [ $? -eq 0 ]; then
    # Run the Java program
    java "$class_name"
    
    # Clean up .class files
    rm -f "$class_name.class"
else
    cowsay -f "$random_cowsay_style" "Compilation failed. Please check your code."
fi
