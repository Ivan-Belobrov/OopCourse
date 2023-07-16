package Student12;

public class ServerNameExtractor {
    public static void main(String[] args) {
        String url = "http://SomeServerName/abcd/dfdf.htm?dfdf=dfdf";
        String serverName = getServerName(url);
        System.out.println("Имя сервера: " + serverName);
    }

    public static String getServerName(String url) {
        int startIndex = url.indexOf("://") + 3;
        int endIndex = url.indexOf("/", startIndex);

        if (endIndex == -1) {
            endIndex = url.length();
        }

        return url.substring(startIndex, endIndex);
    }
}