package q1B_LucasRangel;


import java.util.HashMap;


public class Employee_B {
    public String employee_name;
    HashMap<String, String> funcionario_veiculo = new HashMap<>();
    public Employee_B(String employee_name){
        this.employee_name = employee_name;
    }
    public void drives (Vehicle_B vehicle){
        this.funcionario_veiculo.put(employee_name,vehicle.toString());
    }
}
