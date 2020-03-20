package com.in28minutes.tests.services;

import com.in28minutes.services.TodoService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("1","2","Spring","4");
    }
}
