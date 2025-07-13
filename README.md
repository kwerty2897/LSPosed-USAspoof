# 🗽 USASpoof – Xposed SIM Spoofing Module

**USASpoof** is a minimal [LSPosed](https://github.com/LSPosed/LSPosed) module that spoofs SIM card and network info to make any app believe your device is using a U.S. carrier.

---

## ✨ Features

- No UI, no settings – just install and enable.
- Two branches available:
  - `main`: global spoofing for all apps.
  - `tiktok-only`: spoofing applies to **TikTok only** (```com.zhiliaoapp.musically```).

---

## ⚙️ Requirements

* Rootless ([LSPatch](https://github.com/LSPosed/LSPatch)) or Rooted Android device
* Xposed framework (LSPosed or EdXposed)
* Android 5.0+ (API level 21 or higher)

---

## 🛠️ Build Instructions

1. Clone the repo:

```bash
git clone https://github.com/yourusername/USASpoof.git
cd USASpoof
```

2. Build APK:

```bash
./gradlew assembleRelease
```

3. (Optional) Sign the APK:

---

## 🔐 Disclaimer

> This module is for educational and testing purposes only.
> You are solely responsible for how you use it.

---
