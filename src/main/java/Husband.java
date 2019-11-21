import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Husband {
    final static String[] NEW = new String[] {"Bread", "Lenovo"};


    public static void main(String[] arg) throws SQLException {
        searchGoods();
    }


    private static void searchGoods() throws SQLException {
        List<String> ListOfShops = Shops.getAllTables();
        Statement db = Shops.connectionToDataBase();

        ArrayList<String> shopGoods = new ArrayList<String>();
        ArrayList<Float> goodsPrice = new ArrayList<Float>();

        for (int i = 0; i<ListOfShops.size()-1; i++){
            ResultSet res = null;

            String query = "select * from Grossary."+ ListOfShops.get(i);
            try {
                res = db.executeQuery(query);
            } catch (SQLException e) {
                System.out.println("Problems");
                return;
            }
            while (res.next()){
                for (int j =0; j<NEW.length; j++){
                    String good = res.getString("name");
                    if(good.equals(NEW[j])) {
                        shopGoods.add(good);
                        goodsPrice.add(res.getFloat("price"));
                    }

                }
            }


            }
        db.close();
        System.out.println(shopGoods);
        System.out.println(goodsPrice);

    }


}
