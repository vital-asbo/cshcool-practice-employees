package spring.employees;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.foo.Foo;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmpController {

    List<Emp> list = new ArrayList<>();


    @RequestMapping("/addDefaultValues")
    public String addDefaultValues() {
        list.add(new Emp(1, "Janek", 120000, "Radom", "vital347@mail.ru"));
        list.add(new Emp(2, "Zosia", 9000, "Makowiec", "vital347@mail.ru"));
        list.add(new Emp(3, "Marek", 10000, "Warszawa", "vital347@mail.ru"));
        list.add(new Emp(4, "Krystyna", 13000, "Ryzowice", "vital347@mail.ru"));
        return "emp/adddefaultvalues";
    }


    @RequestMapping(value = "/save_emp")
    public ModelAndView save(@ModelAttribute(value = "emp") Emp emp) {
        if (emp.getId() < 0) {
            System.out.println("Adding a new employee");
            int index = list.size();
            emp.setId(index + 1);
            list.add(emp);
        } else {
            Emp employeeTemporary = getEmployeesById(emp.getId());
            employeeTemporary.setName(emp.getName());
            employeeTemporary.setSalary(emp.getSalary());
            employeeTemporary.setDesignation(emp.getDesignation());
            employeeTemporary.setEmail(emp.getEmail());
        }
        return new ModelAndView("redirect:/viewemp");
    }

    @RequestMapping(value = "/removeemployee")
    public ModelAndView removeEmployee(@RequestParam(value = "emp_id") String stringId) {
        int intId = Integer.parseInt(stringId);
        list.remove(getEmployeesById(intId));
        return new ModelAndView("redirect:/viewemp");
    }


    @RequestMapping(value = "/edit_employee")
    public ModelAndView editEmployee(@RequestParam(value = "emp_id") String emp_id) {
        Emp employee = getEmployeesById(Integer.parseInt(emp_id));
        return new ModelAndView("emp/empform", "emp", employee);
    }


    @RequestMapping("/")
    public String indexGet() {
        return "emp/index";
    }


    @RequestMapping(value = "/button", method = RequestMethod.POST)
    public ModelAndView testButton() {
        System.out.println("Hello User!");
        return new ModelAndView("redirect:/viewemp");
    }


    @RequestMapping(value = "/empform", method = RequestMethod.GET)
    public ModelAndView showform(Model model) {
        return new ModelAndView("emp/empform", "emp", new Emp());
    }


    @RequestMapping("/viewemp")
    public ModelAndView viewemp(Model model) {
        return new ModelAndView("emp/viewemp", "list", list);
    }


    private Emp getEmployeesById(@RequestParam int id) {
//        list.stream().filter(f -> f.getId() == id).forEach(System.out::println);
        return list.stream().filter(f -> f.getId() == id).findFirst().get();
    }
}