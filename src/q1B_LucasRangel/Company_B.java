package q1B_LucasRangel;

import java.util.ArrayList;

public class Company_B {
    public String company_name;
    public ArrayList<String> lista_funcionarios = new ArrayList<>();
    public Company_B(String company_name){
        this.company_name = company_name;
    }
    public void hires(Employee_B employee) {
        this.lista_funcionarios.add(employee.toString());
    }

    public static void main(String [] args){
        Company_B teste = new Company_B("Tesla");
        Employee_B teste_employee = new Employee_B("Lucas");
        teste.hires(teste_employee);
        Vehicle_B teste_veiculo = new Vehicle_B("5555");
        teste_employee.drives(teste_veiculo);
        System.out.println(teste_employee.funcionario_veiculo);
    }
}
