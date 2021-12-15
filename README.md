# Spring Boot school API

## Grade(class)
* GET localhost:9090/grades
```json
[  
    {  
    "grade_id": 1,  
    "grade_name": "1-A"  
    },  
    {  
    "grade_id": 2,  
    "grade_name": "1-B"  
    }  
]
```
* GET localhost:9090/grades/{grade_id}
```json
{
  "grade_id": 1,
  "grade_name": "1-A"
}
```
* POST localhost:9090/grades
```json
{
  "grade_name": "1-B"
}
```

## Student
* GET localhost:9090/students
```json
[
    {
        "student_id": 1,
        "name": "Peter Parker",
        "age": 11,
        "grade_id": 1
    },
    {
        "student_id": 2,
        "name": "Ilon Mask",
        "age": 12,
        "grade_id": 2
    },
    {
        "student_id": 3,
        "name": "Robert De Niro",
        "age": 10,
        "grade_id": 1
    }
]
```
* GET localhost:9090/students/{student_id}
```json
{
    "student_id": 1,
    "name": "Peter Parker",
    "age": 11,
    "grade_id": 1
}
```
* POST localhost:9090/students
```json
{
    "name": "Peter Parker",
    "age": 11,
    "grade_id": 1
}
```
## Lessons
* GET localhost:9090/students/grade/{grade_id}
```json
["Peter Parker","Robert De Niro"]
```

* POST localhost:9090/lessons
```json
{
  "name": "History",
  "grade_id": 1
}
```
## Marks
* GET localhost:9090/marks/{student_id}
```json
{
  "12-10-2021":{"Russian":"0","Math":"3"},
  "12-02-2021":{"Russian":"0","Math":"0"},
  "12-03-2021":{"Russian":"0","Math":"0"}
}
```
* POST localhost:9090/marks

```json
{
  "val": 4,
  "attended": true,
  "student_id": 1,
  "lesson_id": 2
}
```
## Summary result
* GET localhost:9090/students/result/{student_id}
```json
{
  "Average result":"4.0",
  "Absent":"0"
}
```