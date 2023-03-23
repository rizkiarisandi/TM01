import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TM1_MuhamadRizkiAriSandi_2D extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JPanel mainpanel;
    private JButton button1;
    private JTextArea textArea1;



    public TM1_MuhamadRizkiAriSandi_2D() {
        setContentPane(mainpanel);
        setTitle("Barang");
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        TM1_MuhamadRizkiAriSandi_2D content = new TM1_MuhamadRizkiAriSandi_2D();
        ConnectURL koneksiSaya = new ConnectURL();
        URL myAdress = koneksiSaya.TM1_MuhamadRizkiAriSandi_2D("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        //response
        String response = koneksiSaya.getResponseFromHttpurl(myAdress);
        System.out.println(response);
        //DcodingJSON
        assert response != null;
        JSONArray responsedJSON = new JSONArray(response);
        ArrayList<DataFarmasi> models = new ArrayList<>();
        for (int i =0; i<responsedJSON.length(); i++) {
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

        content.button1.addActionListener(e ->  {
                for (int index = 0; index < models.size(); index++) {
                    String namaBarang = String.valueOf(models.get(index).getI_name());
                    String Stok = models.get(index).getI_qty();
                    //mengonversikan menjadi int
                    int harga = Integer.parseInt(models.get(index).getI_sell());
                    if (namaBarang.contains("S") && harga < 7000 && Stok != null) {
                            content.textArea1.append("nama Barang : " + namaBarang +
                                    "\nHarga : " + harga +
                                    "\nstok : " + Stok + "\n");

                    }
                }
        });
    }
}

