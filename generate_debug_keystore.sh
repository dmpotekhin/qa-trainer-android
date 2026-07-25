#!/bin/bash
# generate_debug_keystore.sh — создаёт debug.keystore для QA Trainer
keytool -genkey -v \
  -keystore debug.keystore \
  -alias androiddebugkey \
  -keyalg RSA -keysize 2048 -validity 10000 \
  -storepass android -keypass android \
  -dname "CN=Android Debug,O=QA Trainer,C=US" \
  -noprompt 2>/dev/null || echo "keytool not found. Copy from ~/.android/debug.keystore"
