package com.clx.airbnb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/AI")
public class AiRecommendation {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("recommendation")
    @ResponseBody
    public List<Map<String, Object>> listListingAI(HttpServletRequest request) {
        String neighbourhood="'"+ request.getParameter("neighbourhood")+"%'";
        String root_type="'"+request.getParameter("room_type")+"%'";
        double lowPrice=Double.valueOf(request.getParameter("lowPrice"));
        double highPrice=Double.valueOf(request.getParameter("highPrice"));

        String sql = "select host_name,neighbourhood,room_type,property_type,price,minimum_night,number_of_reviews,url from ads_recommendation where neighbourhood like "+neighbourhood+" and room_type like "+root_type+" " +
                "and price between "+lowPrice+" and "+highPrice+"";
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
        return results;
    }
}
