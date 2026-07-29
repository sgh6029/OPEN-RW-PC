@echo off
chcp 65001 >nul
title Rusted Warfare - OpenAI Enhanced
cd /d "%~dp0"

echo ========================================
echo   Rusted Warfare - OpenAI Enhanced
echo ========================================
echo.

where java >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERROR] Java not found!
    echo Please install Java 17+ from: https://adoptium.net/
    pause
    exit /b 1
)

echo Starting game...
echo.

java -Xmx2g -Djava.library.path=. -jar "Rusted Warfare Core-1.0-SNAPSHOT-all.jar" %*

if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Game failed to start! Error code: %errorlevel%
    pause
)
