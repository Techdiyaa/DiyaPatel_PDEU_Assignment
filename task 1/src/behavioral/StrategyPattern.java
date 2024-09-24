package behavioral;

import java.util.Scanner;
import java.util.Arrays;

interface SortingStrategy {
    void sort(int[] array);
}

class BubbleSort implements SortingStrategy {
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
               
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted using Bubble Sort: " + Arrays.toString(array));
    }
}

class QuickSort implements SortingStrategy {
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        System.out.println("Sorted using Quick Sort: " + Arrays.toString(array));
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

class Sorter {
    private SortingStrategy sortingStrategy;

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(int[] array) {
        sortingStrategy.sort(array);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();
            int[] array = new int[size];

            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                while (!scanner.hasNextInt()) {  
                    System.out.println("Please enter a valid integer.");
                    scanner.next(); 
                }
                array[i] = scanner.nextInt();  
            }

            System.out.print("Choose sorting strategy (1: Bubble Sort, 2: Quick Sort): ");
            while (!scanner.hasNextInt()) {  
                System.out.println("Please enter a valid choice (1 or 2).");
                scanner.next();  
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sorter.setSortingStrategy(new BubbleSort());
                    break;
                case 2:
                    sorter.setSortingStrategy(new QuickSort());
                    break;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }

            sorter.sort(array);
        } finally {
         
        }
    }
}
