package com.example.students.Exception;

public class ResourseNotFound extends RuntimeException{
    public ResourseNotFound(String msg)
    {
        super(msg);
    }
}
