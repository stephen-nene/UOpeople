#!/bin/bash

# Define an array of cowsay styles
cowsaystyles=("apt" "bud-frogs" "bunny" "calvin" "cheese" "cock" "cower" "daemon" "default" "dragon" "dragon-and-cow" "duck" "elephant" "elephant-in-snake" "eyes" "flaming-sheep" "fox" "ghostbusters" "gnu" "hellokitty" "kangaroo" "kiss" "koala" "kosh" "luke-koala" "mech-and-cow" "milk" "moofasa" "moose" "pony" "pony-smaller" "ren" "sheep" "skeleton" "snowman" "stegosaurus" "stimpy" "suse" "three-eyes" "turkey" "turtle" "tux" "unipony" "unipony-smaller" "vader" "vader-koala" "www")

# Pick a random cowsay style
random_cowsay_style=${cowsaystyles[$RANDOM % ${#cowsaystyles[@]}]}

# Function to check if a command exists
check_command() {
    command -v "$1" >/dev/null 2>&1
}

# Function to handle messages (fallback to echo if cowsay is missing)
show_message() {
    local message="$1"
    if check_command "cowsay"; then
        cowsay -f "$random_cowsay_style" "$message"
    else
        echo "$message"
    fi
}

# Function to prompt the user to install missing dependencies
install_dependency() {
    local package_name=$1
    if ! check_command "$package_name"; then
        read -p "$package_name is not installed. Install it now? (y/n): " choice
        case "$choice" in
            y|Y) sudo apt install -y "$package_name" ;;
            *) show_message "Skipping $package_name installation!" ;;
        esac
    fi
}

# Ensure required dependencies are installed
install_dependency "javac"
install_dependency "java"

# Check if a filename was provided
if [ $# -eq 0 ]; then
    show_message "Usage: $0 <filename.java>"
    exit 1
fi

# Get the filename and validate it
filename="$1"
if [[ ! "$filename" =~ \.java$ ]]; then
    show_message "Wrong file type! Please provide a .java file."
    exit 1
fi

# Extract class name (without extension)
class_name=$(basename "$filename" .java)

# Compile the Java file
javac "$filename" 2> error.log
if [ $? -ne 0 ]; then
    show_message "Compilation failed. Check error.log."
    exit 1
fi

# Run the Java program in the background and get its PID
java "$class_name" &
java_pid=$!

# Wait for the Java program (GUI) to finish
wait $java_pid

# Cleanup .class files after Java GUI closes
rm -f "$class_name.class"

show_message "Cleanup complete!"
