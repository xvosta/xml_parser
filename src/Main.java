import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine(); //имя файла, который создастся с измененными данными
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String g;
        Matcher m;
        String s1;
        Pattern MY_PATTERN = Pattern.compile("[<^}li](.)*li[^}>]*.");

        try (FileInputStream fileInputStream1 = new FileInputStream(fileName1))
        {
            while (fileInputStream1.available() > 0) {
                byteArrayOutputStream.write(fileInputStream1.read());
            }
            g = byteArrayOutputStream.toString();
            m= MY_PATTERN.matcher(g);
            while (m.find()) {
                s1 = m.group();
                s1 = s1.replaceAll(">(.*?)<",">change<");
                g=g.replace(m.group(), s1);
            }
        }
        File file = new File(fileName2);
        FileWriter fw = new FileWriter(file);
        fw.write(g);
        fw.close();
    }
}
