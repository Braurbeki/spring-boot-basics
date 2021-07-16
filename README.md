# Java Intro Task
## Description
This task is an emulation of the training management system. Key concepts here are:
1. `Grade` - objects of this class represent the grade that student received on the training. 
   It consists of the first and second semester marks. Each mark must not exceed 10 and must be greater or equal to 0.
2. `Student` - objects of this class represent the student that participates in the training. 
   It consists of the student first and last name.
3. `Training` is an interface that declares the main training functionality like adding the student
   to the training, changing the grade, etc.
4. `GlobalLogicTraining` is an implementation of the `Training` class. It is given to you without any 
   method implementations.
   
## Task
Given the information from description and unit test provided with the task, implement the 
training management system's logic and make all unit tests pass.

## List of files allowed to be modified
1. `src/main/java/com/globallogic/basecamp/Student.java`
2. `src/main/java/com/globallogic/basecamp/GlobalLogicTraining.java`

Other files will be restored before the Jenkins build. 

---
Good luck! \
GL BaseCamp Team.