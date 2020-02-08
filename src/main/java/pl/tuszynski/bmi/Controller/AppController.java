package pl.tuszynski.bmi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.tuszynski.bmi.Result;
import pl.tuszynski.bmi.Service.ResultService;

import javax.websocket.server.PathParam;
import java.text.DecimalFormat;
import java.util.List;

@Controller
public class AppController {

  @Autowired
  private ResultService service;

  @GetMapping("/")

  public String home() {

    return "calculator";

  }

  @RequestMapping(value = "/save", method = {RequestMethod.GET, RequestMethod.POST})
  public String getValue(@RequestParam Double weight,
                         @RequestParam Double height,
                         Double bmi,
                         ModelMap model,
                         @ModelAttribute("result") Result result) {
    service.save(result);
    bmi =(weight / (height * height)) * 10000;
    double bmiTwoDecimalPlaces = Math.round(bmi * 100.0) / 100.0;
    model.addAttribute("bmi", bmiTwoDecimalPlaces);
    return "valueOfBMI";
  }

  @RequestMapping("/results")
  public String viewAllResults(Model model) {
    List<Result> listResults = service.listAll();
    model.addAttribute("listResults", listResults);

    return "all_results";
  }


  @RequestMapping("/delete/{id}")
  public String deleteRecord(@PathVariable(name = "id") int id) {
    service.delete(id);
    return "redirect:/";
  }


//  @GetMapping(value = "/")
//  public String show(@RequestParam Integer weight,
//                     @RequestParam Integer height,
//                     Model model) {
//    if (weight != null && height != null) {
//      DecimalFormat decimalFormat = new DecimalFormat("###.#");
//      Double bmi;
//      bmi = Double.valueOf((weight / (height * height)) * 10000);
//      model.addAttribute("bmi", bmi);
//    }
//    return "calculator";
//
//
//
//}
}
