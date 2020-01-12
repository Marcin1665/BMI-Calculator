package pl.tuszynski.bmi.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.tuszynski.bmi.Result;
import pl.tuszynski.bmi.Service.ResultService;

import java.text.DecimalFormat;
import java.util.List;

@Controller
public class AppController {

  @Autowired
  private ResultService service;

  @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
  public String showNewProductPage(@RequestParam(required = false) Integer weight,
                                   @RequestParam(required = false) Integer height,
                                   ModelMap model) {
    if (weight != null && height != null) {
      DecimalFormat decimalFormat = new DecimalFormat("###.#");
      Double bmi = Double.valueOf((weight / (height * height)) * 10000);
      model.put("bmi",decimalFormat.format(bmi));
    }
    Result result = new Result();
    model.addAttribute("result", result);

    return "calculator";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveProduct(@ModelAttribute("result") Result result) {
    service.save(result);

    return "redirect:/";
  }

  @RequestMapping("/results")
  public String viewHomePage(Model model) {
    List<Result> listResults = service.listAll();
    model.addAttribute("listResults", listResults);

    return "all_results";
  }



  @RequestMapping("/delete/{id}")
  public String deleteProduct(@PathVariable(name = "id") int id) {
    service.delete(id);
    return "redirect:/";
  }

//
//  @GetMapping("/")
//  public String show(@RequestParam(required = false) Double weight,
//                     @RequestParam(required = false) Integer height,
//                     Model model) {
//    if (weight != null && height != null) {
//      DecimalFormat decimalFormat = new DecimalFormat("###.#");
//      Double bmi = (weight / (height * height)) * 10000;
//      model.addAttribute("bmi", bmi);
//    }
//    return "calculator";
//
//}
}
