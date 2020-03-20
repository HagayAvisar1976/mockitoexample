package com.in28minutes.tests.busniess;

import com.in28minutes.busniess.TodoBusinessImpl;
import com.in28minutes.services.TodoService;
import com.in28minutes.tests.services.TodoServiceStub;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplTests {

    @Test
    public void testUsingStub()
    {
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(new TodoServiceStub());

        List<String> list = todoBusiness.retrieveTodosRelatedToSpring("bla");

        Assert.assertEquals(1,list.size());
    }

    @Test
    public void testUsingMock()
    {
        TodoService todoServiceMock = mock(TodoService.class);
        when(todoServiceMock.retrieveTodos(anyString())).thenReturn(Arrays.asList("1","2","Spring","4"));

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceMock);

        List<String> list = todoBusiness.retrieveTodosRelatedToSpring("bla");

        Assert.assertEquals(1,list.size());
    }
}
