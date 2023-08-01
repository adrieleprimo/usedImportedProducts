package appplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat dMY = new SimpleDateFormat ("dd/MM/yyyy");
		Scanner sc = new Scanner (System.in);
		List <Product> list = new ArrayList<>();
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for (int i =1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char answer = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String productName = sc.next();
			System.out.print("Price: ");
			Double productPrice = sc.nextDouble();
			if (answer == 'u') {
				System.out.print("Manufacture date (DD/MM/YYY): ");
				Date  productDate = dMY.parse(sc.next());
				list.add(new UsedProduct(productName, productPrice, productDate));
			}
			else if ( answer == 'i') {
				System.out.print("Customs fee: ");
				Double productCustoms = sc.nextDouble();
				list.add(new ImportedProduct(productName, productPrice, productCustoms));
			}
			else {
				list.add(new Product(productName, productPrice));
			}	
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		list.forEach(System.out::print);
		sc.close();
	}
}
