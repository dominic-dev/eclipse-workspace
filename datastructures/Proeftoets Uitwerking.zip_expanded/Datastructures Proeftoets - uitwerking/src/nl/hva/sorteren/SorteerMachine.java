package nl.hva.sorteren;

import java.util.Arrays;

public class SorteerMachine {
  
  private int[] origineel;
  private int[] gesorteerd;
  private int swapCount = 0;
  
  public SorteerMachine() {
    super();
    origineel = null;
    gesorteerd = null;
    swapCount = 0;
  }
  
  public int sorteer1() {
    gesorteerd = Arrays.copyOf(origineel, origineel.length);
    swapCount = 0;
    internetSort1(gesorteerd);
    return ( swapCount );
  }
  
  public int sorteer2() {
    gesorteerd = Arrays.copyOf(origineel, origineel.length);
    swapCount = 0;
    internetSort2(gesorteerd);
    return ( swapCount );
  }
  
  private void internetSort1(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int valueToSort = arr[i];
      int j = i;
      while (j > 0 && arr[j - 1] > valueToSort) {
        arr[j] = arr[j - 1];
        j--;
        swapCount++;
      }
      arr[j] = valueToSort;
    }
  }
  
  public void internetSort2(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int minPos = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minPos]) {
          minPos = j;
        }
      }
      if ( arr[i] > arr[minPos] ) {
        int h = arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = h;
        swapCount++;
      }
    }
  }

  public void setOrigineel(int[] origineel) {
    this.origineel = origineel;
  }

  public int[] getOrigineel() {
    return origineel;
  }

  public int[] getGesorteerd() {
    return gesorteerd;
  }

  public int getSwapCount() {
    return swapCount;
  }
}
