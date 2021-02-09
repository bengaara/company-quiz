import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


class Result1 {

    /*
     * Complete the 'getArticleTitles' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING author as parameter.
     *
     * URL for cut and paste:
     * https://jsonmock.hackerrank.com/api/articles?author=<authorName>&page=<num>
     *
     */

    public static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) {

        int pageNum = 0;
        boolean isdata =true;
        String url = "https://jsonmock.hackerrank.com/api/transactions/search?txnType=par1&page=par2";

        List<Integer> arr = new ArrayList();
        List<Double> totalUse = new ArrayList();
        List<Integer> totalUseId = new ArrayList();
        List<Double> totalDeb = new ArrayList();


        do{


            try{
            // Connect to the URL using java's native library
            URL ur = new URL(url.replace("par1",txnType).replace("par2",String.valueOf(pageNum)));
            URLConnection request = ur.openConnection();
            request.connect();

            // Convert to a JSON object to print data
            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
            BigInteger page = rootobj.get("page").getAsBigInteger();
            BigInteger perpage = rootobj.get("per_page").getAsBigInteger();
            BigInteger total = rootobj.get("total").getAsBigInteger();
            BigInteger totalPages = rootobj.get("total_pages").getAsBigInteger();
            JsonArray data = rootobj.get("data").getAsJsonArray();




            data.forEach(jsonElement -> {
              //  String id =!jsonElement.getAsJsonObject().get("id").isJsonNull()?jsonElement.getAsJsonObject().get("id").getAsString():null;
                String id =jsonElement.getAsJsonObject().get("id").getAsString();
                Long timestamp =jsonElement.getAsJsonObject().get("timestamp").getAsLong();
                String userId =jsonElement.getAsJsonObject().get("userId").getAsString();
                String tType =jsonElement.getAsJsonObject().get("txnType").getAsString();
                String amount =jsonElement.getAsJsonObject().get("amount").getAsString();

                ZonedDateTime utc = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.UTC);
                if(DateTimeFormatter.ofPattern("MM-YYYY").format(utc).equalsIgnoreCase(monthYear)){
                    if(Integer.valueOf(userId) ==uid){

                        if(tType.equalsIgnoreCase(txnType)){
                           Double a = Double.valueOf(amount.replace("$","").replace(",",""));
                           totalUse.add(a);
                            totalUseId.add(Integer.valueOf(id))  ;
                        }
                        if(tType.equalsIgnoreCase("debit")){
                            Double b = Double.valueOf(amount.replace("$","").replace(",",""));
                            totalDeb.add(b);
                        }


                    }

                }




            });

            if(pageNum>=totalPages.intValue()-1){
                isdata = false;
            }
            pageNum ++;




        }catch(Exception e){
            e.printStackTrace();
        }

        }while(isdata);


        //find average and return greater
        Double av = Double.valueOf(0);
        for(int x=0;x<totalDeb.size();x++){
            av += totalDeb.get(x);
        }
        av = av/totalDeb.size();

        List<Integer> ids = new ArrayList<>();
        for(int x=0;x<totalUse.size();x++){
            if(totalUse.get(x)>av){
                ids.add( totalUseId.get(x));
            };
        }
          if(ids.size()<1){
              ids.add(-1);
          }
        return ids;
    }

}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //String author = bufferedReader.readLine();
        int uid = Integer.parseInt(bufferedReader.readLine().trim());

        String txnType = bufferedReader.readLine();

        String monthYear = bufferedReader.readLine();

        List<Integer> result = Result1.getUserTransaction(uid, txnType, monthYear);

//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
     //   bufferedWriter.close();
    }
}
