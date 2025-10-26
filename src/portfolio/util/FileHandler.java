package portfolio.util;

import portfolio.model.Company;
import java.util.*;
import java.io.*;

public class FileHandler {

    private static final String FILE_NAME = "companies_data.ser";

    public static void saveCompanies(List<Company> companies) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(companies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Company> loadCompanies() {
        List<Company> companies = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            companies = (List<Company>) ois.readObject();
        } catch (Exception e) {
            System.out.println("No saved data found.");
        }
        return companies;
    }
}
