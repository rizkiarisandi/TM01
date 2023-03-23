import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConnect {
    public static void main(String[] args) throws IOException {
        //Request
        ConnectURL koneksisaya = new ConnectURL();
        URL myadress = koneksisaya.TM1_MuhamadRizkiAriSandi_2D("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        //Response
        String response = koneksisaya.getResponseFromHttpurl(myadress);
        System.out.println(response);
        //Dcoding JSON
        assert response != null;
        JSONArray responsedJSON = new JSONArray(response);
        ArrayList<DataFarmasi> models = new ArrayList<>();
        for (int i = 0; i < responsedJSON.length(); i++) {
            DataFarmasi fardata = new DataFarmasi();
            JSONObject myJSONObject = responsedJSON.getJSONObject(i);
            fardata.setI_code(myJSONObject.getString("i_code"));
            fardata.setG_code(myJSONObject.getString("g_code"));
            fardata.setI_supp(myJSONObject.getString("i_supp"));
            fardata.setI_barcode(myJSONObject.getString("i_barcode"));
            fardata.setI_name(myJSONObject.getString("i_name"));
            fardata.setI_qty(myJSONObject.getString("i_qty"));
            fardata.setI_qtymin(myJSONObject.getString("i_qtymin"));
            fardata.setI_unit(myJSONObject.getString("i_unit"));
            fardata.setI_size(myJSONObject.getString("i_size"));
            fardata.setI_color(myJSONObject.getString("i_color"));
            fardata.setI_brands(myJSONObject.getString("i_brands"));
            fardata.setI_barcode(myJSONObject.getString("i_article"));
            fardata.setI_cogs(myJSONObject.getString("i_cogs"));
            fardata.setI_kdsell(myJSONObject.getString("i_kdsell"));
            fardata.setI_sell(myJSONObject.getString("i_sell"));
            fardata.setI_status(myJSONObject.getString("i_status"));
            fardata.setId(myJSONObject.getString("id"));
            models.add(fardata);
        }
        System.out.println("RESPONSE ARE :  ");
        for (int index = 0; index < models.size(); index++) {
            System.out.println("Name : " + models.get(index).getI_name());
            System.out.println("qty : " + models.get(index).getI_qty());
            System.out.println("Harga : " + models.get(index).getI_sell());
        }
    }
}