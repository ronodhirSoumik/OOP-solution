class ProductView{

    public void displayProductDetails(String name, int number, float profit){
        System.out.format("%-12s%-20d%-10.2f\n" , name, number, profit);
    }

    public static void displayBalance(){
        System.out.println("Available balance is: " + Product.getBalance() + "BDT");
    }

}