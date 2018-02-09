package practicum6;


public class RandomSet {
    public int[] numbers;

    public RandomSet(int rangeMin, int rangeMax, int size){
        numbers = new int[size];
        for (int i=0; i < size ; i++){
            int candidateNumber = 0;

            // Prevent duplicates
            while (this.contains(candidateNumber)){
                candidateNumber = (int) (Math.random() * (rangeMax - rangeMin + 1));
            }
            numbers[i] = candidateNumber;
        }

    }

    public boolean contains(int number){
        return Helper.arrayHasInt(numbers, number);
    }

}
