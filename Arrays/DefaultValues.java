public class DefaultValues {

    public static void main(String[] args) {
        // Declare and initialize arrays for different data types
        int[] num = new int[2];
        double[] bigNum = new double[2];
        char[] character = new char[2];
        boolean[] booleanStatus = new boolean[2];
        String[] list = new String[2];

        // Print default values for int array
        System.out.println("Default values for int array:");
        for (int i = 0; i < num.length; i++) {
            System.out.println("intArray[" + i + "]: " + num[i]);
        }

        // Print default values for double array
        System.out.println("\nDefault values for double array:");
        for (int i = 0; i < bigNum.length; i++) {
            System.out.println("doubleArray[" + i + "]: " + bigNum[i]);
        }

        // Print default values for char array
        System.out.println("\nDefault values for char array:");
        for (int i = 0; i < character.length; i++) {
            // Display the char value and its Unicode value to highlight default behavior
            System.out.println("charArray[" + i + "]: " + character[i] );
        }

        // Print default values for boolean array
        System.out.println("\nDefault values for boolean array:");
        for (int i = 0; i < booleanStatus.length; i++) {
            System.out.println("booleanArray[" + i + "]: " + booleanStatus[i]);
        }

        // Print default values for String array
        System.out.println("\nDefault values for String array:");
        for (int i = 0; i < list.length; i++) {
            System.out.println("stringArray[" + i + "]: " + list[i]);
        }
    }
}
