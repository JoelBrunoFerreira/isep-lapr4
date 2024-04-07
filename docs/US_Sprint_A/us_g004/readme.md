# US G004

## 1. Context

*As Project Manager, I want the team to setup a continuous integration server.*

## 2. Requirements

*GitHub Actions/Workflows should be used.*

## 3. Analysis

The team develop two jobs. The first job to build the project and the second job to run Unit tests. 

## 4. Design

### 4.1. Realization

*NA*

### 4.2. Class Diagram

*NA*

### 4.3. Applied Patterns

*NA*

### 4.4. Tests

*NA*

## 5. Implementation

    name: Java CI with Maven

on:
workflow_dispatch:
push:
branches:
- main

jobs:

build:  # --> First job
runs-on: ubuntu-latest

    steps:
    - run: |
        echo "The job was automatically triggered by a ${{ github.event_name }} event."
        echo "This job is now running on a ${{ runner.os }} server hosted by GitHub!"

    - name: Checkout the repository
      uses: actions/checkout@v4

    - name: Set up JDK 21
      uses: actions/setup-java@v4
      with:
        java-version: '21'
        distribution: 'temurin'
        cache: maven

    - name: Build with Maven
      run: mvn -B compile --file pom.xml

test: # --> Second job
runs-on: ubuntu-latest
needs: [ build ]

    steps:
    - name: Checkout the repository
      uses: actions/checkout@v4

    - name: Set up JDK 21
      uses: actions/setup-java@v4
      with:
        java-version: '21'
        distribution: 'temurin'
        cache: maven

    - name: Cache Maven packages
      uses: actions/cache@v4
      with:
        path: ~/.m2
        key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
        restore-keys: ${{ runner.os }}-m2

    - name: Run tests with Maven
      run: mvn -B test --file pom.xml

## 6. Integration/Demonstration

*NA*

## 7. Observations

*NA*
