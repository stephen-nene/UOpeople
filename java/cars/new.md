### **Java Programming Question: Vehicle Information System**  

---
  
### **Problem Statement:**  
You have been hired by a **car rental agency** to develop a **Vehicle Information System** that manages different types of vehicles, including **cars, motorcycles, and trucks**. The system should enforce a common structure using **interfaces** and provide a way for users to create and manage vehicle details interactively.  

Your task is to **design and implement the system using Java OOP concepts**, ensuring that each vehicle type adheres to a **consistent contract** while also having **unique attributes and behaviors**.  

---
  
### **Requirements:**
  
#### **1️⃣ Interface Design**  
You must create and implement the following **interfaces**:  

1. **Vehicle (Base Interface)**  
   - Methods to retrieve the **make, model, and year of manufacture** of a vehicle.  
     
2. **CarVehicle (Extends Vehicle)**  
   - Methods to **set and retrieve** the **number of doors** and **fuel type** (`petrol`, `diesel`, `electric`).  

3. **MotorVehicle (Extends Vehicle)**  
   - Methods to **set and retrieve** the **number of wheels** and **motorcycle type** (`sport`, `cruiser`, `off-road`).  

4. **TruckVehicle (Extends Vehicle)**  
   - Methods to **set and retrieve** the **cargo capacity** (in tons) and **transmission type** (`manual`, `automatic`).  

---
  
#### **2️⃣ Class Implementation**
  
Create **three classes** that implement the respective interfaces:  

- **Car** (Implements `CarVehicle`)  
  - Stores details like **make, model, year, number of doors, and fuel type**.  

- **Motorcycle** (Implements `MotorVehicle`)  
  - Stores details like **make, model, year, number of wheels, and motorcycle type**.  

- **Truck** (Implements `TruckVehicle`)  
  - Stores details like **make, model, year, cargo capacity, and transmission type**.  

Each class should provide **constructors, getters, setters, and a `displayDetails()` method** that prints all information about the vehicle.  

---
  
#### **3️⃣ Main Program**
  
- The main program should:
  1. Allow the **user to input vehicle details** interactively.  
  2. Create objects for **Car, Motorcycle, and Truck** based on user input.  
  3. Store these objects in a **list**.  
  4. Provide an option to **display all vehicles** stored in the system.  
  5. Include **error handling** to manage incorrect inputs gracefully.  

---
  
### **Evaluation Criteria:**  
Your submission will be evaluated based on:  
✅ **Interface Design:** Proper contract for vehicle attributes and behaviors.  
✅ **Class Implementation:** Correct translation of interfaces into concrete classes.  
✅ **Main Program Functionality:** User-friendly interaction and proper object management.  
✅ **Code Quality:** Readable, maintainable, and follows Java best practices.  
✅ **Error Handling:** Prevents crashes and handles invalid inputs gracefully.  
✅ **Documentation:** Clear explanations of classes and methods for easy understanding.  

---
  
### **Expected Output Example:**
```
Welcome to the Vehicle Information System!
Select a vehicle type to add:
1. Car
2. Motorcycle
3. Truck
4. Display all vehicles
5. Exit
Enter your choice: 1

Enter Car Make: Toyota
Enter Car Model: Corolla
Enter Manufacturing Year: 2020
Enter Number of Doors: 4
Enter Fuel Type (Petrol/Diesel/Electric): Petrol

Car added successfully!

[Repeats for Motorcycle and Truck]

Displaying all vehicles:
1. Car - 2020 Toyota Corolla, 4 doors, Petrol
2. Motorcycle - 2021 Yamaha R3, 2 wheels, Sport
3. Truck - 2019 Ford F-150, 5 tons, Automatic
```

---
  
Would you like me to provide a **Java implementation** for this problem? 🚀