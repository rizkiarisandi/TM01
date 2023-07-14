import java.util.Scanner;

public class laptop {
    private static void displayData(modellaptop[] laptops) {
        for (modellaptop laptop : laptops) {
            System.out.println(laptop);
        }
        System.out.println();
    }

    private static void selectionSort(modellaptop[] laptops) {
        int n = laptops.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (laptops[j].getRating() < laptops[minIndex].getRating()) {
                    minIndex = j;
                }
            }
            modellaptop temp = laptops[minIndex];
            laptops[minIndex] = laptops[i];
            laptops[i] = temp;
        }
    }

    private static double getUserInput() {
            System.out.print("Masukkan rating yang ingin Anda cari: ");
            try {
                Scanner scanner = new Scanner(System.in);
                return scanner.nextDouble();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            return-1;
    }

}
