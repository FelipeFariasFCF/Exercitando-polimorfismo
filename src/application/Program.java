package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		List<Product> list = new ArrayList<>();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char resposta = sc.next().charAt(0);

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (resposta == 'i') {
				System.out.print("Customs fee: ");
				double custom = sc.nextDouble();
				list.add(new ImportedProduct(name, price, custom));
			} else if (resposta == 'u') {
				System.out.println("Manufacture data (dd/mm/yyyy): ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			} else if(resposta == 'c'){
				list.add( new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("Price tags:");
		for(Product p: list) {
			System.out.println(p.priceTag());
		}

		sc.close();
	}
}