Your version of the **Library System** is well-structured, and I can borrow a few good ideas from it to improve the previous implementation. Here are the key takeaways:  

---

### **What I Can Borrow & Improve**
1. **Preloading Books into the Library**  
   - Your version initializes the library with **predefined books** (e.g., *Harry Potter*, *The Hobbit*).  
   - This makes testing **easier** and provides a good **user experience**.  
   - I would add a method to **prepopulate** books.

2. **Better User Interaction (Emojis & Formatting)**  
   - Your program adds **emojis** (📚 ✅ ❌) and **formatted output** for a **more engaging UI**.  
   - I would enhance my implementation by improving **output readability**.

3. **`displayBooks()` Method**  
   - The function **lists available books** in a **formatted table**.  
   - This helps users **easily view available books** before borrowing/returning.  
   - I would **integrate** a `displayBooks()` function in my implementation.

4. **`addQuantity()` and `subtractQuantity()` Methods in `Book` Class**  
   - Your `Book` class has **methods to modify quantity** instead of directly changing the variable.  
   - This improves **encapsulation and code readability**.  
   - I would **apply these helper methods** in my `Book` class.

5. **Using `scanner.next()` Instead of `scanner.nextLine()` for Titles**  
   - Your code uses `scanner.next()` to read **single-word titles**, which **prevents accidental skipping**.  
   - However, for **multi-word titles**, `scanner.nextLine()` is better.  
   - I would modify my input handling to **support both single-word and multi-word titles**.

6. **Error Handling in User Input**  
   - Your program **ensures users enter valid numbers** before processing transactions.  
   - This avoids **crashes due to invalid input**.  
   - I would **integrate improved error handling** when reading integer values.

---

### **What I Would Keep from My Version**
1. **Trimmed Input (`trim()`)**  
   - My version ensures user input is **trimmed (`.trim()`)** to avoid leading/trailing spaces.  
   - I would **keep this approach** to prevent user input errors.

2. **Returning Books Validation**  
   - My version **checks if the book belongs to the library** before accepting returns.  
   - I would **keep this check** to **prevent users from returning books that don’t exist in the library**.

---

### **Final Thought**
I can **merge the best parts of both versions** to make the **library system more user-friendly, robust, and readable**. 🚀