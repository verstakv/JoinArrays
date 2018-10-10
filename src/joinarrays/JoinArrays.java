package joinarrays;

import java.util.Arrays;

public class JoinArrays {

    public static int[] join(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            System.err.println("joinarrays.JoinArrays.join()"
                    + " Invalid arguments!");
            return null;
        }

        int[] resultArray = new int[array1.length + array2.length];
        int indexArr1 = 0, indexArr2 = 0, indexResultArr = 0;

        while (indexArr1 < array1.length) {
            int num1 = array1[indexArr1];
            
            while (indexArr2 < array2.length) {
                int num2 = array2[indexArr2];
                if (num1 < num2) {
                    resultArray[indexResultArr++] = num1;
                    break;
                } else {
                    resultArray[indexResultArr++] = num2;
                    indexArr2++;
                }
            }

            if (indexArr2 == array2.length) {
                break;
            } else {
                indexArr1++;
            }
        }

        if (indexArr1 == array1.length) {
            System.arraycopy(array2, indexArr2, resultArray, indexResultArr, resultArray.length - indexResultArr);
        } else if (indexArr2 == array2.length) {
            System.arraycopy(array1, indexArr1, resultArray, indexResultArr, resultArray.length - indexResultArr);
        }
        
        return resultArray;
    }

}
