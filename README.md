# Project Name

Project description goes here.

## Table of Contents
- [Introduction](#introduction)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)

## Introduction

Briefly describe the purpose of the project and its main features.

## Technologies

- [Jetpack Compose](https://developer.android.com/jetpack/compose): Modern Android UI toolkit.
- [Kotlin](https://kotlinlang.org/): Official programming language for Android development.
- [Dagger Hilt](https://dagger.dev/hilt/): Dependency injection library for Android.
- [Retrofit](https://square.github.io/retrofit/): Type-safe HTTP client for Android.

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/amaankhan420/CaseStudy.git

## Project Structure
|-- app
|   |-- src
|       |-- main
|           |-- java/com/example/foodzz
|               |-- di                  # Dagger Hilt modules
|               |-- api                 # For api service
|               |-- viewmodel           # ViewModel for the app
|               |-- viewmodel/modules   # ViewModel Module and Factory
|               |-- reposotory          # Repository for the ViewModel
|               |-- data_classes        # Data classes for state of app
|               |-- composables         # Jetpack Compose UI components
|               |-- components          # Bottom Navigation bar components
|               |-- screens             # Different app screens
|               |-- MainActivity.kt     # Main entry point for the app
|               |-- Foodzz.kt           # Entry point Hilt
|-- build.gradle.kts                    # Project-level Gradle file
|-- settings.gradle.kts                 # Project settings
|-- ...
