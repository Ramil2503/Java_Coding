package Final_Task;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Notebook> notebooks = createNotebooks();

        Map<Integer, Object> filterCriteria = getFilterCriteriaFromUser();

        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filterCriteria);

        displayNotebooks(filteredNotebooks);
    }

    private static Set<Notebook> createNotebooks() {
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook("Brand 1", 8, 512, "MacOs", "Black"));
        notebooks.add(new Notebook("Brand 2", 16, 1024, "Linux", "Silver"));
        notebooks.add(new Notebook("Brand 3", 8, 256, "Windows", "White"));
        notebooks.add(new Notebook("Brand 4", 16, 512, "Windows", "Black"));
        return notebooks;
    }

    private static Map<Integer, Object> getFilterCriteriaFromUser() {
        Map<Integer, Object> filterCriteria = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number corresponding to the filter criterion:");
        System.out.println("1 - RAM");
        System.out.println("2 - Storage Capacity");
        System.out.println("3 - Operating System");
        System.out.println("4 - Color");

        int criteriaNumber = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character

        while (criteriaNumber >= 1 && criteriaNumber <= 4) {
            switch (criteriaNumber) {
                case 1:
                    System.out.print("Enter the minimum RAM size (in gb): ");
                    int minRAM = scanner.nextInt();
                    filterCriteria.put(1, minRAM);
                    break;
                case 2:
                    System.out.print("Enter the minimum storage capacity (in gb): ");
                    int minStorageCapacity = scanner.nextInt();
                    filterCriteria.put(2, minStorageCapacity);
                    break;
                case 3:
                    System.out.print("Enter the operating system: ");
                    String operatingSystem = scanner.nextLine();
                    filterCriteria.put(3, operatingSystem);
                    break;
                case 4:
                    System.out.print("Enter the color: ");
                    String color = scanner.nextLine();
                    filterCriteria.put(4, color);
                    break;
            }
            System.out.print("Enter the number corresponding to the next filter criterion (or 0 to apply this filter): ");
            criteriaNumber = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character
        }
        scanner.close();
        return filterCriteria;
    }

    private static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<Integer, Object> filterCriteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>(notebooks);

        for (Map.Entry<Integer, Object> entry : filterCriteria.entrySet()) {
            int criteriaNumber = entry.getKey();
            Object criteriaValue = entry.getValue();

            switch (criteriaNumber) {
                case 1:
                    filteredNotebooks.removeIf(notebook -> notebook.getRAM() < (int) criteriaValue);
                    break;
                case 2:
                    filteredNotebooks.removeIf(notebook -> notebook.getStorageCapacity() < (int) criteriaValue);
                    break;
                case 3:
                    filteredNotebooks.removeIf(notebook -> !notebook.getOperatingSystem().equalsIgnoreCase((String) criteriaValue));
                    break;
                case 4:
                    filteredNotebooks.removeIf(notebook -> !notebook.getColor().equalsIgnoreCase((String) criteriaValue));
                    break;
            }
        }

        return filteredNotebooks;
    }

    private static void displayNotebooks(Set<Notebook> notebooks) {
        if (notebooks.isEmpty()) {
            System.out.println("No notebooks matching the filter criteria were found.");
        } else {
            System.out.println("\nFiltered notebooks:");
            for (Notebook notebook : notebooks) {
                System.out.println("Brand: " + notebook.getBrand());
                System.out.println("RAM: " + notebook.getRAM() + " GB");
                System.out.println("Storage Capacity: " + notebook.getStorageCapacity() + " GB");
                System.out.println("Operating System: " + notebook.getOperatingSystem());
                System.out.println("Color: " + notebook.getColor());
                System.out.println();
            }
        }
    }
}
