import java.util.Map;
import java.util.TreeMap;

public class B4{
    public static void main(String[] args){
        Map<String, Float> employees = new TreeMap<>();
        employees.put("NV001", 20000.5f);
        employees.put("NV123", 30000.5f);
        employees.put("NV345", 40000.5f);
        employees.put("NV002", 50000.5f);
        employees.put("NV003", 60000.5f);

        for(Map.Entry<String, Float> employee: employees.entrySet()){
            System.out.println(employee.getKey() + " " + employee.getValue());
        }

        for(Map.Entry<String, Float> employee: employees.entrySet()){
            if(employee.getKey().equals("NV123")){
                employee.setValue(employee.getValue() * 2);
            }
        }

        employees.remove("NV123");
        for(Map.Entry<String, Float> employee: employees.entrySet()){
            System.out.println(employee.getKey() + " " + employee.getValue());
        }

    }
}
