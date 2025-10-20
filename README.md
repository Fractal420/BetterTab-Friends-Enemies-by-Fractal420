# BetterTab – Friends Edition by Fractal420

A fork of [BetterTab by FySjutton](https://github.com/FySjutton/BetterTab), updated for **Minecraft 1.21.1** and extended with a **Friends highlighting feature**.

![Screenshot](https://i.postimg.cc/G356nZpK/Screenshot-20251020-050023.jpg)

---

## 🧩 What’s New
- Added a **Friends system** – highlight friends in the TAB list with green names.  
- Configurable via simple JSON file at:

.minecraft/config/friends.json
Example:

````
{
  "friends": [
    "nickname1",
    "example2",
    "friend3"
  ]
}
````

* Works only with **Minecraft 1.21.1**, **Java 21**, and **Fabric**.

---

## ⚙️ Installation

1. Install **Fabric Loader** and **Fabric API** for 1.21.1
2. (Optional) Add **Mod Menu** + **YACL** for settings
3. Drop the `.jar` into your `mods` folder and launch the game.

---

## 💡 Original BetterTab Features

* Scrollable, non-overlapping player list
* Numerical ping display
* Lightweight and compatible with large servers

---

## 🧱 Build (for developers)

```bash
git clone https://github.com/Fractal420/BetterTab-Friends-Enemies-by-Fractal420.git
cd BetterTab-Friends-Enemies-by-Fractal420
./gradlew build
```

Resulting file: `build/libs/better-tab-friends-enemies-by-fractal420-1.0.0-friends+1.20.5-1.21.x.jar`

---

## 🧑‍💻 Credits

* Original mod: [FySjutton / BetterTab](https://github.com/FySjutton/BetterTab)
* Friends Edition: **Fractal420**
* License: GPL-3.0
