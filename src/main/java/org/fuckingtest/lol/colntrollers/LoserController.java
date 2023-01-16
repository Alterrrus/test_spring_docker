package org.fuckingtest.lol.colntrollers;

import io.swagger.v3.oas.annotations.Operation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.fuckingtest.lol.util.LolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller("/lose")
public class LoserController {

  private LolService serviceUtil;
@Operation
  @GetMapping("/lose/all")
  public String getLoser(Model model, HttpServletRequest request, HttpServletResponse response) {
    model.addAttribute("serviceUtil", getServiceUtil().doIt());
    return "lose";
  }

  public LolService getServiceUtil() {
    return serviceUtil;
  }

  @Autowired
  public void setServiceUtil(LolService serviceUtil) {
    this.serviceUtil = serviceUtil;
  }
}
