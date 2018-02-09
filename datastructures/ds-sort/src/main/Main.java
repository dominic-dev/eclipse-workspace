package main;

import java.util.Arrays;

public class Main {
    //private final static int SIZE = 1000000;
    private final static int SIZE = 100000;


	public static void main(String[] args) {
        //int[] array = new int[]{
            //4,2,5,3,6,7,9,8,1
        //};
        Main main = new Main();
        int[] array = new int[SIZE];
        int[] array2 = new int[SIZE];
        int[] array3 = new int[SIZE];
        for(int i=0; i<SIZE; i++){
            array[i] = main.randomInt(0, 10);
            array2[i] = main.randomInt(0, 10);
            array3[i] = main.randomInt(0, 10);
        }
        //System.out.println(Arrays.toString(array));
        //main.selectionSort(array);
        //main.selectionSortRecursive(array, 0);
        //main.insertionSort(array);
        //main.insertionSortRecursive(array, 1, 0, 1);

        System.out.println("starting insertion sort");
        long start = System.currentTimeMillis();
        main.insertionSort(array2);
        long duration = System.currentTimeMillis() - start;
        System.out.println("sorted");
        System.out.println("duration (ms): " + duration);

        System.out.println("starting selection sort");
        start = System.currentTimeMillis();
        main.selectionSort(array);
        duration = System.currentTimeMillis() - start;
        System.out.println("sorted");
        System.out.println("duration (ms): " + duration);


        System.out.println("starting merge sort");
        start = System.currentTimeMillis();
        main.mergesort(array3);
        duration = System.currentTimeMillis() - start;
        System.out.println("sorted");
        System.out.println("duration (ms): " + duration);
        //System.out.println(Arrays.toString(array));
        //
        //
        //int[] array1 = new int[]{1,3,5,7,9, 11, 13};
        //int[] array2 = new int[]{2,4,6,8,10,12};
        //int[] array3 = main.merge(array1, array2);
        //System.out.println(Arrays.toString(array3));
	}


    public int randomInt(int min, int max){
        return (int) (Math.random() * (max-min) + min);
    }


    public void selectionSort(int[] array){
        int pointer = 0;
        for(int i=0; i < array.length ; i++){
            int smallestIndex = pointer;
            for(int j=pointer; j<array.length; j++){
                if (array[j] < array[smallestIndex]){
                    smallestIndex = j;
                    break;
                }
            }
            swap(array, pointer, smallestIndex);
            //int cache = array[pointer];
            //array[pointer] = array[smallestIndex];
            //array[smallestIndex] = cache;
            pointer++;
        }
    }

    public void selectionSortRecursive(int[] array, int pointer){
        // TODO
        if(pointer == array.length - 1){
            return;
        }

        int smallestIndex = pointer;
        for(int i=pointer; i<array.length; i++){
            if (array[i] < array[smallestIndex]){
                smallestIndex = i;
                break;
            }
        }
        swap(array, pointer, smallestIndex);
        //int cache = array[pointer];
        //array[pointer] = array[smallestIndex];
        //array[smallestIndex] = cache;
        selectionSortRecursive(array, ++pointer);
    }

    public void insertionSort(int[] array){
        for(int i=1; i<array.length; i++){
            // Insert into sorted part
            for(int j=0; j<i; j++){
                if(array[i] < array[j]){
                    int cache = array[i];
                    for(int k=i-1; k>=j; k--){
                        swap(array, k, k+1);
                    }
                    array[j] = cache;
                    break;
                }
            }
        }
    }

    public void insertionSortRecursive(int[] array, int i, int j, int pointer){
        // TODO
        if(array[i] < array[j]){
            int cache = array[i];
            shift(array, i-1, j);
            array[j] = cache;
            i++;
            pointer++;
        }
        else{
            j++;
        }
        if(j == pointer){
            j=0;
            i++;
            pointer++;
        }
        if(i < array.length){
            insertionSortRecursive(array, i, j, pointer);
        }
    }

    public void shift(int[] array, int start, int end){
        for(int k=start; k>=end; k--){
            swap(array, k, k+1);
        }
    }



    public void swap(int[] array, int i1, int i2){
        int cache = array[i1];
        array[i1] = array[i2];
        array[i2] = cache;
    }

    public void mergesort(int[] array){
        int[] result = mergesort(array, 0, array.length-1);
        for(int i=0; i<result.length; i++){
            array[i] = result[i];
        }
    }

    public int[] mergesort(int[] array, int start, int end){
        int middle = (start + end) / 2;
        if(end - start == 1){
            return merge(new int[]{array[start]}, new int[]{array[end]});
        }
        if(end - start == 0){
            return new int[]{array[start]};
        }
        return merge(mergesort(array, start, middle), mergesort(array, middle+1, end));
    }

    public int[] merge(int[] array1, int[] array2){
        int[] result = new int[array1.length + array2.length];
        //System.out.println(Arrays.toString(array1));
        //System.out.println(Arrays.toString(array2));
        int counter1 = 0;
        int counter2 = 0;

        for(int i=0; i<result.length; i++){
            if(counter1 >= array1.length){
                result[i] = array2[counter2++];
                continue;
            }
            else if(counter2 >= array2.length){
                result[i] = array1[counter1++];
                continue;
            }
            if(array1[counter1] < array2[counter2]){
                result[i] = array1[counter1++];
            }
            else {
                result[i] = array2[counter2++];
            }
        }
        return result;
    }
}
