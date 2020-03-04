package pl.tuszynski.bmi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.tuszynski.bmi.Model.Result;
import pl.tuszynski.bmi.Service.ResultService;

import java.util.List;

@Controller
public class AppController {

  @Autowired
  private ResultService service;

  @GetMapping("/")
  public String home() {

    return "calculator";

  }

  @RequestMapping(value = "/valueOfBMI", method = {RequestMethod.GET, RequestMethod.POST})
  public String getValue(@RequestParam Double weight,
                         @RequestParam Double height,
                         @RequestParam String nickname,
                         ModelMap model) {
    Result result = new Result();
    result.setHeight(height);
    result.setWeight(weight);
    result.setNickname(nickname);
    model.addAttribute("result",result);

    service.save(result);

    return "valueOfBMI";
  }

  @RequestMapping("/results")
  public String viewAllResults(Model model) {
    List<Result> listResults = service.listAll();
    model.addAttribute("listResults", listResults);

    return "allResults";
  }




  @RequestMapping("/delete/{id}")
  public String deleteRecord(@PathVariable(name = "id") int id) {
    service.delete(id);

    return "redirect:/";
  }



}
