import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class B6{
    public static void main(String[] args){
        Map<String, Float> studentScores = new LinkedHashMap<>();
        studentScores.put("Nguyễn Văn A", 5.6f);
        studentScores.put("Trần Minh B", 6.7f);
        studentScores.put("Lê Thị C", 7.8f);
        studentScores.put("Phạm Văn D", 8.2f);
        studentScores.put("Hoàng Minh E", 5.9f);
        studentScores.put("Bùi Thị F", 6.5f);
        studentScores.put("Đặng Quốc G", 7.1f);
        studentScores.put("Vũ Ngọc H", 9.0f);
        studentScores.put("Đỗ Thanh I", 4.8f);
        studentScores.put("Lý Văn J", 7.3f);

        for(Map.Entry<String, Float> entry : studentScores.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        float sum = 0;
        for(Map.Entry<String, Float> entry : studentScores.entrySet()){
            sum += entry.getValue();
        }
        float avg = sum / studentScores.size();
        System.out.println("avarage score: " + avg);
        Iterator<Map.Entry<String, Float>> iterator = studentScores.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Float> entry = iterator.next();
            if (entry.getValue() < avg) {
                iterator.remove();
            }
        }

        for (Map.Entry<String, Float> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
