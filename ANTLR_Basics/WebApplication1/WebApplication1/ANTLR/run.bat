@echo off
chcp 65001 > nul
title Simple Language Interpreter
color 0A

echo.
echo =================================
echo    SIMPLE LANGUAGE INTERPRETER
echo =================================
echo.

echo [1/4] Lösche alte Class-Dateien...
del *.class 2>nul

echo [2/4] Generiere Parser/Lexer von Simple.g4...
java -cp ".\antlr-4.13.2-complete.jar" org.antlr.v4.Tool Simple.g4

if %errorlevel% neq 0 (
    echo FEHLER: ANTLR Generation fehlgeschlagen!
    pause
    exit /b 1
)

echo [3/4] Kompiliere Java-Dateien...
javac -cp ".;.\antlr-4.13.2-complete.jar" *.java

if %errorlevel% neq 0 (
    echo FEHLER: Kompilierung fehlgeschlagen!
    pause
    exit /b 1
)

echo [4/4] Starte Interpreter mit test.simple...
echo.
java -cp ".;.\antlr-4.13.2-complete.jar" SimpleExecutor

echo.
echo ======================
echo    PROGRAMM BEENDET
echo ======================
pause