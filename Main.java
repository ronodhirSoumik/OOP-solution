import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Product> productList = new ArrayList<>();
    public static void main(String args[]){
        int option=1;
        Scanner input = new Scanner(System.in);

        Product product;
        String productName;
        int productNum;

        init(); //initially 5 products are added and three of them are sold.

        System.out.println("Welcome. Enter value(1-7) for below actions.\n 1. Add a product.\n 2. Delete a product.\n 3. Buy a product.\n 4. Sell a product.\n 5. See the list of products\n 6. See available balance.\n 7. Exit.\n");
        
        while(option>=1 && option<7){
            System.out.print("Enter your option: ");
            option = input.nextInt();

            switch(option){
                case 1: //Add product
                    System.out.println("Add product details.");
                    System.out.print("Product name: ");
                    productName = input.next();
                    System.out.print("Buying price: ");
                    float buyPrice = input.nextFloat();
                    System.out.print("Selling price: ");
                    float sellPrice = input.nextFloat(); 
                    System.out.print("Number of available product in store: ");
                    productNum = input.nextInt();
                    
                    Product p = new Product();
                    p.setProduct(productName, buyPrice, sellPrice, productNum);
                    productList.add(p);
                    System.out.println(productName + " is added.");
                    break;

                case 2: //Delete product
                    System.out.println("Enter the product name you want to delete.");
                    System.out.print("Product name: ");
                    productName = input.next();

                    product = searchProduct(productName);
                    if(product != null){
                        productList.remove(product);
                        System.out.println(productName + " is deleted.");
                    }
                    break;
                
                case 3: //buy a product
                    System.out.println("Enter the product name and number of items you want to buy.");
                    System.out.print("Product name: ");
                    productName = input.next();
                    System.out.print("Number of product: ");
                    productNum = input.nextInt();

                    product = searchProduct(productName);
                    if(product != null){
                        ProductView view = new ProductView();
                        ProductController controller = new ProductController(product, view);
                        controller.buyProduct(productNum); //buy function from Product class;
                    }
                    break;

                case 4: //sell a product
                    System.out.println("Enter the product name and number of items you want to sell."); //May you should print the current list then say to enter
                    System.out.print("Product name: ");
                    productName = input.next();
                    System.out.print("Number of product: ");
                    productNum = input.nextInt();

                    product = searchProduct(productName);
                    if(product != null){
                        ProductView view = new ProductView();
                        ProductController controller = new ProductController(product, view);
                        controller.sellProduct(productNum); //sell function from Product class;
                    }
                    break;

                case 5: //see the product list
                    displayProductList();
                    break;

                case 6: //see available balance;
                    ProductController.getAvailableBalance();
                    break;
            }
           
        } 
        System.out.println("Exiting.");
        input.close();
    }

    private static void init(){
        Product p1 = new Product();
        p1.setProduct("TV", 22000, 25000, 10);
        productList.add(p1);
        Product p2 = new Product();
        p2.setProduct("Mobile", 12000, 14000, 20);
        productList.add(p2);
        Product p3 = new Product();
        p3.setProduct("AC", 30000, 45000, 15);
        productList.add(p3);
        Product p4 = new Product();
        p4.setProduct("Headphone", 800, 850, 50);
        productList.add(p4);
        Product p5 = new Product();
        p5.setProduct("VR set", 1000, 1200, 5);
        productList.add(p5);
        System.out.println("Initially 10 TV, 20 Mobile, 15 AC, 50 Headphones and 5 VR set are added.");

        p1.sell(10);
        p3.sell(15);
        p5.sell(5);
    }

    private static Product searchProduct(String name){
        for(Product product: productList){
            ProductView view = new ProductView();
            ProductController controller = new ProductController(product, view);
            if(controller.getProductName().equals(name)){
                return product;
            }
        }
        System.out.println("Product is not found.");
        return null;
    }

    private static void displayProductList(){
        if(productList.isEmpty()){
            System.out.println("No product.");
            return;
        }
        System.out.println("----------------------------------------------");
        System.out.printf("%-12s%-20s%-10s\n" , "Product", "Num. of" , "Profit");   
        System.out.printf("%-12s%-20s%-10s" , "Name", "Avail. products" , ""); 
        System.out.println();
        for(Product product: productList){
            ProductView view = new ProductView();
            ProductController controller = new ProductController(product, view);
            System.out.println("----------------------------------------------\n");
            controller.showDetails();  
        }
        System.out.println("----------------------------------------------");

    }
}
