package com.in28minutes.tests;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static sun.nio.cs.Surrogate.is;

public class ListTests {

    @Test
    public void test()
    {
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(2).thenReturn(3);

        Assert.assertEquals(2, listMock.size());
        Assert.assertEquals(3, listMock.size());

    }

    @Test
    public void testListSizeInBDD()
    {
        /*
        //Given
        List listMock = mock(List.class);
        given(listMock.size()).willReturn(2);

        //When
        int listSize = listMock.size();

        //Then
        //assertThat(listSize,is(2));
        //assertThat(listSize,is(2));
        */

    }

    @Test(expected = RuntimeException.class)
    public void testAnException()
    {
        List listMock = mock(List.class);

        when(listMock.get(anyInt())).thenThrow(new RuntimeException());

        listMock.get(0);

    }
}
