package kopo.poly.controller;

import kopo.poly.dto.NewsDTO;
import kopo.poly.service.INewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NewsController {

    private final INewsService newsService;


    //네이버 뉴스 크롤링
    @GetMapping(value = "/newslist")
    public String newslist(ModelMap model) throws Exception {
        log.info(this.getClass().getName() + "뉴스 크롤링 시작");

        List<NewsDTO> rList = newsService.newsList();
        log.info("가져온 뉴스 조회 데이터 결과(controller) : " + rList.size());

        log.info(this.getClass().getName() + "뉴스 크롤링 시작");

        model.addAttribute("rList", rList);
        return "news/news";


    }

    //환경부 뉴스 크롤링
@GetMapping(value = "/ennewslist")
    public String ennewslist(ModelMap model)throws Exception{
        log.info(this.getClass().getName()+"환경부 뉴스 크롤링 시작");

        List<NewsDTO> eList =newsService.ennewsList();
        log.info("가져온 환경부 뉴스 조회 데이터 결과(controller) "+eList.size());

        log.info(this.getClass().getName()+"환경부 뉴스 크롤링 시작");

        model.addAttribute("eList",eList);
        return "news/news";
}


}





