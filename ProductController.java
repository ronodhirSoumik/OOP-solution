class ProductController{
    private Product product;
    private ProductView view;

    public ProductController(Product product, ProductView view){
        this.product = product;
        this.view = view;
    }

    public void setProductDetails(String name, float buyPrice, float sellPrice, int availNum){
        product.setProduct(name, buyPrice, sellPrice, availNum);
    }

    public String getProductName(){
        return product.getName();
    }

    public int getProductAvailNumber(){
        return product.getAvailNumber();
    }

    public float getProductProfit(){ 
        return product.getProfit();
    }

    public void sellProduct(int num){
        product.sell(num);
    }

    public void buyProduct(int num){
        product.buy(num);
    }

    public static void getAvailableBalance(){
        ProductView.displayBalance();
    }

    public void showDetails(){
        view.displayProductDetails(product.getName(),product.getAvailNumber(),product.getProfit());
    }

}