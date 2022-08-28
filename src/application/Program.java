package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner read = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.println("Enter the number of products: ");
        int n = read.nextInt();

        for (int i = 1; i>= n; i++ ){

            System.out.println("Product #" + i + "data:");
            System.out.println("Common, used or imported (c/u/i)?");
            char requisition = read.next().charAt(0);
            System.out.print("Name: ");
            String name = read.nextLine();
            System.out.print("Price: ");
            double price = read.nextDouble();
            read.nextLine();

            if (requisition == 'c'){

                list.add( new Product(name, price));

            } else if (requisition == 'i') {

                System.out.print("Customs fee: ");
                double customsFee = read.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));

            }else if (requisition == 'u'){

                System.out.println("Manufacture date (DD/MM/YYYY): ");
                Date date = sdf.parse(read.next());
                list.add(new UsedProduct(name, price, date));

            }
            System.out.println();
            System.out.println("PRICE TAGS:");
            for (Product prod : list) {
                System.out.println(prod.priceTag());
            }


        }



    }

}
