package com.in28minutes.tests.busniess;

import com.in28minutes.busniess.TodoBusinessImpl;
import com.in28minutes.services.TodoService;
import com.in28minutes.tests.services.TodoServiceStub;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplUsingMockAnnotationsTests {

    @Mock
    TodoService todoServiceMock;


    @InjectMocks
    TodoBusinessImpl todoBusiness; //same as writing this: TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);


    @Test
    public void testUsingMockWithAnnotation()
    {

        //TodoService todoServiceMock = mock(TodoService.class);
        when(todoServiceMock.retrieveTodos(anyString())).thenReturn(Arrays.asList("1","2","Spring","4"));

        //TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        List<String> list = todoBusiness.retrieveTodosRelatedToSpring("bla");

        Assert.assertEquals(1,list.size());

    }

    @Test
    public void testUsingMockWithOutAnnotations()
    {
        TodoService todoServiceMock1 = mock(TodoService.class);
        when(todoServiceMock1.retrieveTodos(anyString())).thenReturn(Arrays.asList("1","2","Spring","4"));

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock1);

        List<String> list = todoBusiness.retrieveTodosRelatedToSpring("bla");

        Assert.assertEquals(1,list.size());
    }
}
