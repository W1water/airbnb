package com.clx.airbnb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/actual_time_search")
public class ActualTimeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("increase_by_price")
    @ResponseBody
    public List<Map<String, Object>> listListing1(HttpServletRequest request) {
        String neighbourhood="'"+ request.getParameter("neighbourhood")+"%'";
        String root_type="'"+request.getParameter("room_type")+"%'";
        String startDt ="'"+ request.getParameter("startDt")+"'";
        int rentDays=Integer.valueOf(request.getParameter("rentDays"));
        int addDays=rentDays-1;
        double lowPrice=Double.valueOf(request.getParameter("lowPrice"));
        double highPrice=Double.valueOf(request.getParameter("highPrice"));

        String sql = "select d.host_name as host_name,d.neighbourhood as neighbourhood,d.room_type as room_type," +
                "d.property_type as property_type,c.avg_price as avg_price,d.minimum_night as minimum_night," +
                "d.number_of_reviews as number_of_reviews,listing_url from (\n" +
                "select b.id,count(*) total_day,cast(avg(price) as decimal(8,2)) avg_price from calendar a join \n" +
                "(select id from listing where neighbourhood like "+neighbourhood+" and room_type like "+root_type+" \n" +
                "and  minimum_night <= "+rentDays+") b\n" +
                "on a.listing_id=b.id where a.dt between "+startDt+" and date_add("+startDt+",+"+addDays+") and a.available='t' group by b.id\n" +
                ") c join listing d on c.id=d.id where total_day="+rentDays+" and avg_price between "+lowPrice+" and "+highPrice+"\n " +
                "order by avg_price asc ";
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
        return results;
    }

    @GetMapping("decrease_by_price")
    @ResponseBody
    public List<Map<String, Object>> listListing2(HttpServletRequest request) {
        String neighbourhood="'"+ request.getParameter("neighbourhood")+"%'";
        String root_type="'"+request.getParameter("room_type")+"%'";
        String startDt ="'"+ request.getParameter("startDt")+"'";
        int rentDays=Integer.valueOf(request.getParameter("rentDays"));
        int addDays=rentDays-1;
        double lowPrice=Double.valueOf(request.getParameter("lowPrice"));
        double highPrice=Double.valueOf(request.getParameter("highPrice"));

        String sql = "select d.host_name as host_name,d.neighbourhood as neighbourhood,d.room_type as room_type," +
                "d.property_type as property_type,c.avg_price as avg_price,d.minimum_night as minimum_night," +
                "d.number_of_reviews as number_of_reviews,listing_url from (\n" +
                "select b.id,count(*) total_day,cast(avg(price) as decimal(8,2)) avg_price from calendar a join \n" +
                "(select id from listing where neighbourhood like "+neighbourhood+" and room_type like "+root_type+" \n" +
                "and  minimum_night <= "+rentDays+") b\n" +
                "on a.listing_id=b.id where a.dt between "+startDt+" and date_add("+startDt+",+"+addDays+") and a.available='t' group by b.id\n" +
                ") c join listing d on c.id=d.id where total_day="+rentDays+" and avg_price between "+lowPrice+" and "+highPrice+"\n " +
                "order by avg_price desc ";
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
        return results;
    }
    @GetMapping("increase_by_heat")
    @ResponseBody
    public List<Map<String, Object>> listListing3(HttpServletRequest request) {
        String neighbourhood="'"+ request.getParameter("neighbourhood")+"%'";
        String root_type="'"+request.getParameter("room_type")+"%'";
        String startDt ="'"+ request.getParameter("startDt")+"'";
        int rentDays=Integer.valueOf(request.getParameter("rentDays"));
        int addDays=rentDays-1;
        double lowPrice=Double.valueOf(request.getParameter("lowPrice"));
        double highPrice=Double.valueOf(request.getParameter("highPrice"));

        String sql = "select d.host_name as host_name,d.neighbourhood as neighbourhood,d.room_type as room_type," +
                "d.property_type as property_type,c.avg_price as avg_price,d.minimum_night as minimum_night," +
                "d.number_of_reviews as number_of_reviews,listing_url from (\n" +
                "select b.id,count(*) total_day,cast(avg(price) as decimal(8,2)) avg_price from calendar a join \n" +
                "(select id from listing where neighbourhood like "+neighbourhood+" and room_type like "+root_type+" \n" +
                "and  minimum_night <= "+rentDays+") b\n" +
                "on a.listing_id=b.id where a.dt between "+startDt+" and date_add("+startDt+",+"+addDays+") and a.available='t' group by b.id\n" +
                ") c join listing d on c.id=d.id where total_day="+rentDays+" and avg_price between "+lowPrice+" and "+highPrice+"\n " +
                "order by number_of_reviews asc ";
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
        return results;
    }
    @GetMapping("decrease_by_heat")
    @ResponseBody
    public List<Map<String, Object>> listListing4(HttpServletRequest request) {
        String neighbourhood="'"+ request.getParameter("neighbourhood")+"%'";
        String root_type="'"+request.getParameter("room_type")+"%'";
        String startDt ="'"+ request.getParameter("startDt")+"'";
        int rentDays=Integer.valueOf(request.getParameter("rentDays"));
        int addDays=rentDays-1;
        double lowPrice=Double.valueOf(request.getParameter("lowPrice"));
        double highPrice=Double.valueOf(request.getParameter("highPrice"));

        String sql = "select d.host_name as host_name,d.neighbourhood as neighbourhood,d.room_type as room_type," +
                "d.property_type as property_type,c.avg_price as avg_price,d.minimum_night as minimum_night," +
                "d.number_of_reviews as number_of_reviews,listing_url from (\n" +
                "select b.id,count(*) total_day,cast(avg(price) as decimal(8,2)) avg_price from calendar a join \n" +
                "(select id from listing where neighbourhood like "+neighbourhood+" and room_type like "+root_type+" \n" +
                "and  minimum_night <= "+rentDays+") b\n" +
                "on a.listing_id=b.id where a.dt between "+startDt+" and date_add("+startDt+",+"+addDays+") and a.available='t' group by b.id\n" +
                ") c join listing d on c.id=d.id where total_day="+rentDays+" and avg_price between "+lowPrice+" and "+highPrice+"\n " +
                "order by number_of_reviews desc ";
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
        return results;
    }
}
