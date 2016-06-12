package client;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class Client {

    public final static void main(String[] args) throws Exception {

        URLConnection connection = new URL("http://localhost:8080").openConnection();
        connection.setDoOutput(true);
        String data = "Man is distinguished, not only by his reason, but by this singular " +
                "passion from other animals, which is a lust of the mind, that by a persev" +
                "erance of delight in the continued and indefatigable generation of knowle" +
                "dge, exceeds the short vehemence of any carnal pleasure.";
        String hash = DigestUtils.md5Hex(data);
        data = "TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0" +
                "aGlzIHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1" +
                "c3Qgb2YgdGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0" +
                "aGUgY29udGludWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdl" +
                "LCBleGNlZWRzIHRoZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4=";
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
            writer.print("number=1&isLast=true&hash=" + hash + "&data=" + data);
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }
        int responseCode = ((HttpURLConnection) connection).getResponseCode();
        System.out.println(responseCode); // Should be 200

    }
}
