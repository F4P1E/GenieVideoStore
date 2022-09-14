package rmit.team7.teamproject.genievideostore;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public interface SystemMethods {
    public static void takeInCustomerDocument(ArrayList<Customer> customerList, ArrayList<Item> itemList) throws IOException {
        Path path;
        path = Paths.get("./database/customers.txt");
        long count = Files.lines(path).count();

        for (int i = 0; i < count; i++) {
            String line = Files.readAllLines(path).get(i);

            if (!line.trim().equals("")) {
                int customerIndexCount = 0;
                String[] cusProfile = line.split(",");

                if (cusProfile[0].matches("^C")) {
                    customerList.add(new Customer(cusProfile[0], cusProfile[1], cusProfile[2], cusProfile[3], Integer.parseInt(cusProfile[4]), cusProfile[5], cusProfile[6], cusProfile[7]));
                    customerIndexCount++;
                } else if (cusProfile[0].matches("^I")) {
                    customerList.get(customerIndexCount).getListOfRentedItems().add(itemFinder(cusProfile[0], itemList));
                }
            }
        }

        if (customerList.size() != count)
            System.out.println("Error in generating customer list: Number of customer generated is not equal to number of lines counted in customers.txt file");
    }

    public static void takeInItemDocument(ArrayList<Item> itemList) throws IOException {
        Path path = Paths.get("./database/items.txt");
        long count = Files.lines(path).count();

        for (int i = 0; i < count; i++) {
            String line = Files.readAllLines(path).get(i);
            String[] itemProfile = line.split(",");

            if (!line.trim().equals("")) {
                itemList.add(new Item(itemProfile[0], itemProfile[1], itemProfile[2], itemProfile[3], itemProfile[4], Double.parseDouble(itemProfile[5]), itemProfile[6]));
            }
        }

        if (itemList.size() != count)
            System.out.println("Error in generating item list: Number of items generated is not equal to number of lines counted in Items.txt file");
    }

    public static Item itemFinder(String itemID, ArrayList<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            if (itemID == items.get(i).getItemID()) {
                return items.get(i);
            }
        }

        return null;
    }
}
