public class TryCatchArray {
    public static void main(String[] args) {
        int [] numbers = {10,20,30,40,50};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("intArray[" + i + "]: " + numbers[i]);
                        
        }
        try {
            System.out.println(numbers[6]);
            } 
        catch ( ArrayIndexOutOfBoundsException e) {
                    System.out.println(" Caught bad:"+ e.getMessage());
                    }

        
    }   
}

