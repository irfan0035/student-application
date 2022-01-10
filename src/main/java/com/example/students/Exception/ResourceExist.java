package com.example.students.Exception;

public class ResourceExist extends RuntimeException{
    public ResourceExist(String msg)
    {
        super(msg);
    }
}
