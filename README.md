# 🧩 Java Desktop Toolkit – File Manager & Fractal Visualizer

![Java](https://img.shields.io/badge/Java-17-blue)
![GUI](https://img.shields.io/badge/GUI-AWT%20%7C%20Swing-green)
![ZIP](https://img.shields.io/badge/ZIP-Compression-orange)
![Status](https://img.shields.io/badge/Status-Completed-success)

---


## 🧠 About the Project

This project is a Java desktop application that combines:

* 🗂️ File management operations (GUI-based)
* 📦 ZIP compression & extraction
* 🎨 Fractal visualization (recursive graphics)

It demonstrates both system-level programming and graphical rendering concepts.

---

## 🔧 Features

### 📁 File Manager (AWT Interface)

* List contents of partitions:

  * `C:\`
  * `F:\`
* Display results inside a text area
* Simple GUI using AWT components (Frame, Panel, Button, TextArea)

---

### 📦 ZIP Operations

* Archive (compress) files into `.zip`
* Extract ZIP files to selected directory
* File selection using `FileDialog`

```java
fisier.Arhivare(path);
fisier.Dezarhivare(zipPath, destination);
```

---

### 🎨 Fractal Generator (Swing)

* Recursive hexagonal fractal
* Drawn using `Graphics2D`
* Adjustable recursion depth (`acuratete`)
* Automatically centered and scaled

---

## 🖥️ Technologies Used

* **AWT** → main GUI (buttons, layout, dialogs)
* **Swing** → fractal rendering
* **Java IO** → file handling
* **ZIP Streams** → compression/decompression
* **Recursion** → fractal generation

---

## 📁 Project Structure

```
📦 Java-Desktop-Toolkit
 ┣ 📂 images
 ┃ ┣ app.png
 ┃ ┗ fractal.png
 ┣ 📜 Interfata.java
 ┣ 📜 fisier.java
 ┣ 📜 Fractal.java
 ┣ 📜 InterfataFractal.java
 ┗ 📜 README.md
```

---

## 🧠 Concepts Used

* Event-driven programming (`ActionListener`)
* File handling (`File`, `FileInputStream`)
* ZIP processing (`ZipInputStream`, `ZipOutputStream`)
* Recursion (fractal)
* 2D Graphics (`Graphics2D`)
* GUI development (AWT & Swing)

---

## 📌 Notes

* Works best on Windows (uses paths like `C:\`, `F:\`)
* Educational project covering:

  * file systems
  * GUI programming
  * recursion

---


## 👨‍💻 Author

**Stefan Virlan**

---

