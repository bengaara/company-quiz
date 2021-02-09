import java.io.*;
import java.math.*;
import java.net.URL;
import java.net.URLConnection;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import com.google.gson.*;


class Result {

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

    public static List<String> getArticleTitles(String auth) {

        int pageNum = 0;
        boolean isdata =true;
        String url = "https://jsonmock.hackerrank.com/api/articles?author=par1&page=par2";

        List<String> titles = new ArrayList();



        do{


            try{
            // Connect to the URL using java's native library
            URL ur = new URL(url.replace("par1",auth).replace("par2",String.valueOf(pageNum)));
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
                String t =!jsonElement.getAsJsonObject().get("title").isJsonNull()?jsonElement.getAsJsonObject().get("title").getAsString():null;
                String st =!jsonElement.getAsJsonObject().get("story_title").isJsonNull()?jsonElement.getAsJsonObject().get("story_title").getAsString():null;
                t =(t==null || t.isEmpty())?st:t;

                if(t!=null && !t.isEmpty()){
                    titles.add(t);
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


        return titles;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String author = bufferedReader.readLine();

        List<String> result = Result.getArticleTitles(author);

//        bufferedWriter.write(
//                result.stream()
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
     //   bufferedWriter.close();
    }
}
