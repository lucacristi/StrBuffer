import org.junit.Test;

import static org.junit.Assert.*;

public class StrSetTest {
    @Test
    public void GivenASetWith1Element_WhenUnionWithAnotherSetOf1Element_ThenResultingSetContainsBothElements(){
        //Given
        String[] elemntsArray1 = new String[]{"string1"};
        StrSet set1 = new StrSet(elemntsArray1);

        //When
        String[] elemntsArray2 = new String[]{"string2"};
        StrSet set2 = new StrSet(elemntsArray2);

        StrSet receivedSet = set1.union(set2);

        //Then
        StrSet expectedSet =  new StrSet();
        expectedSet.addString("string1");
        expectedSet.addString("string2");

        assertEquals(receivedSet.size(), expectedSet.size());
        assertEquals(receivedSet.getAll(), expectedSet.getAll());
    }

    @Test
    public void GivenASetWithMoreElements_WhenSubstractingAnotherSet_ThenResultingSetContainsElementsOfFirstSetThatAreNotInSecondSet(){
        //Given
        String[] elemntsArray1 = new String[]{"1","2","3","4","5"};
        StrSet set1 = new StrSet(elemntsArray1);

        //When
        String[] elemntsArray2 = new String[]{"2","3"};
        StrSet set2 = new StrSet(elemntsArray2);

        StrSet receivedSet = set1.difference(set2);

        //Then
        StrSet expectedSet =  new StrSet();
        expectedSet.addString("1");
        expectedSet.addString("4");
        expectedSet.addString("5");

        assertEquals(receivedSet.size(), expectedSet.size());
        assertEquals(receivedSet.getAll(), expectedSet.getAll());
    }

    @Test
    public void GivenASetWithMoreElement_WhenCheckingExistenceOfOneElement_ThenResultShouldBeTrue(){
        //Given
        String[] elemntsArray1 = new String[]{"1","2","3","4","5"};
        StrSet set1 = new StrSet(elemntsArray1);

        //When
       boolean receivedResult = set1.contains("3");

        //Then
        assertTrue(receivedResult);
        assertFalse(set1.contains("7"));
    }
}
