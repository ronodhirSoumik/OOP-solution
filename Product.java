class Product{
    private String name;
    private float buyPrice, sellPrice, profit;
    private int availNum;
    private static float totalProfit=0, crntBalance=0;

    public void setProduct(String name, float buyPrice, float sellPrice, int availNum){ 
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.availNum = availNum;
        this.profit = 0;
    }

    public String getName(){
        return name;
    }

    public int getAvailNumber(){
        return availNum;
    }

    public float getProfit(){ 
        return profit;
    }

    public void sell(int num){
        if(num > availNum){
            System.out.println("Inventory has not such ammount of this product.");
            return;
        }
        availNum = availNum - num;
        float profit = (sellPrice - buyPrice)*num;
        this.profit += profit;
        crntBalance += sellPrice * num;
        System.out.println(num + " of " + name + " are sold.");
    }

    public void buy(int num){
        float price = buyPrice*num;
        if(price > crntBalance){
            System.out.println("It is not affordable considering available balance.");
            return;
        }
        crntBalance -= price;
        availNum += num;
        System.out.println(num + " of " + name + " are bought.");
    }

    static float getBalance(){
        return crntBalance;
    }



}