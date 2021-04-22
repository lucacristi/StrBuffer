import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StrBufferTest {

    @Test
    public void GivenAnArrayReference_WhenInstantiatingArray_ThenArraySizeIsZero(){
        //Given
        int emptyArraySize = 0;
        StrBuffer strBuffer;

        //When
        strBuffer = new StrBuffer();

        //Then
        assertEquals(strBuffer.size(), emptyArraySize);
    }

    @Test
    public void GivenAnArray_WhenInstantiatingArrayOfGivenSize_ThenArraysSizeIsTheGivenSize(){
        //Given
        int givenArraySize = 25;
        StrBuffer strBuffer;

        //When
        strBuffer = new StrBuffer(givenArraySize);

        //Then
        assertEquals(strBuffer.size(), givenArraySize);
    }

    @Test
    public void GivenAnArray_WhenInstantiatingArrayOfNegativeSize_ThenArraysSizeIsZero(){
        //Given
        int negativeArraySize = -1;
        StrBuffer strBuffer;

        //When
        strBuffer = new StrBuffer(negativeArraySize);

        //Then
        assertEquals(strBuffer.size(), 0);
    }

    @Test
    public void GivenAnArray_WhenAddingElement_ThenArraySizeGrows(){
        //Given
        int initialSize = 0;
        int finalSize = initialSize + 1;

        StrBuffer strBuffer = new StrBuffer();

        //When
        strBuffer.addString("New String");

        //Then
        assertEquals(strBuffer.size(), finalSize);
    }

    @Test
    public void GivenAnArray_WhenAddingMoreElement_ThenArraySizeIsGrowsWithNumberOfAddedElements(){
        //Given
        int noAddedElements = 5;
        StrBuffer strBuffer = new StrBuffer();

        //When
        for(int i = 0; i < noAddedElements; i++){
            strBuffer.addString("New String");
        }

        //Then
        assertEquals(strBuffer.size(), noAddedElements);
    }

    @Test
    public void GivenEmptyArray_WhenAddingElement_ThenFirstElementIsTheInsertedOne(){
        //Given
        String addedString = "Test String";
        StrBuffer strBuffer = new StrBuffer();

        //When
        strBuffer.addString(addedString);

        //Then
        assertEquals(strBuffer.elementAt(0), addedString);
    }
    
    @Test
    public void GivenArrayOf3Elements_WhenQueryingMidElement_ThenSecondElementIsReturned(){
        //Given
        String string1 = "string1";
        String string2 = "string2";
        String string3 = "string3";
        int string2Index = 1;
        StrBuffer strBuffer = new StrBuffer();

        //When
        strBuffer.addString(string1);
        strBuffer.addString(string2);
        strBuffer.addString(string3);

        //Then
        assertEquals(strBuffer.elementAt(string2Index), string2);
    }

    @Test
    public void GivenArrayWith1Element_WhenDeletingTheElement_ThenElementIsReturnANdArraySizeIsZero(){
        //Given
        int finalArraySize = 0;
        String expectedString = "Test";

        StrBuffer strBuffer = new StrBuffer();
        strBuffer.addString(expectedString);

        //When
        String receivedString = strBuffer.removeString(0);

        //Then
        assertEquals(expectedString, receivedString);
        assertEquals(strBuffer.size(), finalArraySize);
    }

    @Test
    public void GivenArrayWithMoreElements_WhenDeletingNegativeIndexElement_ThenNullIsReturnedAndArraysSizeIsUnchanged(){
        //Given
        int finalArraySize = 1;
        String expectedString = null;

        StrBuffer strBuffer = new StrBuffer();
        strBuffer.addString("test");

        //When
        String receivedString = strBuffer.removeString(Integer.MIN_VALUE);

        //Then
        assertEquals(expectedString, receivedString);
        assertEquals(strBuffer.size(), finalArraySize);
    }

    @Test
    public void GivenArrayWithMoreElements_WhenDeletingElementOfIndexGreaterThanSize_ThenNullIsReturnedAndArraysSizeIsUnchanged(){
        //Given
        int finalArraySize = 1;
        String expectedString = null;

        StrBuffer strBuffer = new StrBuffer();
        strBuffer.addString("test");

        //When
        String receivedString = strBuffer.removeString(Integer.MAX_VALUE);

        //Then
        assertEquals(expectedString, receivedString);
        assertEquals(strBuffer.size(), finalArraySize);
    }

    @Test
    public void GivenArraysOfMoreElements_WhenQueryingElements_ThenAddedElementsAreReturned(){
        //Given
        List<String> expectedStrings = Arrays.asList("string1", "string2", "string3");

        String string1 = "string1";
        String string2 = "string2";
        String string3 = "string3";

        StrBuffer strBuffer = new StrBuffer();

        //When
        strBuffer.addString(string1);
        strBuffer.addString(string2);
        strBuffer.addString(string3);

        List<String> receivedStrings = Arrays.asList(strBuffer.getAll());

        //Then
        assertEquals(expectedStrings.size(), receivedStrings.size());
        assertEquals(expectedStrings, receivedStrings);
    }
}
