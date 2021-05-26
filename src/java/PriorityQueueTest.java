import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.PriorityQueue;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;



public class PriorityQueueTest {
    static Stream<Arguments> stringIntAndListProvider(){
        //  return stream
        return Stream.of(
                arguments(new int[]{3,1,2},new int[] {1,2,3}),
                arguments(new int[]{3,9,6,4},new int[] {3,4,6,9}),
                arguments(new int[]{3,7,2,5},new int[] {2,3,5,7}),
                arguments(new int[]{9,0,1,2},new int[] {0,1,2,9}),
                arguments(new int[]{5,4,3,2,1},new int[] {1,2,3,4,5})
        );
    }

    public void PriorityQueue_RunTest(int [] random_array,int[] correct_array){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int [] result = new int[random_array.length];
        for (int i =0 ; i<random_array.length;i++){
            test.add(random_array[i]);
        }
        //random_array add to priorityqueue   get result
        for(int i =0 ; i< random_array.length;i++){
            result[i] = test.poll();

        }
        assertArrayEquals(correct_array,result);
    }


    public void InitialCapacityTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(-1, null);
        });
    }

    public void OfferTest(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            new PriorityQueue().offer(null);
        });
    }


    public void ForEachRemainingTest(){
        Exception exception = assertThrows(NullPointerException.class, () ->{
            new PriorityQueue().forEach(null);
        });
    }
}
