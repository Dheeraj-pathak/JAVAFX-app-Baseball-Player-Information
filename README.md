# ⚾ JavaFX Baseball Player Manager

A visually interactive desktop application to manage and display **baseball player stats**, built using **JavaFX**, **SceneBuilder**, and **MySQL**. It enables searching, analyzing, and managing player data efficiently with dynamic GUI updates.

---

## 🎯 Features

- 📋 **Display All**: View complete list of players with their statistics
- 🔍 **Search Player**: By First Name or Player ID (validated input)
- 🧮 **Minimum/Maximum Batting Score**: Get top and bottom performers instantly
- 🧼 **Clear Table**: One-click reset of data grid

---

## ⚙️ Technologies Used

- **JavaFX**
- **SceneBuilder**
- **MySQL 8+**
- **JDBC (MySQL Connector/J)**
- **Eclipse IDE (2024 Release)**

---

## 🧱 Database Design

**Database Name**: `PlayersDB`  
**Table Name**: `players`

| Column Name      | Data Type     | Description                        |
|------------------|---------------|------------------------------------|
| player_id        | INT (3 digits)| Unique Player ID (101–999)         |
| first_name       | VARCHAR       | Player's First Name                |
| last_name        | VARCHAR       | Player's Last Name                 |
| batting_average  | DOUBLE        | Must be > 0                        |
| position         | VARCHAR       | E.g., Catcher, Pitcher, etc.       |

Populate with at least **5 favorite baseball players**.

✅ *Input Validations:*  
- Player ID must be 3 digits (101–999)  
- Batting average must be positive (> 0)  
- Fields must not be empty

---

## 📂 Project Structure

/src

├── controller/

│ └── PlayersController.java

├── model/

│ └── Player.java

├── dao/

│ └── PlayerDAO.java

└── util/

└── DBUtil.java

/resources

├── Players.fxml

└── application.css

/sql

└── players.sql


---

## 🖼 UI Snapshot

> *Designed using SceneBuilder with a clean TableView, labeled fields, and operational buttons.*  
> *(You may add screenshots to the GitHub repo under `/images` and reference here.)*

---

## 🔧 Setup Instructions

1. Clone the repository.
2. Import into **Eclipse IDE**.
3. Use MySQL to run the `players.sql` script and create/populate the database.
4. Ensure the `mysql-connector-java` JAR is added to the build path.
5. Open and edit `DBUtil.java` with your local DB credentials if necessary.
6. Run Main.java to launch the GUI.

🔄 Alternative Version (No DB)
If you prefer not using MySQL, an alternate version uses a Java collection (e.g., ArrayList) to maintain player records in-memory. This is included for offline/demo use.

💡 Future Enhancements
Add/Edit/Delete player functionality

Export player data to CSV

Dark/light theme toggle

Pagination for large datasets

👨‍💻 Author
Developed and Authored by: Dheeraj Pathak
🎯 JavaFX Enthusiast | Android Developer | AIML Student
🔗 GitHub: @Dheeraj-pathak

📜 License
This project is licensed under the MIT License.

“Simple design. Powerful results. Data made visible.” – Dheeraj Pathak
