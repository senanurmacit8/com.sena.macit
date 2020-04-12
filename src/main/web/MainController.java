package src.main.web;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import src.main.service.MainService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Locale;

@Controller
@RequestMapping(value = "/*")
public class MainController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MainService mainService;

    @RequestMapping(value = "/anasayfa", method = RequestMethod.GET)
    public String anasayfa(Locale locale, Model model) {

        model.addAttribute("karsilama",
                messageSource.getMessage("karsilama", null, locale));

        model.addAttribute("kisiKarsilama",
                messageSource.getMessage("kisiKarsilama", new Object[]{"Talha"}, locale));

        Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);

        return "anasayfa";
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(HttpServletRequest request, HttpServletResponse response) {
        return "user";
    }






    @RequestMapping(value = "/giris.ajax")
    public @ResponseBody
    String giris(@RequestParam String kullaniciAdi, @RequestParam String sifre,
                 HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Gelen Parametreler: Kullanıcı Adı: " + kullaniciAdi + " && Şifre: " + sifre);
        return kullaniciAdi;
    }






    @RequestMapping(value = "/loadUser.ajax")
    public @ResponseBody
    String loadUser(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = mainService.loadUser();
        return jsonObject.toString();
    }




    @RequestMapping(value = "/loadToDoList.ajax")
    public @ResponseBody
    String loadToDoList(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = mainService.loadToDoList();
        return jsonObject.toString();
    }




    @RequestMapping(value = "/loadToDoListItem.ajax")
    public @ResponseBody
    String loadToDoListItem(HttpServletRequest request, HttpServletResponse response) {
        JSONObject jsonObject = mainService.loadToDoListItem();
        return jsonObject.toString();
    }




    @RequestMapping(value = "/saveOrUpdateUser.ajax")
    public @ResponseBody
    String saveOrUpdateUser(@RequestParam String data, HttpServletRequest request, HttpServletResponse response) throws ParseException {
        JSONObject jsonObject = mainService.saveOrUpdateUser(JSONObject.fromObject(data));
        return jsonObject.toString();
    }




    @RequestMapping(value = "/deleteUser.ajax")
    public @ResponseBody
    String deleteUser(@RequestParam Long userId, HttpServletRequest request, HttpServletResponse response) throws ParseException {
        JSONObject jsonObject = mainService.deleteUser(userId);
        return jsonObject.toString();
    }


}

